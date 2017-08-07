package io.husayn.fetchlibrary.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public class ImageFetchApi {


    private static final String TAG = ImageFetchApi.class.getName();
    private Context context;


    private ImageFetchApi(Context context) {
        this.context = context;
    }


    public static ImageFetchApi instance(Context context) {
        return new ImageFetchApi(context);
    }


    /**
     * Used to load 1 image.
     *
     * @param url
     * @return
     */
    public Single<Bitmap> load(final String url) {
        return load(url, new Callable<Bitmap>() {
            @Override
            public Bitmap call() throws Exception {
                return Picasso.with(context).load(url).get();
            }
        });
    }


    /**
     * Used to load 1 image with a certain 'Width' and 'Height'.
     *
     * @param url
     * @param width
     * @param height
     * @return
     */
    public Single<Bitmap> load(final String url, final int width, final int height) {
        return load(url, new Callable<Bitmap>() {
            @Override
            public Bitmap call() throws Exception {
                return Picasso.with(context).load(url).resize(width, height).get();
            }
        });
    }


    public Single<Bitmap> load(final String url, Callable<Bitmap> callable) {
        return Single.fromCallable(callable)
                .subscribeOn(Schedulers.newThread())
                .doOnSuccess(new Consumer<Bitmap>() {
                    @Override
                    public void accept(@NonNull Bitmap bitmap) throws Exception {
                        Log.d(TAG, "Done loading an image resource for url: " + url);
                    }
                })
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.e(TAG, "Error while loading an image resource: " + throwable.getMessage());
                    }
                })
                .cache();
    }


    /**
     * Used to load a list of images.
     *
     * @param urls
     * @return
     */
    public Observable<List<Bitmap>> load(final List<String> urls) {
        return Observable.defer(new Callable<ObservableSource<? extends List<Bitmap>>>() {
            @Override
            public Observable<List<Bitmap>> call() {

                List<Bitmap> images = new ArrayList<>(urls.size());

                for (String url : urls) {
                    try {
                        images.add(Picasso.with(context)
                                .load(url)
                                .get());
                    } catch (Exception e) {
                        Log.e(TAG, "Error while loading images: " + e.getMessage());
                        e.printStackTrace();
                        return Observable.error(e);
                    }
                }
                return Observable.just(images);
            }
        });
    }


    /**
     * Used to load a list of images with a certain 'Width' and 'Height'.
     *
     * @param urls
     * @param width  Width of all the resulting images
     * @param height Height of all the resulting images
     * @return
     */
    public Observable<List<Bitmap>> load(final List<String> urls, final int width, final int height) {
        return Observable.defer(new Callable<ObservableSource<? extends List<Bitmap>>>() {
            @Override
            public Observable<List<Bitmap>> call() {

                List<Bitmap> images = new ArrayList<>(urls.size());

                for (String url : urls) {
                    try {
                        images.add(Picasso.with(context)
                                .load(url)
                                .resize(width, height)
                                .get());
                    } catch (Exception e) {
                        Log.e(TAG, "Error while loading images: " + e.getMessage());
                        e.printStackTrace();
                        return Observable.error(e);
                    }
                }
                return Observable.just(images);
            }
        });
    }
}
