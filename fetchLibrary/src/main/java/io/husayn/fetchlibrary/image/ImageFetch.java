package io.husayn.fetchlibrary.image;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.Collections;
import java.util.List;

import io.husayn.fetchlibrary.Fetch;
import io.husayn.fetchlibrary.ResourceType;
import io.husayn.fetchlibrary.helper.CheckAgent;
import io.reactivex.Observable;
import io.reactivex.Single;

import static io.husayn.fetchlibrary.helper.UiHelper.dpToPx;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public class ImageFetch extends Fetch {


    public static final int DEFAULT_DIMENSION = -1;
    private int width = DEFAULT_DIMENSION;
    private int height = DEFAULT_DIMENSION;


    public ImageFetch(Context context) {
        this.context = context;
        this.resourceType = ResourceType.TEXT;
        checkAgent = new CheckAgent(this);
    }


    /**
     * @param url: URL from which data will be fetched
     * @return Fetcher object with the attribute 'urls' set
     */
    public ImageFetch from(String url) {
        this.urls = Collections.singletonList(url);
        return this;
    }


    public ImageFetch from(List<String> urls) {
        this.urls = urls;
        return this;
    }


    /**
     * @param itemsCount: Number of items to be fetched
     * @return Fetcher object with the attribute 'itemCount' set
     */
    public ImageFetch take(int itemsCount) {
        this.itemsCount = itemsCount;
        return this;
    }


    /**
     * @param cache
     * @return Fetcher object with the attribute 'cache' set
     */
    public ImageFetch cache(int cache) {
        this.cache = cache;
        return this;
    }


    public ImageFetch withDimens(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }


    public Single<Bitmap> load() {
        checkAgent.checkAttributes();
        if (checkAgent.isFetchable() && width != DEFAULT_DIMENSION && height != DEFAULT_DIMENSION)
            return ImageFetchApi.instance(context).load(urls.get(0), dpToPx(context, width), dpToPx(context, height));
        return ImageFetchApi.instance(context).load(urls.get(0));
    }


    public Observable<List<Bitmap>> loadAll() {
        checkAgent.checkAttributes();
        if (checkAgent.isFetchable() && width != DEFAULT_DIMENSION && height != DEFAULT_DIMENSION)
            return ImageFetchApi.instance(context).load(urls, dpToPx(context, width), dpToPx(context, height));
        return ImageFetchApi.instance(context).load(urls);
    }


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }
}
