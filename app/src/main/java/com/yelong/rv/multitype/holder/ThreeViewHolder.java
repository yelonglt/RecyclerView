package com.yelong.rv.multitype.holder;

import android.view.View;
import android.widget.TextView;

import com.yelong.rv.R;
import com.yelong.rv.multitype.adapter.MultiTypeAdapter;
import com.yelong.rv.multitype.model.Three;

/**
 * Created by yelong on 2017/1/16.
 * mail:354734713@qq.com
 */
public class ThreeViewHolder extends BaseViewHolder<Three> {

    public ThreeViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(Three model, int position, MultiTypeAdapter adapter) {
        TextView textView = (TextView) getView(R.id.item_three_text);
        textView.setText(String.valueOf(model.getWeight()));
    }
}
