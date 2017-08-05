package io.husayn.fetchlibrary;

import android.content.Context;

import java.util.List;

import io.husayn.fetchlibrary.helper.CheckAgent;
import io.husayn.fetchlibrary.image.ImageFetch;
import io.husayn.fetchlibrary.text.TextFetch;


/**
 * Created by husaynhakeem on 8/4/17.
 */

abstract public class Fetch {

    protected static final int DEFAULT_ITEMS_COUNT = 10;
    protected static final int DEFAULT_CACHE = 10;


    protected Context context;
    protected List<String> urls;
    protected int itemsCount = DEFAULT_ITEMS_COUNT;
    protected int cache = DEFAULT_CACHE;
    protected ResourceType resourceType = ResourceType.NONE;


    protected CheckAgent checkAgent;


    /**
     * To be used when one needs to fetch for data of types such
     * as JSON, XML, etc
     *
     * @return Text Fetcher
     */
    public static TextFetch forText(Context context) {
        return new TextFetch(context);
    }


    /**
     * To be used when one needs to fetch for images.
     * The returned data will be of type BITMAP
     *
     * @return Image Fetcher
     */
    public static ImageFetch forImage(Context context) {
        return new ImageFetch(context);
    }


    public Context getContext() {
        return context;
    }


    public List<String> getUrls() {
        return urls;
    }


    public int getItemsCount() {
        return itemsCount;
    }


    public int getCache() {
        return cache;
    }


    public Object getResourceType() {
        return resourceType;
    }
}
