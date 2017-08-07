package io.husayn.fetch.detail;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.husayn.fetch.R;

/**
 * Created by husaynhakeem on 8/6/17.
 */

public class DetailView extends Fragment implements DetailContract.View {


    @BindView(R.id.iv_detail_image)
    ImageView detailImageView;

    @BindView(R.id.tv_image_by_username)
    TextView usernameTextView;

    @BindView(R.id.tv_image_by_onsplash)
    TextView onsplaseTextView;

    @BindView(R.id.tv_image_likes)
    TextView likesTextView;

    @BindView(R.id.tv_created_value)
    TextView createdAtTextView;

    @BindView(R.id.tv_width_value)
    TextView widthTextView;

    @BindView(R.id.tv_height_value)
    TextView heightTextView;

    @BindView(R.id.tv_categories_value)
    TextView categoriesTextView;

    @BindView(R.id.iv_profile_image)
    ImageView profileImageView;

    @BindView(R.id.tv_user_name)
    TextView userFullNameTextView;

    @BindView(R.id.fab_profile)
    FloatingActionButton profileFab;

    private DetailContract.Presenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, rootView);
        presenter.start();
        return rootView;
    }


    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void setImage(Bitmap bitmap) {
        detailImageView.setImageBitmap(bitmap);
    }


    @Override
    public void setUsername(String username) {
        usernameTextView.setText(username);
    }


    @Override
    public void setLikes(String likes) {
        likesTextView.setText(likes);
    }


    @Override
    public void setCreationDate(String creationDate) {
        createdAtTextView.setText(creationDate);
    }


    @Override
    public void setWidth(String width) {
        widthTextView.setText(width);
    }


    @Override
    public void setHeight(String height) {
        heightTextView.setText(height);
    }


    @Override
    public void setCategories(String categories) {
        categoriesTextView.setText(categories);
    }


    @Override
    public void setProfileImage(Bitmap bitmap) {
        profileImageView.setImageBitmap(bitmap);
    }


    @Override
    public void setUserFullName(String fullName) {
        userFullNameTextView.setText(fullName);
    }
}
