package com.example.gridviewwithcustomadapters;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridView);
        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(view -> {
            finish();
            System.exit(0);
        });

        String[] itemNames = {"Camera" , "Camera Roll" , "Featured" , "My Videos" , "Likes" , "Watch Later" , "Stats" , "Subscriptions" , "Help" };
        int[] itemIcons = {R.drawable.ic_camera, R.drawable.ic_camera_roll, R.drawable.ic_featured,
                R.drawable.ic_my_videos, R.drawable.ic_likes, R.drawable.ic_watch_later,
                R.drawable.ic_stats, R.drawable.ic_subscriptions, R.drawable.ic_help};

        GridAdapter adapter = new GridAdapter(this , itemNames , itemIcons);
        gridView.setAdapter(adapter);

        // Add click listener for grid items
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            // Pass selected item name and image to the new activity
            Intent intent = new Intent(MainActivity.this, ItemDetailActivity.class);
            intent.putExtra("itemName", itemNames[position]);  // Pass item name
            intent.putExtra("itemIcon", itemIcons[position]);  // Pass item icon resource ID
            startActivity(intent);
        });

    }
}