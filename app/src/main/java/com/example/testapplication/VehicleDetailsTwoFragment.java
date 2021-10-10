package com.example.testapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class VehicleDetailsTwoFragment extends Fragment {

    TextView vehicleTwoBack;
    TextView vehicleTwoNext;
    private String[] conditions;
    private String[] fuelTypes;

    public VehicleDetailsTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vehicle_details_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vehicleTwoBack = (TextView) view.findViewById(R.id.vehicleTwo_back);
        vehicleTwoNext = (TextView) view.findViewById(R.id.vehicleTwo_next);

        this.conditions = getResources().getStringArray(R.array.conditions);
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.dropdown_item, conditions);
        AutoCompleteTextView autoCompleteTextView = getView().findViewById(R.id.autoCompleteTextView_conditions);
        autoCompleteTextView.setAdapter(arrayAdapter );

        this.fuelTypes = getResources().getStringArray(R.array.fuelTypes);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(requireContext(), R.layout.dropdown_item, fuelTypes);
        AutoCompleteTextView autoCompleteTextView2 = getView().findViewById(R.id.autoCompleteTextView_fuelTypes);
        autoCompleteTextView2.setAdapter(arrayAdapter2 );

        vehicleTwoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new VehicleDetailsOneFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit();
            }
        });

        vehicleTwoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ContactDetailsFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit();
            }
        });
    }
}