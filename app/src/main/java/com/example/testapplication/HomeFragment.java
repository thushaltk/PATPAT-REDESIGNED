package com.example.testapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<String> adTitlesArr = new ArrayList<>();
    private ArrayList<String> adPricesArr = new ArrayList<>();
    private ArrayList<String> adDownPaymentsArr = new ArrayList<>();
    private ArrayList<String> adBestLeaseRentalsArr = new ArrayList<>();
    private ArrayList<String> adDatesArr = new ArrayList<>();
    private ArrayList<String> adImagesArr = new ArrayList<>();
    private Helper helper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);


    };
    // Other code

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initImageBitMaps();

    };

    private void initImageBitMaps(){
        this.adImagesArr.add("https://www.dailynews.lk/sites/default/files/news/2019/12/12/z_p-i--Vehicle.jpg");
        this.adImagesArr.add("https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/vdat/submodels/hyundai_kona_hyundai-kona_2019-1544050623924.jpg?fill=18:11&resize=480:*");
        this.adImagesArr.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFgmaQMEbJaJTyJ_z9Lrtwu8zr88FBj9kSM9sTSPiBWHOOoJvO-A7iA9C7MYQXxCopam0&usqp=CAU");
        this.adImagesArr.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFgmaQMEbJaJTyJ_z9Lrtwu8zr88FBj9kSM9sTSPiBWHOOoJvO-A7iA9C7MYQXxCopam0&usqp=CAU");

        this.adTitlesArr.add("Vehicle-01");
        this.adTitlesArr.add("Vehicle-02");
        this.adTitlesArr.add("Vehicle-03");
        this.adTitlesArr.add("Vehicle-03");

        this.adPricesArr.add("LKR 150,000");
        this.adPricesArr.add("LKR 160,000");
        this.adPricesArr.add("LKR 170,000");
        this.adPricesArr.add("LKR 170,000");

        this.adDownPaymentsArr.add("LKR 80,500");
        this.adDownPaymentsArr.add("LKR 90,500");
        this.adDownPaymentsArr.add("LKR 100,500");
        this.adDownPaymentsArr.add("LKR 100,500");

        this.adBestLeaseRentalsArr.add("LKR 60,500");
        this.adBestLeaseRentalsArr.add("LKR 70,500");
        this.adBestLeaseRentalsArr.add("LKR 50,500");
        this.adBestLeaseRentalsArr.add("LKR 50,500");

        this.adDatesArr.add("Kalutara | 2021-09-11 | 16.23.06");
        this.adDatesArr.add("Maradana | 2021-09-11 | 16.23.06");
        this.adDatesArr.add("Borella | 2021-09-11 | 16.23.06");
        this.adDatesArr.add("Borella | 2021-09-11 | 16.23.06");

        initRecyclerView();
    }


    private void initRecyclerView(){
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(adTitlesArr, adPricesArr, adDownPaymentsArr, adBestLeaseRentalsArr, adDatesArr, adImagesArr, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
