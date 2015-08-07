package com.android.technews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import android.widget.AdapterView.OnItemSelectedListener;

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
public class AllNews extends Fragment {

    private Spinner spinner;
    private ListView listView;
    private List<Collection1> newsList = new ArrayList<>();
    private NewsAdapter newsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.all_news, container, false);
        listView = (ListView) view.findViewById(R.id.all_news);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
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

    public class CustomOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
            Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }
}
