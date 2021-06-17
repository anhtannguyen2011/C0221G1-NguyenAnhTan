package com.practice.model.base;

public class LetterElectric {
    private String language;
    private int pagesize;
    private boolean filter;
    private String signature;

    public LetterElectric() {
    }

    public LetterElectric(String language, int pagesize, boolean filter, String signature) {
        this.language = language;
        this.pagesize = pagesize;
        this.filter = filter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
