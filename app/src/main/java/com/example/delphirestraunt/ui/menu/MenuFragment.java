package com.example.delphirestraunt.ui.menu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

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
import java.util.Collections;
import java.util.List;

public class MenuFragment extends Fragment {
    private MenuFragment menuFragment;
    private String activeTypeFilter;
    private String activeIngFilter;
    private String activeTimeFilter;
    View root;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        activeIngFilter = "Нет";
        activeTimeFilter = "Нет";
        activeTypeFilter = "Нет";
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        menuFragment = this;

        root = inflater.inflate(R.layout.fragment_menu, container, false);
        ImageButton filterBtn = root.findViewById(R.id.menu_filter_button);
        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                FiltersFragment ff = new FiltersFragment(menuFragment, activeTypeFilter, activeIngFilter, activeTimeFilter);
                fragmentTransaction.add(R.id.menu_socket, ff);
                fragmentTransaction.commit();
            }
        });
        return root;
    }


    @Override
    public void onResume() {

        super.onResume();
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