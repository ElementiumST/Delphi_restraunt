package com.example.delphirestraunt.ui.postSystem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class LayParent extends Fragment {
    List<PostFragment> postFragments = new ArrayList<>();
    View root;
    public void loadContent(List<String> pathList){
        for(String path: pathList){
            PostFragment pf = new PostFragment(path);
            postFragments.add(pf);
        }


    }



}
