package com.theaverageguy.mowiz.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.theaverageguy.mowiz.R;
import com.theaverageguy.mowiz.model.dataModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class EMAdapter extends FirebaseRecyclerAdapter<
        dataModel, EMAdapter.myViewholder> {

    public EMAdapter(
            @NonNull FirebaseRecyclerOptions<dataModel> options) {
        super(options);
    }

    @Override
    protected void
    onBindViewHolder(@NonNull myViewholder holder,
                     int position, @NonNull dataModel model) {
    }

    @NonNull
    @Override
    public myViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType) {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.em_layout, parent, false);
        return new myViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class myViewholder
            extends RecyclerView.ViewHolder {
        CircleImageView imageView;

        public myViewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}