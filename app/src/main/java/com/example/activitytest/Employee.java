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

<<<<<<< HEAD
        testData();

=======
>>>>>>> 138b0bc97218fd8495a3dac903f4d987ae7cc496
        mListView = findViewById(R.id.listView);

        empAdapter = new EmployeeAdapter(this, TempData.getEmpInfo());

        mListView.setAdapter(empAdapter);
    }

    public void testData() {

        /*empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));
        empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));
        empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));
        empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));
        empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));
        empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));
        empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));
        empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));
        empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));
        empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));
        empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));
        empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));
        empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));
        empList.add(new EmployeeInfo("name", "email", "pass", "age", "abcd", "male", "500"));*/
        //empList.add(TempData.getEmpInfo().get(0));
    }
}
