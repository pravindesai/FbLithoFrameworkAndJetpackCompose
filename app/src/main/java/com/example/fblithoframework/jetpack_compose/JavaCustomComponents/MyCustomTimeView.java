package com.example.fblithoframework.jetpack_compose.JavaCustomComponents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.fblithoframework.R;

public class MyCustomTimeView extends CardView {
    public TextView titleTv;
    public TextView dataTv;
    private Context mContext;

    public MyCustomTimeView(Context context) {
        super(context);
        init(context);
    }

    public MyCustomTimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.mycustomtimeview, this);
        titleTv = findViewById(R.id.title);
        dataTv = findViewById(R.id.data);
    }
    public void setData(String title, String time){
        titleTv.setText(title);
        dataTv.setText(time);
    }

    public void setTime(String time){
        dataTv.setText(time);
    }
}
