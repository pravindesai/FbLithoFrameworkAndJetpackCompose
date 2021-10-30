package com.example.fblithoframework.LithoComponents;

import android.text.InputType;

import androidx.core.content.ContextCompat;

import com.example.fblithoframework.Response.FormDataItem;
import com.example.fblithoframework.R;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.State;
import com.facebook.litho.widget.Text;
import com.facebook.litho.widget.TextInput;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;

@LayoutSpec
public class LithoMyNumericSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext cc, @Prop FormDataItem formDataItem, @State String stringValue){
        return
                Column.create(cc).child(
                        Text.create(cc).textSizeDip(20).text(formDataItem.getFieldParameterLabel()).flex(1)
                ).child(
                        Row.create(cc).child(
                                TextInput.create(cc).textSizeDip(20).initialText(formDataItem.getStringValue()).flex(1)
                                        .inputType(InputType.TYPE_CLASS_NUMBER)
                                        .background(ContextCompat.getDrawable(cc.getApplicationContext(), R.drawable.edittextborder))
                                        .paddingDip(YogaEdge.LEFT,5).paddingDip(YogaEdge.RIGHT,5)
                        )
                                .paddingDip(YogaEdge.ALL, 5).alignItems(YogaAlign.CENTER)
                ).paddingDip(YogaEdge.ALL, 5).build();
    }


}
