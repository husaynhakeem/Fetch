package io.husayn.fetch.detail;

import android.support.v4.app.Fragment;

/**
 * Created by husaynhakeem on 8/6/17.
 */

public class DetailView extends Fragment implements DetailContract.View {


    private DetailContract.Presenter presenter;


    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
