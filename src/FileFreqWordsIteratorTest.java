import static org.junit.Assert.*;

import org.junit.Test;


public class FileFreqWordsIteratorTest {

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
	
	@Test
	public void IteratorWithoutWordTest() {
		FileFreqWordsIterator it = new FileFreqWordsIterator("testFile/IteratorTest1.txt", 0);
		assertTrue(it.next().equals(convertToBinaryString("a".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("b".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("c".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("d".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("e".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("f".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("g".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("h".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("i".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("j".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("k".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("l".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("m".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("n".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("o".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("p".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("q".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("r".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("s".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("t".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("u".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("v".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("w".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("x".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("y".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("z".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("\n".getBytes())));
		assertTrue(!it.hasNext());
	}
	
	@Test
	public void IteratorWithWordTest() {
		FileFreqWordsIterator it = new FileFreqWordsIterator("testFile/IteratorTest2.txt", 10);
		assertTrue(it.next().equals(convertToBinaryString("a".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("b".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("c".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("d".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("e".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TOTO".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("f".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("g".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("h".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("i".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("j".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TOTO".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("k".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TATA".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("l".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("m".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("n".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TATA".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("o".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("p".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("q".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TITI".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("r".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("s".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("t".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TATA".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("u".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("v".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TOTO".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("w".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("x".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("y".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("z".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TITI".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("\n".getBytes())));
		assertTrue(!it.hasNext());
	}
	
	@Test
	public void IteratorWithWord2Test() {
		FileFreqWordsIterator it = new FileFreqWordsIterator("testFile/IteratorTest3.txt", 2);
		assertTrue(it.next().equals(convertToBinaryString("a".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("b".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("c".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("d".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("e".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TOTO".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("f".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("g".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("h".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TOTO".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("i".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("j".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TOTO".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("k".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TATA".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("l".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("m".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("n".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TATA".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("o".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("p".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("q".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("T".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("I".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("T".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("I".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("r".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("s".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("t".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TATA".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("u".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("v".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TOTO".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("w".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("TATA".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("x".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("y".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("z".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString(" ".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("T".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("I".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("T".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("I".getBytes())));
		assertTrue(it.next().equals(convertToBinaryString("\n".getBytes())));
		assertTrue(!it.hasNext());
	}

}
