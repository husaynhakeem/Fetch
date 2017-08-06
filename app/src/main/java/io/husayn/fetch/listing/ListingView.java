package io.husayn.fetch.listing;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.husayn.fetch.R;
import io.husayn.fetch.model.Item;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public class ListingView extends Fragment implements ListingContract.View {


    private static final int SPAN_COUNT = 2;
    @BindView(R.id.rv_listing)
    RecyclerView listingRecyclerView;

    @BindView(R.id.pb_loading)
    ProgressBar loadingProgressBar;

    private Activity activity;
    private ListingAdapter listingAdapter;
    private Snackbar snackbar;
    private ListingContract.Presenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_listing, container, false);
        ButterKnife.bind(this, rootView);
        presenter.start();
        setUpViews();
        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (ListingActivity) context;
    }


    @Override
    public void setPresenter(ListingContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void setUpViews() {
        listingAdapter = new ListingAdapter(null, getContext());
        listingRecyclerView.setAdapter(listingAdapter);
        LinearLayoutManager listingLayoutManager = new LinearLayoutManager(getContext());
        listingRecyclerView.setLayoutManager(listingLayoutManager);
        listingRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(listingLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                presenter.loadItems();
            }
        });
    }


    @Override
    public void showLoadingIndicator() {
        loadingProgressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void hideLoadingIndicator() {
        loadingProgressBar.setVisibility(View.GONE);
    }


    @Override
    public void setItems(List<Item> items) {
        listingAdapter.putItems(items);
        listingAdapter.notifyDataSetChanged();
    }


    @Override
    public void onErrorAndNoInternet(String message) {
        if (snackbar != null && snackbar.isShown())
            snackbar.dismiss();
        snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(R.string.retry, view -> presenter.loadItems());
        snackbar.show();
    }
}
