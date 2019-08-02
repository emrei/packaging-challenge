package com.yemre.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.yemre.dao.InputDAO;
import com.yemre.dao.impl.FileInputDAO;
import com.yemre.exception.APIException;
import com.yemre.model.Case;
import com.yemre.util.CaseGenerator;
/**
 * Test class for FileInputDAO
 * @author YunusEmre
 *
 */
public class FileInputDAOTest {
    InputDAO fileInputDAO;

    @ParameterizedTest
    @MethodSource("provideInputForGetCaseList")
    public void testSuccessfulGetCaseList(String input, List<Case> expectedList) throws Exception {

	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(input).getFile());

	fileInputDAO = new FileInputDAO(file.getAbsolutePath());
	List<Case> actualList = fileInputDAO.getCaseList();

	assertEquals(expectedList, actualList);
    }

    @Test
    public void testExceptionThrownGetCaseList() {
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource("testcases//invalidCase.txt").getFile());

	fileInputDAO = new FileInputDAO(file.getAbsolutePath());
	assertThrows(APIException.class, () -> {
	    fileInputDAO.getCaseList();
	});
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> provideInputForGetCaseList() {
	return Stream.of(Arguments.of("testcases//validCase.txt", getExpectedList_Case1()),
		Arguments.of("testcases//noBestCase.txt", getExpectedList_Case2()));
    }

    private static List<Case> getExpectedList_Case2() {
	List<Case> caseList = new ArrayList<Case>();
	caseList.add(CaseGenerator.generateCase(2));
	return caseList;
    }

    private static List<Case> getExpectedList_Case1() {
	List<Case> caseList = new ArrayList<Case>();

	for (int i = 1; i <= 4; i++) {
	    caseList.add(CaseGenerator.generateCase(i));
	}

	return caseList;
    }

}
