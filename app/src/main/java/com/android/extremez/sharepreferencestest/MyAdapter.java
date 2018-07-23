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

    private final ArrayList<GridActivity.Bean> dataList;
    private final Activity activity;

    public MyAdapter(Activity activity, ArrayList<GridActivity.Bean> dataList) {
        this.dataList = dataList;
        this.activity = activity;
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GridActivity.Bean bean = dataList.get(position);
        ((TextView) holder.itemView.findViewById(R.id.textview)).setText(bean.text);
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
