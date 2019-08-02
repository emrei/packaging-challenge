package com.yemre.service.impl;

import java.math.BigDecimal;

import com.yemre.exception.APIException;
import com.yemre.model.Case;
import com.yemre.model.Thing;
import com.yemre.service.ValidatorService;

/**
 * ValidatorService implementation class
 * 
 * @author YunusEmre
 *
 */
public class CaseValidatorService implements ValidatorService {

    public static final BigDecimal MAX_PACKAGE_WEIGHT = new BigDecimal("100");
    public static final int MAX_INDEX = 15;
    public static final BigDecimal MAX_THING_WEIGHT = new BigDecimal("100");
    public static final double MAX_THING_COST = 100;

    @Override
    public void validate(Case inputCase) throws APIException {
	if (inputCase.getMaxWeight().compareTo(MAX_PACKAGE_WEIGHT) > 0) {
	    throw new APIException("Max allowed package limit is: " + MAX_PACKAGE_WEIGHT);
	}
	if (inputCase.getThingList().size() > MAX_INDEX) {
	    throw new APIException("Max allowed thing size is " + MAX_INDEX);
	}

	for (Thing thing : inputCase.getThingList()) {

	    if (thing.getWeight().compareTo(MAX_THING_WEIGHT) > 0) {
		throw new APIException("Max allowed weight is " + MAX_THING_WEIGHT);
	    }
	    if (thing.getCost() > MAX_THING_COST) {
		throw new APIException("Max allowed cost is " + MAX_INDEX);
	    }
	}
    }

}
