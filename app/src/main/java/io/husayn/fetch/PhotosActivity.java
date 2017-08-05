package io.husayn.fetch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

import io.husayn.fetchlibrary.Fetch;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class PhotosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        List<String> urls = Arrays.asList("https://images.unsplash.com/profile-1441738874514-bf742aedca3c?ixlib=rb-0.3.5\\u0026q=80\\u0026fm=jpg\\u0026crop=faces\\u0026fit=crop\\u0026h=64\\u0026w=64\\u0026s=c6dfba1a18a9d641d4d345d7ec85606d",
                "https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5\\u0026q=80\\u0026fm=jpg\\u0026crop=faces\\u0026fit=crop\\u0026h=64\\u0026w=64\\u0026s=ef631d113179b3137f911a05fea56d23");

        final ImageView imageView = (ImageView) findViewById(R.id.iv_image);
        final ImageView imageView2 = (ImageView) findViewById(R.id.iv_image2);

        Fetch.forImage(this)
                .from(urls)
                .loadAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(images -> {
                    imageView.setImageBitmap(images.get(0));
                    imageView2.setImageBitmap(images.get(1));
                }, throwable -> Timber.e("Error, duuuuh!"));
    }
}
