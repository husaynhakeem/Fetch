package io.husayn.fetch.listing;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.husayn.fetch.R;

/**
 * Created by husaynhakeem on 8/6/17.
 */

public class ListingItemVH extends RecyclerView.ViewHolder {


    @BindView(R.id.iv_listing_item)
    ImageView listingItemImageView;


    public ListingItemVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
