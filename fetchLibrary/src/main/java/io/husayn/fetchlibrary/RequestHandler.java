package io.husayn.fetchlibrary;

import android.content.Context;

import java.util.List;

import io.reactivex.Single;
import io.husayn.fetchlibrary.Fetch.ResourceType;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public class RequestHandler<T> {


    public Single<T> load(Context context, List<String> urls, ResourceType resourceType, int itemsCount, int cache) {

        switch (resourceType) {

            case IMAGE:
                return null;


            case JSON:
                new FetchJsonApi<T>(urls.get(0)).apiInterface().getJsonObjects();

                default:
                    return null;
        }
    }
}
