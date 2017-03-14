package com.khush.elevator.controller;

import com.khush.elevator.scheduler.RequestSchedulingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by khush on 14/03/2017.
 */
public class ElevatorRequest {

    private Queue<ElevatorRequest> request = new LinkedBlockingQueue<ElevatorRequest>();

    //desired scheduling algorithm can be used to process requests
    private final RequestSchedulingAlgorithm requestSchedulingAlgorithm;

    @Autowired
    public ElevatorRequest(RequestSchedulingAlgorithm requestSchedulingAlgorithm) {
        this.requestSchedulingAlgorithm = requestSchedulingAlgorithm;
    }

    public void addRequest(ElevatorRequest request) {
        this.request.add(request);
    }

    public void removeRequest(ElevatorRequest request) {
        this.request.remove(request);
    }

    public ElevatorRequest getNextRequestToProcess() {
        return this.request.peek();
    }
}

