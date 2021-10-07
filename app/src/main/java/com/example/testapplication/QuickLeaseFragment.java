package com.example.testapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuickLeaseFragment extends Fragment {
    
    private String[] titles;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quicklease, container, false);

    }


    @Override
    public void onResume() {
        super.onResume();

        this.titles = getResources().getStringArray(R.array.titles);
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.dropdown_item, titles);


        AutoCompleteTextView autoCompleteTextView = getView().findViewById(R.id.autoCompleteTextView3);
        autoCompleteTextView.setAdapter(arrayAdapter );
    }
}
