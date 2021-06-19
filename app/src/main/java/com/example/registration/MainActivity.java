package com.example.registration;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText etLogin;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etAge;
    private EditText etAdress;
    private Button btRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLogin = findViewById(R.id.etLogin);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etAge = findViewById(R.id.etAge);
        etAdress = findViewById(R.id.etAdress);
        btRegistration = findViewById(R.id.btRegistration);

        User userSergei = new User("Sergei87", "tsybulnikserg@gmail.com", "12345", "12345",
                34, "Ирпень, Украина, 08200, ул. Джерельная 12-42");
        User userIvanov = new User("Ivan", "ivanov@gmail.com", "54321",
                "54321", 43, "Донецк, Украина, 08045, ул. Арктическая 12");
        User newUser = new User();
        ArrayList<User> users = new ArrayList<>();
        users.add(userSergei);
        users.add(userIvanov);

        etLogin.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (etLogin.getText().toString().equals(userSergei.getLogin()) ||
                        etLogin.getText().toString().equals(userIvanov.getLogin())) {
                    etLogin.setText("");
                    etLogin.setHint("Введите другой логин");
                    Toast.makeText(MainActivity.this,
                            "Пользователь с таким логином уже существует!",
                            Toast.LENGTH_LONG).show();
                    return true;
                }
                if (etLogin.getText().toString().length() <= 5) {
                    etLogin.setText("");
                    Toast.makeText(MainActivity.this, "Логин должен иметь более 5 символов", Toast.LENGTH_LONG).show();
                    etLogin.setHint("Введите новый логин");
                    return true;
                }else {
                    newUser.setLogin(etLogin.getText().toString());
                    etLogin.setText(newUser.getLogin());
                    return false;
                }
            }
        });
        etEmail.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (!etEmail.getText().toString().contains("@") || !etEmail.getText().toString().contains(".")) {
                    etEmail.setText("");
                    Toast.makeText(MainActivity.this,
                            "Email должен содержать знак '&' и '.'",
                            Toast.LENGTH_LONG).show();
                    etEmail.setHint("Введите корректный email");
                    return true;
                }
                newUser.setEmail(etEmail.getText().toString());
                etEmail.setText(newUser.getEmail());
                return false;
            }
        });
        etPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (etPassword.getText().toString().length() <= 4) {
                    etPassword.setText("");
                    Toast.makeText(MainActivity.this,
                            "Пароль должнен быть более 4 символов",
                            Toast.LENGTH_LONG).show();
                    etPassword.setHint("Попробуйте другой пароль");
                    return true;
                }
                newUser.setPassword(etPassword.getText().toString());
                return false;
            }
        });
        etConfirmPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (etConfirmPassword.getText().toString().equals(etPassword.getText().toString())) {
                    newUser.setConfirmPasword(etPassword.getText().toString());
                    return false;
                }
                etConfirmPassword.setText("");
                Toast.makeText(MainActivity.this,
                        "Пароли должны совпадать",
                        Toast.LENGTH_LONG).show();
                etConfirmPassword.setHint("Потверждение вашего пароля");
                return true;
            }
        });

        etAge.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                int age = Integer.parseInt(etAge.getText().toString());
                if (age < 18) {
                    etAge.setText("");
                    Toast.makeText(MainActivity.this,
                            "Ваш возраст должны быть больше 18 лет",
                            Toast.LENGTH_LONG).show();
                    etAge.setHint("Ваш возраст");
                    return true;
                }
                newUser.setAge(Integer.parseInt(etAge.getText().toString()));
                return false;
            }
        });
        etAdress.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (!etAdress.getText().toString().contains("Ukraine")) {
                    etAdress.setText("");
                    Toast.makeText(MainActivity.this,
                            "Вы должны проживать в Украине",
                            Toast.LENGTH_LONG).show();
                    etAdress.setHint("Ваш адрес в Украине");
                    return true;
                }
                newUser.setAdress(etAdress.getText().toString());
                return false;
            }
        });
        btRegistration.setOnClickListener(v -> {
            if (newUser!=null) {
                Toast.makeText(MainActivity.this,
                        "Имя "+newUser.getLogin() + " " +"Email "+ newUser.getEmail(),
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this,
                        "Заполните все данные корректно",
                        Toast.LENGTH_LONG).show();
            }
        });
    }


}