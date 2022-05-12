package com.seu.cupsapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private ArrayList<CupsProduct> cupProduct;
    private ManagementCart managementCart;


    public CartAdapter(ArrayList<CupsProduct> cupProduct, Context context) {
        this.cupProduct = cupProduct;
        this.managementCart = new ManagementCart(context);
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);

        return new CartViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
    holder.price.setText(cupProduct.get(position).getCupPrice());
    holder.name.setText(cupProduct.get(position).getCupName());

        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(cupProduct.get(position).getCupImg().toString()
                , "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.imgCrt);
    }

    @Override
    public int getItemCount() {
        return cupProduct.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        TextView price,name;
        ImageView imgCrt;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.price);
            imgCrt =itemView.findViewById(R.id.imageViewCart);
            name= itemView.findViewById(R.id.priceName);

        }
    }
}
