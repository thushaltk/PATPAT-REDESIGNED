package com.example.testapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> adTitlesArr = new ArrayList<>();
    private ArrayList<String> adPricesArr = new ArrayList<>();
    private ArrayList<String> adDownPaymentsArr = new ArrayList<>();
    private ArrayList<String> adBestLeaseRentalsArr = new ArrayList<>();
    private ArrayList<String> adDatesArr = new ArrayList<>();
    private ArrayList<String> adImagesArr = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<String> adTitlesArr, ArrayList<String> adPricesArr, ArrayList<String> adDownPaymentsArr, ArrayList<String> adBestLeaseRentalsArr, ArrayList<String> adDatesArr, ArrayList<String> adImagesArr, Context context) {
        this.adTitlesArr = adTitlesArr;
        this.adPricesArr = adPricesArr;
        this.adDownPaymentsArr = adDownPaymentsArr;
        this.adBestLeaseRentalsArr = adBestLeaseRentalsArr;
        this.adDatesArr = adDatesArr;
        this.adImagesArr = adImagesArr;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.advertisement_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(context).asBitmap().load(adImagesArr.get(position)).into(holder.adImage);

        holder.adTitle.setText(adTitlesArr.get(position));
        holder.adPrice.setText(adPricesArr.get(position));
        holder.adDownPayment.setText(adDownPaymentsArr.get(position));
        holder.adBestLeaseRental.setText(adBestLeaseRentalsArr.get(position));
        holder.adDate.setText(adDatesArr.get(position));

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, adTitlesArr.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return adTitlesArr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

            RelativeLayout relativeLayout;
            ConstraintLayout constraintLayout;
            TextView adTitle;
            TextView adPrice;
            TextView adDownPayment;
            TextView adDownPaymentText;
            TextView adBestLeaseRental;
            TextView adBestLeaseRentalText;
            TextView adDate;
            ImageView adImage;


          public ViewHolder(@NonNull View itemView) {
             super(itemView);
             relativeLayout = itemView.findViewById(R.id.relative_layout);
             constraintLayout = itemView.findViewById(R.id.constraint_layout);
             //rectangle_View = itemView.findViewById(R.id.rectangle_2);
              adTitle = itemView.findViewById(R.id.ad_title);
              adPrice = itemView.findViewById(R.id.ad_price);
              adDownPayment = itemView.findViewById(R.id.ad_down_payment);
              adDownPaymentText = itemView.findViewById(R.id.ad_down_payment_text);
              adBestLeaseRental = itemView.findViewById(R.id.ad_best_lease_rental);
              adBestLeaseRentalText = itemView.findViewById(R.id.ad_best_lease_rental_text);
              adDate = itemView.findViewById(R.id.ad_date);
              adImage = itemView.findViewById(R.id.imageView_ad_image);
              
         }
     }
}
