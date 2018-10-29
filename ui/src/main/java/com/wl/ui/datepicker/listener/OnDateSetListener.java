package com.wl.timepicker.listener;

import com.wl.timepicker.TimePickerDialog;

import java.util.Calendar;

/**
 * Created by jzxiang on 16/4/20.
 */
public interface OnDateSetListener {

    void onDateSet(TimePickerDialog timePickerView, long millseconds);
}
