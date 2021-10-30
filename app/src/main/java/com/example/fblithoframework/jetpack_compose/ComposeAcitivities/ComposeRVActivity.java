package com.example.fblithoframework.jetpack_compose.ComposeAcitivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.ComposeView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fblithoframework.ComposeComposables;
import com.example.fblithoframework.R;
import com.example.fblithoframework.jetpack_compose.JavaCustomComponents.MyCustomTimeView;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class ComposeRVActivity extends AppCompatActivity {
    RvFragment rvFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_rvactivity);

        rvFragment = (RvFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);

    }

    public void addView(View view) {
        MyCustomTimeView myCustomTimeView = new MyCustomTimeView(this);
        RvFragment.Companion.addView(myCustomTimeView);

    }
}