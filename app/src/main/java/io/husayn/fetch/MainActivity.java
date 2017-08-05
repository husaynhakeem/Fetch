package io.husayn.fetch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import io.husayn.fetchlibrary.Fetch;
import io.husayn.fetchlibrary.ResourceType;
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

        new Fetch(this).from("https://jsonplaceholder.typicode.com/posts")
                .ofType(ResourceType.JSON)
                .take(10)
                .cache(100)
                .load()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(posts -> resutlTextView.setText((String) posts),
                        t -> Log.e(TAG, "Error occured while fetching data: " + t));
    }
}
