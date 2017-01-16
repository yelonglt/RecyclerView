package com.yelong.rv.multitype.holder;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import com.yelong.rv.multitype.adapter.MultiTypeAdapter;

/**
 * Created by yelong on 2017/1/16.
 * mail:354734713@qq.com
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    /**
     * 所有控件的集合
     */
    private SparseArray<View> mViews;

    /**
     * 控件的父布局
     */
    private View mItemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
        mItemView = itemView;
    }

    /**
     * 通过resID获取控件视图
     *
     * @param id id
     * @return 视图
     */
    public View getView(@IdRes int id) {
        View view = mViews.get(id);
        if (view == null) {
            view = mItemView.findViewById(id);
            mViews.put(id, view);
        }
        return view;
    }

    public View getItemView() {
        return mItemView;
    }

    /**
     * 设置布局内容
     *
     * @param model    数据
     * @param position 位置
     * @param adapter  适配器
     */
    public abstract void setUpView(T model, int position, MultiTypeAdapter adapter);
}
