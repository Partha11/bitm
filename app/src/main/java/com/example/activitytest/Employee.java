package com.example.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Employee extends AppCompatActivity {

    TextView fields[];

    EmployeeInfo student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        initFields();

        Bundle bundle = getIntent().getExtras();

        student = (EmployeeInfo) bundle.getSerializable("name");

        fields[0].setText(student.getName());
        fields[1].setText(student.get_age());
        fields[2].setText(student.getSkill());
        fields[3].setText(student.getGender());
    }

    public void initFields() {

        fields = new TextView[4];

        for (int i = 0; i < 4; i++) {

            if (i == 0)

                fields[i] = findViewById(R.id.name);

            else if (i == 1)

                fields[i] = findViewById(R.id.age);

            else if (i == 2)

                fields[i] = findViewById(R.id.skills);

            else

                fields[i] = findViewById(R.id.gender);
        }
    }
}
