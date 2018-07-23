package com.android.extremez.sharepreferencestest;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meiyou.jet.myapplication.R;

import java.util.ArrayList;

/**
 * @author zhengxiaobin@xiaoyouzi.com
 * @since 2018/7/23
 */
class MyAdapter extends RecyclerView.Adapter {
    private static final String TAG = "MyAdapter";

    private final ArrayList<GridActivity.Bean> dataList;
    private final Activity activity;
    private final RecyclerView rv;

    public MyAdapter(Activity activity, ArrayList<GridActivity.Bean> dataList, RecyclerView rv) {
        this.dataList = dataList;
        this.activity = activity;
        this.rv = rv;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new BaseVH(View.inflate(activity, R.layout.item_grid_head, null));
        } else {
            return new BaseVH(View.inflate(activity, R.layout.item_grid, null));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position).isTitle) {
            return 1;
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        GridActivity.Bean bean = dataList.get(position);
        TextView textView = (TextView) holder.itemView.findViewById(R.id.textview);
        final int count = dataList.size();
        
//        GridLayoutManager layoutManager = (GridLayoutManager) rv.getLayoutManager();
//        int groupIndex = layoutManager.getSpanSizeLookup().getSpanGroupIndex(position, count);
//        int spanIndex = layoutManager.getSpanSizeLookup().getSpanIndex(position, count);
//        String format = String.format("%s; group: %s; span: %s",bean.text, groupIndex, spanIndex);

        textView.setText(bean.text);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GridLayoutManager layoutManager = (GridLayoutManager) rv.getLayoutManager();
//                int groupIndex = layoutManager.getSpanSizeLookup().getSpanGroupIndex(position, count);
//                int spanIndex = layoutManager.getSpanSizeLookup().getSpanIndex(position, count);
//
//                Log.e(TAG, "onClick: " + String.format("group: %s; span: %s", groupIndex, spanIndex));
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class BaseVH extends RecyclerView.ViewHolder {
        public BaseVH(View itemView) {
            super(itemView);
        }
    }
}
