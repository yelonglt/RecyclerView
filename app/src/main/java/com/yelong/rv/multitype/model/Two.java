package com.yelong.rv.multitype.model;

import com.yelong.rv.multitype.type.TypeFactory;

/**
 * 布局二
 * Created by yelong on 2017/1/16.
 * mail:354734713@qq.com
 */
public class Two implements BaseModel {

    private int age;

    public Two(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
