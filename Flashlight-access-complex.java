**************************AndroidManifest.xml******************************

<uses-permission-sdk-23 android:name="android.permission.CAMERA"/>

***************************************************************************


***************************MainActivity.java*******************************

         On_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.READ_CONTACTS)
                        != PackageManager.PERMISSION_GRANTED) {
                    
					// Permission is not granted
					//request authorization dialog (Asynchronous!!!)
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            1);
                } else {
                    // Permission has already been granted
                    flashOn();
                }

            }
        });

		
		
	@Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    flashOn();
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
    void flashOn(){
        camera = Camera.open();
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
        camera.startPreview();
    }
	
**************************************************************************

//FLASH_MODE_OFF
//camera.stopPreview();
//camera.release();

very good explanation:
https://developer.android.com/training/permissions/requesting