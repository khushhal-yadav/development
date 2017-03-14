package com.khush.elevator.controller;

import com.khush.elevator.component.Elevator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by khush on 14/03/2017.
 */
public class ElevatorController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final Set<Elevator> elevator;

    //to read request to control elevator
    private final ElevatorRequest elevatorRequest;

    @Autowired
    public ElevatorController(Set<Elevator> elevator, ElevatorRequest elevatorRequest) {
        this.elevator = elevator;
        this.elevatorRequest = elevatorRequest;
    }

    public void shudDownElevator() {
        log.info("Logic to shut down lifts");
    }

    public void startElevator() {
        log.info("Logic to start elevator");
    }

    public void reset() {
        log.info("Logic to reset elevator system");
    }

}
