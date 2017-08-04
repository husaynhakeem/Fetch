package io.husayn.fetchlibrary;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by husaynhakeem on 8/4/17.
 */

public class Fetch<T> {


    enum ResourceType {
        IMAGE,
        XML,
        JSON,
        PDF
    }


    private ResourceType resource;

    private String url;
    private List<String> urls;

    private int cacheS;
    private int itemsCount;

    private Single<List<T>> fetchedData;


    public Fetch<T> from(String url) {
        notNullNorEmpty(url);
        this.url = url;
        return new Fetch<T>();
    }


    public Fetch<T> from(List<String> urls) {
        urls.forEach(this::notNullNorEmpty);
        this.urls = urls;
        return new Fetch<T>();
    }


    private void notNullNorEmpty(String s) {
        if (s == null)
            throw new RuntimeException("Url must not be null");
        if (s.trim().length() == 0)
            throw new RuntimeException("Url must not be empty");
    }


    public Single<T> load() {
    }
}
