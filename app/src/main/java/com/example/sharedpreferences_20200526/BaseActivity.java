package com.example.sharedpreferences_20200526;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContxt = this;

    public abstract void setupEvents();
    public abstract void setValues();
}
