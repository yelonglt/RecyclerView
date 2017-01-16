package com.yelong.rv.multitype.holder;

import android.view.View;
import android.widget.TextView;

import com.yelong.rv.R;
import com.yelong.rv.multitype.adapter.MultiTypeAdapter;
import com.yelong.rv.multitype.model.Normal;

/**
 * Created by yelong on 2017/1/16.
 * mail:354734713@qq.com
 */
public class NormalViewHolder extends BaseViewHolder<Normal> {

    public NormalViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(Normal model, int position, MultiTypeAdapter adapter) {
        TextView textView = (TextView) getView(R.id.item_normal_text);
        textView.setText(model.getAddress());
    }
}
