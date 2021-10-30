package com.example.fblithoframework.LithoComponents;

import android.text.InputType;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.example.fblithoframework.Response.FormDataItem;
import com.example.fblithoframework.R;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.StateValue;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnUpdateState;
import com.facebook.litho.annotations.Param;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.State;
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.litho.widget.TextInput;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;

@LayoutSpec
public class LithoMyTextSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext cc, @Prop FormDataItem formDataItem, @State String stringValue){

        return
                Column.create(cc).child(
                        Text.create(cc).textSizeDip(20).text(formDataItem.getFieldParameterLabel()).flex(1)
                ).child(
                        Row.create(cc).child(
                                TextInput.create(cc).textSizeDip(20).initialText(formDataItem.getStringValue()).flex(1)
                                        .inputType(InputType.TYPE_CLASS_TEXT)
                                        .background(ContextCompat.getDrawable(cc.getApplicationContext(), R.drawable.edittextborder))
                                        .paddingDip(YogaEdge.LEFT,5).paddingDip(YogaEdge.RIGHT,5)
                            ).child(
                                Image.create(cc).drawableRes(R.drawable.ic_baseline_cancel_24).scaleType(ImageView.ScaleType.CENTER).heightDip(24).widthDip(24).flex(0)
                                        .marginDip(YogaEdge.ALL,3)).paddingDip(YogaEdge.ALL, 5).alignItems(YogaAlign.CENTER)
                ).paddingDip(YogaEdge.ALL, 5).build();
    }

    @OnCreateInitialState
    static void onCreateInitialState(ComponentContext c, StateValue<String> stringValue) {

    }



    @OnUpdateState
    static void UpdateName(StateValue<String> stringValue, @Param String value){
            stringValue.set(value);
    }

}
