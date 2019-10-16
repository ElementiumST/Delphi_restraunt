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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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
        @SuppressLint("CutPasteId") final TextView typeFilterView = root.findViewById(R.id.filter_type_value);
        typeFilterView.setText(parent.getChangeTypeFilter());
        @SuppressLint("CutPasteId") final TextView ingFilterView = root.findViewById(R.id.filter_ing_value);
        ingFilterView.setText(parent.getChangeIngFilter());
        @SuppressLint("CutPasteId") final TextView timeFilterView = root.findViewById(R.id.filter_time_value);
        timeFilterView.setText(parent.getChangeTimeFilter());

        View filterTypeButton = root.findViewById(R.id.filter_type_btn);
        filterTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.changeStart("type");
            }
        });
        View filterIngButton = root.findViewById(R.id.filter_ing_btn);
        View filterTimeButton = root.findViewById(R.id.filter_time_btn);

        Button filterCancelButton = root.findViewById(R.id.filter_cancel_btn);
        filterCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
        ConstraintLayout layout = parent.root.findViewById(R.id.filter_fragment_lay);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
        Button filterSuccessButton = root.findViewById(R.id.filter_succes_btn);
        filterSuccessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.successFilters(typeFilterView.getText().toString(), ingFilterView.getText().toString(), timeFilterView.getText().toString());
                close();
            }
        });
        return root;
    }

    public void close(){
        FragmentTransaction ft = parent.getParent().getFragmentManager().beginTransaction();
        ft.remove(parent);
        ft.commit();
    }
    public View getRoot() {
        return root;
    }
}
