package com.yelong.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yelong.rv.helper.ItemTouchCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by eyetech on 16/5/10.
 * mail:354734713@qq.com
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>
        implements ItemTouchCallback.ItemTouchListener {

    private Context mContext;
    private List<String> mDatas;
    private List<Integer> mHeights;

    @Override
    public void onMove(int fromPosition, int toPosition) {
        if (fromPosition == mDatas.size() - 1 || toPosition == mDatas.size() - 1) {
            return;
        }
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mDatas, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mDatas, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onSwiped(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mItemClickListener;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public HomeAdapter(Context mContext, List<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    /**
     * 当是瀑布流布局时，添加随机高度
     *
     * @param recyclerView
     */
    public void setRandomHeights(RecyclerView recyclerView) {
        //获取RecyclerView的LayoutManager
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        //瀑布流布局才随机设置高度
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (mHeights == null) {
                mHeights = new ArrayList<>();
            }

            mHeights.clear();
            for (int i = 0; i < mDatas.size(); i++) {
                mHeights.add((int) (100 + Math.random() * 300));
            }
            notifyDataSetChanged();
        }
    }

    /**
     * 删除瀑布流随机高度布局
     */
    public void deleteRandomHeights() {
        if (mHeights != null) {
            mHeights.clear();
            mHeights = null;
            notifyDataSetChanged();
        }
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.home_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, final int position) {
        holder.tv.setText(mDatas.get(position));

        if (mHeights != null) {
            ViewGroup.LayoutParams lp = holder.tv.getLayoutParams();
            lp.height = mHeights.get(position);
            holder.tv.setLayoutParams(lp);
        }

        if (mItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mItemClickListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mItemClickListener.onItemLongClick(holder.itemView, pos);
                    return true;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addData(int position) {
        mDatas.add(position, "insert-" + position);
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    static class HomeViewHolder extends RecyclerView.ViewHolder {

        public TextView tv;

        public HomeViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_text);
        }
    }
}
