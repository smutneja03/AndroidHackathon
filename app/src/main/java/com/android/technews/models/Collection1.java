
package com.android.technews.models;

import com.google.gson.annotations.Expose;

public class Collection1 {

    @Expose
    private ArticleTitle articleTitle;
    @Expose
    private String articleDate;
    @Expose
    private ArticleAuthor articleAuthor;
    @Expose
    private String articleReadTime;
    @Expose
    private Integer index;
    @Expose
    private String url;

    /**
     * 
     * @return
     *     The articleTitle
     */
    public ArticleTitle getArticleTitle() {
        return articleTitle;
    }

    /**
     * 
     * @param articleTitle
     *     The articleTitle
     */
    public void setArticleTitle(ArticleTitle articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * 
     * @return
     *     The articleDate
     */
    public String getArticleDate() {
        return articleDate;
    }

    /**
     * 
     * @param articleDate
     *     The articleDate
     */
    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    /**
     * 
     * @return
     *     The articleAuthor
     */
    public ArticleAuthor getArticleAuthor() {
        return articleAuthor;
    }

    /**
     * 
     * @param articleAuthor
     *     The articleAuthor
     */
    public void setArticleAuthor(ArticleAuthor articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    /**
     * 
     * @return
     *     The articleReadTime
     */
    public String getArticleReadTime() {
        return articleReadTime;
    }

    /**
     * 
     * @param articleReadTime
     *     The articleReadTime
     */
    public void setArticleReadTime(String articleReadTime) {
        this.articleReadTime = articleReadTime;
    }

    /**
     * 
     * @return
     *     The index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * 
     * @param index
     *     The index
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
