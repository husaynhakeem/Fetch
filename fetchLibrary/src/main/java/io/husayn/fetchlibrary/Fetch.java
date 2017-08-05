package io.husayn.fetchlibrary;

import android.content.Context;

import java.util.Collections;
import java.util.List;

import io.reactivex.Single;

import static io.husayn.fetchlibrary.Fetch.ResourceType.NONE;

/**
 * Created by husaynhakeem on 8/4/17.
 */

public class Fetch<T> {

    private static final int DEFAULT_ITEMS_COUNT = 10;
    private static final int DEFAULT_CACHE = 10;

    enum ResourceType {
        IMAGE,
        XML,
        JSON,
        PDF,
        NONE
    }

    private Context context;
    private List<String> urls;
    private ResourceType resourceType = NONE;
    private int itemsCount = DEFAULT_ITEMS_COUNT;
    private int cache = DEFAULT_CACHE;


    private Fetch(Context context) {
        this.context = context;
    }


    public static Fetch with(Context context) {
        return new Fetch(context);
    }


    public void from(String url) {
        this.urls = Collections.singletonList(url);
    }


    public void from(List<String> urls) {
        this.urls = urls;
    }


    public void ofType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }


    public void take(int itemsCount) {
        this.itemsCount = itemsCount;
    }


    public void cache(int cache) {
        this.cache = cache;
    }


    public Single<T> load() {
        assertMandatoryAttributesNotNull();
        return new RequestHandler<T>().load(context, urls, resourceType, itemsCount, cache);
    }


    private void assertMandatoryAttributesNotNull() {
        checkUrls();
        checkResourceType();
    }


    private void checkUrls() {
        urls.forEach(this::notNullNorEmpty);
    }


    private void checkResourceType() {
        if (resourceType == null || resourceType == NONE)
            throw new RuntimeException("Resource type must not be null");
    }


    private void notNullNorEmpty(String s) {
        if (s == null)
            throw new RuntimeException("Url must not be null");
        if (s.trim().length() == 0)
            throw new RuntimeException("Url must not be empty");
    }
}
