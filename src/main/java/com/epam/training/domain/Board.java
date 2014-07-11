package com.epam.training.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Board {

	private final int size;

	private final List<Ship> shipList;

	private final Random random = new Random();

	public Board(final int size) {
		this.size = size;
		shipList = new ArrayList<>();
	}

	public void createShips(ShipType shipType, int piece) {
		for (int i = 0; i < piece; i++) {
			placeShip(shipType);
		}
	}

	private void placeShip(ShipType shipType) {
		boolean isPlacedOnBoard = false;

		Ship ship = null;
		while(!isPlacedOnBoard) {
			int positionX = random.nextInt(size);
			int positionY = random.nextInt(size);
			ship = createShip(shipType, positionX, positionY);

			isPlacedOnBoard = isOnBoard(ship);

			if (isPlacedOnBoard) {
				isPlacedOnBoard = !isShipAtTheSamePosition(ship);
			}
		}

		shipList.add(ship);
	}

	private boolean isShipAtTheSamePosition(Ship ship) {
		for (int i = 0; i < shipList.size(); i++) {
			if (ship.isOverLap(shipList.get(i))) {
				return true;
			}
		}

		return false;
	}

	private Ship createShip(ShipType shipType, int positionX, int positionY) {
		return new Ship(shipType, positionX, positionY);
	}

	private boolean isOnBoard(Ship ship) {
		ShipElement lastElement = ship.getLastElement();
		
		return isHorizontalOnBoard(lastElement) && isVerticalOnBoard(lastElement);
	}

	private boolean isVerticalOnBoard(ShipElement lastElement) {
		return 0 <= lastElement.getRelativePositionY() && lastElement.getRelativePositionY() < size;
	}

	private boolean isHorizontalOnBoard(ShipElement lastElement) {
		return 0 <= lastElement.getRelativePositionX() && lastElement.getRelativePositionX() < size;
	}

	public int getSize() {
		return size;
	}

	public List<Ship> getShips() {
		return Collections.unmodifiableList(shipList);
	}
}
