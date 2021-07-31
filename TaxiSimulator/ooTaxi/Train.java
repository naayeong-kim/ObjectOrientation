package ooTaxi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The train brings a number of passengers to a station in the simulation.
 *
 * @author Nayeong Kim (s1006313)
 */
public class Train implements Runnable {

    private int nrOfPassengers;
    private final Station station;
    private int nrOfTrips = 0;
    private static final int MIN_TRAVELLERS = 60;
    private static final int MAX_TRAVELLERS = 90;
    private final int MAX_TRAIN_TRIPS = 10;
    private Lock lock;

    public Train(Station station) {
        this.station = station;
        this.nrOfPassengers = 0;
        this.lock = station.getLock();
    }

    /**
     * Populate this train with number nrOfPassengers
     *
     * @param number the number of passengers of this train
     */
    public void loadPassengers(int number) {
        lock.lock();
        try {
            nrOfPassengers = number;
        } finally {
            lock.unlock();
        }
    }

    /**
     * empties this train and augment the number of Passengers at the station
     * with this nrOfPassenegers
     */
    public void unloadPassengers() {
        lock.lock();
        try {
            nrOfTrips += 1;
            station.enterStation(nrOfPassengers);
        } finally {
            lock.unlock();
        }
    }

    public void closeStation() {
        station.close();
    }

    public int getNrOfTrips() {
        return nrOfTrips;
    }

    @Override
    public void run() {
        while (nrOfTrips <= MAX_TRAIN_TRIPS) {
            lock.lock();
            try {

                while (station.getWaitingPassengers() > 0) {
                    try {
                        station.getNoPassengers().await();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                loadPassengers(Util.getRandomNumber(MIN_TRAVELLERS, MAX_TRAVELLERS));
                unloadPassengers();
                station.getAnyPassengers().signalAll();

                
            } finally {
                lock.unlock();
            }
        }
        closeStation();
    }
}
