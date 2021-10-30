package com.example.fblithoframework.LithoComponents;

import com.example.fblithoframework.Response.FormDataItem;
import com.example.fblithoframework.Response.Repository;
import com.facebook.litho.StateValue;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.State;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.DataDiffSection;
import com.facebook.litho.sections.common.SingleComponentSection;
import com.facebook.litho.widget.Text;

import java.util.List;

@GroupSectionSpec
public class LithoListSectionSpec {

    @OnCreateChildren
    static Children onCreateChildren(
            final SectionContext c,
            @Prop List<FormDataItem> dataItems) {

        Children.Builder builder = Children.create();

        for (FormDataItem formDataItem:dataItems) {
            builder.child(
                    SingleComponentSection.create(c).component(Text.create(c)
                            .text(formDataItem.getStringValue())).build()
            );
        }

        return builder.build();
    }
}
