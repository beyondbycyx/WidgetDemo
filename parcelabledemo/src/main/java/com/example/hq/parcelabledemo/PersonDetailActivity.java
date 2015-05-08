package com.example.hq.parcelabledemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



public class PersonDetailActivity extends Activity {

    private PersonDetailFragment pf=null;

    public Person getPerson() {
        return person;
    }

    private Person person=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person);
        //接收intent传递的person数据
        Intent intent =getIntent();
        person=intent.getParcelableExtra("person");
       //动态加载fragment
         pf=new PersonDetailFragment();
         getFragmentManager().beginTransaction().replace(R.id.pl,pf,pf.TAG).commit();
    }




}
