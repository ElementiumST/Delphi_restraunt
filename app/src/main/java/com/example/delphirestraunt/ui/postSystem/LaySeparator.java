package com.example.delphirestraunt.ui.postSystem;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LaySeparator {
    List<LayParent> clasterList = new ArrayList<>();
    List<DataSnapshot> snapshotList = new ArrayList<>();
    int step;
    public LaySeparator(int step){
        this.step = step;
        DatabaseReference postRef = FirebaseDatabase.getInstance().getReference("posts");
        postRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot childSnapshot : dataSnapshot.getChildren()){
                    snapshotList.add(childSnapshot);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void separate(int id, FragmentManager fragmentManager) {
        int i = 0;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        int skip = 0;
        for(DataSnapshot dataSnapshot : snapshotList){
            if(skip != 0){
                skip -= 1;
                continue;
            }

            int tl0 = dataSnapshot.child("title").getValue().toString().length();
            //два следующих блока нужны для завершения подгрузки постов
            //блок, который выполняется если осталось 2 поста
            if(snapshotList.indexOf(dataSnapshot) == snapshotList.size()-2){
                //динамическое распределение по формам согластно размеру
                int tl1 = snapshotList.get(i+1).child("title").getValue().toString().length();
                if(tl0 > tl1+7)
                    fragmentTransaction.add(id, new Lay2to1Fragment(
                            dataSnapshot.child("title").getValue().toString(),
                            snapshotList.get(i+1).child("title").getValue().toString()
                    ));
                else if(tl0 < tl1+7)
                    fragmentTransaction.add(id, new Lay1to2Fragment(
                            dataSnapshot.child("title").getValue().toString(),
                            snapshotList.get(i+1).child("title").getValue().toString()
                    ));
                else
                    fragmentTransaction.add(id, new Lay1to1Fragment(
                            dataSnapshot.child("title").getValue().toString(),
                            snapshotList.get(i+1).child("title").getValue().toString()
                    ));
                break;
            }
            //блок, который выполняется если остался 1 пост
            if(snapshotList.indexOf(dataSnapshot) == snapshotList.size()-1){
                fragmentTransaction.add(id, new Lay1Fragment(dataSnapshot.getKey()));
                break;
            }
            int titleLength = dataSnapshot.child("title").getValue().toString().length();
            i++;

        }

    }
}
