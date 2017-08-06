package io.husayn.fetch.listing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.husayn.fetch.R;

public class ListingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        setupListing();
    }


    private void setupListing() {
        ListingView view = new ListingView();
        ListingPresenter presenter = new ListingPresenter();

        view.setPresenter(presenter);
        presenter.setView(view);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.listing_frame, view)
                .commit();
    }
}
