@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putCharSequence("meinWert",textView.getText());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Oder das in onCreate() Methode!
        if(savedInstanceState != null){
            textView.setText(savedInstanceState.getCharSequence("meinWert"));
        }
    }