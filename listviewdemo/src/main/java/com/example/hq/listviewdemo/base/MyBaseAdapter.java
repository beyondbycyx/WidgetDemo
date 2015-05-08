package com.example.hq.listviewdemo.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by hq on 2015/4/30.
 */
//所有的适配器继承该基类
public class MyBaseAdapter<T> extends BaseAdapter{

    //根据类传进来的T类型决定源数据类型
    private List<T> data=null;

    @Override//返回源数据的总个数
    public int getCount() {
        return data.size();
    }
    @Override//创建每个视图返回
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }
}
