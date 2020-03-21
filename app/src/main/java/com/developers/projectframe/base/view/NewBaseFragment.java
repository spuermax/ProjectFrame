package com.developers.projectframe.base.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developers.projectframe.R;
import com.developers.projectframe.base.event.MessageEvent;
import com.developers.projectframe.network.base.IPresenter;
import com.developers.projectframe.network.base.IView;
import com.gyf.barlibrary.ImmersionBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * @Author yinzh
 * @Date 2020/3/21 10:48
 * @Description
 */
public abstract class NewBaseFragment <P extends IPresenter> extends Fragment implements IView {

    protected Activity mActivity;
    protected View mContainerView;
    protected Context mContext;

    protected P mPresenter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
        mContext = mActivity.getBaseContext();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContainerView = inflaterView(inflater, container, savedInstanceState);
        //沉浸状态栏
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }

        mPresenter = loadPresenter();
        initView(mContainerView);
        initData();
        return mContainerView;
    }

    protected abstract View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle);

    protected P loadPresenter() {
        return null;
    }

    protected void initView(View view) {
    }

    protected void initData() {
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden && isImmersionBarEnabled()) {
            ImmersionBar.with(this).init();
        }
    }

    /**
     * 是否可以使用沉浸式
     */
    protected boolean isImmersionBarEnabled() {
        return false;
    }


    protected void initImmersionBar() {
        ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(R.color.es_bg_white)
                .statusBarDarkFont(true, 0.2f)//解决 状态栏字体颜色
                .addTag("default")
                .init();
    }

    @Override
    public void showLoadingDialog(String msg) {
    }

    @Override
    public void dismissLoadingDialog(String msg) {
    }

    @Subscribe
    public void onReceiveMessage(MessageEvent messageEvent) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

        if (mPresenter != null) {
            mPresenter.detach();//在presenter中解绑释放view
            mPresenter = null;
        }

        if (isImmersionBarEnabled()) {
            ImmersionBar.with(this).destroy();
        }
    }

}

