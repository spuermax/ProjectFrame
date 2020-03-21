package com.developers.projectframe.module.home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.developers.projectframe.R;
import com.developers.projectframe.base.view.NewBaseActivity;
import com.developers.projectframe.module.home.adapter.MainViewPagerAdaper;
import com.developers.projectframe.module.home.fragment.HomeFragment;
import com.developers.projectframe.module.home.fragment.LearnFragment;
import com.developers.projectframe.module.home.fragment.MineFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends NewBaseActivity {

    private ViewPager viewPager;
    private MagicIndicator magicIndicator;
    private MainViewPagerAdaper mainViewPagerAdaper;
    private List<Fragment> fragmentList = new ArrayList<>();
    private static final String[] CHANNELS = new String[]{"免费体验", "学习中心", "我的"};
    private List<String> mDataList = Arrays.asList(CHANNELS);
    private static final int[] ICON = new int[]{R.mipmap.tab_find_icon_normal, R.mipmap.tab_class_normal, R.mipmap.tab_mine_icon_normal};
    private static final int[] ICON_SELECT = new int[]{R.mipmap.tab_find_icon_pressed, R.mipmap.tab_class_pressed, R.mipmap.tab_mine_icon_pressed};



    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setToolBarTitle("ProjectFrame");
        viewPager = findViewById(R.id.viewpager);
        magicIndicator = findViewById(R.id.magic_indicator);

        initIndicator();


    }


    @Override
    protected void initData() {
        HomeFragment homeFragment = new HomeFragment();
        LearnFragment learnFragment = new LearnFragment();
        MineFragment mineFragment = new MineFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(learnFragment);
        fragmentList.add(mineFragment);


        mainViewPagerAdaper = new MainViewPagerAdaper(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(mainViewPagerAdaper);

    }

    private void initIndicator() {
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setBackgroundColor(getResources().getColor(R.color.es_bg_white));
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);

                // load custom layout
                View customLayout = LayoutInflater.from(context).inflate(R.layout.simple_pager_title_layout, null);
                final ImageView titleImg = (ImageView) customLayout.findViewById(R.id.title_img);
                final TextView titleText = (TextView) customLayout.findViewById(R.id.title_text);
                titleImg.setImageResource(R.mipmap.ic_launcher);
                titleText.setText(mDataList.get(index));
                commonPagerTitleView.setContentView(customLayout);

                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {

                    @Override
                    public void onSelected(int index, int totalCount) {
                        titleText.setTextColor(getResources().getColor(R.color.color_323C32));
                        titleImg.setImageResource(ICON_SELECT[index]);
                    }

                    @Override
                    public void onDeselected(int index, int totalCount) {
                        titleText.setTextColor(getResources().getColor(R.color.color_898D89));
                        titleImg.setImageResource(ICON[index]);

                    }

                    @Override
                    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
                    }

                    @Override
                    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
                    }
                });

                commonPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(index);
                    }
                });

                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager);

    }


}
