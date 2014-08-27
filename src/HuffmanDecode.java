import java.util.Hashtable;

public class HuffmanDecode {
	
	public static Hashtable<String, String> constructCodewordMap(FileCharIterator myIter) {
		Hashtable<String, String> htcw = new Hashtable<String, String>();			
		
		StringBuilder strLine = new StringBuilder();
        boolean flag = false;
		while (myIter.hasNext()) {
			String character = myIter.nextChar();
        	if (flag && character.equals(HuffmanEncoding.NEXT_LINE_CHAR))
        		break;
            if (character.equals(HuffmanEncoding.NEXT_LINE_CHAR)) {
            	String[] tmp = strLine.toString().split(HuffmanEncoding.HEADER_SEPARATOR_CHAR);
            	if (!tmp[0].equals(HuffmanEncoding.END_FILE))
            		htcw.put(tmp[1], tmp[0]);
  			  	strLine = new StringBuilder();
  			  	flag = true;
            }
            else {
            	strLine.append(character);
            	flag = false;
            }
		}
		return htcw;
	}
	
	private static String getEncodedString(FileCharIterator myIter) {
        StringBuilder strLine = new StringBuilder();
        while (myIter.hasNext()) {
        	strLine.append(myIter.next());
		}
        return strLine.toString();
	}
	
	public static String decodeDate(Hashtable<String, String> htcw, String encodedString) {
		StringBuilder codeword = new StringBuilder();
		StringBuilder decodeString = new StringBuilder();
		for (int i = 0; i != encodedString.length(); i++) {
			if (htcw.containsKey(codeword.toString())) {
				String value = htcw.get(codeword.toString());
				if (value.equals(HuffmanEncoding.END_FILE))
					break;
				decodeString.append(value);
				codeword = new StringBuilder();
			}
			codeword.append(encodedString.charAt(i));
		}
		return decodeString.toString();
	}
	
	public static void decode(String pathTarget, String pathDestination) {
		FileCharIterator myIter = new FileCharIterator(pathTarget);
		Hashtable<String, String> htcw = constructCodewordMap(myIter);
		String decodeString = decodeDate(htcw, getEncodedString(myIter));
		FileOutputHelper.writeBinStrToFile(decodeString, pathDestination, false);
	}
}
