package com.example.delphirestraunt.ui.menu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.delphirestraunt.R;

import java.util.List;

public class ChangeFilterFragment extends Fragment {
    private List<String> filterList;
    private String mode;
    private String activeFilter;
    FiltersFragment parent;
    View root;
    public ChangeFilterFragment(FiltersFragment parent, List<String> filterList, String activeFilter, String mode) {
        this.parent = parent;
        this.filterList = filterList;
        this.mode = mode;
        this.activeFilter = activeFilter;
        }
    public void endWithOut(String out){
        switch (mode)
    }
    public void endWithCancel(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_filter_change, container, false);
        LinearLayout ll = root.findViewById(R.id.filter_change_lay);
        Log.i("value", activeFilter);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        for(String s : filterList){
            Log.i("value", s);
            boolean b = s.contains(activeFilter);
            ButtonFragment bf = new ButtonFragment(this, s, b);
            fragmentTransaction.add(R.id.filter_change_lay, bf);
        }
        ButtonFragment bf = new ButtonFragment(this, "назад", false);

        fragmentTransaction.add(R.id.filter_change_lay, bf);
        fragmentTransaction.commit();

        return root;
    }
}
