package com.example.fblithoframework.jetpack_compose.JavaCustomComponents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.fblithoframework.R;

public class MyCustomDateView extends CardView {
    public TextView titleTv;
    public TextView dataTv;
    private Context mContext;

    public MyCustomDateView(Context context) {
        super(context);
        init(context);
    }

    public MyCustomDateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.mycustomdateview, this);
        titleTv = findViewById(R.id.title);
        dataTv = findViewById(R.id.data);
    }
    public void setData(String title, String date){
        titleTv.setText(title);
        dataTv.setText(date);
    }

    public void setDate(String time){
        dataTv.setText(time);
    }
}
