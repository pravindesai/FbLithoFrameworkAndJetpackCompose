package com.example.fblithoframework.jetpack_compose.JavaCustomComponents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.fblithoframework.R;

public class MyCustomGpsView extends CardView {
    public TextView titleTv;
    public TextView dataTv;
    public ImageView image;
    private Context mContext;

    public MyCustomGpsView(Context context) {
        super(context);
        init(context);
    }

    public MyCustomGpsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.mycustomgpsview, this);
        titleTv = findViewById(R.id.title);
        dataTv = findViewById(R.id.data);
        image = findViewById(R.id.imageView);
        image.setOnClickListener(view -> Toast.makeText(context, "TODO GET LOCATION", Toast.LENGTH_SHORT).show());
    }
    public void setData(String title, String date){
        titleTv.setText(title);
        dataTv.setText(date);
    }

    public void setText(String time){
        dataTv.setText(time);
    }
}
