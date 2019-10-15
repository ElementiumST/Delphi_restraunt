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
    private String changetTypeFilter;
    private String changetIngFilter;
    private String changetTimeFilter;
    private Filters filters;
    View root;
    public FiltersFragment(Filters filters, String changetTypeFilter, String changetIngFilter, String changetTimeFilter){
        this.filters = filters;
        this.changetIngFilter= changetIngFilter;
        this.changetTimeFilter = changetTimeFilter;
        this.changetTypeFilter = changetTypeFilter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_filter, container, false);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        MainFilterFragment mf = new MainFilterFragment();
        ft.add(R.id.filter_socket, mf);
        mf.getRoot().findViewById(R.id.filter_succes_btn);
        return root;
    }

    public String getChangetTypeFilter() {
        return changetTypeFilter;
    }

    public void setChangetTypeFilter(String changetTypeFilter) {
        this.changetTypeFilter = changetTypeFilter;
    }

    public String getChangetIngFilter() {
        return changetIngFilter;
    }

    public void setChangetIngFilter(String changetIngFilter) {
        this.changetIngFilter = changetIngFilter;
    }

    public String getChangetTimeFilter() {
        return changetTimeFilter;
    }

    public void setChangetTimeFilter(String changetTimeFilter) {
        this.changetTimeFilter = changetTimeFilter;
    }

    public Filters getFilters() {
        return filters;
    }
}
