package io.husayn.fetchlibrary;

import android.content.Context;

import java.util.Collections;
import java.util.List;

import io.reactivex.Single;

import static io.husayn.fetchlibrary.ResourceType.NONE;

/**
 * Created by husaynhakeem on 8/4/17.
 */

public class Fetch {

    private static final int DEFAULT_ITEMS_COUNT = 10;
    private static final int DEFAULT_CACHE = 10;


    private Context context;
    private List<String> urls;
    private ResourceType resourceType = NONE;
    private int itemsCount = DEFAULT_ITEMS_COUNT;
    private int cache = DEFAULT_CACHE;


    public Fetch(Context context) {
        this.context = context;
    }


    public Context getContext() {
        return context;
    }


    public List<String> getUrls() {
        return urls;
    }


    public ResourceType getResourceType() {
        return resourceType;
    }


    public int getItemsCount() {
        return itemsCount;
    }


    public int getCache() {
        return cache;
    }


    public Fetch from(String url) {
        this.urls = Collections.singletonList(url);
        return this;
    }


    public Fetch from(List<String> urls) {
        this.urls = urls;
        return this;
    }


    public Fetch ofType(ResourceType resourceType) {
        this.resourceType = resourceType;
        return this;
    }


    public Fetch take(int itemsCount) {
        this.itemsCount = itemsCount;
        return this;
    }


    public Fetch cache(int cache) {
        this.cache = cache;
        return this;
    }


    public Single<? extends Object> load() {
        new CheckAgent(this).checkAttributes();
        return new RequestHandler<String>().load(context, urls, resourceType, itemsCount, cache);
    }
}
