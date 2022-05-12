package com.seu.cupsapplication.Tea;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seu.cupsapplication.Coffee.CoffeeDetails;
import com.seu.cupsapplication.CupsProduct;
import com.seu.cupsapplication.R;

import java.util.List;

public class TeaAdapter extends RecyclerView.Adapter<TeaAdapter.TeaViewHolder> {
    Context context;
    List<CupsProduct> listTeaPrud;

    public TeaAdapter(Context context, List<CupsProduct> listTeaPrud) {
        this.context = context;
        this.listTeaPrud = listTeaPrud;
    }


    @NonNull
    @Override
    public TeaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.tea_item,parent,false);

        return new TeaViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull TeaViewHolder holder, int position) {
        holder.teaInfo.setText(listTeaPrud.get(position).getCupName());
        holder.teaImg.setImageResource(listTeaPrud.get(position).getCupImg());

        holder.teaImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentT = new Intent(holder.itemView.getContext(), TeaDetails.class);
                intentT.putExtra("object",  listTeaPrud.get(position));
                holder.itemView.getContext().startActivity(intentT);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listTeaPrud.size();
    }

    public static final class TeaViewHolder extends RecyclerView.ViewHolder{

        ImageView teaImg;
        TextView teaInfo;

        public TeaViewHolder(@NonNull View itemView) {
            super(itemView);
            teaImg = itemView.findViewById(R.id.imageView_tea);
            teaInfo = itemView.findViewById(R.id.info_tea);

        }
    }
}
