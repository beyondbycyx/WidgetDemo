package com.example.hq.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hq on 2015/4/27.
 */
public class Fragment2 extends Fragment{

    private Button bt1=null;
    //在该方法下注册监听button
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //在关联的activity中获取id
        bt1=(Button)getActivity().findViewById(R.id.bt1);
        //设置监听
        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //获取fragment1的textview的字符串内容
                TextView tv1=(TextView)getActivity().findViewById(R.id.tv1);
                String text=tv1.getText().toString();
                Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);
    }
}
