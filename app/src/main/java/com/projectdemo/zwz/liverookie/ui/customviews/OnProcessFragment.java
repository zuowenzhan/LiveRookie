package com.projectdemo.zwz.liverookie.ui.customviews;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import com.projectdemo.zwz.liverookie.R;


/**
 * @description:
 * @author: Andruby
 * @time: 2016/12/17 10:23
 */
public class OnProcessFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = new Dialog(getActivity(), R.style.loading_dialog);
        dialog.setContentView(R.layout.fragment_loading);
        dialog.setCancelable(false);

        return dialog;
    }
}
