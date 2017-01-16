package com.yelong.rv.multitype.holder;

import android.view.View;
import android.widget.TextView;

import com.yelong.rv.R;
import com.yelong.rv.multitype.adapter.MultiTypeAdapter;
import com.yelong.rv.multitype.model.Two;

/**
 * Created by yelong on 2017/1/16.
 * mail:354734713@qq.com
 */
public class TwoViewHolder extends BaseViewHolder<Two> {

    public TwoViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(Two model, int position, MultiTypeAdapter adapter) {
        TextView textView = (TextView) getView(R.id.item_two_text);
        textView.setText(String.valueOf(model.getAge()));
    }
}
