package io.husayn.fetch.listing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.husayn.fetch.R;
import io.husayn.fetch.model.Item;
import io.husayn.fetchlibrary.Fetch;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by husaynhakeem on 8/6/17.
 */

public class ListingAdapter extends RecyclerView.Adapter<ListingItemVH> {


    private static final String TAG = ListingAdapter.class.getSimpleName();
    private List<Item> items;
    private Context context;


    public ListingAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @Override
    public ListingItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item, parent, false);
        return new ListingItemVH(itemView);
    }


    @Override
    public void onBindViewHolder(ListingItemVH holder, int position) {
        Fetch.forImage(context)
                .from(items.get(position).urls.regular)
                .load()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(holder.listingItemImageView::setImageBitmap,
                        t -> onBindViewHolderError(t, position));
    }


    private void onBindViewHolderError(Throwable t, int position) {
        Log.e(TAG, "Error while loading image for url " + items.get(position).urls.small + ", Error: " + t.getMessage());
    }


    public void putItems(List<Item> items) {
        if (this.items == null)
            this.items = new ArrayList<>();
        this.items.addAll(items);
    }


    @Override
    public int getItemCount() {
        return (items == null) ? 0 : items.size();
    }
}
