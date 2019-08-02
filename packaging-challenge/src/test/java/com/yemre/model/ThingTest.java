package com.yemre.model;

import org.junit.jupiter.api.Test;

import com.yemre.model.Thing;

import nl.jqno.equalsverifier.EqualsVerifier;
/**
 * Test class for Thing model
 * @author YunusEmre
 *
 */
public class ThingTest {

    @Test
    public void testEqualsHashCodeContracts() {
	EqualsVerifier.forClass(Thing.class).verify();
    }
}
