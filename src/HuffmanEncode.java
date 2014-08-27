import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class HuffmanEncode {
	
	private static LinkedList<String> listFileWords;
	private static StringBuilder header_;
	private static StringBuilder encodedData_;
	
	private static void associateEncodeCodeword(HuffmanTree.TreeNode node, String codeword, Hashtable<String, String> htcw) {
		if (node.myLeft != null)
			associateEncodeCodeword(node.myLeft, codeword + HuffmanEncoding.BYTE_LEFT_ENCODE, htcw);
		if (node.myKey.length() > 0) {
			htcw.put(node.myKey, codeword);
			header_.append(node.myKey + HuffmanEncoding.HEADER_SEPARATOR_CHAR + codeword + HuffmanEncoding.NEXT_LINE_CHAR);
		}
		if (node.myRight != null)
			associateEncodeCodeword(node.myRight, codeword + HuffmanEncoding.BYTE_RIGHT_ENCODE, htcw);
	}
	
	private static Hashtable<String, String> associateEncodeCodeword(HuffmanTree ht) {
		Hashtable<String, String> htcw = new Hashtable<String, String>();
		associateEncodeCodeword(ht.myRoot, "", htcw);
		return htcw;
	}
	
	private static void encodedData(Hashtable<String, String> htcw, String pathTarget, int n) {
		for (String tmp : listFileWords) {
			encodedData_.append(htcw.get(tmp));
        }
		
		for (int i = 0; i == 0 || encodedData_.length() % 8 != 0; ++i) {
			if (i == 0)
				encodedData_.append(htcw.get(HuffmanEncoding.END_FILE));
			else
				encodedData_.append(HuffmanEncoding.FILLING_BYTE);
		}
	}
	
	private static HuffmanTree createHuffmanTree(String pathTarget, int n) {	
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		listFileWords = new LinkedList<String>();
		if (n > 0) {
			for (FileFreqWordsIterator it = new FileFreqWordsIterator(pathTarget, n); it.hasNext();) {
				String key = it.next();
				listFileWords.addLast(key);
				ht.put(key, (ht.containsKey(key) ? ht.get(key) + 1 : 1));
			}
		}
		else {
			for (FileCharIterator it = new FileCharIterator(pathTarget); it.hasNext();) {
				String key = it.next();
				listFileWords.addLast(key);
				ht.put(key, (ht.containsKey(key) ? ht.get(key) + 1 : 1));
			}
		}
		ht.put(HuffmanEncoding.END_FILE, 0);
        return new HuffmanTree(HuffmanEncoding.sortByValuesIncreasing(ht));
	}
	
	private static void encodeFile(String pathTarget, int n) {
		HuffmanTree huffmantree = createHuffmanTree(pathTarget, n);
		Hashtable<String, String> htcw = associateEncodeCodeword(huffmantree);
		header_.append(HuffmanEncoding.NEXT_LINE_CHAR);
		encodedData(htcw, pathTarget, n);
	}
	
	public static void encodedFile(String pathTarget) {
		header_ = new StringBuilder();
		encodedData_ = new StringBuilder();
		encodeFile(pathTarget, 0);
	}
	public static String getHeader() 		{return header_.toString();}
	public static String getEncodedData() 	{return encodedData_.toString();}
	
	public static void encode(String pathTarget, String pathDestination, int n) {
		header_ = new StringBuilder();
		encodedData_ = new StringBuilder();
		encodeFile(pathTarget, n);
		PrintWriter writer;
		try {
			writer = new PrintWriter(pathDestination);
			writer.write(header_.toString());
			writer.close();
			FileOutputHelper.writeBinStrToFile(encodedData_.toString(), pathDestination);
		} catch (FileNotFoundException e) {e.printStackTrace();}
	}
}
