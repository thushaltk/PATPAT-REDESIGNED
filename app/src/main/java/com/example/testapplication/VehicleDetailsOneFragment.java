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

import org.w3c.dom.Text;

public class VehicleDetailsOneFragment extends Fragment {

    TextView vehicleOneNext;
    private String[] vehicleTypes;
    private String[] transmissions;
    private String[] manufacturers;

    public VehicleDetailsOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vehicle_details_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.vehicleTypes = getResources().getStringArray(R.array.vehicleType);
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.dropdown_item, vehicleTypes);
        AutoCompleteTextView autoCompleteTextView = getView().findViewById(R.id.autoCompleteTextView_vehicleTypes);
        autoCompleteTextView.setAdapter(arrayAdapter );


        this.transmissions = getResources().getStringArray(R.array.transmissions);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(requireContext(), R.layout.dropdown_item, transmissions);
        AutoCompleteTextView autoCompleteTextView2 = getView().findViewById(R.id.autoCompleteTextView_transmission);
        autoCompleteTextView2.setAdapter(arrayAdapter2 );

        this.manufacturers = getResources().getStringArray(R.array.manufacturers);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(requireContext(), R.layout.dropdown_item, manufacturers);
        AutoCompleteTextView autoCompleteTextView3 = getView().findViewById(R.id.autoCompleteTextView_manufactuere);
        autoCompleteTextView3.setAdapter(arrayAdapter3 );





        vehicleOneNext = (TextView) view.findViewById(R.id.vehicleOne_next);
        vehicleOneNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new VehicleDetailsTwoFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit();
            }
        });
    }
}