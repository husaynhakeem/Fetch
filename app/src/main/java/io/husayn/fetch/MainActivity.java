package io.husayn.fetch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.husayn.fetchlibrary.Fetch;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getName();
    TextView resutlTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resutlTextView = (TextView) findViewById(R.id.tv_result);

        new Fetch<List<Post>>(this).from("")
                .cache(100)
                .ofType(Fetch.ResourceType.JSON)
                .take(10)
                .load()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(posts -> resutlTextView.setText("Posts size: " + posts.size()),
                        t -> Log.e(TAG, "Error occured while fetching data: " + t.getMessage()),
                        () -> Log.d(TAG, "Done fetching data"));
    }


    class Post {

        @SerializedName("userId")
        @Expose
        public int userId;

        @SerializedName("id")
        @Expose
        public int id;

        @SerializedName("title")
        @Expose
        public String title;

        @SerializedName("body")
        @Expose
        public String body;
    }
}
