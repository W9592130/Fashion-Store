package com.example.fashionstore;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.Image;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class FsMain extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    public TextView loc;
    private final LocationListener locationListener = new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {
            loc = findViewById(R.id.loci);
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            // Convert location into address
            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            List<Address> addresses;
            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
            try {
                addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                String address = addresses.get(0).getAddressLine(0);
                loc.setText(address);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView men = findViewById(R.id.men);
        men.setOnClickListener(task->{
            Intent intent = new Intent(this, FsMen.class);
            startActivity(intent);
        });
        ImageView women = findViewById(R.id.women);
        women.setOnClickListener(task->{
            Intent intent = new Intent(this, FsWomen.class);
            startActivity(intent);
        });
        ImageView drawable = findViewById(R.id.imageView);
        drawable.setOnClickListener(task->{
            Intent intent = new Intent(this, FsDrawable.class);
            startActivity(intent);
        });
        ImageView cart = findViewById(R.id.imageView4);
        cart.setOnClickListener(task->{
            Intent intent = new Intent(this, Products.class);
            startActivity(intent);
        });
        ImageView prof = findViewById(R.id.imageView13);
        prof.setOnClickListener(task->{
            Intent intent = new Intent(this, FsProfile.class);
            startActivity(intent);
        });


 }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser() == null){
            finish();
            Intent intent = new Intent(this, FsLogin.class);
            startActivity(intent);
        }
        loc = findViewById(R.id.loci);
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Please enable the location permision!", Toast.LENGTH_SHORT).show();
            return;
        }
// Request location updates
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

    }
}
