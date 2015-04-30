package com.example.hq.listviewdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by hq on 2015/4/29.
 */
//自定义一个适配器(模仿simpleadapter的源码)：数据源是ListitemModel
//覆写以下方法时，要注意，当设置完该适配器后，程序运行它的覆盖方法的顺序是以下面的方法顺序相应的
//即getCount()是先于getView的
public class MyAdapter extends BaseAdapter {

    private LayoutInflater mInflater=null;
    private JobModel mdata=null;
    private int mResource;

    //所有的ListItem的视图组件
    public final class ListItemView
    {
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;
        public TextView tv4;
        public TextView tv5;
    }
    //默认只传一个数据模型
    public MyAdapter(Context context,JobModel data,int resource)
    {
        //根据context,创建一个布局填充器
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //传入数据源
        mdata=data;
        //传入布局文件的id:数据源放哪
        mResource=resource;
    }
    @Override
    public int getCount() {
        //因为默认传入一个数据模型
         return 1;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //创建一个视图并返回
        View v=null;
        if(convertView==null)
        {   //用context给的布局填充器创建视图
            v=mInflater.inflate(mResource,parent,false);
        }else{
            v=convertView;
        }
        //绑定数据
        bindView(1,v);
        return v;
    }
    @Override
    public long getItemId(int position) {
        //默认只有一个
        return 0;
    }
    @Override
    public Object getItem(int position) {
        //默认只有一个
        return mdata;
    }
    //将数据与view绑定
    private  void bindView(int position ,View v)
    {
        //为视图填充相应的数据(可以封装成一个bindView(int position, View view)方法)
        ListItemView liv=new ListItemView();
        liv.tv1=(TextView)v.findViewById(R.id.title);
        liv.tv2=(TextView)v.findViewById(R.id.content);
        liv.tv3=(TextView)v.findViewById(R.id.salary);
        liv.tv4=(TextView)v.findViewById(R.id.company_name);
        liv.tv5=(TextView)v.findViewById(R.id.is_urgent);

        liv.tv1.setText(mdata.title);
        liv.tv2.setText(mdata.content);
        liv.tv3.setText(mdata.salary);
        liv.tv4.setText(mdata.company_name);
    }
}
