package com.example.a12345;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;


public class Shelves extends AppCompatActivity {

    FrameLayout frameLayout;
    TabLayout tabLayout;



    // Added because on somehow when clicking back it would just pop fragments from the stack
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        finish(); // Close the current activity if there are no fragments in the back stack
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelves);

        frameLayout = findViewById(R.id.fl1);
        tabLayout = findViewById(R.id.tabl1);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl1, new FirstFragment())
                .addToBackStack(null)
                .commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                // Create a new transaction each time a tab is selected
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                Fragment fragment = null;
                switch(tab.getPosition()){
                    case 0:
                        fragment = new FirstFragment();
                        // Set custom animations
                        transaction.setCustomAnimations(
                                R.anim.slide_in_left,
                                R.anim.slide_out_right
                        );
                        break;
                    case 1:
                        fragment = new SecondFragment();
                        // Set custom animations
                        transaction.setCustomAnimations(
                                R.anim.slide_in_right,
                                R.anim.slide_out_left
                        );
                        break;
                }

                // Replace the fragment
                transaction.replace(R.id.fl1, fragment)
                        .addToBackStack(null) // You can add to back stack if needed
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}