package com.example.myfirstproje;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstproje.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    List<String> tabNameList = Arrays.asList("Latest Movies", "Top Movies", "Favorites");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mainviewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle()));
        new TabLayoutMediator(binding.maintabLayout, binding.mainviewpager, (tab, position) -> tab.setText(tabNameList.get(position))).attach();

    }
}
