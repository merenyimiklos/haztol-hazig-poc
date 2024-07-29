package com.example.mylibrary;

public class FragmentManagerSingleton {
    private static FragmentManagerSingleton instance;
    private ReactNativeFragment myFragment;

    private FragmentManagerSingleton() {}

    public static synchronized FragmentManagerSingleton getInstance() {
        if (instance == null) {
            instance = new FragmentManagerSingleton();
        }
        return instance;
    }

    public void setMyFragment(ReactNativeFragment fragment) {
        this.myFragment = fragment;
    }

    public ReactNativeFragment getMyFragment() {
        return myFragment;
    }
}
