package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.ManagmentCart;
import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity {
    ActivityDetailBinding binding;
    private Foods object;
    private int num = 1;
    private ManagmentCart managmentCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));

        getIntentExtra();
        setVariable();
    }

    private void setVariable() {

        managmentCart = new ManagmentCart(this);
        binding.backDetailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Glide.with(DetailActivity.this)
                .load(object.getImagePath())
                .into(binding.detailImg);
        binding.priceDetailTxt.setText(object.getPrice()+"đ");
        binding.timeDetailTxt.setText(object.getTimeValue()+" phút");
        binding.desTxt.setText(object.getDescription());
        binding.rateTxt.setText(object.getStar()+" Đánh giá");
        binding.ratingBar.setRating((float) object.getStar());
        binding.totalTxt.setText((num * object.getPrice()+" đ"));
        binding.titleDetailTxt.setText(object.getTitle());

        binding.plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = num + 1;
                binding.numTxt.setText(num + " ");
                binding.totalTxt.setText((num * object.getPrice()) + "Vnđ");
            }
        });

        binding.minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num > 1){
                    num = num - 1;
                    binding.numTxt.setText(num + " ");
                    binding.totalTxt.setText((num * object.getPrice()) + "Vnđ");
                }
            }
        });

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(num);
                managmentCart.insertFood(object);
            }
        });
    }

    private void getIntentExtra() {
        object = (Foods) getIntent().getSerializableExtra("object");
    }
}