package com.yemre.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.yemre.model.Case;
import com.yemre.model.Thing;
/**
 * Test case generator class
 * @author YunusEmre
 *
 */
public class CaseGenerator {
    public static Case generateCase(int caseNumber) {
	switch (caseNumber) {
	case 1:
	    return getCase1();
	case 2:
	    return getCase2();
	case 3:
	    return getCase3();
	case 4:
	    return getCase4();
	case 5:
	    return getCase5();
	case 6:
	    return getCase6();
	case 7:
	    return getCase7();
	default:
	    return getCase1();
	}
    }

    private static Case getCase1() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(1, new BigDecimal("53.38"), 45));
	thingList.add(new Thing(2, new BigDecimal("88.62"), 98));
	thingList.add(new Thing(3, new BigDecimal("78.48"), 3));
	thingList.add(new Thing(4, new BigDecimal("72.30"), 76));
	thingList.add(new Thing(5, new BigDecimal("30.18"), 9));
	thingList.add(new Thing(6, new BigDecimal("46.34"), 48));

	return new Case(new BigDecimal("81"), thingList);
    }

    private static Case getCase2() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(1, new BigDecimal("15.3"), 34));

	return new Case(new BigDecimal("8"), thingList);
    }

    private static Case getCase3() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(1, new BigDecimal("85.31"), 29));
	thingList.add(new Thing(2, new BigDecimal("14.55"), 74));
	thingList.add(new Thing(3, new BigDecimal("3.98"), 16));
	thingList.add(new Thing(4, new BigDecimal("26.24"), 55));
	thingList.add(new Thing(5, new BigDecimal("63.69"), 52));
	thingList.add(new Thing(6, new BigDecimal("76.25"), 75));
	thingList.add(new Thing(7, new BigDecimal("60.02"), 74));
	thingList.add(new Thing(8, new BigDecimal("93.18"), 35));
	thingList.add(new Thing(9, new BigDecimal("89.95"), 78));

	return new Case(new BigDecimal("75"), thingList);
    }

    private static Case getCase4() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(1, new BigDecimal("90.72"), 13));
	thingList.add(new Thing(2, new BigDecimal("33.80"), 40));
	thingList.add(new Thing(3, new BigDecimal("43.15"), 10));
	thingList.add(new Thing(4, new BigDecimal("37.97"), 16));
	thingList.add(new Thing(5, new BigDecimal("46.81"), 36));
	thingList.add(new Thing(6, new BigDecimal("48.77"), 79));
	thingList.add(new Thing(7, new BigDecimal("81.80"), 45));
	thingList.add(new Thing(8, new BigDecimal("19.36"), 79));
	thingList.add(new Thing(9, new BigDecimal("6.76"), 64));

	return new Case(new BigDecimal("56"), thingList);
    }

    private static Case getCase5() {
	List<Thing> thingList = new ArrayList<Thing>();
	thingList.add(new Thing(1, new BigDecimal("190.72"), 13));
	thingList.add(new Thing(2, new BigDecimal("33.20"), 40));
	thingList.add(new Thing(3, new BigDecimal("13.10"), 10));
	thingList.add(new Thing(4, new BigDecimal("45.76"), 16));

	return new Case(new BigDecimal("92.06"), thingList);
    }

    private static Case getCase6() {
	List<Thing> thingList = new ArrayList<Thing>();

	thingList.add(new Thing(1, new BigDecimal("190.72"), 13));
	thingList.add(new Thing(2, new BigDecimal("33.20"), 40));
	thingList.add(new Thing(3, new BigDecimal("13.10"), 10));
	thingList.add(new Thing(4, new BigDecimal("45.76"), 24));
	thingList.add(new Thing(5, new BigDecimal("26.81"), 46));
	thingList.add(new Thing(6, new BigDecimal("38.77"), 99));
	thingList.add(new Thing(7, new BigDecimal("67.80"), 65));
	thingList.add(new Thing(8, new BigDecimal("29.36"), 53));
	thingList.add(new Thing(9, new BigDecimal("0.76"), 64));
	thingList.add(new Thing(10, new BigDecimal("35.42"), 24));
	thingList.add(new Thing(11, new BigDecimal("66.41"), 46));
	thingList.add(new Thing(12, new BigDecimal("58.77"), 99));
	thingList.add(new Thing(13, new BigDecimal("7.80"), 65));
	thingList.add(new Thing(14, new BigDecimal("9.35"), 53));
	thingList.add(new Thing(15, new BigDecimal("0.76"), 64));

	return new Case(new BigDecimal("1.06"), thingList);
    }

    private static Case getCase7() {
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

	return new Case(new BigDecimal("60"), thingList);
    }

}
