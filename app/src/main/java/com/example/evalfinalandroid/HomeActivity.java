package com.example.evalfinalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class HomeActivity extends AppCompatActivity {

    public Toolbar toolbar1;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);


                // Initialize the Mobile Ads SDK
        MobileAds.initialize(this, getString(R.string.admob_app_id));
                // Find Banner ad
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
                // Display Banner ad
        mAdView.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.divisa:
                Intent irDivisa = new Intent(this, DivisaActivity.class);
                startActivity(irDivisa);
                break;
            case R.id.multa:
                Intent irMulta = new Intent(this, MultaActivity.class);
                startActivity(irMulta);
                break;
            case R.id.seguro:
                Intent irSeguro = new Intent(this, SeguroActivity.class);
                startActivity(irSeguro);
                break;
            case R.id.close:
                finishAffinity();
        }
        return false;
    }
}