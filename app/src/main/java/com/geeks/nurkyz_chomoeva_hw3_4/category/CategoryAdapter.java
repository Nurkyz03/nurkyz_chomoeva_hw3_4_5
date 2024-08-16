package com.geeks.nurkyz_chomoeva_hw3_4.category;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geeks.nurkyz_chomoeva_hw3_4.OnItemClick;
import com.geeks.nurkyz_chomoeva_hw3_4.databinding.CategoryItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private ArrayList<Category> categoryList;
    private OnItemClick onItemClick;

    public CategoryAdapter(ArrayList<Category> categoryList, OnItemClick onItemClick) {
        this.categoryList = categoryList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryItemBinding binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.onBind(categoryList.get(position));
        holder.itemView.setOnClickListener(v->{
            onItemClick.onClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}

class CategoryViewHolder extends RecyclerView.ViewHolder {
    private CategoryItemBinding binding;

    public CategoryViewHolder(CategoryItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(Category category) {
        binding.tvName.setText(category.getName());
        Glide.with(binding.imgCategory).load(category.getImg()).into(binding.imgCategory);
    }
}

