package com.example.fblithoframework.LithoComponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fblithoframework.Response.Repository;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;

public class RecyclerViewActivity extends AppCompatActivity {
    Repository repository;
    ComponentContext c;
    Component recyclerViewCom;
    LithoView reclclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dynamic_form3);
        c = new ComponentContext(this);
        repository = new Repository(this);

        recyclerViewCom = RV.create(c).formDataItems(repository.getSortedFormData()).build();
        reclclerView = LithoView.create(c, recyclerViewCom);

        setContentView(reclclerView);

    }
}