package com.example.hq.parcelabledemo;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hq on 2015/4/28.
 */
public class Person  implements Parcelable {


    private String name;
    private char sex;
    private Bundle bundle=new Bundle();

    public Bundle getBundle() {

        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //打包person信息到Bundle上，再序列化传递
        bundle.putString("name",name);
        bundle.putChar("sex",sex);
        //将打包的bundle序列化
        dest.writeBundle(getBundle());
    }
    //定义一个创造者
    public static final Parcelable.Creator<Person> CREATOR=new Parcelable.Creator<Person>(){
        @Override
        public Person createFromParcel(Parcel source) {
            //在此反序列化人
            Bundle bundle=source.readBundle();
            Person  p=new Person();
            p.setBundle(bundle);
            return p;
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }




    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
