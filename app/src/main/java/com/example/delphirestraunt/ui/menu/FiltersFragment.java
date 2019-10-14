package com.example.delphirestraunt.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.delphirestraunt.R;

public class FiltersFragment extends Fragment {

    Filters filters;
    View root;
    public FiltersFragment(Filters filters){
        this.filters = filters;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_filter, container, false);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        MainFilterFragment mf = new MainFilterFragment()
        ft.add(R.id.filter_socket, );
        return root;
    }
}
