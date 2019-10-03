//***************************************************************************************************
    // Statisches setzten einer Framgment xml ohne Java-Code
	// Beachte den ganzen vollen Namen der xml-Datei mit Package-Name
    <fragment
        android:id="@+id/fragment_a"
        android:name="ch.nicolassauter.fragamente2.a"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
		
//***************************************************************************************************
		
		public void onclick_button1(View v){
		//Fragment austauschen
        Fragment fragment = new Fragment_a();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,fragment).commit();
    }
	
//***************************************************************************************************
	
	public class Fragment_a extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

//***************************************************************************************************

	public void button__fragment_a(View v) {
        // Von MainActivity auf statisch gesetzter Inhalt(Text) des Fragments zugreifen
		// Fragment.xml/EditText hat eine id!(edit_text_a)
		String str = ((EditText) findViewById(R.id.edit_text_a)).getText().toString();
        ((EditText) findViewById(R.id.edit_text_b)).setText(str);
    }
	
//***************************************************************************************************
	 
	// Inerhalb einer Fragment-Klasse 
	 @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
	
//***************************************************************************************************