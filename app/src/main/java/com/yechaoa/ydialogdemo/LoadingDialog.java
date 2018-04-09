package com.yechaoa.ydialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by yechao on 2018/4/4.
 * Describe :
 */

public class LoadingDialog extends Dialog {

    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LoadingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {

        private Context context;
        private String message;
        private boolean isShowMessage = true;
        private boolean isCancelable = false;
        private boolean isCancelOutside = false;

        public Builder(Context context) {
            this.context = context;
        }

        /**
         * 设置提示信息
         *
         * @param message
         * @return
         */

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        /**
         * 设置是否显示提示信息
         *
         * @param isShowMessage
         * @return
         */
        public Builder setShowMessage(boolean isShowMessage) {
            this.isShowMessage = isShowMessage;
            return this;
        }

        /**
         * 设置是否可以按返回键取消
         *
         * @param isCancelable
         * @return
         */

        public Builder setCancelable(boolean isCancelable) {
            this.isCancelable = isCancelable;
            return this;
        }

        /**
         * 设置是否可以取消
         *
         * @param isCancelOutside
         * @return
         */
        public Builder setCancelOutside(boolean isCancelOutside) {
            this.isCancelOutside = isCancelOutside;
            return this;
        }

        public LoadingDialog create() {

            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.dialog_loading, null);


            /**
             * 获取高度
             */
            LinearLayout llLoading = (LinearLayout) view.findViewById(R.id.ll_loading);
            //measure的参数为0即可
            llLoading.measure(0,0);
            //获取高度
            int measuredHeight = llLoading.getMeasuredHeight();


            /**
             * 设置宽度
             */
            LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) llLoading.getLayoutParams();
            //把宽度设置跟高度一样
            linearParams.width = (int) measuredHeight;
            view.setLayoutParams(linearParams);


            LoadingDialog loadingDialog = new LoadingDialog(context, R.style.ProgressDialog);
            TextView loadingText = (TextView) view.findViewById(R.id.loading_text);
            loadingText.setText(message);
//            if(isShowMessage){
//                msgText.setText(message);
//            }else{
//                msgText.setVisibility(View.GONE);
//            }
            loadingDialog.setContentView(view);
            loadingDialog.setCancelable(isCancelable);
            loadingDialog.setCanceledOnTouchOutside(isCancelOutside);
            return loadingDialog;

        }

    }

}
