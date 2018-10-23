package com.wl.ui.tdialog.listener;

import android.view.View;

import com.wl.ui.tdialog.TDialog;
import com.wl.ui.tdialog.base.BindViewHolder;

public interface OnViewClickListener {
    void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog);
}
