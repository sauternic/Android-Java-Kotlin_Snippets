import android.app.AlertDialog

	try {
		//To try code
	} catch (Exception e) {
		//region AlertDialog
		AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
		msg.setTitle("Meldung");
		msg.setMessage(e.getMessage());
		msg.setCancelable(true);
		AlertDialog msgDialog = msg.create();
		msgDialog.show();
		//endregion
	}