package com.example.delphirestraunt.ui.postSystem;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class LaySeparator {
    List<LayParent> clasterList = new ArrayList<>();
    public LaySeparator(int step){
        DatabaseReference postRef = FirebaseDatabase.getInstance().getReference("posts");

    }
    public void separate(){

    }
}
