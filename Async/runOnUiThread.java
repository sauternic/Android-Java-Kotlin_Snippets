// Background Thread with return to th UI Thread for actualisation	 
	
	@Override
	public void onClick(View v) {
		
		Thread tr = new Thread(new Runnable() {

			//Background Thread
			@Override
			public void run() {

				for (MainActivity.i = 0; i <= 10; i++) {
					
					//Short back to the UI Thread
					//!!!runOnUiThread()!!!
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							updateUI(textView2);
						}
					});
					//Continue with Background Thread

					try {
						Thread.sleep(1000);
					} catch (Exception e) {}
				}
		}
	});
	tr.start();