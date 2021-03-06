package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText fields[];

    CheckBox checkBox;

    Button submitButton;
    Button resetButton;
    Button loginButton;

    RadioGroup genderGroup;
    RadioGroup salaryGroup;

    RadioButton genderButton;
    RadioButton salaryButton;

    Spinner locationSpinner;

    ArrayAdapter adapter;

    List<String> skills;
    List<String> locations;

    EmployeeInfo emp;

    String name;
    String _age;
    String mail;
    String pass;
    String skillConcatenated;
    String gender;
    String salary;
    String empLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skills = new ArrayList<>();
        locations = new ArrayList<>();

        initAll();
        initLocation();

        adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, locations);

        submitButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);

        genderGroup.check(R.id.male);
        salaryGroup.check(R.id.basedSalary);

        locationSpinner.setAdapter(adapter);

        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                empLocation = locations.get(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void initAll() {

        fields = new EditText[4];

        fields[0] = findViewById(R.id.nameField);   //Name
        fields[1] = findViewById(R.id.mailField);   //Email
        fields[2] = findViewById(R.id.passField);   //Password
        fields[3] = findViewById(R.id.ageField);    //Age

        genderGroup = findViewById(R.id.genderGroup);
        salaryGroup = findViewById(R.id.salaryGroup);

        submitButton = findViewById(R.id.submitButton);
        resetButton = findViewById(R.id.resetButton);
        loginButton = findViewById(R.id.loginButton);

        locationSpinner = findViewById(R.id.spinner);
    }

    public void initLocation() {

        locations.add("Dhaka");
        locations.add("Sylhet");
        locations.add("Rajshahi");
        locations.add("Rangpur");
        locations.add("Comilla");
        locations.add("Barisal");
        locations.add("CHittagong");
    }

    public void clearAll() {

        skills.clear();

        for (int i = 0; i < 4; i++)

            fields[i].setText("");

        genderGroup.check(R.id.male);
        salaryGroup.check(R.id.basedSalary);
    }

    public void fieldToText() {

        name = fields[0].getText().toString();
        mail = fields[1].getText().toString();
        pass = fields[2].getText().toString();
        _age = fields[3].getText().toString();

        skillConcatenated = TextUtils.join(", ", skills);

        int genderIndex = genderGroup.getCheckedRadioButtonId();
        int salaryIndex = salaryGroup.getCheckedRadioButtonId();

        genderButton = findViewById(genderIndex);
        salaryButton = findViewById(salaryIndex);

        gender = genderButton.getText().toString();
        salary = salaryButton.getText().toString();
    }

    public void checkboxClicked(View view) {

        checkBox = (CheckBox) view;

        String text = checkBox.getText().toString();

        if (checkBox.isChecked()) {

            skills.add(text);
        }

        else {

            skills.remove(text);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.submitButton:

                submitButtonClicked(view);
                break;

            case R.id.resetButton:

                resetButtonClicked(view);
                break;

            case R.id.loginButton:

                loginButtonClicked(view);
                break;

            default:

                Toast.makeText(this, "Could Not Click Button", Toast.LENGTH_SHORT).show();
        }
    }

    public int checkFields() {

        if (fields[0].getText().toString().equals("") || fields[0].getText().toString().equals(" "))

            return 1;

        else if (fields[1].getText().toString().equals("") || fields[1].getText().toString().equals(" "))

            return 2;

        else if (fields[2].getText().toString().equals("") || fields[2].getText().toString().equals(" "))

            return 3;

        else if (fields[3].getText().toString().equals("") || fields[3].getText().toString().equals(" "))

            return 4;

        else

            return 0;
    }

    public void submitButtonClicked(View view) {

        //emp = new EmployeeInfo("abc", "abc", "***", "21", "java", "male", "500");

        fieldToText();

        int validateFields = checkFields();

        if (validateFields == 0) {

            emp = new EmployeeInfo(name, mail, pass, _age, skillConcatenated, gender, salary, empLocation);

            TempData.getEmpInfo().add(emp);

            resetButtonClicked(view);
        }

        else if (validateFields == 1)

            fields[0].setError("Name field can not be empty!!");

        else if (validateFields == 2)

            fields[1].setError("Email field can not be empty!!");

        else if (validateFields == 3)

            fields[2].setError("Password can not be blank!!");

        else if (validateFields == 4)

            fields[3].setError("Age field can not be empty!!");
    }

    public void resetButtonClicked(View view) {

        clearAll();

        CheckBox javaBox = findViewById(R.id.javaCheck);
        CheckBox cppBox = findViewById(R.id.cppCheck);
        CheckBox pythonBox = findViewById(R.id.pythonCheck);
        CheckBox phpBox = findViewById(R.id.phpCheck);

        javaBox.setChecked(false);
        cppBox.setChecked(false);
        pythonBox.setChecked(false);
        phpBox.setChecked(false);
    }

    public void loginButtonClicked(View view) {

        Intent intent = new Intent(MainActivity.this, Employee.class);
        startActivity(intent);
    }
}