package com.example.fblithoframework.Response;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Repository {
    Context context;
    public Repository(Context context) {
        this.context = context;
    }

    private String getLocalJson(){
        String json;
        try {
            InputStream is = context.getAssets().open("formDetails.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public List<FormDataItem> getSortedFormData(){

        Gson gson = new Gson();
        Response response = (Response) gson.fromJson(getLocalJson(), Response.class);
        Log.e("**Repository", "getSortedFormData: "+Thread.currentThread().getName() );

        List<FormDataItem> formDataList = response.getFormData();
        formDataList = SortByRowOrder(formDataList);

        return formDataList;
    }

    private List<FormDataItem> SortByRowOrder(List<FormDataItem> formDataList) {
        Comparator<FormDataItem> compareById = (FormDataItem o1, FormDataItem o2) ->
                Integer.valueOf(o1.getRowOrder()).compareTo( o2.getRowOrder() );

        Collections.sort(formDataList, compareById);

        return formDataList;
    }
}
