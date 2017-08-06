package io.husayn.fetch.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.parceler.Parcels;

import io.husayn.fetch.R;
import io.husayn.fetch.model.Item;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setUpDetail();
    }


    private void setUpDetail() {
        DetailView view = new DetailView();
        DetailPresenter presenter = new DetailPresenter();

        view.setPresenter(presenter);
        presenter.setView(view);

        Item item = Parcels.unwrap(getIntent().getParcelableExtra("item"));
        presenter.setItem(item);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.detail_frame, view)
                .commit();
    }
}
