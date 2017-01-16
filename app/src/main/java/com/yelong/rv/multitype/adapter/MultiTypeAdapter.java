package com.yelong.rv.multitype.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.yelong.rv.multitype.holder.BaseViewHolder;
import com.yelong.rv.multitype.model.BaseModel;
import com.yelong.rv.multitype.type.TypeFactory;
import com.yelong.rv.multitype.type.TypeFactoryImpl;

import java.util.List;

/**
 * 多类型适配器
 * Created by yelong on 2017/1/16.
 * mail:354734713@qq.com
 */
public class MultiTypeAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private TypeFactory mTypeFactory;
    private List<BaseModel> mModels;

    public MultiTypeAdapter(List<BaseModel> models) {
        mModels = models;
        mTypeFactory = new TypeFactoryImpl();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        final View itemView = View.inflate(context, viewType, null);
        return mTypeFactory.createViewHolder(viewType, itemView);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setUpView(mModels.get(position), position, this);
    }

    @Override
    public int getItemCount() {
        return mModels == null ? 0 : mModels.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mModels.get(position).type(mTypeFactory);
    }
}
