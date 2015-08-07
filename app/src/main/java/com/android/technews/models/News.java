package com.android.technews.models;

/**
 * Created by smutneja03 on 07/08/15.
 */
public class News {

    String title;
    String date_added;
    String author;
    String min_read;

    public News(String title, String date_added, String author, String min_read) {
        this.title = title;
        this.date_added = date_added;
        this.author = author;
        this.min_read = min_read;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMin_read() {
        return min_read;
    }

    public void setMin_read(String min_read) {
        this.min_read = min_read;
    }
}
