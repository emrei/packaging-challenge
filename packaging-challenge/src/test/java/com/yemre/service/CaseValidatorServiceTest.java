package com.yemre.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.yemre.exception.APIException;
import com.yemre.model.Case;
import com.yemre.model.Thing;
import com.yemre.service.ValidatorService;
import com.yemre.service.impl.CaseValidatorService;
/**
 * Test class for CaseValidator service
 * @author YunusEmre
 *
 */
public class CaseValidatorServiceTest {
    ValidatorService caseValidatorService = new CaseValidatorService();

    @Test
    public void testValidCase() throws APIException {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(1, new BigDecimal("53.38"), 45));
	thingList.add(new Thing(2, new BigDecimal("88.62"), 98));
	thingList.add(new Thing(3, new BigDecimal("78.48"), 3));
	thingList.add(new Thing(4, new BigDecimal("72.30"), 76));
	thingList.add(new Thing(5, new BigDecimal("30.18"), 9));
	thingList.add(new Thing(6, new BigDecimal("46.34"), 48));

	caseValidatorService.validate(new Case(new BigDecimal("81"), thingList));
    }

    @Test
    public void testInValidCase_ExceedsMaxThing() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(1, new BigDecimal("53.38"), 45));
	thingList.add(new Thing(2, new BigDecimal("88.62"), 98));
	thingList.add(new Thing(3, new BigDecimal("78.48"), 3));
	thingList.add(new Thing(4, new BigDecimal("72.30"), 76));
	thingList.add(new Thing(5, new BigDecimal("30.18"), 9));
	thingList.add(new Thing(6, new BigDecimal("46.34"), 48));
	thingList.add(new Thing(7, new BigDecimal("53.38"), 45));
	thingList.add(new Thing(8, new BigDecimal("88.62"), 98));
	thingList.add(new Thing(9, new BigDecimal("78.48"), 3));
	thingList.add(new Thing(10, new BigDecimal("72.30"), 76));
	thingList.add(new Thing(11, new BigDecimal("30.18"), 9));
	thingList.add(new Thing(12, new BigDecimal("46.34"), 48));
	thingList.add(new Thing(13, new BigDecimal("72.30"), 76));
	thingList.add(new Thing(14, new BigDecimal("30.18"), 9));
	thingList.add(new Thing(15, new BigDecimal("46.34"), 48));
	thingList.add(new Thing(16, new BigDecimal("46.34"), 48));

	assertThrows(APIException.class, () -> {
	    caseValidatorService.validate(new Case(new BigDecimal("81"), thingList));
	});

    }

    @Test
    public void testInValidCase_ExceedsMaxThingWeight() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(1, new BigDecimal("53.38"), 45));
	thingList.add(new Thing(2, new BigDecimal("88.62"), 98));
	thingList.add(new Thing(3, new BigDecimal("78.48"), 3));
	thingList.add(new Thing(4, new BigDecimal("72.30"), 76));
	thingList.add(new Thing(5, new BigDecimal("130.18"), 9));
	thingList.add(new Thing(6, new BigDecimal("46.34"), 48));

	assertThrows(APIException.class, () -> {
	    caseValidatorService.validate(new Case(new BigDecimal("81"), thingList));
	});
    }

    @Test
    public void testInValidCase_ExceedsMaxPackageWeight() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(1, new BigDecimal("53.38"), 45));
	thingList.add(new Thing(2, new BigDecimal("88.62"), 98));
	thingList.add(new Thing(3, new BigDecimal("78.48"), 3));
	thingList.add(new Thing(4, new BigDecimal("72.30"), 76));
	thingList.add(new Thing(5, new BigDecimal("13.18"), 9));
	thingList.add(new Thing(6, new BigDecimal("46.34"), 48));

	assertThrows(APIException.class, () -> {
	    caseValidatorService.validate(new Case(new BigDecimal("180"), thingList));
	});
    }

    @Test
    public void testInValidCase_ExceedsMaxThingCost() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(1, new BigDecimal("53.38"), 45));
	thingList.add(new Thing(2, new BigDecimal("88.62"), 98));
	thingList.add(new Thing(3, new BigDecimal("78.48"), 3));
	thingList.add(new Thing(4, new BigDecimal("72.30"), 76));
	thingList.add(new Thing(5, new BigDecimal("30.18"), 9));
	thingList.add(new Thing(6, new BigDecimal("46.34"), 480));

	assertThrows(APIException.class, () -> {
	    caseValidatorService.validate(new Case(new BigDecimal("80"), thingList));
	});
    }
}
