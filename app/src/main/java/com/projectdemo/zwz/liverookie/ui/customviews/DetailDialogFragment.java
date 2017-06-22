package com.projectdemo.zwz.liverookie.ui.customviews;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.projectdemo.zwz.liverookie.R;


/**
 * @description:  结束dialog
 * @author: Andruby
 * @time: 2016/12/17 10:23
 */
public class DetailDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog mDetailDialog = new Dialog(getActivity(), R.style.dialog);
        mDetailDialog.setContentView(R.layout.dialog_publish_detail);
        mDetailDialog.setCancelable(false);

        TextView tvCancel = (TextView) mDetailDialog.findViewById(R.id.btn_cancel);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDetailDialog.dismiss();
                getActivity().finish();
            }
        });

        TextView tvDetailTime = (TextView) mDetailDialog.findViewById(R.id.tv_time);
        TextView tvDetailAdmires = (TextView) mDetailDialog.findViewById(R.id.tv_admires);
        TextView tvDetailWatchCount = (TextView) mDetailDialog.findViewById(R.id.tv_members);

        //确认则显示观看detail
        tvDetailTime.setText(getArguments().getString("time"));
        tvDetailAdmires.setText(getArguments().getString("heartCount"));
        tvDetailWatchCount.setText(getArguments().getString("totalMemberCount"));

        return mDetailDialog;
    }
}
