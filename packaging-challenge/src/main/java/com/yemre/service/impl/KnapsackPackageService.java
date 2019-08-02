package com.yemre.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.yemre.exception.APIException;
import com.yemre.model.Case;
import com.yemre.model.Thing;
import com.yemre.service.PackageService;

/**
 * PackageService implementation class
 * 
 * @author YunusEmre
 *
 */
public class KnapsackPackageService implements PackageService {

    @Override
    public Case pack(Case inputCase) throws APIException {
	try {
	    List<Case> caseCombinations = findAllCombinations(inputCase);
	    return getBestCase(caseCombinations, inputCase.getMaxWeight());
	} catch (Exception e) {
	    throw new APIException("Exception occured while packing case: " + e);
	}
    }

    private Case getBestCase(List<Case> caseCombinations, BigDecimal maxWeight) {
	return caseCombinations.stream().filter(c -> c.getMaxWeight().compareTo(maxWeight) < 1)
		.sorted(Comparator.comparing(Case::getTotalCost).reversed().thenComparing(Case::getMaxWeight))
		.findFirst().orElse(new Case(BigDecimal.ZERO, new ArrayList<>()));
    }

    private List<Case> findAllCombinations(Case inputCase) {
	List<Case> caseCombinations = new ArrayList<Case>();
	int n = inputCase.getThingList().size();
	for (int i = 1; i < n + 1; i++) {
	    Thing[] combination = new Thing[i];
	    findCombination(caseCombinations, inputCase.getThingList(), combination, i, 0, 0, n - 1);
	}
	return caseCombinations;
    }

    /**
     * find combinations by considering given r. (nCr) Every combination is also a
     * case. Every possible thing list is saved as a Case and put into
     * combinationList
     * 
     * @param combinationList
     * @param thingList
     * @param combinationArray
     * @param r
     * @param firstIndex
     * @param index
     * @param lastIndex
     */
    private static void findCombination(List<Case> combinationList, List<Thing> thingList, Thing[] combinationArray,
	    int r, int firstIndex, int index, int lastIndex) {
	if (index == r) {
	    combinationList.add(getPossibleCase(combinationArray));
	    return;
	}
	for (int i = firstIndex; i <= lastIndex; i++) {
	    combinationArray[index] = thingList.get(i);
	    findCombination(combinationList, thingList, combinationArray, r, i + 1, index + 1, lastIndex);
	}
    }

    private static Case getPossibleCase(Thing combinationArray[]) {
	List<Thing> combination = new ArrayList<Thing>();
	BigDecimal weight = BigDecimal.ZERO;
	for (int j = 0; j < combinationArray.length; j++) {
	    combination.add(combinationArray[j]);
	    weight = weight.add(combinationArray[j].getWeight());
	}
	return new Case(weight, combination);
    }

}
