package com.example.fblithoframework.LithoComponents;

import androidx.recyclerview.widget.OrientationHelper;

import com.example.fblithoframework.Response.FormDataItem;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.ChangeSetCompleteCallback;
import com.facebook.litho.widget.ComponentRenderInfo;
import com.facebook.litho.widget.LinearLayoutInfo;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;
import com.facebook.litho.widget.RenderInfo;

import java.util.ArrayList;
import java.util.List;

@LayoutSpec
class RVSpec {

  @OnCreateInitialState
  static void onCreateInitialState(ComponentContext c) {

  }

  @OnCreateLayout
  static Component onCreateLayout(ComponentContext c,  @Prop List<FormDataItem> formDataItems) {

      final RecyclerBinder recyclerBinder = new RecyclerBinder.Builder()
                      .layoutInfo(new LinearLayoutInfo(c, OrientationHelper.VERTICAL, false))
                      .build(c);
      loadAsyncViews(c, recyclerBinder, formDataItems);

//      for (FormDataItem formDataItem: formDataItems) {
//          Log.e("**LithoFormThread", "onCreateLayout: "+Thread.currentThread().getName() );
//
//          switch (formDataItem.getFieldInputType()){
//              case "TEXT":
//                  recyclerBinder.insertItemAt(0, LithoMyText.create(c).formDataItem(formDataItem).build());
//                  break;
//              case "GPS":
//                  recyclerBinder.insertItemAt(0,LithoMyGps.create(c).formDataItem(formDataItem).build());
//                  break;
//              case "NUMERIC":
//                  recyclerBinder.insertItemAt(0,LithoMyNumeric.create(c).formDataItem(formDataItem).build());
//                  break;
//              case "TIME":
//                  recyclerBinder.insertItemAt(0,LithoMyTime.create(c).formDataItem(formDataItem).build());
//                  break;
//              case "DATE":
//                  recyclerBinder.insertItemAt(0,LithoMyDate.create(c).formDataItem(formDataItem).build());
//                  break;
//              case "PHOTOS":
//                  recyclerBinder.insertItemAt(0,LithoMyPhotos.create(c).formDataItem(formDataItem).build());
//                  break;
//
//          }
//      }


//      for (int i = 0; i < 50; i++) {
//
//          RenderInfo renderInfo = ComponentRenderInfo.create().component(
//                  Text.create(c).text("Item: " + i + "  "+Thread.currentThread().getName()).textSizeDip(20).build()
//          ).build();
//
//          recyclerBinder.insertItemAtAsync(i, renderInfo);
//          recyclerBinder.notifyChangeSetCompleteAsync(true, new ChangeSetCompleteCallback() {
//              @Override
//              public void onDataBound() {
//                  Log.e("**", "onDataBound: " );
//              }
//
//              @Override
//              public void onDataRendered(boolean isMounted, long uptimeMillis) {
//                  Log.e("**", "onDataRendered: " );
//
//              }
//          });
//
//      }

      return Recycler.create(c).binder(recyclerBinder).build();

  }

    private static void loadAsyncViews(ComponentContext c, RecyclerBinder recyclerBinder, List<FormDataItem> formDataItems) {
        final ArrayList<Component> components = new ArrayList<>();
        final ArrayList<RenderInfo> renderInfos = new ArrayList<>();
        Component component = null;

        for (FormDataItem formDataItem: formDataItems) {
            switch (formDataItem.getFieldInputType()){
                case "TEXT":
                     component =  LithoMyText.create(c).formDataItem(formDataItem).build();
                    break;
                case "GPS":
                    component = LithoMyGps.create(c).formDataItem(formDataItem).build();
                    break;
                case "NUMERIC":
                    component = LithoMyNumeric.create(c).formDataItem(formDataItem).build();
                    break;
                case "TIME":
                    component = LithoMyTime.create(c).formDataItem(formDataItem).build();
                    break;
                case "DATE":
                    component = LithoMyDate.create(c).formDataItem(formDataItem).build();
                    break;
                case "PHOTOS":
                    component = LithoMyPhotos.create(c).formDataItem(formDataItem).build();
                    break;
            }

            if (component!=null) {
                components.add(component);
                renderInfos.add(ComponentRenderInfo.create().component(component).build());
            }
        }

        recyclerBinder.insertRangeAtAsync(0, renderInfos);
        recyclerBinder.notifyChangeSetCompleteAsync(true, new ChangeSetCompleteCallback() {
            @Override
            public void onDataBound() {

            }

            @Override
            public void onDataRendered(boolean isMounted, long uptimeMillis) {

            }
        });
  }

}