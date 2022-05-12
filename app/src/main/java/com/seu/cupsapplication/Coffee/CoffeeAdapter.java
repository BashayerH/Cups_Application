package com.seu.cupsapplication.Coffee;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seu.cupsapplication.CupsProduct;
import com.seu.cupsapplication.R;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder> {

    Context context;
    List<CupsProduct> cupsProductList;

    public CoffeeAdapter(Context context, List<CupsProduct> cupsProductList) {
        this.context = context;
        this.cupsProductList = cupsProductList;
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.coffee_item,parent,false);

        return new CoffeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) {
    holder.info.setText(cupsProductList.get(position).getCupName());
    holder.img_cof.setImageResource(cupsProductList.get(position).getCupImg());

    holder.img_cof.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(holder.itemView.getContext(),CoffeeDetails.class);
            intent.putExtra("object", cupsProductList.get(position));
            holder.itemView.getContext().startActivity(intent);

        }
    });
    }

    @Override
    public int getItemCount() {
        return cupsProductList.size();
    }

    public static final class CoffeeViewHolder extends RecyclerView.ViewHolder{

        ImageView img_cof;
        TextView info;
        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);
            img_cof = itemView.findViewById(R.id.imageView_coffee);
            info= itemView.findViewById(R.id.info_coffee);
        }
    }
}
