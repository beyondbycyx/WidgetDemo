package com.example.hq.fragments;

import android.app.Fragment;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private Fragment2 fragment2=new Fragment2();
    private Fragment1 fragment1=new Fragment1();
    private Button button=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linearlayout);
        //动态添加fragment1
        getFragmentManager().beginTransaction().add(R.id.linear,fragment1,Fragment1.Tag).commit();

        //button进行监听：
        button=(Button)findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //获取fragment1
                       // Fragment1 fragment=(Fragment1)getFragmentManager().findFragmentById(R.id.fragment1);
                        Fragment1 fragment=(Fragment1)getFragmentManager().findFragmentByTag(Fragment1.Tag);
                        String Tag=fragment.getTag()+":";
                        TextView tv1=(TextView)findViewById(R.id.tv1);
                        String str=Tag+tv1.getText().toString();
                TextView tv=(TextView)findViewById(R.id.tv);
                tv.setText(str);


            }
        });

//        //判读屏幕是否为横屏、竖屏，变换不同的界面
//        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE)
//        {
//            //横屏时：添加fragment2
//            //步骤：
//            /*
//            * 1.获取fragment管理器：FragmentManager
//            * 2.获取开始任务：beginTransaction
//            * 3.任务操作：add,replace，show,hide等等
//            * 4.提交任务：commit();
//            * */
//            getFragmentManager().beginTransaction().add(android.R.id.content, fragment2).commit();
//
//        }else{
//            //竖屏时：添加fragment1
//            getFragmentManager().beginTransaction().add(android.R.id.content, fragment1).commit();
//           // getFragmentManager().beginTransaction().replace()
//        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
