package com.example.fblithoframework.jetpack_compose.JavaCustomComponents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.fblithoframework.R;

public class MyCustomNumericView extends CardView {
    public TextView titleTv;
    public EditText dataTv;
    private Context mContext;

    public MyCustomNumericView(Context context) {
        super(context);
        init(context);
    }

    public MyCustomNumericView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.mycustomnumericview, this);
        titleTv = findViewById(R.id.title);
        dataTv = findViewById(R.id.data);
    }
    public void setData(String title, String number){
        titleTv.setText(title);
        dataTv.setText(number+"");
    }

    public void setnumber(String number){
        dataTv.setText(number+"");
    }
}
