import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;


public class HuffmanEncoding {
	
	public static String NEXT_LINE_CHAR = "\n";
	public static String SPACE_CHAR = " ";
	public static String HEADER_SEPARATOR_CHAR = ",";
	public static String END_FILE = "EOF";
	public static String BYTE_RIGHT_ENCODE = "1";
	public static String BYTE_LEFT_ENCODE = "0";
	public static String FILLING_BYTE = "0";
	public static int MIN_SIZE_WORD = 2;
	
	public static <K, V extends Comparable<V>> Map<K, V> sortByValuesDescending(final Map<K, V> map) {
	    Comparator<K> valueComparator =  new Comparator<K>() {
	        public int compare(K k1, K k2) {
	            int compare = map.get(k2).compareTo(map.get(k1));
	            if (compare == 0) return 1;
	            else return compare;
	        }
	    };
	    Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
	    sortedByValues.putAll(map);
	    return sortedByValues;
	}
	
	public static <K, V extends Comparable<V>> Map<K, V> sortByValuesIncreasing(final Map<K, V> map) {
	    Comparator<K> valueComparator =  new Comparator<K>() {
	        public int compare(K k1, K k2) {
	            int compare = map.get(k2).compareTo(map.get(k1));
	            if (compare == 0) return 1;
	            else return -compare;
	        }
	    };
	    Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
	    sortedByValues.putAll(map);
	    return sortedByValues;
	}
	
	public static void main(String[] args) {
		if (args.length < 3) {
			System.err.println("Usage: HuffmanEncoding fct{encode/decode} pathTarget pathDestination [n]");
			return ;
		}
		if (args[0].equals("encode")) {
			int n = 0;
			if (args.length >= 4 && args[3].matches("^\\d+$"))
				n = Integer.parseInt(args[3]);
			HuffmanEncode.encode(args[1], args[2], n);
		}
		else if (args[0].equals("decode"))
			HuffmanDecode.decode(args[1], args[2]);
		else
			System.err.println("Usage: HuffmanEncoding fct{encode/decode} pathTarget pathDestination [n]");
	}
}
