package com.yelong.rv.multitype.model;

import com.yelong.rv.multitype.type.TypeFactory;

/**
 * 布局三
 * Created by yelong on 2017/1/16.
 * mail:354734713@qq.com
 */
public class Three implements BaseModel {

    private float weight;

    public Three(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
