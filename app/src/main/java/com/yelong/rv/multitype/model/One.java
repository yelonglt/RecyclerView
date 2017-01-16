package com.yelong.rv.multitype.model;

import com.yelong.rv.multitype.type.TypeFactory;

/**
 * 布局一
 * Created by yelong on 2017/1/16.
 * mail:354734713@qq.com
 */
public class One implements BaseModel {

    private String name;

    public One(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
