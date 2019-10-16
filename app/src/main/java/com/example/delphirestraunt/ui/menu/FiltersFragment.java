package com.example.delphirestraunt.ui.menu;

import android.os.Bundle;
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

public class FiltersFragment extends Fragment {
    private MenuFragment parent;
    private String changeTypeFilter;
    private String changeIngFilter;
    private String changeTimeFilter;
    private Filters filters;
    View root;
    public FiltersFragment(MenuFragment parent, Filters filters, String changeTypeFilter, String changeIngFilter, String changeTimeFilter){
        this.parent = parent;
        this.filters = filters;
        this.changeIngFilter = changeIngFilter;
        this.changeTimeFilter = changeTimeFilter;
        this.changeTypeFilter = changeTypeFilter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_filter, container, false);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        MainFilterFragment mf = new MainFilterFragment(this);
        ft.add(R.id.filter_socket, mf);
        ft.commit();
        return root;
    }
    public void loadFilterChange(String mode) {

        switch (mode){
            case "type":
                new ChangeFilterFragment(filters.getTYPE(), changeTypeFilter);
                break;
            case "ing":
                new ChangeFilterFragment(filters.getINGREDIENT(), changeIngFilter);
                break;
            case "time":
                new ChangeFilterFragment(filters.getTIME(), changeTimeFilter);
                break;
        }
    }

    public void changeAnimation(View from, View to){
        Animation animationFrom = AnimationUtils.loadAnimation(getContext(), R.anim.animation_hide);
        Animation animationTo = AnimationUtils.loadAnimation(getContext(), R.anim.animation_show);
        from.startAnimation(animationFrom);
        to.startAnimation(animationTo);

    }
    public void succesFilters(String changeTypeFilter, String changeIngFilter, String changeTimeFilter){
        if(changeIngFilter != null && filters.getINGREDIENT().contains(changeIngFilter))
            parent.setActiveIngFilter(changeIngFilter);
        if(changeTimeFilter != null && filters.getTIME().contains(changeTimeFilter))
            parent.setActiveTimeFilter(changeTimeFilter);
        if(changeTypeFilter != null &&filters.getTYPE().contains(changeTypeFilter))
            parent.setActiveTypeFilter(changeTypeFilter);
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
    public Filters getFilters() {
        return filters;
    }
    public MenuFragment getParent() {
        return parent;
    }
}
