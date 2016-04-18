package homework.task2;

import homework.util.Constant;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.junit.Assert.*;


public class ParserFileTest {
	@Test
	public void testParsFile() throws FileNotFoundException {
		ParserFile.parsFile(Constant.TEST_FILE_TXT);
		ConcurrentLinkedQueue<Object> trans = ParserFile.getTrans();
		final String expected = "[Transaction{sender=1, recipient=2, amount=5}]";
		assertEquals(expected, trans.toString());

	}
	
}