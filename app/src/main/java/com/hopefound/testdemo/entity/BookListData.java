package com.hopefound.testdemo.entity;

import java.io.Serializable;

/**
 * Created by 王震 on 2018/4/20 0020.
 */

public class BookListData implements Serializable{
    /**
     * imageUrl : http://img.txt99.cc/Cover/39/39389.jpg
     * bookName : 医统江山
     * author : 作者：石章鱼
     * introduction : 前世过劳而死的医生转世大康第一奸臣之家，附身在聋哑十六年的白痴少年身上，究竟是他的幸运还是不...
     * id : 39389
     */

    private String imageUrl;
    private String bookName;
    private String author;
    private String introduction;
    private int id;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
