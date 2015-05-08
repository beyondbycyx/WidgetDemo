package com.example.hq.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hq on 2015/4/27.
 */
public class Fragment1 extends Fragment {
    public static final String  Tag=Fragment1.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //创建自己的用户界面,为该fragment指定布局文件“R.layout.fragment1”
        return inflater.inflate(R.layout.fragment1,container,false);

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(Tag,"onCreate");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.v(Tag,"onAttach");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v(Tag,"onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v(Tag,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v(Tag,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(Tag,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v(Tag,"onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(Tag,"onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v(Tag,"onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v(Tag,"onDetach");
    }
}
