package io.husayn.fetch.detail;

/**
 * Created by husaynhakeem on 8/6/17.
 */

public class DetailPresenter implements DetailContract.Presenter {


    private DetailContract.View view;


    @Override
    public void setView(DetailContract.View view) {
        this.view = view;
    }


    @Override
    public void start() {

    }
}
