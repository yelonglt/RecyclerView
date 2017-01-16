package com.yelong.rv.multitype.type;

import android.view.View;

import com.yelong.rv.multitype.holder.BaseViewHolder;
import com.yelong.rv.multitype.model.Normal;
import com.yelong.rv.multitype.model.One;
import com.yelong.rv.multitype.model.Three;
import com.yelong.rv.multitype.model.Two;

/**
 * 多布局类型工厂
 * Created by yelong on 2017/1/16.
 * mail:354734713@qq.com
 */
public interface TypeFactory {

    int type(One one);

    int type(Two two);

    int type(Three three);

    int type(Normal normal);

    BaseViewHolder createViewHolder(int type, View itemView);

}
