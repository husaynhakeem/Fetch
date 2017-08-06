package io.husayn.fetch;

import android.app.Application;
import android.content.Context;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public class FetchSampleApp extends Application {


    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getBaseContext();
    }


    public static Context getContext() {
        return context;
    }
}
