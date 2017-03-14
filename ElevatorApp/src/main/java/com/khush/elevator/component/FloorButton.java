package com.khush.elevator.component;

import com.khush.elevator.controller.ElevatorRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by khush on 14/03/2017.
 */
public class FloorButton extends Button {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Direction direction;

    private final ElevatorRequest request;

    @Autowired
    public FloorButton(ElevatorRequest request) {
        this.request = request;
    }


    @Override
    public void placeRequest(ElevatorRequest request) {

    }
}
