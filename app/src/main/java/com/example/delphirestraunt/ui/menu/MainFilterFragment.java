package com.example.delphirestraunt.ui.menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.delphirestraunt.R;

public class MainFilterFragment extends Fragment {
    private View root;
    private FiltersFragment parent;

    public MainFilterFragment(FiltersFragment parent){
        this.parent = parent;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_filter_main, container, false);
        @SuppressLint("CutPasteId")
        TextView typeFilterView = root.findViewById(R.id.filter_type_value);
        typeFilterView.setText(parent.getChangetTypeFilter());
        @SuppressLint("CutPasteId")
        TextView ingFilterView = root.findViewById(R.id.filter_time_value);
        ingFilterView.setText(parent.getChangetIngFilter());
        @SuppressLint("CutPasteId")
        TextView timeFilterView = root.findViewById(R.id.filter_time_value);
        timeFilterView.setText(parent.getChangetTimeFilter());

        View filterTypeButton = root.findViewById(R.id.filter_type_btn);

        View filterIngButton = root.findViewById(R.id.filter_ing_btn);
        View filterTimeButton = root.findViewById(R.id.filter_time_btn);

        return root;
    }

    public View getRoot() {
        return root;
    }
}
