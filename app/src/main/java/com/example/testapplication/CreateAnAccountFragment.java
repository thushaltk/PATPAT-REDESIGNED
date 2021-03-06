package com.example.testapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class CreateAnAccountFragment extends Fragment {

    Button ca_btn;
    private String[] titles;

    public CreateAnAccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_an_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ca_btn = view.findViewById(R.id.ca_submit);

        this.titles = getResources().getStringArray(R.array.titles);
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.dropdown_item, titles);


        AutoCompleteTextView autoCompleteTextView = getView().findViewById(R.id.autoCompleteTextView_ca);
        autoCompleteTextView.setAdapter(arrayAdapter );

        ca_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SuccessPopup.class);
                startActivity(intent);
            }
        });
    }
}