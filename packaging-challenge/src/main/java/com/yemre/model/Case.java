package com.yemre.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * The class includes features of each test case, each line in the given file.
 * 
 * @author YunusEmre
 *
 */
public class Case {
    private final BigDecimal maxWeight;
    private final List<Thing> thingList;

    public Case(BigDecimal maxWeight, List<Thing> thingList) {
	this.maxWeight = maxWeight;
	this.thingList = thingList;
    }

    public BigDecimal getMaxWeight() {
	return maxWeight;
    }

    public List<Thing> getThingList() {
	return thingList;
    }

    public int getTotalCost() {
	return thingList.stream().map(item -> item.getCost()).reduce(0, (a, b) -> a + b);
    }

    @Override
    public final int hashCode() {
	return Objects.hash(maxWeight, thingList);
    }

    @Override
    public final boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof Case))
	    return false;
	Case other = (Case) obj;
	return Objects.equals(maxWeight, other.maxWeight) && Objects.equals(thingList, other.thingList);
    }

}
