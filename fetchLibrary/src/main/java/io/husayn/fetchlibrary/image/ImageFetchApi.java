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
    private int index = 0;


    private ImageFetchApi(Context context) {
        this.context = context;
    }


    public static ImageFetchApi instance(Context context) {
        return new ImageFetchApi(context);
    }


    public Single<Bitmap> load(final String url) {
        return Single.fromCallable(new Callable<Bitmap>() {
            @Override
            public Bitmap call() throws Exception {
                return Picasso.with(context).load(url).get();
            }
        })
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


    public Observable<List<Bitmap>> load(final List<String> urls) {
        return Observable.defer(new Callable<ObservableSource<? extends List<Bitmap>>>() {
            @Override
            public Observable<List<Bitmap>> call() {

                List<Bitmap> images = new ArrayList<>(urls.size());

                for (String url : urls) {
                    try {
                        images.add(Picasso.with(context).load(url).get());
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
