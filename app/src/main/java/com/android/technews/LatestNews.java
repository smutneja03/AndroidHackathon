package com.android.technews;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.app.Service;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

import com.android.technews.adapters.NewsAdapter;
import com.android.technews.models.Collection1;
import com.android.technews.models.TechNewsResponse;
import com.android.technews.network.NewsAPI;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by smutneja03 on 07/08/15.
 */
public class LatestNews extends Fragment {

private LinearLayout llAnchor;
    private WebView newsBrowser;
    private ListView listView;
    private List<Collection1> newsList = new ArrayList<>();
    private NewsAdapter newsAdapter;
    private ProgressDialog mProgressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.latest_news, container, false);
        listView = (ListView) view.findViewById(R.id.latest_news);
        llAnchor = (LinearLayout) view.findViewById(R.id.llAnchor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(), "You clicked: " + String.valueOf(position), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "Result: " + newsList.get(position).getArticleTitle().getHref().toString(), Toast.LENGTH_SHORT).show();
            openPopup(newsList.get(position).getArticleTitle().getHref().toString());
            }
        });

        showProgressDialog();

        NewsAPI.getApi().getMusicList(new Callback<TechNewsResponse>() {

            @Override
            public void success(TechNewsResponse musicApiResponse, Response response) {
                newsAdapter = new NewsAdapter(getActivity(), musicApiResponse.getResults().getCollection1());
                newsList = musicApiResponse.getResults().getCollection1();
                listView.setAdapter(newsAdapter);

                if (mProgressDialog.isShowing()) {
                    hideProgressDialog();
                }

            }

            @Override
            public void failure(RetrofitError error) {

            }

        });

        return view;
    }

    private void showProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.getWindow().setGravity(Gravity.CENTER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setTitle("Please Wait");
        mProgressDialog.setMessage("The news are loading...");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();

    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    private void openPopup(String browserURL) {

        LayoutInflater layoutInflater = (LayoutInflater) getActivity()
                .getBaseContext().getSystemService(
                        Service.LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.news_popup, null);
        final PopupWindow popupWindow = new PopupWindow(popupView,
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        newsBrowser = (WebView) popupView.findViewById(R.id.webView);
        newsBrowser.loadUrl(browserURL);
        newsBrowser.getSettings().setDefaultTextEncodingName("utf-8");
        newsBrowser.requestFocus();
        newsBrowser.setWebViewClient(new WebViewClient() {
            @SuppressLint("NewApi")
            @Override
            public void onPageFinished(WebView view, String url) {
                hideProgressDialog();
            }
        });

        popupWindow.setFocusable(true);
        Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
        btnDismiss.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.showAsDropDown(llAnchor, 0, 0);
        showProgressDialog();

    }

}
