package com.developers.projectframe.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developers.projectframe.R;
import com.developers.projectframe.base.view.NewBaseFragment;
import com.developers.projectframe.module.home.MainPresenter;
import com.developers.projectframe.module.home.adapter.HomeItemAdapter;
import com.developers.projectframe.module.home.bean.AdvisoryBean;
import com.developers.projectframe.module.home.contract.MainContract;
import com.developers.projectframe.utils.ToastUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * @Author yinzh
 * @Date 2020/3/21 15:43
 * @Description
 */
public class HomeFragment extends NewBaseFragment<MainPresenter> implements MainContract.IMainView {

    private RecyclerView recyclerView;
    private ArrayList<String> arrayList;
    private HomeItemAdapter adapter;
    private RefreshLayout refreshLayout;

    @Override
    protected MainPresenter loadPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        recyclerView = view.findViewById(R.id.recycler);
        refreshLayout = view.findViewById(R.id.refreshLayout);

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.getAdvisoryInfo();
            }
        });

        refreshLayout.setEnableLoadMore(true);// 打开加载更多

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                ToastUtil.shortToast(mActivity,"加载更多");
                mPresenter.getAdvisoryInfo();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        arrayList = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            arrayList.add("Super = " + i);
        }

        adapter = new HomeItemAdapter(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void requestData() {

    }

    @Override
    public void setAdvisoryInfo(AdvisoryBean bean) {
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();
        ToastUtil.shortToast(mActivity,"刷新页面成功");
    }
}
