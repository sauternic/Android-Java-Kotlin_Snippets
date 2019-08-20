//<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
//<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />


    private boolean isNetworkConnected() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;

    }