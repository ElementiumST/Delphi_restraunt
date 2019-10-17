package com.example.delphirestraunt.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.delphirestraunt.R;

public class ButtonFragment extends Fragment {
    ChangeFilterFragment parent;
    private Button button;
    private String text;
    private boolean isActive;
    public ButtonFragment(ChangeFilterFragment parent, String text, boolean isActive){
        this.isActive = isActive;
        this.text = text;
        this.parent = parent;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_button, container, false);
        button = root.findViewById(R.id.button_main);
        button.setText(text);
        if(text.equals("назад"))
            button.setTextSize(18);
            if(isActive) {
            button.setPointerIcon(PointerIcon.load(getResources(), getResources().getIdentifier("ic_check_black_24dp", "drawble", "com.example.delphirestraunt")));
        }
        return root;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
