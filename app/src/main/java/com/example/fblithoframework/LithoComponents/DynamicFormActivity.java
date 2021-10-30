package com.example.fblithoframework.LithoComponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.fblithoframework.Response.Repository;
import com.example.fblithoframework.Loader;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;

public class DynamicFormActivity extends AppCompatActivity {
    Repository repository;
    private String TAG="**Dynamic_Form_Activity ";
    Component form;
    LithoView formView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository(this);
        ComponentContext cc = new ComponentContext(this);
        Log.e(TAG, "onCreate: "+repository.getSortedFormData() );

        Loader.getInstance().showLoader(this, "Loading...");
        form = LithoForm.create(cc).formDataItems(repository.getSortedFormData()).build();
        formView = LithoView.create(this, form);
        setContentView(formView);
        Loader.getInstance().dismissLoader();

    }
}