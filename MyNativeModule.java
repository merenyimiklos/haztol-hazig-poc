package com.emma.poc;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class MyNativeModule extends ReactContextBaseJavaModule {

    MyNativeModule(ReactApplicationContext context) {
        super(context);
    }

    @NonNull
    @Override
    public String getName() {
        return "MyNativeModule";
    }

    @ReactMethod
    public void callFragmentMethod(String value) {
        MainActivity activity = (MainActivity) getCurrentActivity();
        if (activity != null) {
            activity.updateFromReactNative(value);
        }
    }
}
