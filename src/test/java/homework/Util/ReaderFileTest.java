package homework.Util;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class ReaderFileTest {

	@Test
	public void testRead() throws FileNotFoundException {
		String expected = ReaderFile.read(Constant.TEST_FILE_TXT);
		Assert.assertEquals("test file\n", expected);

	}
	
}