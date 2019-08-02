package com.yemre.model;

import org.junit.jupiter.api.Test;

import com.yemre.model.Case;

import nl.jqno.equalsverifier.EqualsVerifier;
/**
 * Test class for Case model
 * @author YunusEmre
 *
 */
public class CaseTest {

    @Test
    public void testEqualsHashCodeContracts() {
	EqualsVerifier.forClass(Case.class).verify();
    }
}
