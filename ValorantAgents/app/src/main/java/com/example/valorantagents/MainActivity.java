package com.example.valorantagents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.core.view.GravityCompat;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private Toolbar toolbar;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DrawerLayout, Toolbar ve NavigationView'in bağlanması
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer);

        // ActionBarDrawerToggle ile DrawerLayout'ın açılıp kapanmasını sağlamak
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 0, 0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        toolbar.setTitle("Ajanlar");


        View view = navigationView.inflateHeaderView(R.layout.ajanlar_tasarim);

        // NavHostFragment ve NavigationUI kullanımı
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        if (navHostFragment != null) {
            NavigationUI.setupWithNavController(navigationView, navHostFragment.getNavController());
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onBackPressed() {
        // Drawer açıldığında geri tuşuna basıldığında drawer'ı kapat
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
