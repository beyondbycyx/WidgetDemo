package com.example.hq.listviewdemo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

//显示joblistactivity
public class JobListActivity extends Activity {

    private ListView listView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);
        listView=(ListView)findViewById(R.id.joblistview);

        JobModel data=new JobModel();
        MyAdapter myAdapter=new MyAdapter(this,data,R.layout.job_list_item);

        listView.setAdapter(myAdapter);
    }
}
