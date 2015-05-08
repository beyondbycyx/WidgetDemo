package com.example.hq.parcelabledemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hq on 2015/4/28.
 */
public class PersonDetailFragment extends Fragment {
    public static final String TAG= PersonDetailFragment.class.getSimpleName();
    private Person person=null;
    private TextView tv=null;
    private View v=null;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //当activity的oncreate执行完后执行这个方法
        //获取person信息
        PersonDetailActivity pa=(PersonDetailActivity)getActivity();
        person=pa.getPerson();
        Bundle bundle=person.getBundle();
        String str=bundle.getString("name")+";";
        str=str+bundle.getChar("sex");
        tv=(TextView)v.findViewById(R.id.persontextview);
        tv.setText(str);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.personfragment,container,false);
        return v;
    }
}
