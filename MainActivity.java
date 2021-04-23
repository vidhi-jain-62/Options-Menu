package com.example.options_menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayMap();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_order:
                displayToast(getString(R.string.action_order_message));
                return true;
            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                return true;
            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                return true;
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDonutOrder(View view) {
        showFoodOrder(getString(R.string.donut_order_message));
    }

    public void showIceCreamOrder(View view) {
        showFoodOrder(getString(R.string.ice_cream_order_message));
    }

    public void showFroyoOrder(View view) {
        showFoodOrder(getString(R.string.froyo_order_message));
    }

    public void showFoodOrder(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void displayMap() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        // Using the coordinates for Google headquarters.
        String data = getString(R.string.google_mtv_coord_zoom12);
        intent.setData(Uri.parse(data));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}