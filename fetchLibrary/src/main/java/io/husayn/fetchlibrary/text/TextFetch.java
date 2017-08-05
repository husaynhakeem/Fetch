package io.husayn.fetchlibrary.text;

import android.content.Context;

import java.util.Collections;

import io.husayn.fetchlibrary.Fetch;
import io.husayn.fetchlibrary.ResourceType;
import io.husayn.fetchlibrary.helper.CheckAgent;
import io.reactivex.Single;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public class TextFetch extends Fetch {


    public TextFetch(Context context) {
        this.context = context;
        this.resourceType = ResourceType.TEXT;
        checkAgent = new CheckAgent(this);
    }


    /**
     * @param url: URL from which data will be fetched
     * @return Fetcher object with the attribute 'urls' set
     */
    public TextFetch from(String url) {
        this.urls = Collections.singletonList(url);
        return this;
    }


    /**
     * @param itemsCount: Number of items to be fetched
     * @return Fetcher object with the attribute 'itemCount' set
     */
    public TextFetch take(int itemsCount) {
        this.itemsCount = itemsCount;
        return this;
    }


    /**
     * @param cache
     * @return Fetcher object with the attribute 'cache' set
     */
    public TextFetch cache(int cache) {
        this.cache = cache;
        return this;
    }


    public Single<String> load() {
        checkAgent.checkAttributes();
        return TextFetchApi.instance()
                .load(urls.get(0))
                .cache();
    }
}
