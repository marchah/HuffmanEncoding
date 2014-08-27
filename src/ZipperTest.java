import static org.junit.Assert.*;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

import org.junit.Test;


public class ZipperTest {

	private static boolean listFileAndFolder(String directoryName, LinkedList<File> list) {
	    File directory = new File(directoryName);

	    if (!directory.isDirectory())
	    	return false;
	    list.add(directory);
	    File[] fList = directory.listFiles();
	    for (File file : fList) {
	    	if (file.isFile())
	    		list.add(file);
	        if (file.isDirectory())
	        	listFileAndFolder(file.getPath(), list);
	    }
	    return true;
	}
	
	@Test
	public void exemple_dirZipperDecodeTest() {
		LinkedList<File> list1 = new LinkedList<File>();
		LinkedList<File> list2 = new LinkedList<File>();
		long start = System.currentTimeMillis();
		Zipper.unzipper("testFile/example_dir.zipper", "testFile/example_dir_result");
		System.out.println("Unzipper example_dir: " + (System.currentTimeMillis() - start));
		listFileAndFolder("testFile/example_dir", list1);
		listFileAndFolder("testFile/example_dir_result/example_dir", list2);
		try {
			for (int i = 0; i != list1.size(); i++) {
				assertTrue(list1.get(i).getName().equals(list2.get(i).getName()));
				if (list1.get(i).isFile()) {
					String text1 = new String(Files.readAllBytes(Paths.get(list1.get(i).getAbsolutePath())), StandardCharsets.UTF_8);
					String text2 = new String(Files.readAllBytes(Paths.get(list2.get(i).getAbsolutePath())), StandardCharsets.UTF_8);
					assertTrue(text1.equals(text2));
				}
			}
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void dir1ZipperEncodeDecodeTest() {
		LinkedList<File> list1 = new LinkedList<File>();
		LinkedList<File> list2 = new LinkedList<File>();
		long start = System.currentTimeMillis();
		Zipper.zipper("testFile/dir1/", "testFile/dir1.zipper");
		System.out.println("Zipper dir1: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		Zipper.unzipper("testFile/dir1.zipper", "testFile/testFolder");
		System.out.println("Unzipper dir1: " + (System.currentTimeMillis() - start));
		listFileAndFolder("testFile/dir1", list1);
		listFileAndFolder("testFile/testFolder/dir1", list2);
		try {
			for (int i = 0; i != list1.size(); i++) {
				assertTrue(list1.get(i).getName().equals(list2.get(i).getName()));
				if (list1.get(i).isFile()) {
					String text1 = new String(Files.readAllBytes(Paths.get(list1.get(i).getAbsolutePath())), StandardCharsets.UTF_8);
					String text2 = new String(Files.readAllBytes(Paths.get(list2.get(i).getAbsolutePath())), StandardCharsets.UTF_8);
					assertTrue(text1.equals(text2));
				}
			}
		} catch (Exception e) {e.printStackTrace();}
	}

}
