package com.example.delphirestraunt.ui.menu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.delphirestraunt.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FiltersFragment extends Fragment {
    private MainFilterFragment child;
    private MenuFragment parent;
    private Filters filters;
    private String changeTypeFilter;
    private String changeIngFilter;
    private String changeTimeFilter;
    View root;
    public FiltersFragment(MenuFragment parent, String changeTypeFilter, String changeIngFilter, String changeTimeFilter){
        filters = new Filters();
        this.parent = parent;
        this.changeIngFilter = changeIngFilter;
        this.changeTimeFilter = changeTimeFilter;
        this.changeTypeFilter = changeTypeFilter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_filter, container, false);
        loadFilters("ingredients");
        loadFilters("time");
        loadFilters("type");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        child = new MainFilterFragment(this);

        ft.add(R.id.filter_socket, child);
        ft.commit();
        return root;
    }

    public void changeStart(String mode){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.hide(child);
        List<String> filterList = new ArrayList<>();
        String activeFilter = "";
        switch (mode) {
            case "type":
                activeFilter = changeTypeFilter;
                filterList = filters.getTYPE();
                break;
            case "ingredient":
                activeFilter = changeIngFilter;
                filterList = filters.getINGREDIENT();
                break;
            case "time":
                activeFilter = changeTimeFilter;
                filterList = filters.getTIME();
                break;
            default:

                Log.e("FilterError", "Wrong mode select");
                break;
        }
        ChangeFilterFragment changeFilterFragment = new ChangeFilterFragment(this, filterList, activeFilter);
        ft.add(R.id.filter_socket, changeFilterFragment);
        ft.remove(child);
        ft.commit();
    }

    public void successFilters(String changeTypeFilter, String changeIngFilter, String changeTimeFilter){
        if(changeIngFilter != null || filters.getINGREDIENT().contains(changeIngFilter))
            parent.setActiveIngFilter(changeIngFilter);
        if(changeTimeFilter != null && filters.getTIME().contains(changeTimeFilter))
            parent.setActiveTimeFilter(changeTimeFilter);
        if(changeTypeFilter != null && filters.getTYPE().contains(changeTypeFilter))
            parent.setActiveTypeFilter(changeTypeFilter);
    }


    public void loadFilters(String child) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("filters");
        ref.child(child).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> output = new ArrayList<>();
                for(DataSnapshot childSnap : dataSnapshot.getChildren()) {
                    String out = childSnap.getValue().toString();
                    output.add(out);
                }
                switch (child) {
                    case "type":
                        filters.setTYPE(output);
                        break;
                    case "ingredients":
                        filters.setINGREDIENT(output);
                        break;
                    case "time":
                        filters.setTIME(output);
                        break;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.i(child, databaseError.getMessage());
            }
        });
    }
    public void setFilters(Filters filters) {
        this.filters = filters;
    }
    public Filters getFilters() {
        return filters;
    }
    public String getChangeTypeFilter() {
        return changeTypeFilter;
    }
    public void setChangeTypeFilter(String changeTypeFilter) {
        this.changeTypeFilter = changeTypeFilter;
    }
    public String getChangeIngFilter() {
        return changeIngFilter;
    }
    public void setChangeIngFilter(String changeIngFilter) {
        this.changeIngFilter = changeIngFilter;
    }
    public String getChangeTimeFilter() {
        return changeTimeFilter;
    }
    public void setChangeTimeFilter(String changeTimeFilter) {
        this.changeTimeFilter = changeTimeFilter;
    }
    public MenuFragment getParent() {
        return parent;
    }
}
