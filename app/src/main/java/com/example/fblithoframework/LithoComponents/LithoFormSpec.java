package com.example.fblithoframework.LithoComponents;

import android.util.Log;

import com.example.fblithoframework.Response.FormDataItem;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.VerticalScroll;

import java.util.List;

@LayoutSpec
public class LithoFormSpec {

    private static final String TAG="**LithoForm";

    @OnCreateLayout
    static Component onCreateLayout(
           ComponentContext c,
            @Prop List<FormDataItem> formDataItems) {

            Column.Builder builder = Column.create(c);
            Log.e(TAG, "Ui size : "+formDataItems.size() );
            for (FormDataItem formDataItem: formDataItems) {
                Log.e("**LithoFormThread", "onCreateLayout: "+Thread.currentThread().getName() );

                switch (formDataItem.getFieldInputType()){
                    case "TEXT":
                        builder.child(LithoMyText.create(c).formDataItem(formDataItem));
                        break;
                    case "GPS":
                        builder.child(LithoMyGps.create(c).formDataItem(formDataItem));
                        break;
                    case "NUMERIC":
                        builder.child(LithoMyNumeric.create(c).formDataItem(formDataItem));
                        break;
                    case "TIME":
                        builder.child(LithoMyTime.create(c).formDataItem(formDataItem));
                        break;
                    case "DATE":
                        builder.child(LithoMyDate.create(c).formDataItem(formDataItem));
                        break;
                    case "PHOTOS":
                        builder.child(LithoMyPhotos.create(c).formDataItem(formDataItem));
                        break;

                }
                builder.child(LithoLine.create(c));
            }


            return VerticalScroll.create(c).childComponent(builder.build()).verticalFadingEdgeEnabled(true).fadingEdgeLengthDip(1).build();

        }
}
