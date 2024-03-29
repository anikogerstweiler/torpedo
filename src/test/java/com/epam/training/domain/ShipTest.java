package com.epam.training.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ShipTest {

	@Test
	public void testCreateShipByTypeWhenShipIsOneElement() {
		//given
		List<ShipElement> elements = new ArrayList<>();
		elements.add(new ShipElement(0, 0));
		
		//when
		Ship ship = new Ship(ShipType.ONE_ELEMENT, 0, 0);
		ShipElement expected = elements.get(0);
		
		//then
		assertEquals(ship.getShipElements().size(), elements.size());
		assertEquals(expected.getRelativePositionX(), ship.getAbsolutePositionX());
		assertEquals(expected.getRelativePositionY(), ship.getAbsolutePositionY());
	}
	
	@Test
	public void testCreateShipByTypeWhenShipIsTwoElement() {
		//given
		List<ShipElement> elements = new ArrayList<>();
		ShipElement first = new ShipElement(0, 0);
		ShipElement second = new ShipElement(1, 0);
		elements.add(first);
		elements.add(second);
		
		//when
		Ship ship = new Ship(ShipType.TWO_ELEMENT, 0, 0);
		ShipElement actual = ship.getShipElements().get(0);

		//then
		assertEquals(ship.getShipElements().size(), elements.size());
		assertEquals(first.getRelativePositionX(), actual.getRelativePositionX());
		assertEquals(first.getRelativePositionY(), actual.getRelativePositionY());
	}
	
	@Test
	public void testCreateShipByTypeWhenShipIsThreeElement() {
		//given
		List<ShipElement> elements = new ArrayList<>();
		ShipElement first = new ShipElement(0, 0);
		elements.add(first);
		ShipElement second = new ShipElement(1, 0);
		elements.add(second);
		ShipElement third = new ShipElement(2, 0);
		elements.add(third);
		
		//when
		Ship ship = new Ship(ShipType.THREE_ELEMENT, 0, 0);
		
		//then
		assertEquals(ship.getShipElements().size(), elements.size());
		
		ShipElement actual = ship.getShipElements().get(0);
		assertEquals(first.getRelativePositionX(), actual.getRelativePositionX());
		assertEquals(first.getRelativePositionY(), actual.getRelativePositionY());
		
		actual = ship.getShipElements().get(1);
		assertEquals(second.getRelativePositionX(), actual.getRelativePositionX());
		assertEquals(second.getRelativePositionY(), actual.getRelativePositionY());
		
		actual = ship.getShipElements().get(2);
		assertEquals(third.getRelativePositionX(), actual.getRelativePositionX());
		assertEquals(third.getRelativePositionY(), actual.getRelativePositionY());
	}
	
	@Test
	public void testCreateShipByTypeWhenShipIsFourElement() {
		//given
		List<ShipElement> elements = new ArrayList<>();
		ShipElement first = new ShipElement(0, 0);
		elements.add(first);
		ShipElement second = new ShipElement(1, 0);
		elements.add(second);
		ShipElement third = new ShipElement(2, 0);
		elements.add(third);
		ShipElement fourth = new ShipElement(3, 0);
		elements.add(fourth);
		
		//when
		Ship ship = new Ship(ShipType.FOUR_ELEMENT, 0, 0);
		
		//then
		assertEquals(ship.getShipElements().size(), elements.size());
		
		ShipElement actual = ship.getShipElements().get(0);
		assertEquals(first.getRelativePositionX(), actual.getRelativePositionX());
		assertEquals(first.getRelativePositionY(), actual.getRelativePositionY());
		
		actual = ship.getShipElements().get(1);
		assertEquals(second.getRelativePositionX(), actual.getRelativePositionX());
		assertEquals(second.getRelativePositionY(), actual.getRelativePositionY());
		
		actual = ship.getShipElements().get(2);
		assertEquals(third.getRelativePositionX(), actual.getRelativePositionX());
		assertEquals(third.getRelativePositionY(), actual.getRelativePositionY());
		
		actual = ship.getShipElements().get(3);
		assertEquals(fourth.getRelativePositionX(), actual.getRelativePositionX());
		assertEquals(fourth.getRelativePositionY(), actual.getRelativePositionY());
	}
	
	@Test
	public void testCreateShipByTypeWhenShipIsFourElementWithTop() {
		//given
		List<ShipElement> elements = new ArrayList<>();
		ShipElement first = new ShipElement(1, 0);
		elements.add(first);
		ShipElement second = new ShipElement(0, 1);
		elements.add(second);
		ShipElement third = new ShipElement(1, 1);
		elements.add(third);
		ShipElement fourth = new ShipElement(2, 1);
		elements.add(fourth);
		
		//when
		Ship ship = new Ship(ShipType.FOUR_ELEMENT_WITH_TOP, 0, 0);
		
		//then
		assertEquals(ship.getShipElements().size(), elements.size());
		
		ShipElement actual = ship.getShipElements().get(0);
		assertEquals(first.getRelativePositionX(), actual.getRelativePositionX());
		assertEquals(first.getRelativePositionY(), actual.getRelativePositionY());
		
		actual = ship.getShipElements().get(1);
		assertEquals(second.getRelativePositionX(), actual.getRelativePositionX());
		assertEquals(second.getRelativePositionY(), actual.getRelativePositionY());
		
		actual = ship.getShipElements().get(2);
		assertEquals(third.getRelativePositionX(), actual.getRelativePositionX());
		assertEquals(third.getRelativePositionY(), actual.getRelativePositionY());
		
		actual = ship.getShipElements().get(3);
		assertEquals(fourth.getRelativePositionX(), actual.getRelativePositionX());
		assertEquals(fourth.getRelativePositionY(), actual.getRelativePositionY());
	}
	
	@Test
	public void testIsOverLapWhenCheckItselfReturnsTrue() {
		//given
		Ship ship = new Ship(ShipType.ONE_ELEMENT, 0, 0);
		
		//when
		boolean overLapped = ship.isOverLap(ship);
		
		//then
		assertTrue(overLapped);
	}
	
	@Test
	public void testIsOverLapWhenOverLapReturnsTrue() {
		//given
		Ship ship = new Ship(ShipType.ONE_ELEMENT, 0, 0);
		Ship other = new Ship(ShipType.TWO_ELEMENT, 0, 0);
		
		//when
		boolean overLapped = ship.isOverLap(other);
		
		//then
		assertTrue(overLapped);
	}
	
	@Test
	public void testIsOverLapWhenNotOverLapReturnsFalse() {
		//given
		Ship ship = new Ship(ShipType.ONE_ELEMENT, 0, 0);
		Ship other = new Ship(ShipType.THREE_ELEMENT, 1, 1);

		//when
		boolean overLapped = ship.isOverLap(other);

		//then
		assertFalse(overLapped);
	}

}
