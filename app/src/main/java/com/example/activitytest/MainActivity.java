package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText fields[];
    CheckBox checkBox;
    Button submitButton;
    RadioGroup genderGroup;
    RadioGroup salaryGroup;

    List<String> skills;

    EmployeeInfo emp;

    String name;
    String _age;
    String mail;
    String pass;
    String skillConcatenated;
    String gender;
    String salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skills = new ArrayList<>();

        genderGroup = findViewById(R.id.genderGroup);
        salaryGroup = findViewById(R.id.salaryGroup);

        genderGroup.check(R.id.male);

        initFields();

        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick( View view ) {

                //emp = new EmployeeInfo("abc", "abc", "***", "21", "java", "male", "500");

                name = fields[0].getText().toString();
                mail = fields[1].getText().toString();
                pass = fields[2].getText().toString();
                _age = fields[3].getText().toString();

                emp = new EmployeeInfo(name, mail, pass, _age, "java", "male", "500");

                TempData.empInfo.add(emp);

                Intent intent = new Intent(MainActivity.this, Employee.class);
                startActivity(intent);
            }
        });
    }

    public void initFields() {

        fields = new EditText[4];

        fields[0] = findViewById(R.id.nameField);
        fields[1] = findViewById(R.id.mailField);
        fields[2] = findViewById(R.id.passField);
        fields[3] = findViewById(R.id.ageField);
    }

    public void checkboxClicked(View view) {

        checkBox = (CheckBox) view;

        String text = checkBox.getText().toString();

        if (checkBox.isChecked()) {

            skills.add(text);

            Toast.makeText(this, text + " added", Toast.LENGTH_SHORT).show();
        }

        else {

            skills.remove(text);

            Toast.makeText(this, text + " removed", Toast.LENGTH_SHORT).show();
        }
    }
}