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


public class CustomerInquiryFragment extends Fragment {

    private String[] titles;
    Button addCustomerInquiry;

    public CustomerInquiryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_inquiry, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.titles = getResources().getStringArray(R.array.titles);
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.dropdown_item, titles);

        AutoCompleteTextView autoCompleteTextView = getView().findViewById(R.id.autoCompleteTextView_custInq_faq);
        autoCompleteTextView.setAdapter(arrayAdapter );

        addCustomerInquiry = (Button) view.findViewById(R.id.add_custInq_submit);
        addCustomerInquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CustomerInquirySuccessPopup.class);
                startActivity(intent);
            }
        });
    }
}