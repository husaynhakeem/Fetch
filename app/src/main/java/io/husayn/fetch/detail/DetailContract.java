package io.husayn.fetch.detail;

import android.graphics.Bitmap;

import io.husayn.fetch.BasePresenter;
import io.husayn.fetch.BaseView;
import io.husayn.fetch.model.Item;

/**
 * Created by husaynhakeem on 8/6/17.
 */

public interface DetailContract {


    interface View extends BaseView<Presenter> {

        void setImage(Bitmap bitmap);

        void setUsername(String username);

        void setLikes(String likes);

        void setCreationDate(String creationDate);

        void setWidth(String width);

        void setHeight(String height);

        void setCategories(String categories);

        void setProfileImage(Bitmap bitmap);

        void setUserFullName(String fullName);
    }

    interface Presenter extends BasePresenter<View> {

        void setItem(Item item);

        void setImage();

        void onImageLoaded(Bitmap bitmap);

        void setUsername();

        void setLikes();

        void setCreationDate();

        void setWidth();

        void setHeight();

        void setCategories();

        void setProfileImage();

        void onProfileImageLoaded(Bitmap bitmap);

        void setUserFullName();

        void onImageLoadingError(Throwable t);

        void onProfileImageLoadingError(Throwable t);
    }
}
