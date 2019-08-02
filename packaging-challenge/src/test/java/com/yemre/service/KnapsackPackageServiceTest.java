package com.yemre.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.yemre.exception.APIException;
import com.yemre.model.Case;
import com.yemre.model.Thing;
import com.yemre.service.impl.KnapsackPackageService;
import com.yemre.util.CaseGenerator;
/**
 * Test class for KnapsackPackage service
 * @author YunusEmre
 *
 */
public class KnapsackPackageServiceTest {

    KnapsackPackageService packageService = new KnapsackPackageService();
    
    @Test
    public void testPackComb() throws APIException {
	Case actual = packageService.pack(CaseGenerator.generateCase(1));
	assertEquals(getExpected_Case1(), actual);
    }

    @ParameterizedTest
    @MethodSource("provideInputForTestPack")
    public void testPack(Case input, Case expected) throws APIException {
	Case actual = packageService.pack(input);
	assertEquals(expected, actual);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> provideInputForTestPack() {
	return Stream.of(Arguments.of(CaseGenerator.generateCase(1), getExpected_Case1()),
		Arguments.of(CaseGenerator.generateCase(2), getExpected_Case2()),
		Arguments.of(CaseGenerator.generateCase(3), getExpected_Case3()),
		Arguments.of(CaseGenerator.generateCase(4), getExpected_Case4()),
		Arguments.of(CaseGenerator.generateCase(5), getExpected_Case5()),
		Arguments.of(CaseGenerator.generateCase(6), getExpected_Case6()),
		Arguments.of(CaseGenerator.generateCase(7), getExpected_Case7()));
    }

    private static Case getExpected_Case1() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(4, new BigDecimal("72.30"), 76));

	return new Case(new BigDecimal("72.30"), thingList);
    }

    private static Case getExpected_Case2() {
	List<Thing> thingList = new ArrayList<Thing>();

	return new Case(BigDecimal.ZERO, thingList);
    }

    private static Case getExpected_Case3() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(2, new BigDecimal("14.55"), 74));
	thingList.add(new Thing(7, new BigDecimal("60.02"), 74));

	return new Case(new BigDecimal("74.57"), thingList);
    }

    private static Case getExpected_Case4() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(8, new BigDecimal("19.36"), 79));
	thingList.add(new Thing(9, new BigDecimal("6.76"), 64));

	return new Case(new BigDecimal("26.12"), thingList);
    }

    private static Object getExpected_Case5() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(2, new BigDecimal("33.20"), 40));
	thingList.add(new Thing(3, new BigDecimal("13.10"), 10));
	thingList.add(new Thing(4, new BigDecimal("45.76"), 16));

	return new Case(new BigDecimal("92.06"), thingList);
    }

    private static Object getExpected_Case6() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(9, new BigDecimal("0.76"), 64));

	return new Case(new BigDecimal("0.76"), thingList);

    }

    private static Object getExpected_Case7() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(1, new BigDecimal("0.72"), 13));
	thingList.add(new Thing(2, new BigDecimal("3.20"), 40));
	thingList.add(new Thing(3, new BigDecimal("3.10"), 10));
	thingList.add(new Thing(4, new BigDecimal("5.76"), 24));
	thingList.add(new Thing(5, new BigDecimal("6.81"), 46));
	thingList.add(new Thing(6, new BigDecimal("8.77"), 99));
	thingList.add(new Thing(7, new BigDecimal("7.80"), 65));
	thingList.add(new Thing(8, new BigDecimal("9.36"), 53));
	thingList.add(new Thing(9, new BigDecimal("0.76"), 64));
	thingList.add(new Thing(10, new BigDecimal("1.42"), 24));
	thingList.add(new Thing(11, new BigDecimal("2.41"), 46));
	thingList.add(new Thing(12, new BigDecimal("4.77"), 99));
	thingList.add(new Thing(13, new BigDecimal("1.80"), 65));
	thingList.add(new Thing(14, new BigDecimal("1.35"), 53));
	thingList.add(new Thing(15, new BigDecimal("0.76"), 64));

	return new Case(new BigDecimal("58.79"), thingList);
    }

}
