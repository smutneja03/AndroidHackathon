package com.android.technews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.technews.adapters.NewsAdapter;
import com.android.technews.models.Collection1;
import com.android.technews.models.TechNewsResponse;
import com.android.technews.network.NewsAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by smutneja03 on 07/08/15.
 */
public class LatestNews extends Fragment {

    private ListView listView;
    private List<Collection1> newsList = new ArrayList<>();
    private NewsAdapter newsAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.latest_news, container, false);
        listView = (ListView) view.findViewById(R.id.latest_news);

        NewsAPI.getApi().getMusicList(new Callback<TechNewsResponse>() {

            @Override
            public void success(TechNewsResponse musicApiResponse, Response response) {
                newsAdapter = new NewsAdapter(getActivity(), musicApiResponse.getResults().getCollection1());
                newsList = musicApiResponse.getResults().getCollection1();
                listView.setAdapter(newsAdapter);
            }

            @Override
            public void failure(RetrofitError error) {

            }

        });

        return view;
    }


}
