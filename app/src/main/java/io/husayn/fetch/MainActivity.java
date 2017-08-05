package io.husayn.fetch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
        resutlTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PhotosActivity.class));
            }
        });
        Fetch.forText(this)
                .from("https://jsonplaceholder.typicode.com/posts")
                .load()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(posts -> resutlTextView.setText(posts),
                        t -> Log.e(TAG, "Error occured while fetching data: " + t));
    }
}
