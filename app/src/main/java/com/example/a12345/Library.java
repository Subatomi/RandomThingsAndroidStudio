package com.example.a12345;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Library extends AppCompatActivity {

    LinearLayout btnFilter, btnFormat, btnRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        btnFilter = findViewById(R.id.btnFilter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomDialog(R.layout.filter_layout);
            }
        });

        btnFormat = findViewById(R.id.btnFormat);
        btnFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomDialog(R.layout.format_layout);
//                Intent intent = new Intent(Library.this, Shelves.class);
//                startActivity(intent);
            }
        });

        btnRating = findViewById(R.id.btnRating);
        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomDialog(R.layout.rating_layout);
            }
        });


    }

    private void showBottomDialog(int layoutResourceId) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View bottomSheetView = getLayoutInflater().inflate(layoutResourceId, null);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        // Handle actions based on the inflated layout
        if(layoutResourceId == R.layout.filter_layout){
            createFunctionsInFilter(bottomSheetView);
        } else if (layoutResourceId == R.layout.format_layout) {
            createFunctionsInFormat(bottomSheetView);
        } else if (layoutResourceId == R.layout.rating_layout) {
            createFunctionsInRating(bottomSheetView);
        }
    }

    private void createFunctionsInFilter(View bottomSheetView) {
        // Add your code to handle actions for the filter layout here
        TextView textViewMM = bottomSheetView.findViewById(R.id.txtViewAllFormat);
        textViewMM.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                textViewMM.setText("SUPREME!");
            }
        });
    }

    private void createFunctionsInFormat(View bottomSheetView) {
        // Add your code to handle actions for the format layout here
    }

    private void createFunctionsInRating(View bottomSheetView) {
        // Add your code to handle actions for the rating layout here
    }
}