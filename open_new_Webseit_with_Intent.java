    public void onclick_privacy_policy(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com/"));
        startActivity(intent);

    }
	
	
    // Open new Activity
    public void onclick_textview(View v){
        Intent intent = new Intent(this,NewActivity.class);
        startActivity(intent);
    }