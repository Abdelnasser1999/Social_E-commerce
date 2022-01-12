package com.nasser.ma99.social_e_commerce.Adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nasser.ma99.social_e_commerce.Model.campaignModel;
import com.nasser.ma99.social_e_commerce.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.MyViewHolder> {

    private Activity activity;
    private ArrayList<campaignModel> data;


    public CompanyAdapter(Activity activity, ArrayList<campaignModel> data) {

        this.activity = activity;
        this.data = data;
    }


    @NotNull
    @Override
    public CompanyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(activity).inflate(R.layout.company_item, parent, false);

        return new CompanyAdapter.MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CompanyAdapter.MyViewHolder holder, int position) {

        holder.imageView.setImageBitmap(getUserImage(data.get(position).getImagecomp()));
        holder.Logoview.setImageBitmap(getUserImage(data.get(position).getImagebrand()));


    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, Logoview;


        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_company);
            Logoview = itemView.findViewById(R.id.Logo_company);


        }

    }

    private Bitmap getUserImage(String encodedImage) {
        byte[] bytes = Base64.decode(encodedImage, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

    }
}