package com.example.foodapp.Activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityUserBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class UserActivity extends BaseActivity {
    
    ActivityUserBinding binding;
    private Uri selectedImageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        initProfile();
        updateProfile();
    }

    private void updateProfile() {

        binding.userUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UserActivity.this);
                builder.setTitle("Cập nhật thông tin");

                EditText displayNameEditText = new EditText(UserActivity.this);
                displayNameEditText.setHint("Nhập tên");
                builder.setView(displayNameEditText);

                builder.setPositiveButton("Choose Profile Picture", (dialog, which) -> {


                });

                // Thêm nút cập nhật thông tin
                builder.setNegativeButton("Update", (dialog, which) -> {
                    String newDisplayName = displayNameEditText.getText().toString();

                    StorageReference myRef = storage.getReference();
                    StorageReference profileImageRef = myRef.child("profile_images/" + mAuth.getCurrentUser().getUid() + ".jpg");

                    profileImageRef.putFile(selectedImageUri)
                            .addOnSuccessListener(taskSnapshot -> {
                                // Lấy URL của ảnh vừa tải lên
                                profileImageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                                    Toast.makeText(UserActivity.this, "Up ảnh thành công", Toast.LENGTH_SHORT).show();
                                });
                            })
                            .addOnFailureListener(exception -> {
                                // Xử lý lỗi khi tải ảnh lên
                                // ...
                            });

                    // Kiểm tra xem người dùng đã nhập tên mới hay chưa
                    if (!newDisplayName.isEmpty()) {
                        // Tiếp theo, bạn có thể tải ảnh lên Firebase Storage và sau đó cập nhật thông tin người dùng
                        if (selectedImageUri != null) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(newDisplayName)
                                    .setPhotoUri(selectedImageUri)
                                    .build();
                            user.updateProfile(profileUpdates)
                                    .addOnCompleteListener(task -> {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(UserActivity.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(UserActivity.this, "Failed to update profile", Toast.LENGTH_SHORT).show();
                                        }
                                        finish();
                                    });
                        }
                    } else {
                        // Hiển thị thông báo cho người dùng rằng họ cần nhập tên mới
                        // Điều này phụ thuộc vào yêu cầu của ứng dụng của bạn
                    }
                });

                builder.show();
            }
        });
    }




    private void initProfile() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String displayName = currentUser.getDisplayName();
        Uri photoUrl = currentUser.getPhotoUrl();


        if (displayName != null && !displayName.isEmpty()) {
            binding.userNameTxt.setText(displayName);
        } else {
            binding.userNameTxt.setText("User");
        }

        if (photoUrl != null) {
            Glide.with(this).load(photoUrl).into(binding.userImg);
        } else {
            binding.userImg.setImageResource(R.drawable.facebook);
        }

        binding.userBackBtn.setOnClickListener(view -> finish());
    }
}