+++++++++++++++++++++++AndroidManifest.xml++++++++++++++++++++++++++++++++++++++++++++++++++

    <uses-permission-sdk-23 android:name="android.permission.ACCESS_COARSE_LOCATION"/>
    <uses-permission-sdk-23 android:name="android.permission.ACCESS_FINE_LOCATION"/>
    <uses-permission-sdk-23 android:name="android.permission.INTERNET"/>
	
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



package ch.nicolassauter.adress_test;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity implements LocationListener {

    // Fields
    private LocationManager locationManager;
    private TextView textView1;
    private Geocoder gc = new Geocoder(this);
    private List<Address> addressList = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

    }

    private void registrieren() {
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        berechtigungAbfragen();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Deregistrieren
        locationManager.removeUpdates(this);
    }

//
    private StringBuilder altitude = new StringBuilder();
    private StringBuilder address1 = new StringBuilder();
    private StringBuilder address2 = new StringBuilder();
    private StringBuilder address3 = new StringBuilder();
    private StringBuilder address4 = new StringBuilder();
    private StringBuilder adminArea = new StringBuilder();

    @Override
    public void onLocationChanged(Location location) {



        try {
            addressList = gc.getFromLocation(location.getLatitude(), location.getLongitude(), 4);
        } catch (IOException e) {
            addressList = null;
        }

        address1.append("null");
        address2.append("null");
        address3.append("null");
        address4.append("null");
        adminArea.append("null");

        if (addressList != null) {
            deleteStr();
            address1.append(addressList.get(0).getAddressLine(0));
            address2.append(addressList.get(1).getAddressLine(0));
            address3.append(addressList.get(2).getAddressLine(0));
            address4.append(addressList.get(3).getAddressLine(0));
            adminArea.append(addressList.get(0).getAdminArea());

        }

        altitude.append(location.getAltitude());

        textView1.setText(altitude + "\n" + address1 + "\n" + address2 + "\n" + address3 + "\n" + address4 + "\n" + adminArea );

        deleteStr();
    }

    private void deleteStr() {
        altitude.delete(0, altitude.length());
        address1.delete(0, address1.length());
        address2.delete(0, address2.length());
        address3.delete(0, address3.length());
        address4.delete(0, address4.length());
        adminArea.delete(0, adminArea.length());
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


    private void berechtigungAbfragen() {
        //Abfragen Berechtigung
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            //request authorization dialog (Asynchronous!!!)
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_NETWORK_STATE}
                    , 1);
        } else {
            // Permission has already been granted
            registrieren();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    registrieren();

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }


}
