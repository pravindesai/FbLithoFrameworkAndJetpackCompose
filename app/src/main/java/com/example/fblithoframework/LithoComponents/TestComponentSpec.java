package com.example.fblithoframework.LithoComponents;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Column;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.OnCreateLayout;

@LayoutSpec
class TestComponentSpec {



    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c
    ) {
        return Column.create(c)
                .build();
    }



}