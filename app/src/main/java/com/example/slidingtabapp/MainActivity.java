package com.example.slidingtabapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 pager;
    private SlideAdapater adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager2)findViewById(R.id.pager);
        adapter = new SlideAdapater(this);
        pager.setAdapter(adapter);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position){
                if(position == 0) tab.setText("Breakfast");
                else tab.setText("Lunch");
            }
        }).attach();
    }

    private class SlideAdapater extends FragmentStateAdapter {
        public SlideAdapater(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if(position == 0) return new BreakfastFragment();
            else return new LunchFragment();
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }
}