package io.husayn.fetch.detail;

import android.content.Context;

import java.util.List;

import io.husayn.fetch.model.Item;
import io.husayn.fetchlibrary.Fetch;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by husaynhakeem on 8/7/17.
 */

public class DetailModel {


    public String getCategories(Item item) {
        StringBuilder categoriesBuilder = new StringBuilder();
        List<Item.Category> categories = item.categories;

        for (int i = 0; i < categories.size(); i++) {
            if (i != 0)
                categoriesBuilder.append(", ");
            Item.Category category = categories.get(i);
            categoriesBuilder.append(category.title);
        }

        return categoriesBuilder.toString();
    }


    public void loadImage(DetailContract.Presenter presenter, Context context, String url) {
        Fetch.forImage(context)
                .from(url)
                .load()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(presenter::onImageLoaded, presenter::onImageLoadingError);
    }


    public void loadProfileImage(DetailContract.Presenter presenter, Context context, String url) {
        Fetch.forImage(context)
                .from(url)
                .load()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(presenter::onProfileImageLoaded, presenter::onProfileImageLoadingError);
    }
}
