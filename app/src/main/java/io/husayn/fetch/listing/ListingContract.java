package io.husayn.fetch.listing;

import java.util.List;

import io.husayn.fetch.BasePresenter;
import io.husayn.fetch.BaseView;
import io.husayn.fetch.model.Item;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public interface ListingContract {

    interface View extends BaseView<Presenter> {

        void setUpViews();

        void showLoadingIndicator();

        void hideLoadingIndicator();

        void setItems(List<Item> items);

        void onErrorAndNoInternet(String message);

        void goUpListing();
    }


    interface Presenter extends BasePresenter<View> {

        boolean isInternetAvailable();

        void loadItems();

        void onItemsLoaded(List<Item> items);

        void onNoInternet();

        void onError(Throwable t);

        void onItemClicked(Item item);
    }
}
