package com.yemre.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.yemre.dao.impl.FileInputDAO;
import com.yemre.exception.APIException;
import com.yemre.model.Case;
import com.yemre.service.InputService;
import com.yemre.service.impl.FileInputService;
import com.yemre.util.CaseGenerator;
/**
 * Test class for FileInput service
 * @author YunusEmre
 *
 */
public class FileInputServiceTest {
    InputService fileInputService;

    @Test
    public void testGetCaseList() throws APIException {

	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource("testcases//noBestCase.txt").getFile());
	fileInputService = new FileInputService(new FileInputDAO(file.getAbsolutePath()));

	List<Case> actualList = fileInputService.getCaseList();

	List<Case> expectedList = new ArrayList<Case>();
	expectedList.add(CaseGenerator.generateCase(2));

	assertEquals(expectedList, actualList);
    }
}
