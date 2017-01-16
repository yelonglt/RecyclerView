package com.yelong.rv.multitype;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yelong.rv.R;
import com.yelong.rv.decoration.DividerItemDecoration;
import com.yelong.rv.multitype.adapter.MultiTypeAdapter;
import com.yelong.rv.multitype.model.BaseModel;
import com.yelong.rv.multitype.model.Normal;
import com.yelong.rv.multitype.model.One;
import com.yelong.rv.multitype.model.Three;
import com.yelong.rv.multitype.model.Two;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yelong on 2017/1/16.
 * mail:354734713@qq.com
 */
public class MultiTypeActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_type);

        mRecyclerView = (RecyclerView) findViewById(R.id.info_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        List<BaseModel> models = getData();
        models.add(new One("long"));
        models.add(new Two(90));
        models.add(new Three(100));
        models.add(new One("long"));
        models.add(new Two(90));
        models.add(new Three(100));
        models.add(new One("long"));
        models.add(new Two(90));
        models.add(new Three(100));
        models.add(new Three(100));
        models.add(new Three(100));
        models.add(new One("long"));
        models.add(new Two(90));
        models.add(new One("long"));

        mAdapter = new MultiTypeAdapter(models);
        mRecyclerView.setAdapter(mAdapter);
    }


    private List<BaseModel> getData() {
        List<BaseModel> models = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            models.add(new Normal("Hello == " + i));
        }
        return models;
    }
}
