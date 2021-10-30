package com.example.fblithoframework.LithoComponents;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.fblithoframework.Response.Repository;
import com.example.fblithoframework.R;
import java.util.ArrayList;

import com.facebook.litho.widget.Text;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.common.SingleComponentSection;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;


public class LithoRvAndroidViewsActivity extends AppCompatActivity {
    Repository repository;
    ComponentContext c;
//    Component recyclerViewCom;
//    LithoView reclclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litho_rv);



        c = new ComponentContext(this);
        repository = new Repository(this);

//        recyclerViewCom = AndroidViewsLithoRv.create(c).formDataItems(repository.getSortedFormData()).build();
//        reclclerView = LithoView.create(c, recyclerViewCom);
//        setContentView(reclclerView);


        SingleComponentSection section = SingleComponentSection.create(new SectionContext(this))
                .component(Text.create(c).text("content").textSizeDip(30).build())
                .build();

        Log.e("**", "Section--> "+section );

        try {
            RecyclerCollectionComponent component = RecyclerCollectionComponent.create(c).section(
                    section
            ).disablePTR(true).build();
        }catch (Exception e){
            Log.e("**", "Exception-->  "+e.getCause() );
        }

    }


}