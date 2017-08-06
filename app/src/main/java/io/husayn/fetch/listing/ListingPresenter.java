package io.husayn.fetch.listing;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.parceler.Parcels;

import java.util.List;

import io.husayn.fetch.FetchSampleApp;
import io.husayn.fetch.R;
import io.husayn.fetch.detail.DetailActivity;
import io.husayn.fetch.model.Item;
import io.husayn.fetch.utilities.NetworkUtility;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public class ListingPresenter implements ListingContract.Presenter {


    private static final String TAG = ListingPresenter.class.getSimpleName();
    private ListingContract.View view;
    private ListingDataAgent dataAgent;
    private Context context;
    private int currentOffset = 0;


    @Override
    public void setView(ListingContract.View view) {
        this.view = view;
    }


    @Override
    public void start() {
        setUpContext();
        setUpDataAgent();
        loadItems();
    }


    private void setUpContext() {
        this.context = FetchSampleApp.getContext();
    }


    private void setUpDataAgent() {
        dataAgent = new ListingDataAgent();
    }


    @Override
    public boolean isInternetAvailable() {
        return NetworkUtility.isInternetAvailable();
    }


    @Override
    public void loadItems() {
        if (isInternetAvailable()) {
            view.showLoadingIndicator();
            dataAgent.loadItems(this, currentOffset);
        } else
            onNoInternet();
    }


    @Override
    public void onItemsLoaded(List<Item> items) {
        view.hideLoadingIndicator();
        currentOffset += items.size();
        view.setItems(items);
    }


    @Override
    public void onNoInternet() {
        view.hideLoadingIndicator();
        view.onErrorAndNoInternet(context.getString(R.string.on_no_internet));
    }


    @Override
    public void onError(Throwable t) {
        view.hideLoadingIndicator();
        view.onErrorAndNoInternet(context.getString(R.string.on_error));
        Log.e(TAG, "Error while loading data in listing: " + t.getMessage());
    }


    @Override
    public void onItemClicked(Item item, Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("item", Parcels.wrap(item));
        context.startActivity(intent);
    }
}
