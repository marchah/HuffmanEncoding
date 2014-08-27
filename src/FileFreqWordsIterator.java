import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class FileFreqWordsIterator implements Iterator<String> {
	
	private LinkedList<String> listTopWord;
	private String fileString;
	private int pos;
	
	private Map<String, Integer> constructHashMap(String inputFileName) throws IOException {
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		fileString = new String(Files.readAllBytes(Paths.get(inputFileName)), StandardCharsets.UTF_8);
		String[] words = fileString.split("["+HuffmanEncoding.SPACE_CHAR+HuffmanEncoding.NEXT_LINE_CHAR+"]");
		for (int i = 0; i != words.length; i++) {
			if (words[i].length() > HuffmanEncoding.MIN_SIZE_WORD)
				ht.put(words[i], (ht.containsKey(words[i]) ? ht.get(words[i]) + 1 : 1));
		}
		return HuffmanEncoding.sortByValuesDescending(ht);
	}
	
	private void findTopWord(Map<String, Integer> map, int n) {
		int count = 0;
		Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
		while (count < n && it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			if (entry.getKey().length() >= HuffmanEncoding.MIN_SIZE_WORD) {
				listTopWord.add(entry.getKey());
				count++;
			}
		}
	}
	
	public FileFreqWordsIterator(String inputFileName, int n) {
		listTopWord = new LinkedList<>();
		fileString = "";
		pos = 0;
		try {
			Map<String, Integer> map = constructHashMap(inputFileName);
			if (n > 0)
				findTopWord(map, n);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	@Override
	public boolean hasNext() {
		return pos < fileString.length();
	}

	private String convertToBinaryString(byte[] bytes) {
		StringBuilder binary = new StringBuilder(); 
		
		for (byte b : bytes) {
			int val = b;
			for (int i = 0; i < 8; i++) {
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
		}
		return binary.toString();
	}
	
	@Override
	public String next() {
		if (listTopWord.size() > 0) {
	        for (int i = 0; listTopWord != null && i < listTopWord.size(); ++i) {
                if (fileString.length() > pos + listTopWord.get(i).length() && fileString.substring(pos, pos+listTopWord.get(i).length()).equals(listTopWord.get(i))) {
                    String word = listTopWord.get(i);
                    pos += word.length();
                    return convertToBinaryString(word.getBytes());
                }
	        }
		}
		return convertToBinaryString(("" + fileString.charAt(pos++)).getBytes());
	}

	@Override
	public void remove() {
		int savePos = pos;
		String[] tmp = fileString.substring(pos).split("["+ HuffmanEncoding.NEXT_LINE_CHAR + HuffmanEncoding.SPACE_CHAR+"]", 2);
		
		if (listTopWord.contains(tmp[0])) {
			savePos += tmp[0].length();
		}
		else
			savePos++;
		fileString = fileString.substring(0, pos) + fileString.substring(savePos);
	}

}
