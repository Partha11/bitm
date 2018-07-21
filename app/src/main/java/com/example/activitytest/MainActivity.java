package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
    RadioGroup radioGroup;

    List<String> skills;

    StudentInfo student;

    String name;
    String _age;
    String skillConcatenated;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skills = new ArrayList<>();

        radioGroup = findViewById(R.id.radioGroup);

        radioGroup.check(R.id.male);

        initFields();
    }

    public void initFields() {

        fields = new EditText[2];

        for (int i = 0; i < 2; i++) {

            if (i == 0)

                fields[i] = findViewById(R.id.nameField);

            else

                fields[i] = findViewById(R.id.ageField);
        }
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

    public void submitButtonClicked(View view) {

        submitButton = (Button) view;

        name = fields[0].getText().toString();
        _age = fields[1].getText().toString();

        skillConcatenated = TextUtils.join(", ", skills);

        RadioButton radioSelection = findViewById(radioGroup.getCheckedRadioButtonId());

        gender = radioSelection.getText().toString();

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (name.equals(""))

                    fields[0].setError("Please Enter Your Name");

                else if (_age.equals(""))

                    fields[1].setError("Please Enter Your Age");

                else {

                    student = new StudentInfo(name, _age, skillConcatenated, gender);

                    Intent i = new Intent(MainActivity.this, StudentActivity.class);

                    i.putExtra("name", student);

                    startActivity(i);

                    skills.clear();
                }
            }
        });
    }
}