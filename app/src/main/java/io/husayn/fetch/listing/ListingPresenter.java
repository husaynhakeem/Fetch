package io.husayn.fetch.listing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Log;
import android.widget.ImageView;

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
    private ListingModel dataAgent;
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
        dataAgent = new ListingModel();
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
    public void onItemClicked(Item item, Context context, ImageView imageView) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("item", Parcels.wrap(item));
        Bundle animationBundle = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, imageView, "image").toBundle();
        context.startActivity(intent, animationBundle);
    }


    @Override
    public void onLayoutRefresh() {
        currentOffset = 0;
        loadItems();
    }
}
