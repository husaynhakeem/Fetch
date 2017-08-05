package io.husayn.fetchlibrary;

import android.content.Context;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public class RequestHandler<T> {


    private static final int FIRST_URL_index = 0;

    public Single load(Context context, List<String> urls, ResourceType resourceType, int itemsCount, int cache) {

        switch (resourceType) {

            case IMAGE:
                return null;

            case JSON:
                return FetchJsonApi.instance().load(urls.get(FIRST_URL_index));

            default:
                return null;
        }
    }
}
