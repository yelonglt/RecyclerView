package com.yelong.rv.multitype.holder;

import android.view.View;
import android.widget.TextView;

import com.yelong.rv.R;
import com.yelong.rv.multitype.adapter.MultiTypeAdapter;
import com.yelong.rv.multitype.model.One;

/**
 * Created by yelong on 2017/1/16.
 * mail:354734713@qq.com
 */
public class OneViewHolder extends BaseViewHolder<One> {

    public OneViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(One model, int position, MultiTypeAdapter adapter) {
        TextView textView = (TextView) getView(R.id.item_one_text);
        textView.setText(model.getName());
    }
}
