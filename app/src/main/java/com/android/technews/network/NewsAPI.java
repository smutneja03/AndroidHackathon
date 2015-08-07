package com.android.technews.network;

import com.android.technews.models.TechNewsResponse;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;

/**
 * Created by smutneja03 on 07/08/15.
 */
public class NewsAPI {

    public static final String URL = "https://www.kimonolabs.com/api";

    private static NewsInterface newsInterface = null;

    public static NewsInterface getApi(){

        if(newsInterface==null){
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(URL)
                    .build();
            newsInterface = restAdapter.create(NewsInterface.class);
        }

        return newsInterface;
    }


    public interface NewsInterface{

        @GET("/adc3ibb2?apikey=82KraFmAvNd95FiNNHN8Toai9Amc2b3G")
        void getMusicList(Callback<TechNewsResponse> musicApiResponseCallback);
    }
}
