package com.example.hq.listviewdemo;

import android.app.ListActivity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class HelloListViewActivity extends ListActivity {

    /*
    * 1.适配器，数据源
    * 2.为listview设置适配器
    * 3.设置listview的属性
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String []strs={"1:aaaa","2:bbbb","3:cccc","4:dddd"};
        String []string_array=getResources().getStringArray(R.array.string_array);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_item,string_array);
        setListAdapter(adapter);
        ListView lv=getListView();
        lv.setTextFilterEnabled(true);//当编辑输入字符时会匹配到listview里的item
        lv.setDivider(new ColorDrawable(Color.parseColor("#00ff00")));
        lv.setDividerHeight(2);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  Toast.makeText(HelloListViewActivity.this,"id:"+id,Toast.LENGTH_SHORT).show();
            }
        });


    }



}
