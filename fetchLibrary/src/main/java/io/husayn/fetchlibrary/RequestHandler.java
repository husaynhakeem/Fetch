package io.husayn.fetchlibrary;

import android.content.Context;

import java.util.List;

import io.husayn.fetchlibrary.Fetch.ResourceType;
import io.reactivex.Observable;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public class RequestHandler<T> {


    public Observable<T> load(Context context,
                              List<String> urls,
                              ResourceType resourceType,
                              int itemsCount,
                              int cache) {

        switch (resourceType) {

            case IMAGE:
                return null;


            case JSON:
                new FetchJsonApi<T>(urls.get(0))
                        .apiInterface()
                        .getJsonObjects()
                        .take(itemsCount)
                        .cache();

            default:
                return null;
        }
    }
}
