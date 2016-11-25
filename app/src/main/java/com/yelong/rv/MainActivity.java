package com.yelong.rv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.yelong.rv.decoration.DividerGridItemDecoration;
import com.yelong.rv.helper.ItemTouchCallback;
import com.yelong.rv.helper.RecyclerViewOnItemTouchListener;
import com.yelong.rv.utils.ACache;
import com.yelong.rv.utils.VibratorUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemTouchCallback.OnDragListener {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private HomeAdapter mHomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        initData();
        mHomeAdapter = new HomeAdapter(this, mDatas);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        //mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(mHomeAdapter);

        //设置触摸相关操作
        final ItemTouchHelper touchHelper = new ItemTouchHelper(
                new ItemTouchCallback(mHomeAdapter).setDragListener(this));
        touchHelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.addOnItemTouchListener(new RecyclerViewOnItemTouchListener(mRecyclerView) {
            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {
                if (vh.getLayoutPosition() != mDatas.size() - 1) {
                    touchHelper.startDrag(vh);
                    VibratorUtil.Vibrate(MainActivity.this, 70);   //震动70ms
                }
            }

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                System.out.println("mRecyclerView click=="+vh.getLayoutPosition());
            }
        });

        mHomeAdapter.setItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "click-" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                //Toast.makeText(MainActivity.this, "long click-" + position, Toast.LENGTH_SHORT).show();
                //mHomeAdapter.removeData(position);
            }
        });
    }

    private void initData() {
        mDatas = new ArrayList<>();
        //读缓存
        ArrayList<String> items = (ArrayList<String>) ACache.get(this).getAsObject("items");
        if (items != null) {
            mDatas.addAll(items);
        } else {
            for (int i = 'A'; i < 'z'; i++) {
                mDatas.add("" + (char) i);
            }
        }
    }

    @Override
    public void onFinishDrag() {
        //存入缓存
        ACache.get(this).put("items", (ArrayList<String>) mDatas);
    }
}
