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

public class ListingDataAgent {


    private static final String BASE_URL = "http://pastebin.com/raw/wgkJgazE";
    private static final int ITEMS_TO_TAKE = 10;


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


    private List<Item> fromJsonToItemsList(String s) {
        Type listType = new TypeToken<List<Item>>() {}.getType();
        return new Gson().fromJson(s, listType);
    }
}
