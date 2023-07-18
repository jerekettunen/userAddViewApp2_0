package com.example.userstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] avatarSelectionString = {"Ikoni 1", "Ikoni 2", "Ikoni 3", "Ikoni 4", "Ikoni 5"};
    final int[] iconArray =
            {R.drawable.icon_1,
            R.drawable.icon_2,
            R.drawable.icon_3,
            R.drawable.icon_4,
            R.drawable.icon_5};

    int selectedIcon;
    String program;
    EditText firstName;
    EditText lastName;
    EditText email;
    Context context;
    CheckBox ch1, ch2, ch3, ch4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.avatarSelect);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, avatarSelectionString);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        firstName = findViewById(R.id.firstNameTxt);
        lastName = findViewById(R.id.lastNameTxt);
        email = findViewById(R.id.emailTxt);

        context = MainActivity.this;
        UserStorage.getInstance().loadUsers(context);

        ch1 = findViewById(R.id.bachelorCheck);
        ch2 = findViewById(R.id.engineerCheck);
        ch3 = findViewById(R.id.doctorCheck);
        ch4 = findViewById(R.id.honorDoctorCheck);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        ImageView img = findViewById(R.id.avatarImage);
        selectedIcon = iconArray[position];
        img.setImageResource(selectedIcon);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // noting necessary
    }

    public void addUserClick(View view){
        UserStorage s = UserStorage.getInstance();
        ArrayList<String> degrees = new ArrayList<>();

        RadioGroup programType = findViewById(R.id.fieldGroup);
        RadioButton programSelected = findViewById(programType.getCheckedRadioButtonId());
        program = programSelected.getText().toString();

        if (ch1.isChecked()){
            degrees.add(ch1.getText().toString());
        }
        if (ch2.isChecked()){
            degrees.add(ch2.getText().toString());
        }
        if (ch3.isChecked()){
            degrees.add(ch3.getText().toString());
        }
        if (ch4.isChecked()){
            degrees.add(ch4.getText().toString());
        }

        User user = new User(firstName.getText().toString(), lastName.getText().toString(),
                email.getText().toString(), program, selectedIcon, degrees);
        s.addUser(user);
        s.saveUsers(context);
    }

    public void switchToUserList(View view){
        Intent intent = new Intent(this, UsersListActivity.class);
        startActivity(intent);
    }
}