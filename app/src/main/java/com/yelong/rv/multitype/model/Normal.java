package com.yelong.rv.multitype.model;

import com.yelong.rv.multitype.type.TypeFactory;

/**
 * 通用布局
 * Created by yelong on 2017/1/16.
 * mail:354734713@qq.com
 */
public class Normal implements BaseModel {

    private String address;

    public Normal(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
