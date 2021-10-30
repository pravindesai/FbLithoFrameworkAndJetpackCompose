package com.example.fblithoframework.LithoComponents;

import com.example.fblithoframework.Response.FormDataItem;
import com.example.fblithoframework.R;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.State;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaWrap;

@LayoutSpec
public class LithoMyDateSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext cc, @Prop FormDataItem formDataItem, @State String stringValue){
        return
                Row.create(cc).child(
                        Text.create(cc).textSizeDip(20).text(formDataItem.getFieldParameterLabel()).flexBasisPercent(50).wrapInView()
        ).child(
                        Text.create(cc).textSizeDip(20).text(formDataItem.getStringValue()).flexBasisPercent(50)
                                .textColor(cc.getColor(R.color.qnopy)).paddingDip(YogaEdge.ALL,3)
        ).flexGrow(0).wrap(YogaWrap.WRAP).paddingDip(YogaEdge.ALL, 5).alignItems(YogaAlign.CENTER).build();

    }


}
