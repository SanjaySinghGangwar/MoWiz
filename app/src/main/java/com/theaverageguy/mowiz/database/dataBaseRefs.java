package com.theaverageguy.mowiz.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class dataBaseRefs {

    public static DatabaseReference MoviesYouMayLike = FirebaseDatabase.getInstance().getReference().child("MUML");
    public static DatabaseReference RecentlyAdded = FirebaseDatabase.getInstance().getReference().child("RA");
    public static DatabaseReference ExploreMore = FirebaseDatabase.getInstance().getReference().child("EM");
    public static DatabaseReference ALL = FirebaseDatabase.getInstance().getReference().child("ALL");
    public static String baseURL = "https://drive.google.com/uc?export=download&id=";

}
