package com.example.delphirestraunt.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.delphirestraunt.R;

import java.util.List;

public class ChangeFilterFragment extends Fragment {
    private List<String> filterList;
    private String activeFilter;
    View root;
    public ChangeFilterFragment(List<String> filterList, String activeFilter) {
    this.filterList = filterList;
    if(filterList.contains(activeFilter))
        this.activeFilter=activeFilter;
    else activeFilter = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_filter_change, container, false);
        LinearLayout ll = root.findViewById(R.id.filter_change_lay);
        for(String s : filterList){
            boolean b = s.contains(activeFilter);
            ButtonFragment bf = new ButtonFragment(s, b);
        }
        return root;
    }
}
