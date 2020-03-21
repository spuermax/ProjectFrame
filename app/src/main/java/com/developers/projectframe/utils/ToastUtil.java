package com.developers.projectframe.utils;

import android.content.Context;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.developers.projectframe.R;

/**
 * @Author yinzh
 * @Date 2020/3/21 10:27
 * @Description
 */
public class ToastUtil {

    public static void shortToast(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_SHORT);
    }

    public static void longToast(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_LONG);
    }

    private static void showToast(Context context, String massage, int duration) {

        // 判断是否是在主线程
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Looper.prepare();
            Toast toast = new Toast(context);
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 200);
            toast.setDuration(duration);

            View view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
            TextView tvToast = view.findViewById(R.id.tv_toast);
            tvToast.setText(massage);//设置文本

            toast.setView(view);
            toast.show();
            Looper.loop();
        } else {
            Toast toast = new Toast(context);
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 200);
            toast.setDuration(duration);

            View view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
            TextView tvToast = view.findViewById(R.id.tv_toast);
            tvToast.setText(massage);//设置文本

            toast.setView(view);
            toast.show();
        }

    }

    public static void shortTopToast(Context context, String massage) {

        // 判断是否是在主线程
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Looper.prepare();

            Toast toast = new Toast(context);
            TextView tvToast;

            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 300);
            toast.setDuration(Toast.LENGTH_SHORT);

            View view = LayoutInflater.from(context).inflate(R.layout.toast_layout_download, null);
            tvToast = view.findViewById(R.id.tv_toast);
            tvToast.setText(massage);//设置文本

            toast.setView(view);
            toast.show();
            Looper.loop();
        } else {
            Toast toast = new Toast(context);
            TextView tvToast;

            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 300);
            toast.setDuration(Toast.LENGTH_SHORT);

            View view = LayoutInflater.from(context).inflate(R.layout.toast_layout_download, null);
            tvToast = view.findViewById(R.id.tv_toast);
            tvToast.setText(massage);//设置文本

            toast.setView(view);
            toast.show();
        }
    }

}

