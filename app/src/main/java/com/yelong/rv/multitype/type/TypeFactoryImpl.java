package com.yelong.rv.multitype.type;

import android.view.View;

import com.yelong.rv.R;
import com.yelong.rv.multitype.holder.BaseViewHolder;
import com.yelong.rv.multitype.holder.NormalViewHolder;
import com.yelong.rv.multitype.holder.OneViewHolder;
import com.yelong.rv.multitype.holder.ThreeViewHolder;
import com.yelong.rv.multitype.holder.TwoViewHolder;
import com.yelong.rv.multitype.model.Normal;
import com.yelong.rv.multitype.model.One;
import com.yelong.rv.multitype.model.Three;
import com.yelong.rv.multitype.model.Two;

/**
 * 多布局工厂实现类
 * Created by yelong on 2017/1/16.
 * mail:354734713@qq.com
 */
public class TypeFactoryImpl implements TypeFactory {

    private static final int TYPE_RESOURCE_ONE = R.layout.layout_item_one;
    private static final int TYPE_RESOURCE_TWO = R.layout.layout_item_two;
    private static final int TYPE_RESOURCE_THREE = R.layout.layout_item_three;
    private static final int TYPE_RESOURCE_NORMAL = R.layout.layout_item_normal;


    @Override
    public int type(One one) {
        return TYPE_RESOURCE_ONE;
    }

    @Override
    public int type(Two two) {
        return TYPE_RESOURCE_TWO;
    }

    @Override
    public int type(Three three) {
        return TYPE_RESOURCE_THREE;
    }

    @Override
    public int type(Normal normal) {
        return TYPE_RESOURCE_NORMAL;
    }

    @Override
    public BaseViewHolder createViewHolder(int type, View itemView) {

        if (type == TYPE_RESOURCE_ONE) {
            return new OneViewHolder(itemView);
        } else if (type == TYPE_RESOURCE_TWO) {
            return new TwoViewHolder(itemView);
        } else if (type == TYPE_RESOURCE_THREE) {
            return new ThreeViewHolder(itemView);
        } else if (type == TYPE_RESOURCE_NORMAL) {
            return new NormalViewHolder(itemView);
        }

        return null;
    }
}
