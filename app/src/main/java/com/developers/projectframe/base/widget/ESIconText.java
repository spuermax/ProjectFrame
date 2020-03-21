package com.developers.projectframe.base.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.developers.projectframe.R;
import com.developers.projectframe.utils.CommonUtil;

/**
 * @Author yinzh
 * @Date 2020/3/21 10:42
 * @Description
 */
public class ESIconText extends LinearLayout {
    private static int ICON_LEFT = 1;
    private static int ICON_RIGHT = 2;
    private static int ICON_TOP = 3;
    private static int ICON_BOTTOM = 4;

    private Context mContext;

    private ImageView mImg;
    private TextView mText;

    private String strText;
    private ColorStateList textColor;
    private float textSize;
    private int icon;
    private int iconWidth;
    private int iconHeight;
    private float iconAndTextPadding;
    private int iconPosition;

    public ESIconText(Context context) {
        super(context);
        mContext = context;
    }

    public ESIconText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView(attrs);
    }

    private void initView(android.util.AttributeSet attrs) {
        mImg = new ImageView(mContext);
        mText = new TextView(mContext);
        TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.ESIconText);
        strText = ta.getString(R.styleable.ESIconText_EduSoho_text);
        textColor = ta.getColorStateList(R.styleable.ESIconText_EduSoho_text_color);
        textSize = ta.getDimensionPixelSize(R.styleable.ESIconText_EduSoho_text_size, CommonUtil.sp2px(mContext, 14));

        icon = ta.getResourceId(R.styleable.ESIconText_EduSoho_icon, 0);
        iconWidth = (int) ta.getDimension(R.styleable.ESIconText_EduSoho_icon_width, 0);
        iconHeight = (int) ta.getDimension(R.styleable.ESIconText_EduSoho_icon_height, 0);
        iconAndTextPadding = ta.getDimension(R.styleable.ESIconText_EduSoho_text_icon_padding, 0);
        iconPosition = ta.getInt(R.styleable.ESIconText_EduSoho_icon_position, ICON_TOP);

        LayoutParams tvParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        tvParams.topMargin = (int) iconAndTextPadding;
        mText.setIncludeFontPadding(false);
        mText.setText(strText);
        mText.setTextColor(textColor);
        mText.setTextSize(CommonUtil.px2sp(mContext, textSize));
        mText.setLayoutParams(tvParams);

        mImg.setImageResource(icon);
        LayoutParams params = new LayoutParams(iconWidth == 0 ? LayoutParams.WRAP_CONTENT : iconWidth,
                iconHeight == 0 ? LayoutParams.WRAP_CONTENT : iconHeight);
        mImg.setLayoutParams(params);

        setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        if (iconPosition == ICON_LEFT || iconPosition == ICON_RIGHT) {
            setOrientation(HORIZONTAL);
            if (iconPosition == ICON_LEFT) {
                addView(mImg);
                addView(mText);
            } else {
                addView(mText);
                addView(mImg);
            }
        } else if (iconPosition == ICON_TOP || iconPosition == ICON_BOTTOM) {
            setOrientation(VERTICAL);
            if (iconPosition == ICON_TOP) {
                addView(mImg);
                addView(mText);
            } else {
                addView(mText);
                addView(mImg);
            }
        }
    }

}

