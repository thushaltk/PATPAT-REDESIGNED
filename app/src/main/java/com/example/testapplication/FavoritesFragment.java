package com.example.testapplication;

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

public class FavoritesFragment extends Fragment {

    private ArrayList<String> favTitlesArr = new ArrayList<>();
    private ArrayList<String> favPricesArr = new ArrayList<>();
    private ArrayList<String> favDownPaymentsArr = new ArrayList<>();
    private ArrayList<String> favBestLeaseRentalsArr = new ArrayList<>();
    private ArrayList<String> favDatesArr = new ArrayList<>();
    private ArrayList<String> favImagesArr = new ArrayList<>();
    private Helper helper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorites, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initImageBitMaps();

    };

    private void initImageBitMaps(){
        this.favImagesArr.add("https://www.dailynews.lk/sites/default/files/news/2019/12/12/z_p-i--Vehicle.jpg");
        this.favImagesArr.add("https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/vdat/submodels/hyundai_kona_hyundai-kona_2019-1544050623924.jpg?fill=18:11&resize=480:*");
        this.favImagesArr.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFgmaQMEbJaJTyJ_z9Lrtwu8zr88FBj9kSM9sTSPiBWHOOoJvO-A7iA9C7MYQXxCopam0&usqp=CAU");
        this.favImagesArr.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFgmaQMEbJaJTyJ_z9Lrtwu8zr88FBj9kSM9sTSPiBWHOOoJvO-A7iA9C7MYQXxCopam0&usqp=CAU");

        this.favTitlesArr.add("Vehicle-01");
        this.favTitlesArr.add("Vehicle-02");
        this.favTitlesArr.add("Vehicle-03");
        this.favTitlesArr.add("Vehicle-04");

        this.favPricesArr.add("LKR 150,000");
        this.favPricesArr.add("LKR 160,000");
        this.favPricesArr.add("LKR 170,000");
        this.favPricesArr.add("LKR 170,000");

        this.favDownPaymentsArr.add("LKR 80,500");
        this.favDownPaymentsArr.add("LKR 90,500");
        this.favDownPaymentsArr.add("LKR 100,500");
        this.favDownPaymentsArr.add("LKR 100,500");

        this.favBestLeaseRentalsArr.add("LKR 60,500");
        this.favBestLeaseRentalsArr.add("LKR 70,500");
        this.favBestLeaseRentalsArr.add("LKR 50,500");
        this.favBestLeaseRentalsArr.add("LKR 50,500");

        this.favDatesArr.add("Kalutara | 2021-09-11 | 16.23.06");
        this.favDatesArr.add("Maradana | 2021-09-11 | 16.23.06");
        this.favDatesArr.add("Borella | 2021-09-11 | 16.23.06");
        this.favDatesArr.add("Borella | 2021-09-11 | 16.23.06");

        initRecyclerView();
    };

    private void initRecyclerView(){
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view_fav);
        FavRecyclerViewAdapter adapter = new FavRecyclerViewAdapter(favTitlesArr, favPricesArr, favDownPaymentsArr, favBestLeaseRentalsArr, favDatesArr, favImagesArr, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
