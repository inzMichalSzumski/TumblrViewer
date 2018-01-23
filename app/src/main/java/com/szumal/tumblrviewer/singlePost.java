package com.szumal.tumblrviewer;

/**
 * Created by szuma on 19.01.2018.
 */

public class singlePost {
    String title, text, tags, imgurl, date;
    Long id;

    public singlePost(Long id, String title, String text, String tags, String imgurl, String date){
        this.title = title;
        this.text = text;
        this.tags = tags;
        this.imgurl = imgurl;
        this.id = id;
        this.date = date;
    }

    public singlePost(){};

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getTags() {
        return tags;
    }

    public String getImgurl() {
        return imgurl;
    }

    public String getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
