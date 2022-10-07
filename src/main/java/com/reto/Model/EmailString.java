package com.reto.Model;

import java.util.List;

public class EmailString {
    private List<String> data;

    public EmailString(List<String> data) {
        this.data = data;
    }

    public EmailString() {
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
