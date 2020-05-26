package com.example.sharedpreferences_20200526;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.sharedpreferences_20200526.databinding.ActivityMainBinding;
import com.example.sharedpreferences_20200526.utils.ContextUtil;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.idSaveCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ContextUtil.setIdSave(mContxt,isChecked);
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isIdSave = binding.idSaveCheckBox.isChecked();
                if(isIdSave){
                    String inputId = binding.emailEdt.getText().toString();

                    ContextUtil.setUserId(mContxt, inputId);
                }

            }
        });
    }

    @Override
    public void setValues() {

        binding.idSaveCheckBox.setChecked(ContextUtil.isIdSave(mContxt));

        binding.emailEdt.setText(ContextUtil.getUserId(mContxt));

    }
}
