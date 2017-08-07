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


    /**
     * Helper method to make the application context available
     * anywhere in the application (especially in helper classes)
     *
     * @return
     */
    public static Context getContext() {
        return context;
    }
}
