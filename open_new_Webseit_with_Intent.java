    public void onclick_privacy_policy(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com/"));
        startActivity(intent);

    }