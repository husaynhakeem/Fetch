package io.husayn.fetch.utilities;

import android.content.Context;
import android.net.ConnectivityManager;

import io.husayn.fetch.FetchSampleApp;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public class NetworkUtility {


    /**
     * @return Whether or not the device is connected to the internet
     */
    public static boolean isInternetAvailable() {
        ConnectivityManager manager = (ConnectivityManager) FetchSampleApp.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return manager.getActiveNetworkInfo() != null && manager.getActiveNetworkInfo().isConnected();
    }
}
