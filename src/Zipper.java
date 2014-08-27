import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Zipper {
	private static String header_ = "";
	private static int offset_ = 0;
	private static LinkedList<String> listHeader = new LinkedList<String>();
	private static LinkedList<String> listEncodedData = new LinkedList<String>();
	
	private static boolean listFileAndFolder(String directoryName, String path) {
	    File directory = new File(directoryName);

	    if (!directory.isDirectory())
	    	return false;
	    header_ += ((path.length() > 0) ? path + "/" : "") + directory.getName() + HuffmanEncoding.HEADER_SEPARATOR_CHAR + -1 + HuffmanEncoding.NEXT_LINE_CHAR;
	    if (path.length() <= 0)
	    	path = directory.getName();
	    File[] fList = directory.listFiles();
	    for (File file : fList) {
	    	if (file.isFile())
	    		encodeFile(file.getPath(), path + "/" + file.getName());
	        if (file.isDirectory())
	        	listFileAndFolder(file.getPath(), path + "/" + file.getName());
	    }
	    return true;
	}
	
	private static void encodeFile(String pathFile, String path) {
		HuffmanEncode.encodedFile(pathFile);
		String header = HuffmanEncode.getHeader();
		String encodedData = HuffmanEncode.getEncodedData();
		header_ += path + HuffmanEncoding.HEADER_SEPARATOR_CHAR + offset_ + HuffmanEncoding.NEXT_LINE_CHAR;
		offset_ += header.length() + (encodedData.length() / 8) + 1;
		listHeader.add(header);
		listEncodedData.add(encodedData);
	}
	
	private static void writeZipper(String pathFileZipper) {
		try {
			PrintWriter writer = new PrintWriter(pathFileZipper);
			writer.write(header_);
			writer.close();
			for (int i = 0; i != listHeader.size(); i++) {
				writer = new PrintWriter(new FileWriter(pathFileZipper, true));
				writer.write(HuffmanEncoding.NEXT_LINE_CHAR + listHeader.get(i));
				writer.close();
				FileOutputHelper.writeBinStrToFile(listEncodedData.get(i), pathFileZipper);
			}
		} catch (Exception e) {e.printStackTrace();}
	}
	
	public static void zipper(String pathFolder, String pathFileZipper) {
		if (pathFolder.charAt(pathFolder.length()-1) == '/')
			pathFolder = pathFolder.substring(0, pathFolder.length()-1);
		if (!listFileAndFolder(pathFolder, "")) {
			System.err.println("The path must be a folder");
			return ;
		}
		writeZipper(pathFileZipper);
	}
	
	private static Hashtable<String, Integer> unzipperGetHeader(String pathDirectoryDestination, FileCharIterator myIter) {
		Hashtable<String, Integer> hth = new Hashtable<String, Integer>();			
		
		String strLine = "";
        boolean flag = false;
		while (myIter.hasNext()) {
			String character = myIter.nextChar();
        	if (flag && character.equals(HuffmanEncoding.NEXT_LINE_CHAR))
        		break;
            if (character.equals(HuffmanEncoding.NEXT_LINE_CHAR)) {
            	String[] tmp = strLine.split(HuffmanEncoding.HEADER_SEPARATOR_CHAR);
            	if (pathDirectoryDestination.length() > 0 && tmp[1].equals("-1")) {
    				File dir = new File(pathDirectoryDestination + tmp[0]);
    				if (!dir.exists())
    					dir.mkdirs();
    			}
    			else
    				hth.put(tmp[0], Integer.parseInt(tmp[1]));
  			  	strLine = "";
  			  	flag = true;
            }
            else {
            	strLine += character;
            	flag = false;
            }
		}
		return hth;
	}
	
	private static Hashtable<String, String> unzipperGetHeader(FileCharIterator myIter) {
		Hashtable<String, String> htcw = new Hashtable<String, String>();			
		
		String strLine = "";
        boolean flag = false;
		while (myIter.hasNext()) {
			offset_++;
			String character = myIter.nextChar();
        	if (flag && character.equals(HuffmanEncoding.NEXT_LINE_CHAR))
        		break;
            if (character.equals(HuffmanEncoding.NEXT_LINE_CHAR)) {
            	String[] tmp = strLine.split(HuffmanEncoding.HEADER_SEPARATOR_CHAR);
            	if (!tmp[0].equals(HuffmanEncoding.END_FILE))
            		htcw.put(tmp[1], tmp[0]);
  			  	strLine = "";
  			  	flag = true;
            }
            else {
            	strLine += character;
            	flag = false;
            }
		}
		return htcw;
	}
	
	private static String getEncodedString(FileCharIterator myIter, int offsetNext) {
        String strLine = "";
        while ((offsetNext < 0 || offset_ < offsetNext) && myIter.hasNext()) {
        	strLine += myIter.next();
        	offset_++;
		}
        return strLine;
	}
	
	public static void unzipper(String pathFileZipper, String pathDirectoryDestination) {
		FileCharIterator myIter = new FileCharIterator(pathFileZipper);
		if (!"/".equals(pathDirectoryDestination.charAt(pathDirectoryDestination.length()-1)))
			pathDirectoryDestination += "/";
		Map<String, Integer> listFile = HuffmanEncoding.sortByValuesIncreasing(unzipperGetHeader(pathDirectoryDestination, myIter));
		LinkedList<Integer> listOffset = new LinkedList<Integer>(listFile.values());
		offset_ = 0;
		Iterator<Map.Entry<String, Integer>> it = listFile.entrySet().iterator();
		for (int i = 0; it.hasNext(); i++) {
			Map.Entry<String, Integer> entry = it.next();
			Hashtable<String, String> header = unzipperGetHeader(myIter);			
			int offsetNext = i+1 < listOffset.size() ? listOffset.get(i+1) : -1;
			FileOutputHelper.writeBinStrToFile(HuffmanDecode.decodeDate(header, getEncodedString(myIter, offsetNext-1)), pathDirectoryDestination + entry.getKey(), false);
			while (offset_ < offsetNext) {
				myIter.next();
				offset_++;
			}
		}
	}	
	
	public static void main(String[] args) {	
		if (args.length < 3) {
			System.err.println("Usage: Zipper fct{zipper/unzipper} pathTarget pathDestination");
			return ;
		}
		if (args[0].equals("zipper"))
			zipper(args[1], args[2]);
		else if (args[0].equals("unzipper"))
			unzipper(args[1], args[2]);
		else
			System.err.println("Usage: Zipper fct{zipper/unzipper} pathTarget pathDestination");
	}

}
