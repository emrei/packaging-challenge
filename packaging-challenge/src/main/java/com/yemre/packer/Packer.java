package com.yemre.packer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.yemre.dao.InputDAO;
import com.yemre.dao.impl.FileInputDAO;
import com.yemre.exception.APIException;
import com.yemre.model.Case;
import com.yemre.model.Thing;
import com.yemre.service.InputService;
import com.yemre.service.ValidatorService;
import com.yemre.service.impl.CaseValidatorService;
import com.yemre.service.impl.FileInputService;
import com.yemre.service.impl.KnapsackPackageService;

/**
 * Packer class uses validator service and packageService to run package
 * algorithm for given test cases in the file.
 * 
 * @author YunusEmre
 *
 */
public class Packer {

    private static ValidatorService validatorService = new CaseValidatorService();
    private static KnapsackPackageService packageService = new KnapsackPackageService();

    /**
     * Calculates best option for each case in the file and returns a string by
     * joining each case result
     * 
     * @param filePath
     * @return
     * @throws APIException
     */
    public static String pack(String filePath) throws APIException {
	InputDAO inputDAO = new FileInputDAO(filePath);
	InputService inputService = new FileInputService(inputDAO);
	List<Case> inputCaseList = inputService.getCaseList();
	validateCaseList(inputCaseList);
	return convertCaseList(getBestCaseList(inputCaseList));
    }

    private static List<Case> getBestCaseList(List<Case> inputCaseList) throws APIException {
	List<Case> bestCaseList = new ArrayList<Case>();
	for (Case inputCase : inputCaseList) {
	    bestCaseList.add(packageService.pack(inputCase));
	}

	return bestCaseList;
    }

    private static String convertCaseList(List<Case> bestCaseList) {
	List<String> outputList = new ArrayList<String>();

	for (Case bestCase : bestCaseList) {
	    if (bestCase.getThingList().isEmpty()) {
		outputList.add("-");
	    } else {
		outputList.add(bestCase.getThingList().stream().map(Thing::getIndex).map(Object::toString)
			.collect(Collectors.joining(",")));
	    }
	}
	return outputList.stream().collect(Collectors.joining("\n"));
    }

    private static void validateCaseList(List<Case> caseList) throws APIException {
	for (Case inputCase : caseList) {
	    validatorService.validate(inputCase);
	}
    }
}
