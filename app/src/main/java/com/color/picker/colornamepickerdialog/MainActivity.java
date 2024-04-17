package com.color.picker.colornamepickerdialog;

import static com.color.picker.colornamepicker.ColorNamePicker.ColorNamePickerDailog;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.color.picker.colornamepicker.listener.GetColorFromPallet;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    /*TextView textView;
    Button button;
    ImageView imageView;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.img);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorNamePickerDailog(MainActivity.this, new GetColorFromPallet() {
                    @Override
                    public void getColor(String colorName, String hex) {
                        textView.setText(colorName);
                        textView.append(" "+hex);
                        // Convert hex color string to Color object
                        int color = Color.parseColor(hex);

                        // Set the background color of the ImageView
                        imageView.setColorFilter(color);
                    }
                });
            }
        });

*/


    }
}