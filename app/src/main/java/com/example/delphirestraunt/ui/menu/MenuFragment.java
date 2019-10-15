package com.example.delphirestraunt.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.delphirestraunt.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuFragment extends Fragment {
    private Filters filters;
    private String activeTypeFilter;
    private String activeIngFilter;
    private String activeTimeFilter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadFilters();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_menu, container, false);
        return root;
    }
    public void loadFilters() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("filters");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> typeList = dataSnapshot.child("type").getChildren();
                filters.setTYPE(toList(typeList));
                Iterable<DataSnapshot> timeList = dataSnapshot.child("time").getChildren();
                filters.setTIME(toList(timeList));
                Iterable<DataSnapshot> ingredientsList = dataSnapshot.child("ingredients").getChildren();
                filters.setINGREDIENT(toList(ingredientsList));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public List<String> toList(Iterable<DataSnapshot> dataSnapshots) {
        List<String> output = new ArrayList<>();
        for(DataSnapshot dataSnapshot : dataSnapshots) {
            output.add(dataSnapshot.getValue().toString());
        }
        return output;
    }

    public String getActiveTypeFilter() {
        return activeTypeFilter;
    }

    public void setActiveTypeFilter(String activeTypeFilter) {
        this.activeTypeFilter = activeTypeFilter;
    }

    public String getActiveIngFilter() {
        return activeIngFilter;
    }

    public void setActiveIngFilter(String activeIngFilter) {
        this.activeIngFilter = activeIngFilter;
    }

    public String getActiveTimeFilter() {
        return activeTimeFilter;
    }

    public void setActiveTimeFilter(String activeTimeFilter) {
        this.activeTimeFilter = activeTimeFilter;
    }
}