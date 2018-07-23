package com.android.extremez.sharepreferencestest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.meiyou.jet.myapplication.R;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {
    ArrayList<Bean> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        initData();

        RecyclerView rv = findViewById(R.id.recycle_view);

        GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (dataList.get(position).isTitle) {
                    return 3;
                } else {
                    return 1;
                }
            }
        });
        rv.setLayoutManager(manager);

        rv.setAdapter(new MyAdapter(this,dataList));
    }

    private void initData() {
        dataList.add(new Bean(0, true, "Head1"));

        dataList.add(new Bean(0, false, "item1"));
        dataList.add(new Bean(0, false, "item2"));
        dataList.add(new Bean(0, false, "item3"));
        dataList.add(new Bean(0, false, "item4"));
        dataList.add(new Bean(0, false, "item5"));

        dataList.add(new Bean(1, true, "Head2"));

        dataList.add(new Bean(1, false, "item1"));
        dataList.add(new Bean(1, false, "item2"));
        dataList.add(new Bean(1, false, "item3"));
        dataList.add(new Bean(1, false, "item4"));
        dataList.add(new Bean(1, false, "item5"));

    }

    class Bean {
        public int group = 0;
        public boolean isTitle = false;
        public String text = "bean";

        public Bean(int group, boolean isTitle, String text) {
            this.group = group;
            this.isTitle = isTitle;
            this.text = text;
        }
    }

}
