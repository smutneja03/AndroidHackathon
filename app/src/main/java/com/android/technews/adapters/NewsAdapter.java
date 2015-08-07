package com.android.technews.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.technews.R;
import com.android.technews.models.Collection1;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by smutneja03 on 07/08/15.
 */
public class NewsAdapter extends BaseAdapter{

    WeakReference<Context> contextWeakReference;
    List<Collection1> newsList;

    public NewsAdapter(Context context, List<Collection1> newsList){

        this.contextWeakReference = new WeakReference<Context>(context);
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Collection1 getItem(int i) {
        return newsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        TextView newsTitle ;
        TextView newsPublishedDate;
        TextView newsReadTime;
        TextView newsAuthor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(contextWeakReference.get());
            view = layoutInflater.inflate(R.layout.item_news, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.newsTitle = (TextView) view.findViewById(R.id.news_title);
            viewHolder.newsAuthor = (TextView) view.findViewById(R.id.news_author);
            viewHolder.newsReadTime = (TextView) view.findViewById(R.id.news_readTime);
            viewHolder.newsPublishedDate = (TextView) view.findViewById(R.id.news_date);

            view.setTag(viewHolder);
        }

        if (viewHolder == null) {
            viewHolder = (ViewHolder) view.getTag();
        }

        Collection1 news = getItem(position);

        viewHolder.newsTitle.setText(news.getArticleTitle().getText());
        viewHolder.newsAuthor.setText(news.getArticleAuthor().getText());
        viewHolder.newsReadTime.setText(news.getArticleReadTime());
        viewHolder.newsPublishedDate.setText(news.getArticleReadTime());

        return view;
    }
}
