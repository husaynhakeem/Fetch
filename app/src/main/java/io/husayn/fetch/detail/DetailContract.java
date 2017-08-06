package io.husayn.fetch.detail;

import io.husayn.fetch.BasePresenter;
import io.husayn.fetch.BaseView;

/**
 * Created by husaynhakeem on 8/6/17.
 */

public interface DetailContract {


    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
