package com.example.userstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

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

        RadioGroup programType = findViewById(R.id.fieldGroup);
        RadioButton programSelected = findViewById(programType.getCheckedRadioButtonId());
        program = programSelected.getText().toString();

        User user = new User(firstName.getText().toString(), lastName.getText().toString(),email.getText().toString(),program,selectedIcon);
        s.addUser(user);
    }

    public void switchToUserList(View view){
        Intent intent = new Intent(this, UsersListActivity.class);
        startActivity(intent);
    }
}