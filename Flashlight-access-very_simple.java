**************************AndroidManifest.xml******************************

<uses-permission-sdk-23 android:name="android.permission.CAMERA"/>

***************************************************************************


***************************MainActivity.java*******************************

import android.hardware.Camera;	
import android.Manifest;
import android.support.v4.app.ActivityCompat;

	
	
		try {
		    camera = Camera.open();
		    Camera.Parameters parameters = camera.getParameters();
		    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
		    camera.setParameters(parameters);
		    camera.startPreview();
		} catch (Exception e) {
		    //request authorization-dialog to user
		    ActivityCompat.requestPermissions(MainActivity.this,
		               new String[]{Manifest.permission.CAMERA},
		               1);
		}
	
**************************************************************************

//FLASH_MODE_OFF
//camera.stopPreview();
//camera.release();