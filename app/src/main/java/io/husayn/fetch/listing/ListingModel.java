package io.husayn.fetch.listing;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import io.husayn.fetch.FetchSampleApp;
import io.husayn.fetch.model.Item;
import io.husayn.fetchlibrary.Fetch;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public class ListingModel {


    // URL from which the data in the listing are taken.
    private static final String BASE_URL = "http://pastebin.com/raw/wgkJgazE";

    // Number of items to take on each network call
    private static final int ITEMS_TO_TAKE = 10;


    /**
     * This method doesn't take into consideration the offset, even though in a real
     * world application it should (it must). Even though this offset is incremented
     * before each call of this method, the same set of data is always returned (in
     * order to implement an infinite scrolling list).
     *
     * @param presenter
     * @param offset
     */
    public void loadItems(ListingContract.Presenter presenter, int offset) {
        Fetch.forText(FetchSampleApp.getContext())
                .from(BASE_URL)
                .take(ITEMS_TO_TAKE)
                .load()
                .map(this::fromJsonToItemsList)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(presenter::onItemsLoaded, presenter::onError);
    }


    /**
     * Converts a JSON string to a list og objects of type 'Item'.
     * Ideally, this should be the work of the 'Fetch' library, but
     * I wasn't able to find a way to do so.
     *
     * @param s JSON string
     * @return List of items converted from the input JSON
     */
    private List<Item> fromJsonToItemsList(String s) {
        Type listType = new TypeToken<List<Item>>() {
        }.getType();
        return new Gson().fromJson(s, listType);
    }
}
