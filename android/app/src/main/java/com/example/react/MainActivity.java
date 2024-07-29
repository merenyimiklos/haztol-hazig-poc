package com.example.react;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mylibrary.ReactNativeFragment;

public class MainActivity extends AppCompatActivity {
    String stateValue = "";
    ReactNativeFragment reactNativeFragment;
    AndroidFragment androidFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        androidFragment = new AndroidFragment();
        androidFragment.setWatcher(watcher);

        loadFragment(androidFragment);

        button1.setOnClickListener(v -> {
            String value = stateValue;
            if (androidFragment == null) {
                androidFragment = new AndroidFragment();
            }
            loadFragment(androidFragment);
            androidFragment.setValue(value);
        });

        button2.setOnClickListener(v -> {
            if (reactNativeFragment == null) {
                reactNativeFragment = ReactNativeFragment.newInstance(stateValue);
            }
            loadFragment(reactNativeFragment);
            reactNativeFragment.setState(stateValue);
            reactNativeFragment.setStateUpdater(value -> stateValue = value);
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commitNow();
    }

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence inputValue, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence inputValue, int start, int before, int count) {
            stateValue = inputValue.toString();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}
