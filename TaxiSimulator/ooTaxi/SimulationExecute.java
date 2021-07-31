/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooTaxi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Nayeong Kim (s1006313)
 * Trace at the end of the file
 */
class SimulationExecute {

    private final Station station;
    private final Train train;
    private final Taxi[] taxis;
    private static final int CAPACITY_SMALL = 4;
    private static final int CAPACITY_LARGE = 7;
    private static final int TIME_SMALL = 2;
    private static final int TIME_LARGE = 3;

    public SimulationExecute() {
        this.station = new Station();
        this.train = new Train(station);
        this.taxis = new Taxi[4];

        taxis[0] = new Taxi(1, CAPACITY_SMALL, TIME_SMALL, station);
        taxis[1] = new Taxi(2, CAPACITY_SMALL, TIME_SMALL, station);
        taxis[2] = new Taxi(3, CAPACITY_LARGE, TIME_LARGE, station);
        taxis[3] = new Taxi(4, CAPACITY_LARGE, TIME_LARGE, station);

    }

    void sim() throws InterruptedException {
        ExecutorService e = Executors.newCachedThreadPool();

        e.execute(train);
        for (Taxi taxi : taxis) {
            e.execute(taxi);
        }
        e.shutdown();

        
    
            boolean stopped = e.awaitTermination(2, TimeUnit.SECONDS);
            if (stopped) {
                showStatistics();
            }
            else{
                e.shutdown();
                showStatistics();
                System.exit(0);
            }
        
    

}

public void showStatistics() {
    System.out.println("All persons have been transported");
    System.out.println("Total transport time in this simulation:" + getTotalTime(taxis));
    System.out.println("Total number of train travelers: " + station.getTotalNrOfPassengers());
    System.out.println("Total number of persons transported in this simulation: " + getTotalNrOfPassengers(taxis));
  }
    
    private static int getTotalTime(Taxi[] taxis) {
    int time = 0;
    for (Taxi taxi : taxis) {
      time += taxi.getTotalTransportationTime();
    }
    return time;
  }
    private static int getTotalNrOfPassengers(Taxi[] taxis) {
    int total = 0;
    for (Taxi taxi : taxis) {
      total += taxi.getTotalNrOfPassengers();
    }
    return total;
  }

}

/*
run:
Taxi 1 created
Taxi 2 created
Taxi 3 created
Taxi 4 created
66 passengers arrived at station
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
70 passengers arrived at station
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
61 passengers arrived at station
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 2 passengers
88 passengers arrived at station
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
68 passengers arrived at station
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 2 passengers
68 passengers arrived at station
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 2 passengers
85 passengers arrived at station
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 4 passengers
84 passengers arrived at station
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 3 passengers
68 passengers arrived at station
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 2 passengers
72 passengers arrived at station
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 2 passengers
69 passengers arrived at station
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 4 passengers
Taxi 2 takes 4 passengers
Taxi 3 takes 7 passengers
Taxi 4 takes 7 passengers
Taxi 1 takes 3 passengers
All persons have been transported
Total transport time in this simulation:374
Total number of train travelers: 799
Total number of persons transported in this simulation: 799
*/