import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;


public class HuffmanEncodingTest {
	
	@Test
	public void KaleidoscopeDecodeTest() {
        long start = System.currentTimeMillis();
		HuffmanDecode.decode("testFile/Kaleidoscope.txt.huffman", "testFile/Kaleidoscope.result");
		System.out.println("Decode Kaleidoscope: " + (System.currentTimeMillis() - start));
		try {
			String text1 = new String(Files.readAllBytes(Paths.get("testFile/Kaleidoscope.txt")), StandardCharsets.UTF_8);
			String text2 = new String(Files.readAllBytes(Paths.get("testFile/Kaleidoscope.result")), StandardCharsets.UTF_8);
			assertTrue(text1.equals(text2));
			
		} catch (IOException e) {e.printStackTrace();}	
	}
	
	@Test
	public void KaleidoscopeEncodeAndDecodeTest() {
		long start = System.currentTimeMillis();
		HuffmanEncode.encode("testFile/Kaleidoscope.txt", "testFile/Kaleidoscope.txt.encoded", 0);
		System.out.println("Encode Kaleidoscope: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		HuffmanDecode.decode("testFile/Kaleidoscope.txt.encoded", "testFile/Kaleidoscope.result");
		System.out.println("Decode Kaleidoscope: " + (System.currentTimeMillis() - start));
		try {
			String text1 = new String(Files.readAllBytes(Paths.get("testFile/Kaleidoscope.txt")), StandardCharsets.UTF_8);
			String text2 = new String(Files.readAllBytes(Paths.get("testFile/Kaleidoscope.result")), StandardCharsets.UTF_8);
			assertTrue(text1.equals(text2));
			
		} catch (IOException e) {e.printStackTrace();}	
	}
	
	@Test
	public void HangInThereDecodeTest() {
		long start = System.currentTimeMillis();
		HuffmanDecode.decode("testFile/HangInThere.jpg.huffman", "testFile/HangInThere.jpg.result");
		System.out.println("Decode HangInThere: " + (System.currentTimeMillis() - start));
		try {
			String text1 = new String(Files.readAllBytes(Paths.get("testFile/HangInThere.jpg")), StandardCharsets.UTF_8);
			String text2 = new String(Files.readAllBytes(Paths.get("testFile/HangInThere.jpg.result")), StandardCharsets.UTF_8);
			assertTrue(text1.equals(text2));
			
		} catch (IOException e) {e.printStackTrace();}	
	}

	@Test
	public void HangInThereEncodeAndDecodeTest() {
		long start = System.currentTimeMillis();
		HuffmanEncode.encode("testFile/HangInThere.jpg", "testFile/HangInThere.jpg.encoded", 0);
		System.out.println("Encode HangInThere: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		HuffmanDecode.decode("testFile/HangInThere.jpg.encoded", "testFile/HangInThere.jpg.result");
		System.out.println("Decode HangInThere: " + (System.currentTimeMillis() - start));
		try {
			String text1 = new String(Files.readAllBytes(Paths.get("testFile/HangInThere.jpg")), StandardCharsets.UTF_8);
			String text2 = new String(Files.readAllBytes(Paths.get("testFile/HangInThere.jpg.result")), StandardCharsets.UTF_8);
			assertTrue(text1.equals(text2));
		} catch (IOException e) {e.printStackTrace();}	
	}

	@Test
	public void TheAdventuresOfSherlockHolmesDecodeTest() {
		long start = System.currentTimeMillis();
		HuffmanDecode.decode("testFile/TheAdventuresOfSherlockHolmes.txt.huffman", "testFile/TheAdventuresOfSherlockHolmes.txt.result");
		System.out.println("Decode TheAdventuresOfSherlockHolmes: " + (System.currentTimeMillis() - start));
		try {
			String text1 = new String(Files.readAllBytes(Paths.get("testFile/TheAdventuresOfSherlockHolmes.txt")), StandardCharsets.UTF_8);
			String text2 = new String(Files.readAllBytes(Paths.get("testFile/TheAdventuresOfSherlockHolmes.txt.result")), StandardCharsets.UTF_8);
			assertTrue(text1.equals(text2));
		} catch (IOException e) {e.printStackTrace();}	
	}
	
	@Test
	public void TheAdventuresOfSherlockHolmesEncodeAndDecodeTest() {
		long start = System.currentTimeMillis();
		HuffmanEncode.encode("testFile/TheAdventuresOfSherlockHolmes.txt", "testFile/TheAdventuresOfSherlockHolmes.txt.encoded", 0);
		System.out.println("Encode TheAdventuresOfSherlockHolmes: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		HuffmanDecode.decode("testFile/TheAdventuresOfSherlockHolmes.txt.encoded", "testFile/TheAdventuresOfSherlockHolmes.txt.result");
		System.out.println("Decode TheAdventuresOfSherlockHolmes: " + (System.currentTimeMillis() - start));
		try {
			String text1 = new String(Files.readAllBytes(Paths.get("testFile/TheAdventuresOfSherlockHolmes.txt")), StandardCharsets.UTF_8);
			String text2 = new String(Files.readAllBytes(Paths.get("testFile/TheAdventuresOfSherlockHolmes.txt.result")), StandardCharsets.UTF_8);
			assertTrue(text1.equals(text2));	
		} catch (IOException e) {e.printStackTrace();}	
	}
	
	@Test
	public void lastquestionDecodeTest() {
		long start = System.currentTimeMillis();
		HuffmanDecode.decode("testFile/lastquestion.txt.huffman", "testFile/lastquestion.txt.result");
		System.out.println("Decode lastquestion: " + (System.currentTimeMillis() - start));
		try {
			String text1 = new String(Files.readAllBytes(Paths.get("testFile/lastquestion.txt")), StandardCharsets.UTF_8);
			String text2 = new String(Files.readAllBytes(Paths.get("testFile/lastquestion.txt.result")), StandardCharsets.UTF_8);
			assertTrue(text1.equals(text2));
		} catch (IOException e) {e.printStackTrace();}	
	}
	
	@Test
	public void lastquestionEncodeAndDecodeTest() {
		long start = System.currentTimeMillis();
		HuffmanEncode.encode("testFile/lastquestion.txt", "testFile/lastquestion.txt.encoded", 0);
		System.out.println("Encode lastquestion: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		HuffmanDecode.decode("testFile/lastquestion.txt.encoded", "testFile/lastquestion.txt.result");
		System.out.println("Decode lastquestion: " + (System.currentTimeMillis() - start));
		try {
			String text1 = new String(Files.readAllBytes(Paths.get("testFile/lastquestion.txt")), StandardCharsets.UTF_8);
			String text2 = new String(Files.readAllBytes(Paths.get("testFile/lastquestion.txt.result")), StandardCharsets.UTF_8);
			assertTrue(text1.equals(text2));
		} catch (IOException e) {e.printStackTrace();}	
	}
	
	@Test
	public void TheAdventuresOfSherlockHolmesEncodeAndDecodeWithWordsTest() {
		long start = System.currentTimeMillis();
		HuffmanEncode.encode("testFile/TheAdventuresOfSherlockHolmes.txt", "testFile/TheAdventuresOfSherlockHolmes.txt.encoded", 10);
		System.out.println("Encode TheAdventuresOfSherlockHolmes With 10 Words: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		HuffmanDecode.decode("testFile/TheAdventuresOfSherlockHolmes.txt.encoded", "testFile/TheAdventuresOfSherlockHolmes.txt.result");
		System.out.println("Decode TheAdventuresOfSherlockHolmes With 10 Words: " + (System.currentTimeMillis() - start));
		try {
			String text1 = new String(Files.readAllBytes(Paths.get("testFile/TheAdventuresOfSherlockHolmes.txt")), StandardCharsets.UTF_8);
			String text2 = new String(Files.readAllBytes(Paths.get("testFile/TheAdventuresOfSherlockHolmes.txt.result")), StandardCharsets.UTF_8);
			assertTrue(text1.equals(text2));
		} catch (IOException e) {e.printStackTrace();}	
	}
	
	@Test
	public void lastquestionEncodeAndDecodeWithWordsTest() {
		long start = System.currentTimeMillis();
		HuffmanEncode.encode("testFile/lastquestion.txt", "testFile/lastquestion.txt.encoded", 20);
		System.out.println("Encode lastquestion With 20 Words: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		HuffmanDecode.decode("testFile/lastquestion.txt.encoded", "testFile/lastquestion.txt.result");
		System.out.println("Decode lastquestion With 20 Words: " + (System.currentTimeMillis() - start));
		try {
			String text1 = new String(Files.readAllBytes(Paths.get("testFile/lastquestion.txt")), StandardCharsets.UTF_8);
			String text2 = new String(Files.readAllBytes(Paths.get("testFile/lastquestion.txt.result")), StandardCharsets.UTF_8);
			assertTrue(text1.equals(text2));
		} catch (IOException e) {e.printStackTrace();}	
	}
}
