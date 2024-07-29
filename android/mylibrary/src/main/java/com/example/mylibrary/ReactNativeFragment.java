package com.example.mylibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.react.PackageList;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.soloader.SoLoader;

import java.util.List;

public class ReactNativeFragment extends Fragment {

    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;
    private StateUpdater stateUpdater;

    public void setStateUpdater(StateUpdater updater) {
        this.stateUpdater = updater;
    }

    public static ReactNativeFragment newInstance(String string) {

        Bundle args = new Bundle();
        args.putString("string", string);
        ReactNativeFragment fragment = new ReactNativeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void updateFromReactNative(String value) {
        stateUpdater.updateState(value);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentManagerSingleton.getInstance().setMyFragment(this);
        Bundle props = new Bundle();
        if (getArguments() != null) {
            props.putString("inputText", getArguments().getString("string"));
        }

        if (mReactRootView == null) {
            SoLoader.init(requireContext(), false);

            mReactRootView = new ReactRootView(requireContext());
            List<ReactPackage> packages = new PackageList(requireActivity().getApplication()).getPackages();
            packages.add(new MyAppPackage());

            mReactInstanceManager = ReactInstanceManager.builder()
                    .setApplication(requireActivity().getApplication())
                    .setCurrentActivity(requireActivity())
                    .setBundleAssetName("index.android.bundle")
                    .setJSMainModulePath("index")
                    .addPackages(packages)
                    .setUseDeveloperSupport(BuildConfig.DEBUG)
                    .setInitialLifecycleState(LifecycleState.RESUMED)
                    .build();


            mReactRootView.startReactApplication(mReactInstanceManager, "integrated", props);
        }

        mReactRootView.setAppProperties(props);

        return mReactRootView;
    }

    public void setState(String value) {
        Bundle bundle = new Bundle();
        bundle.putString("inputText", value);
        mReactRootView.setAppProperties(bundle);
    }

    @Override
    public void onDestroy() {
        FragmentManagerSingleton.getInstance().setMyFragment(null);
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
