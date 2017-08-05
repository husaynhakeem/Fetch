package io.husayn.fetchlibrary;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public class FetchJsonApi<T> {

    private Retrofit retrofit;
    private FetchJsonApiInterface apiInterface;


    public FetchJsonApi(String url) {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
        apiInterface = retrofit.create(FetchJsonApiInterface.class);
    }


    public FetchJsonApiInterface apiInterface() {
        return apiInterface;
    }


    interface FetchJsonApiInterface<T> {

        @GET("")
        Single<List<T>> getJsonObjects();
    }
}
