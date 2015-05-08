package com.example.hq.parcelabledemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/*
* 演示利用Parcelable进行自定义对象数据的传递的
* */
public class MainActivity extends ActionBarActivity {

    private EditText et=null;
    private RadioGroup rg=null;
    private Button bt=null;
    private Person  person=new Person();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);
        et=(EditText)findViewById(R.id.et);
        rg=(RadioGroup)findViewById(R.id.rg);
        bt=(Button)findViewById(R.id.bt);
        addListener();
    }
    //添加监听
    public void addListener ()
    {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=(RadioButton)MainActivity.this.findViewById(checkedId);
                char sex=rb.getText().charAt(0);
                person.setSex(sex);
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et.getText().toString();
                person.setName(name);
                //person信息装载完成，准备序列化传递
                Intent  intent=new Intent(MainActivity.this,PersonDetailActivity.class);
                //传递自定义对象person
                intent.putExtra("person",person);
                //启动第二界面
                startActivity(intent);
            }
        });
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
