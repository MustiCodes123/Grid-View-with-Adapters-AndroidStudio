package com.example.gridviewwithcustomadapters;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        // Get the passed data (item name and icon)
        String itemName = getIntent().getStringExtra("itemName");
        int itemIcon = getIntent().getIntExtra("itemIcon", 0);

        // Find views in the layout
        ImageView iconView = findViewById(R.id.iconDetail);
        TextView nameView = findViewById(R.id.nameDetail);

        // Set the item's image and name
        iconView.setImageResource(itemIcon);
        nameView.setText(itemName);

        // Handle back button functionality (optional)
        findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());
    }
}
