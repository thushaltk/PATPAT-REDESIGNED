package com.example.testapplication;

import android.content.Context;
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

public class FavRecyclerViewAdapter extends RecyclerView.Adapter<FavRecyclerViewAdapter.FavViewHolder> {

    private ArrayList<String> favTitlesArr = new ArrayList<>();
    private ArrayList<String> favPricesArr = new ArrayList<>();
    private ArrayList<String> favDownPaymentsArr = new ArrayList<>();
    private ArrayList<String> favBestLeaseRentalsArr = new ArrayList<>();
    private ArrayList<String> favDatesArr = new ArrayList<>();
    private ArrayList<String> favImagesArr = new ArrayList<>();
    private Context context;

    public FavRecyclerViewAdapter(ArrayList<String> favTitlesArr, ArrayList<String> favPricesArr, ArrayList<String> favDownPaymentsArr, ArrayList<String> favBestLeaseRentalsArr, ArrayList<String> favDatesArr, ArrayList<String> favImagesArr, Context context) {
        this.favTitlesArr = favTitlesArr;
        this.favPricesArr = favPricesArr;
        this.favDownPaymentsArr = favDownPaymentsArr;
        this.favBestLeaseRentalsArr = favBestLeaseRentalsArr;
        this.favDatesArr = favDatesArr;
        this.favImagesArr = favImagesArr;
        this.context = context;
    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_item, parent, false);
        FavViewHolder favViewHolder = new FavViewHolder(view);
        return favViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(favImagesArr.get(position)).into(holder.favImage);

        holder.favTitle.setText(favTitlesArr.get(position));
        holder.favPrice.setText(favPricesArr.get(position));
        holder.favDownPayment.setText(favDownPaymentsArr.get(position));
        holder.favBestLeaseRental.setText(favBestLeaseRentalsArr.get(position));
        holder.favDate.setText(favDatesArr.get(position));

        holder.relativeLayoutFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, favTitlesArr.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return favTitlesArr.size();
    }

    public class FavViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout relativeLayoutFav;
        ConstraintLayout constraintLayoutFav;
        TextView favTitle;
        TextView favPrice;
        TextView favDownPayment;
        TextView favDownPaymentText;
        TextView favBestLeaseRental;
        TextView favBestLeaseRentalText;
        TextView favDate;
        ImageView favImage;
        //ImageView deleteBin;
        //ImageView bookmark;

        public FavViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayoutFav = itemView.findViewById(R.id.relative_layout_fav);
            constraintLayoutFav = itemView.findViewById(R.id.constraint_layout_fav);
            favTitle = itemView.findViewById(R.id.fav_title);
            favPrice = itemView.findViewById(R.id.fav_price);
            favDownPayment = itemView.findViewById(R.id.fav_down_payment);
            favDownPaymentText = itemView.findViewById(R.id.fav_down_payment_text);
            favBestLeaseRental = itemView.findViewById(R.id.fav_best_lease_rental);
            favBestLeaseRentalText = itemView.findViewById(R.id.fav_best_lease_rental_text);
            favDate = itemView.findViewById(R.id.fav_date);
            favImage = itemView.findViewById(R.id.imageView_fav_image);
            //deleteBin = itemView.findViewById(R.id.delete_bin);
            //bookmark = itemView.findViewById(R.id.bookmark);
        }
    }
}
