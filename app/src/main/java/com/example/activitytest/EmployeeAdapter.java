package com.example.activitytest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class EmployeeAdapter extends ArrayAdapter<EmployeeInfo> {

    private Context mContext;

    List<EmployeeInfo> empList = new ArrayList<>();

    public EmployeeAdapter(@NonNull Context context, @NonNull List<EmployeeInfo> empList) {
        super(context, R.layout.activity_layout_employee, empList);

        mContext = context;
        this.empList = empList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mContext);

        convertView = inflater.inflate(R.layout.activity_layout_employee, parent, false);

        return convertView;
    }
}
