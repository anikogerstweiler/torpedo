package com.epam.training.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShipElementTest {

	@Test
	public void testConstructor() {
		//given
		int actualX = 0;
		int actualY = 0;
		ShipElement element = new ShipElement(actualX, actualY);
		
		//when
		int expectedX = element.getRelativePositionX();
		int expectedY = element.getRelativePositionY();
		
		//then
		assertEquals(expectedX, actualX);
		assertEquals(expectedY, actualY);
	}

}
