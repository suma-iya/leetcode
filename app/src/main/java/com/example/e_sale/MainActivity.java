package com.example.e_sale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        drawerLayout = findViewById(R.id.my_drawer);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        navController = Navigation.findNavController(this, R.id.main_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

        // Set the navigation item selected listener
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(toggle.onOptionsItemSelected(item)) return true;

        return super.onOptionsItemSelected(item);
    }


    @SuppressLint("NonConstantResourceId")

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.pdf) {
            Toast.makeText(this, "pdf", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://learntocodewith.me/posts/programming-books/"));
            startActivity(i);
        }
        else if (menuItem.getItemId() == R.id.cmp) {
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.programiz.com/python-programming/online-compiler"));
            startActivity(i);

        }else if (menuItem.getItemId() == R.id.home) {
            // Code to handle the "About" item selection
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }

        else if (menuItem.getItemId() == R.id.logout) {
            Toast.makeText(this, "Exited App Successfully", Toast.LENGTH_SHORT).show();
            finishAffinity();
            return true;
        }
        return true;
    }
}