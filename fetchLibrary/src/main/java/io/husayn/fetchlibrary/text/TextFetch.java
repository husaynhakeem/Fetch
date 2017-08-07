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
     * @return Fetch object with the attribute 'urls' set
     */
    public TextFetch from(String url) {
        this.urls = Collections.singletonList(url);
        return this;
    }


    /**
     * @param itemsCount: Number of items to be fetched
     * @return Fetch object with the attribute 'itemCount' set
     */
    public TextFetch take(int itemsCount) {
        this.itemsCount = itemsCount;
        return this;
    }


    /**
     * Fetching for text only supports loading data from one source,
     * meaning one url. Which is why the first element from the urls list
     * is used (it is the only element in the list anyway)
     * <p>
     * The method starts by checking the attributes of the TextFetch object,
     * if any of the attributes isn't set correctly an Exception is thrown,
     * and the rest of this method isn't executed.
     *
     * @return Single object with the result String
     */
    public Single<String> load() {
        checkAgent.checkAttributes();
        return TextFetchApi.instance().load(urls.get(0));
    }
}
