package com.example.fblithoframework.LithoComponents;

import com.example.fblithoframework.R;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaWrap;

@LayoutSpec
public class LithoLineSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext cc){
        return
                Row.create(cc).child(
                            Text.create(cc).text("")
                        ).alignItems(YogaAlign.CENTER)
                        .heightDip(1).backgroundColor(cc.getColor(R.color.grey))
                    .marginDip(YogaEdge.RIGHT, 20).marginDip(YogaEdge.LEFT, 20)
                    .marginDip(YogaEdge.BOTTOM, 10).marginDip(YogaEdge.TOP, 10)
                    .flexGrow(0).wrap(YogaWrap.WRAP).alignItems(YogaAlign.CENTER).build();

    }

}
