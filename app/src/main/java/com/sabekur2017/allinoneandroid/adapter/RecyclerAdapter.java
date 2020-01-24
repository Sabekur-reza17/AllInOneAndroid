package com.sabekur2017.allinoneandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sabekur2017.allinoneandroid.R;
import com.sabekur2017.allinoneandroid.models.ItemModel;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyRecyclerViewHolder> {
    private Context context;
    ArrayList<ItemModel> arrayList;

    public RecyclerAdapter(Context context, ArrayList<ItemModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }




    @NonNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyRecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        holder.image.setImageResource(arrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyRecyclerViewHolder extends RecyclerView.ViewHolder{
         TextView name;
         ImageView image;
         public MyRecyclerViewHolder(@NonNull View itemView) {

             super(itemView);
             name = (TextView) itemView.findViewById(R.id.name);
             image = (ImageView) itemView.findViewById(R.id.image);
         }
     }
}
