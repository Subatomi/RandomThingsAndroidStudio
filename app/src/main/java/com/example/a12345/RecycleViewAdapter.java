package com.example.a12345;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<Book> bookModels;

    public RecycleViewAdapter(Context context, ArrayList<Book> bookModels){
        this.context = context;
        this.bookModels = bookModels;
    }

    @NonNull
    @Override
    public RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This will inflate the layout;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_for_yourbooks, parent, false);
        return new RecycleViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.MyViewHolder holder, int position) {
        //assigning values to each rows in our recycle view
        // based on the position of the recycle view

        if(holder.imgView != null){
            holder.imgView.setBackgroundResource(bookModels.get(position).getImage());
        }
        if(holder.bookTitle != null){
            holder.bookTitle.setText(bookModels.get(position).getTitle());
        }
        if(holder.bookAuthor != null){
            holder.bookAuthor.setText(bookModels.get(position).getAuthor());
        }
        if(holder.bookRatings != null){
            holder.bookRatings.setText(bookModels.get(position).getRatings());
        }
        if(holder.bookPrice != null){
            holder.bookPrice.setText(bookModels.get(position).getPrice());
        }






        // Set onClickListener to the root view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                holder.bookTitle.setText("You Clicked");
            }
        });
    }

    @Override
    public int getItemCount() {
        // define the number of item you want to display
        return bookModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        //pretty much Oncreate
        ImageView imgView;
        TextView bookTitle, bookAuthor, bookRatings, bookPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.imgBook);
            bookTitle = itemView.findViewById(R.id.txtTitle);
            bookAuthor = itemView.findViewById(R.id.txtAuthor);
            bookRatings = itemView.findViewById(R.id.txtRating);
            bookPrice = itemView.findViewById(R.id.txtPrice);

        }
    }
}
