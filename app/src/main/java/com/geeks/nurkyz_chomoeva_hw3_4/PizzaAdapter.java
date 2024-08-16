package com.geeks.nurkyz_chomoeva_hw3_4;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geeks.nurkyz_chomoeva_hw3_4.databinding.PizzaItemBinding;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaViewHolder> {

    private ArrayList<PizzaModel> pizza;
    OnItemClick onItemClick;

    public PizzaAdapter(ArrayList<PizzaModel> pizza, OnItemClick onItemClick) {
        this.pizza = pizza;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PizzaViewHolder(PizzaItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(pizza.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pizza.size();
    }
}

class PizzaViewHolder extends RecyclerView.ViewHolder {

    PizzaItemBinding binding;

    public PizzaViewHolder(@NonNull PizzaItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    public void onBind(PizzaModel pizzaModel) {
        binding.tvName.setText(pizzaModel.name);
        binding.tvDesc.setText(pizzaModel.desc);
        Glide.with(binding.imgPizza).load(pizzaModel.image).into(binding.imgPizza);
    }
}