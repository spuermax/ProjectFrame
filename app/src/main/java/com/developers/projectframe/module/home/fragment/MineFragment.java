package com.developers.projectframe.module.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developers.projectframe.R;
import com.developers.projectframe.base.view.NewBaseFragment;
import com.developers.projectframe.module.home.adapter.HomeItemAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Author yinzh
 * @Date 2020/3/21 15:43
 * @Description
 */
public class MineFragment extends NewBaseFragment {

    private RecyclerView recyclerView;
    private ArrayList<String> arrayList;
    private HomeItemAdapter adapter;


    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        recyclerView = view.findViewById(R.id.recycler);
    }

    @Override
    protected void initData() {
        super.initData();
        arrayList = new ArrayList<>();


        for (int i = 0; i < 10 ; i ++){
            arrayList.add("Super = " + i);
        }

        adapter = new HomeItemAdapter(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);





    }
}
