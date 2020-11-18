package com.theaverageguy.mowiz.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.theaverageguy.mowiz.R;
import com.theaverageguy.mowiz.adapter.EMAdapter;
import com.theaverageguy.mowiz.adapter.myAdapter;
import com.theaverageguy.mowiz.model.dataModel;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.theaverageguy.mowiz.database.dataBaseRefs.ALL;
import static com.theaverageguy.mowiz.database.dataBaseRefs.ExploreMore;
import static com.theaverageguy.mowiz.database.dataBaseRefs.MoviesYouMayLike;
import static com.theaverageguy.mowiz.database.dataBaseRefs.RecentlyAdded;

public class Home extends AppCompatActivity {
    @BindView(R.id.MUML)
    RecyclerView MUMLRecycler;
    @BindView(R.id.RA)
    RecyclerView RARecycler;
    @BindView(R.id.EM)
    RecyclerView EMRecycler;
    @BindView(R.id.ALL)
    RecyclerView ALLRecycler;

    myAdapter MUMLAdapter;
    myAdapter RAAdapter;
    EMAdapter EMAdapter;
    myAdapter ALLAdapter;

    FirebaseRecyclerOptions<dataModel> MYULOptions;
    FirebaseRecyclerOptions<dataModel> ALLOptions;
    FirebaseRecyclerOptions<dataModel> RAOptions;
    FirebaseRecyclerOptions<dataModel> EMOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        myLayoutManager();
        myQueries();
        myAdapters();

    }

    private void myAdapters() {
        MUMLAdapter = new myAdapter(MYULOptions);
        ALLAdapter = new myAdapter(ALLOptions);
        EMAdapter = new EMAdapter(EMOptions);
        RAAdapter = new myAdapter(RAOptions);

        MUMLRecycler.setAdapter(MUMLAdapter);
        ALLRecycler.setAdapter(ALLAdapter);
        EMRecycler.setAdapter(EMAdapter);
        RARecycler.setAdapter(RAAdapter);
    }

    private void myQueries() {
        MYULOptions = new FirebaseRecyclerOptions.Builder<dataModel>()
                .setQuery(MoviesYouMayLike, dataModel.class)
                .build();
        ALLOptions = new FirebaseRecyclerOptions.Builder<dataModel>()
                .setQuery(ALL, dataModel.class)
                .build();

        RAOptions = new FirebaseRecyclerOptions.Builder<dataModel>()
                .setQuery(RecentlyAdded, dataModel.class)
                .build();
        EMOptions = new FirebaseRecyclerOptions.Builder<dataModel>()
                .setQuery(ExploreMore, dataModel.class)
                .build();

    }

    private void myLayoutManager() {
        LinearLayoutManager MUMLManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        LinearLayoutManager ALLManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        LinearLayoutManager EMManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        LinearLayoutManager RAManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);

        MUMLRecycler.setLayoutManager(MUMLManager);
        ALLRecycler.setLayoutManager(ALLManager);
        EMRecycler.setLayoutManager(EMManager);
        RARecycler.setLayoutManager(RAManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MUMLAdapter.startListening();
        RAAdapter.startListening();
        EMAdapter.startListening();
        ALLAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        MUMLAdapter.stopListening();
        RAAdapter.stopListening();
        EMAdapter.stopListening();
        ALLAdapter.stopListening();
    }
}