package com.example.fblithoframework;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

public class Loader {
    private static Loader loader;
    public static ProgressDialog progressDialog;

    private Loader() {
    }

    public static Loader getInstance(){
        if (loader == null){
            loader = new Loader();
        }
        return loader;
    }

    public void showLoader(Context context, String title){
        showLoader(context, title, "");
    }
    public void showLoader(Context context, String title, String msg){
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(title);
        progressDialog.setMessage(msg);
        progressDialog.show();
    }
    public void dismissLoader(){
        progressDialog.dismiss();
        Log.e("**loader", "dismissLoader: " );
    }
}
