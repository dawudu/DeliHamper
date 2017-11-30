package com.example.manthole.delihamper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BottomSheets extends AppCompatActivity {

    Button mButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheets);

        View bottomSheet = findViewById(R.id.design_bottom_sheet);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                switch (newState) {

                    case BottomSheetBehavior.STATE_DRAGGING:
                        //Write your Logic here
                        Log.i("BottomSheetCallBack", "BottomSheetBehavior.STATE_DRAGGING");
                        break;

                    case BottomSheetBehavior.STATE_SETTLING:
                        //Write your Logic here
                        Log.i("BottomSheetCallBack", "BottomSheetBehavior.STATE_SETTLING");
                        break;

                    case BottomSheetBehavior.STATE_EXPANDED:
                        //Write your Logic here
                        Log.i("BottomSheetCallBack", "BottomSheetBehavior.STATE_EXPANDED");
                        break;

                    case BottomSheetBehavior.STATE_COLLAPSED:
                        //Write your Logic here
                        Log.i("BottomSheetCallBack", "BottomSheetBehavior.STATE_COLLAPSED");
                        break;


                    case BottomSheetBehavior.STATE_HIDDEN:
                        //Write your Logic here
                        Log.i("BottomSheetCallBack", "BottomSheetBehavior.STATE_HIDDEN");
                        break;


                }

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                Log.i("BottomSheetCallBack", "slideoffset:" + slideOffset);

            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {

                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                } else {

                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });
    }
}
