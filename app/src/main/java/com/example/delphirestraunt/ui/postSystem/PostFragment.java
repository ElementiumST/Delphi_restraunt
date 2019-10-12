package com.example.delphirestraunt.ui.postSystem;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.delphirestraunt.MainActivity;
import com.example.delphirestraunt.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

// Исходный класс фрагмента поста

public class PostFragment extends Fragment {
    String path;
    View root;
    public PostFragment(String path) {
        this.path = path;
    }

    @Nullable
    @Override
    // В конструкторе принимается путь к посту в базе данных
    //
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_post, container, false);
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(path);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                TextView tv = root.findViewById(R.id.post_text);
                String title = dataSnapshot.child("title").getValue().toString();

                String refPath = dataSnapshot.child("image").getValue().toString();
                StorageReference storageReference = FirebaseStorage.getInstance().getReference(refPath);
                storageReference.getBytes(MainActivity.IMAGE_SIZE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        ImageView iv = root.findViewById(R.id.post_image);
                        iv.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));

                    }
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return root;
    }
}
