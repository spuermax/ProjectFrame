package com.developers.projectframe.module.home.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.developers.projectframe.R;

import java.util.List;

/**
 * @Author yinzh
 * @Date 2020/3/21 17:04
 * @Description
 */
public class HomeItemAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public HomeItemAdapter(@Nullable List<String> data) {
        super(R.layout.item_center_adapter, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_name, item);
    }


}