package com.example.activitytest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class EmployeeAdapter extends ArrayAdapter<EmployeeInfo> {

    private Context mContext;

    private List<EmployeeInfo> empList;

    private TextView mName;
    private TextView mEmail;
    private TextView mAge;
    private TextView mSkills;

    public EmployeeAdapter(@NonNull Context context, @NonNull List<EmployeeInfo> empList) {
        super(context, R.layout.layout_model, empList);

        this.empList = new ArrayList<>();

        mContext = context;
        this.empList = empList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mContext);

        convertView = inflater.inflate(R.layout.layout_model, parent, false);

        mName = convertView.findViewById(R.id.modelName);
        mEmail = convertView.findViewById(R.id.modelEmail);
        mAge = convertView.findViewById(R.id.modelAge);
        mSkills = convertView.findViewById(R.id.modelSkills);

        mName.setText(empList.get(position).getName());
        mAge.setText(empList.get(position).get_age());
        mEmail.setText(empList.get(position).getEmail());
        mSkills.setText(empList.get(position).getSkill());

        return convertView;
    }
}
