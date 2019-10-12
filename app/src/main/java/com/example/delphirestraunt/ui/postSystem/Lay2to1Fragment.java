package com.example.delphirestraunt.ui.postSystem;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.delphirestraunt.R;

import java.util.ArrayList;
import java.util.List;

public class Lay2to1Fragment extends LayParent {
    public Lay2to1Fragment(String firstPostPath, String secondPostPath){
        List<String> list = new ArrayList<>();
        list.add(firstPostPath);
        list.add(secondPostPath);
        loadContent(list);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.post_2_to_1, container, false);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if(postFragments.size() > 1){
            Log.i("Post Creator", "create...");
            ft.add(R.id.p2t1_fragment_socket0, postFragments.get(0));
            ft.add(R.id.p2t1_fragment_socket1, postFragments.get(1));
        }
        return root;
    }
}
