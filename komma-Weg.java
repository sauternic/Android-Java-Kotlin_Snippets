private String kommaWeg(String str) {

	if (str.indexOf(',') > -1) {
		return str.replace(',', '.');
	}
	return str;
}