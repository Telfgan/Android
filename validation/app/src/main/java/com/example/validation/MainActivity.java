package com.example.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText emailInput;
    EditText passwordInput;
    EditText confirmPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.registerBtn);
        btn.setOnClickListener(v -> onRegisterButtonClick());
        emailInput = findViewById(R.id.input_email);
        passwordInput = findViewById(R.id.input_password);
        confirmPasswordInput = findViewById(R.id.input_password_confirmation);
    }

    public void onRegisterButtonClick() {
        Validation validator = new Validation();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String passwordConfirm = confirmPasswordInput.getText().toString();
        User registering = new User(email, password, passwordConfirm);
        if (validator.validateUser(registering)) Toast.makeText(getApplicationContext(),
                "Пользователь зарегистрирован", Toast.LENGTH_SHORT).show();
        else Toast.makeText(getApplicationContext(),
                "Регистрация пользователя провалена", Toast.LENGTH_SHORT).show();
    }
}