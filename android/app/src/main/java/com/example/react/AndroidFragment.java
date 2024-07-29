package com.example.react;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.react.databinding.FragmentSecondBinding;

public class AndroidFragment extends Fragment{

    TextWatcher watcher;
    FragmentSecondBinding binding;
    public void setWatcher(TextWatcher textWatcher) {
        watcher = textWatcher;
    }

    public void setValue(String value) {
        binding.editText.setText(value);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null) {
            binding = FragmentSecondBinding.inflate(inflater, container, false);
        }
        binding.editText.addTextChangedListener(watcher);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        binding.editText.removeTextChangedListener(watcher);
        super.onDestroyView();
    }
}
