package io.husayn.fetch.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import io.husayn.fetch.FetchSampleApp;
import io.husayn.fetch.R;
import io.husayn.fetch.model.Item;
import io.husayn.fetch.utilities.DateUtility;

/**
 * Created by husaynhakeem on 8/6/17.
 */

public class DetailPresenter implements DetailContract.Presenter {


    private static final String TAG = DetailPresenter.class.getSimpleName();
    private DetailContract.View view;
    private DetailModel model;
    private Context context;
    private Item item;


    @Override
    public void setView(DetailContract.View view) {
        this.view = view;
    }


    @Override
    public void start() {
        if (item == null)
            return;

        setUpModel();
        setUpContext();

        setImage();
        setUsername();
        setLikes();
        setCreationDate();
        setWidth();
        setHeight();
        setCategories();
        setProfileImage();
        setUserFullName();
    }


    private void setUpModel() {
        this.model = new DetailModel();
    }


    private void setUpContext() {
        this.context = FetchSampleApp.getContext();
    }


    @Override
    public void setItem(Item item) {
        this.item = item;
    }


    @Override
    public void setImage() {
        model.loadImage(this, context, item.urls.regular);
    }


    @Override
    public void onImageLoaded(Bitmap bitmap) {
        view.setImage(bitmap);
    }


    @Override
    public void setUsername() {
        view.setUsername(item.user.username);
    }


    @Override
    public void setLikes() {
        view.setLikes(String.valueOf(item.likes));
    }


    @Override
    public void setCreationDate() {
        view.setCreationDate(DateUtility.formatDate(item.created_at));
    }


    @Override
    public void setWidth() {
        view.setWidth(context.getString(R.string.width_value, item.width));
    }


    @Override
    public void setHeight() {
        view.setHeight(context.getString(R.string.height_value, item.height));
    }


    @Override
    public void setCategories() {
        view.setCategories(model.getCategories(item));
    }


    @Override
    public void setProfileImage() {
        model.loadProfileImage(this, context, item.user.profile_image.small);
    }


    @Override
    public void onProfileImageLoaded(Bitmap bitmap) {
        view.setProfileImage(bitmap);
    }


    @Override
    public void setUserFullName() {
        view.setUserFullName(item.user.name);
    }


    @Override
    public void onImageLoadingError(Throwable t) {
        view.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_no_image));
        Log.e(TAG, "Error while loading image " + item.urls.regular + ", Error: " + t.getMessage());
    }


    @Override
    public void onProfileImageLoadingError(Throwable t) {
        view.setProfileImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_no_profile_image));
        Log.e(TAG, "Error while loading profile image " + item.user.profile_image.small + ", Error: " + t.getMessage());
    }
}
