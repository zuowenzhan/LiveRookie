package com.projectdemo.zwz.liverookie.ui.loading;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.projectdemo.zwz.liverookie.R;


/**
 * @description: 小球的Progress
 * @author: Andruby
 * @time: 2016/12/17 10:23
 */
public class CustomProgressDialog extends Dialog  {
    private static final String TAG ="CustomProgressDialog";
    private Context context = null;

    private static CustomProgressDialog customProgressDialog = null;
    private static boolean isCanTouchOutside = true;

    private CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    public static CustomProgressDialog createDialog(Context context) {
        if(customProgressDialog!=null)
        {
            customProgressDialog.dismiss();
            customProgressDialog = null;
        }
        customProgressDialog = new CustomProgressDialog(context, R.style.custome_dialog_style);
        customProgressDialog.setContentView(R.layout.custom_progress_dialog);
        customProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        customProgressDialog.setCanceledOnTouchOutside(isCanTouchOutside);
        return customProgressDialog;
    }

    public static void setIsCanTouchOutside(boolean isCanTouchOutside) {

        customProgressDialog.setCanceledOnTouchOutside(isCanTouchOutside);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        if (customProgressDialog == null) {
            return;
        }
    }

    /**
     * [Summary] setMessage 提示内容
     *
     * @param strMessage
     * @return
     */
    public CustomProgressDialog setMessage(String strMessage) {
        TextView tvMsg = (TextView) customProgressDialog
                .findViewById(R.id.id_tv_loadingmsg);
        if (tvMsg != null) {
            tvMsg.setText(strMessage);
        }
        return customProgressDialog;
    }

    public boolean isShow()
    {
        boolean isShow =false;
        if(customProgressDialog!=null && customProgressDialog.isShowing())
        {
            isShow  = true;
        }
        return isShow;
    }

    public void dismiss() {
        if (isShow()) {
            super.dismiss();
        }
        customProgressDialog = null;
    }

    public static CustomProgressDialog getDialog(Context context) {
        if(customProgressDialog!=null)
        {
            return customProgressDialog;
        }else
        {
            return createDialog(context);
        }

    }

    @Override
    public void show() {
        if (customProgressDialog != null&&!customProgressDialog.isShow())
        {
            try{
                super.show();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }else
        {
            Log.e(TAG," null");
        }

    }
}
