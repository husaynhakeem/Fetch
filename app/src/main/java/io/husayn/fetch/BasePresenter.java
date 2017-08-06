package io.husayn.fetch;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public interface BasePresenter<T> {

    void setView(T view);

    void start();
}
