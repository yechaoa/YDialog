package com.yechaoa.ydialogdemo;

import android.app.Activity;


/**
 * Created by yechao on 2018/4/4.
 * Describe :
 */

public class LoadingUtil {

    private static LoadingDialog dialog;

    public static void show(Activity activity,String msg) {

        LoadingDialog.Builder loadBuilder = new LoadingDialog.Builder(activity)
                .setMessage(msg)
                .setCancelable(true)
                .setCancelOutside(true);
        dialog = loadBuilder.create();
        dialog.show();

    }

    public static void dismiss() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}
