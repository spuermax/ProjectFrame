package com.developers.projectframe.base.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.developers.projectframe.R;
import com.developers.projectframe.base.event.MessageEvent;
import com.developers.projectframe.network.base.IPresenter;
import com.developers.projectframe.network.base.IView;
import com.developers.projectframe.utils.KeyboardUtil;
import com.gyf.barlibrary.ImmersionBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * @Author yinzh
 * @Date 2020/3/21 10:34
 * @Description
 */
public abstract class NewBaseActivity <P extends IPresenter> extends AppCompatActivity implements IView {
    protected NewBaseActivity mActivity;
    protected Context mContext;

    protected P mPresenter;

    private ImageView mToolbarback;
    private TextView mToolbarTitle;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mActivity = this;
        mContext = this;
        EventBus.getDefault().register(this);

        //沉浸状态栏
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }

        mToolbar = findViewById(R.id.toolbar);
        mToolbarback = findViewById(R.id.toolbar_back);
        mToolbarTitle = findViewById(R.id.toolbar_title);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        mPresenter = loadPresenter();

        initView();
        initData();
    }

    protected P loadPresenter() {
        return null;
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    /**
     * 是否可以使用沉浸式
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    protected void initImmersionBar() {
        ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(R.color.es_bg_white)
                .statusBarDarkFont(true, 0.2f)//解决 状态栏字体颜色
                .addTag("default")
                .init();
    }

    @Subscribe
    public void onReceiveMessage(MessageEvent messageEvent) {

    }

    public RelativeLayout getRootToolbar() {
        return findViewById(R.id.rl_toolbar);
    }

    public Toolbar getToolbar() {
        return findViewById(R.id.toolbar);
    }


    public ImageView getToolbarback() {
        return mToolbarback;
    }

    public TextView getToolbarTitle() {
        return mToolbarTitle;
    }


    public void setToolBarTitle(CharSequence title) {
        if (mToolbarTitle != null) {
            mToolbarTitle.setText(title);
        } else {
            getToolbar().setTitle(title);
            setSupportActionBar(getToolbar());
        }
    }

    private void showBack() {
        if (mToolbarback != null) {
            if (isShowBacking()) {
                mToolbarback.setVisibility(View.VISIBLE);
                mToolbarback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        KeyboardUtil.closeSoftKeyboard(mActivity);
                        onBackPressed();
                    }
                });
            } else {
                mToolbarback.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 是否显示后退按钮,默认显示,可在子类重写该方法.
     *
     * @return
     */
    protected boolean isShowBacking() {
        return true;
    }


    @Override
    public void showLoadingDialog(String msg) {
    }

    @Override
    public void dismissLoadingDialog(String msg) {
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (null != getToolbar()) {
            showBack();
        }
    }

    @Override
    protected void onDestroy() {
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

