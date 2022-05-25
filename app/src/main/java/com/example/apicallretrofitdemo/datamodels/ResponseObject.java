package com.example.apicallretrofitdemo.datamodels;


/**
 * Created by Mitesh on 12/03/16.
 */
public class ResponseObject<R> {

    private String code;

    private String description;

    private R data;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public R getData() {
        return data;
    }
}
