package com.example.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Employee extends AppCompatActivity {

    ListView mListView;

    List<EmployeeInfo> empList;

    EmployeeInfo singleEmp;
    EmployeeAdapter empAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_employee);

        empList = new ArrayList<>();

        mListView = findViewById(R.id.listView);

        singleEmp = (EmployeeInfo) getIntent().getSerializableExtra("empInfo");

        if (singleEmp == null)

            System.out.println("**************************************************Null Object");

        empList.add(singleEmp);

        empAdapter = new EmployeeAdapter(this, empList);

        mListView.setAdapter(empAdapter);
    }
}
