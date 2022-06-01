package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initListener();
        editListener();
    }
    private void initListener() {
        binding.rt.setEnabled(false);
        binding.rt.setOnClickListener(view -> {
            String login = binding.rrr.getText().toString().trim();
            String password = binding.tt.getText().toString().trim();
            if (login.equals("Admin") && password.equals("admin@12345")) {
                Toast.makeText(this, "Вы зарегистрировались",
                        Toast.LENGTH_LONG).show();
                if (binding.rrr.getVisibility() == View.VISIBLE) {
                    binding.rrr.setVisibility(View.GONE);
                } else {
                    binding.rrr.setVisibility(View.VISIBLE);
                }
                if (binding.tt.getVisibility() == View.VISIBLE) {
                    binding.tt.setVisibility(View.GONE);
                } else {
                    binding.tt.setVisibility(View.VISIBLE);
                }
                if (binding.rr.getVisibility() == View.VISIBLE) {
                    binding.rr.setVisibility(View.GONE);
                } else {
                    binding.rr.setVisibility(View.VISIBLE);
                }
            } else {
                Toast.makeText(this, "Неправильный логин или пороль",
                        Toast.LENGTH_LONG).show();
            }
        });
        binding.txtForget.setOnClickListener(view ->
                Toast.makeText(this, "Ваш логин : Admin \n Ваш пароль : admin@12345 "
                        , Toast.LENGTH_LONG).show());
    }
    public void editListener() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.rrr.getText().length() > 0 && binding.tt.getText().length() > 0) {
                    binding.rt.setBackgroundResource(R.drawable.yy);
                    binding.rt.setEnabled(true);
                } else {
                    binding.rt.setBackgroundResource(R.drawable.rr);
                    binding.rt.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        binding.rrr.addTextChangedListener(textWatcher);
        binding.tt.addTextChangedListener(textWatcher);
    }
}