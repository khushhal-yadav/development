package com.khush.elevator.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by khush on 14/03/2017.
 */
public class Elevator {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private int currentFloor;

    public void moveUp(int toFloor) {
        log.info("move up");
    }

    public void moveDown(int toFloor) {
        log.info("move down");
    }

    public void openDoor() {
        log.info("open door");
    }

    public void closeDoor() {
        log.info("close door");
    }




}
