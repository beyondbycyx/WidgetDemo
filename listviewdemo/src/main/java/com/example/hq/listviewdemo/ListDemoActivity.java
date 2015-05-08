package com.example.hq.listviewdemo;

import android.app.Activity;
import android.database.Cursor;
import android.provider.Contacts;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ListDemoActivity extends Activity {


    private ListView lv=null;
    private TextView tv=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdemo);
        lv=(ListView)findViewById(R.id.listview);
        tv=new TextView(this);
        setSimpleCursorAdapter();
    }
    public void setCursorAdapter()
    {

    }
    public void setSimpleCursorAdapter()
    {
        //读取联系人的信息到listview中，在清单文件上加上android.permission.READ_CONTACTS读取权限
        //查找联系人的信息
        Cursor c=getContentResolver().query(Contacts.People.CONTENT_URI,null,null,null,null);
        startManagingCursor(c);
        ListAdapter adapter=new SimpleCursorAdapter(this,R.layout.list_cursor,c,new String[]{Contacts.People.NAME, Contacts.People.NUMBER},new int[]{R.id.item1,R.id.item2});
        lv.setAdapter(adapter);
    }
    public void setArrayAdapter()
    {
        String []strs=getResources().getStringArray(R.array.string_array);
        ListAdapter adapter=new ArrayAdapter<String>(this,R.layout.listdemo_item,strs);
        lv.setAdapter(adapter);

    }
    public void setHeadViewAdapter()
    {
       // tv.setText("哈哈哈哈哈");
       // lv.addHeaderView(tv);
        ArrayList<ListView.FixedViewInfo> headerViewInfos=new ArrayList<ListView.FixedViewInfo>();
        //ListView.FixedViewInfo fixedViewInfo=new ListView.FixedViewInfo();
        String []strs=getResources().getStringArray(R.array.string_array);
        ListAdapter adapter=new ArrayAdapter<String>(this,R.layout.listdemo_item,strs);
        HeaderViewListAdapter hadapter=new HeaderViewListAdapter(headerViewInfos,null,adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void setSimpleAdapter()
    {
         tv.setText("哈哈哈哈哈");
         lv.addHeaderView(tv);

        List<HashMap<String,String>> data=new ArrayList<HashMap<String,String>>();
        HashMap<String,String> hm1=new HashMap<String,String>();
        hm1.put("item","这是item1");
        hm1.put("subitem","这是subitem1");
        HashMap<String,String> hm2=new HashMap<String,String>();
        hm2.put("item","这是item2");
        hm2.put("subitem","这是subitem2");
         data.add(hm1);
        data.add(hm2);

        ListAdapter adapter=new SimpleAdapter(this,data,R.layout.listdemo_item,new String[]{"item","subitem"},new int[]{R.id.item,R.id.subitem});
        lv.setAdapter(adapter);
    }
}
