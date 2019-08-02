package com.yemre.packer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.yemre.exception.APIException;
import com.yemre.packer.Packer;
/**
 * Test class for Packer class
 * @author YunusEmre
 *
 */
public class PackerTest {
    @Test
    public void testPack_FileNotFound() {
	assertThrows(APIException.class, () -> {
	    Packer.pack("filename");
	});
    }
    
    @Test
    public void testPack_ConstraintViolation() {
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource("testcases//constraintViolationCase.txt").getFile());
	assertThrows(APIException.class, () -> {
	    Packer.pack(file.getAbsolutePath());
	});
    }
    
    @ParameterizedTest
    @MethodSource("provideInputForTestPack")
    public void testPack(String input, String expected) throws APIException {
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(input).getFile());
	String actual = Packer.pack(file.getAbsolutePath());
	assertEquals(expected, actual);
    }
    
    @SuppressWarnings("unused")
    private static Stream<Arguments> provideInputForTestPack() {
	return Stream.of(Arguments.of("testcases//simpleValidCase.txt", "1"),
		Arguments.of("testcases//validCase.txt", "4\n-\n2,7\n8,9"),
		Arguments.of("testcases//noBestCase.txt", "-"),
		Arguments.of("testcases//bigTestCase.txt", "4\n-\n2,7\n8,9\n5\n1\n2,3,4\n8,9\n2\n-\n2,3,7\n-\n5\n2,4"));
    }
}
