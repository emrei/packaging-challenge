package com.yemre.dao.impl;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.yemre.dao.InputDAO;
import com.yemre.exception.APIException;
import com.yemre.model.Case;
import com.yemre.model.Thing;

/**
 * InputDAO implementation
 * 
 * @author YunusEmre
 *
 */
public class FileInputDAO implements InputDAO {

    private String filePath;

    public FileInputDAO(String filePath) {
	this.filePath = filePath;
    }

    @Override
    public List<Case> getCaseList() throws APIException {
	List<String> lines;
	List<Case> caseList;
	try {
	    lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.ISO_8859_1);
	    caseList = lines.stream().map(temp -> {
		return createCaseFromLine(temp);
	    }).collect(Collectors.toList());

	} catch (Exception e) {
	    throw new APIException("Exception occured while parsing file: " + e.getMessage());
	}

	return caseList;
    }

    private Case createCaseFromLine(String line) {
	String[] weightAndThings = line.split(":");
	BigDecimal maxWeight = new BigDecimal(weightAndThings[0].trim());
	String[] things = weightAndThings[1].trim().split(" ");

	List<Thing> thingList = Arrays.asList(things).stream().map(temp -> {
	    String[] thingProperties = temp.split(",");
	    int index = Integer.parseInt(thingProperties[0].substring(1));
	    BigDecimal weight = new BigDecimal(thingProperties[1]);
	    int cost = Integer.parseInt(thingProperties[2].substring(1, thingProperties[2].length() - 1));
	    return new Thing(index, weight, cost);
	}).collect(Collectors.toList());

	return new Case(maxWeight, thingList);
    }

}
