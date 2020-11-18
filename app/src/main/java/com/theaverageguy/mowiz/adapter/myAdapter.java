package com.theaverageguy.mowiz.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;
import com.theaverageguy.mowiz.R;
import com.theaverageguy.mowiz.activity.detailActivity;
import com.theaverageguy.mowiz.model.dataModel;

import static com.theaverageguy.mowiz.database.dataBaseRefs.baseURL;

public class myAdapter extends FirebaseRecyclerAdapter<
        dataModel, myAdapter.myViewholder> {

    public myAdapter(
            @NonNull FirebaseRecyclerOptions<dataModel> options) {
        super(options);
    }

    @Override
    protected void
    onBindViewHolder(@NonNull myViewholder holder,
                     int position, @NonNull dataModel model) {

        Picasso.get().load(baseURL + model.getPortrait()).placeholder(R.drawable.movie).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), detailActivity.class);
                i.putExtra("description", model.getDescription());
                i.putExtra("landscape", model.getLandscape());
                i.putExtra("name", model.getName());
                i.putExtra("portrait", model.getPortrait());
                i.putExtra("url", model.getUrl());
                v.getContext().startActivity(i);
            }
        });

    }

    @NonNull
    @Override
    public myViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType) {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_layout, parent, false);
        return new myAdapter.myViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class myViewholder
            extends RecyclerView.ViewHolder {
        ImageView imageView;

        public myViewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}