package com.yemre.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * The class includes features of each thing in the test case
 * 
 * @author YunusEmre
 *
 */
public class Thing {
    private final int index;
    private final BigDecimal weight;
    private final int cost;

    public Thing(int index, BigDecimal weight, int cost) {
	this.index = index;
	this.weight = weight;
	this.cost = cost;
    }

    public int getIndex() {
	return index;
    }

    public BigDecimal getWeight() {
	return weight;
    }

    public int getCost() {
	return cost;
    }

    @Override
    public final int hashCode() {
	return Objects.hash(cost, index, weight);
    }

    @Override
    public final boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof Thing))
	    return false;
	Thing other = (Thing) obj;
	return cost == other.cost && index == other.index && Objects.equals(weight, other.weight);
    }
    
    @Override
        public String toString() {
    	return index + " ";
        }

}
