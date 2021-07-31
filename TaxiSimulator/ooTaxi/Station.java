package ooTaxi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class that holds the number of persons arriving by train at the station and
 * is waiting for a taxi.
 * 
 * @author Nayeong Kim (s1006313)
 */
public class Station {

    private int nrOfPassengersAtStation = 0;
    private int totalNrOfPassengers = 0;
    private boolean isClosed = false;
    private Lock lock = new ReentrantLock(true);
    private Condition anyPassengers = lock.newCondition();
    private Condition noPassengers = lock.newCondition();
    
    public void enterStation(int nrOfPassengers) {
        lock.lock();
        try {
            nrOfPassengersAtStation += nrOfPassengers;
            totalNrOfPassengers += nrOfPassengers;
            System.out.println(nrOfPassengers + " passengers arrived at station");
        } finally {
            lock.unlock();
        }
    }
    /**
     * Ask for nrOfPassengers Passengers to leave the station
     *
     * @param nrOfPassengers
     */
    public void leaveStation(int nrOfPassengers) {
      lock.lock();
        try {
            if ( nrOfPassengers <= nrOfPassengersAtStation )
                nrOfPassengersAtStation -= nrOfPassengers;
            else
                System.out.println( "leaveStation(" + nrOfPassengers + ") there are only "
                        + nrOfPassengersAtStation + " passengers at the station." );
        } finally {
            lock.unlock();
        }
    }

    public int getWaitingPassengers() {
        try{
            lock.lock();
            return nrOfPassengersAtStation;
        }finally{
            lock.unlock();
        }
        
    }
    
    public void close() {
        isClosed = true;
    }
    
    public boolean isClosed() {
        return isClosed;     
    }

    public int getTotalNrOfPassengers() {
        return totalNrOfPassengers;
    }
    
    public Lock getLock(){
        return lock;
    }
    
    public Condition getAnyPassengers(){
        return anyPassengers;
    }
    
    public Condition getNoPassengers(){
        return noPassengers;
    }
    
}