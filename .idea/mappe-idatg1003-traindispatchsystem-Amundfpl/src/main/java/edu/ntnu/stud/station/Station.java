package edu.ntnu.stud.station;

import edu.ntnu.stud.traindeparture.TrainDeparture;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/**
 * This class takes care of the trains It holds the information of the time a train departs, the
 * line it is on and the train number. The station also holds the information of the destination,
 * the track the train is departing from and any delays. If there is a delay on a train, the station
 * will calculate the new time of the train. To check for existing train numbers the station has a
 * hashmap with the train number as the key and the train as the value.
 */

public class Station {

  private LocalTime clock = LocalTime.parse("00:00");
  private final HashMap<Integer, TrainDeparture> trainDepartureList;

  /**
   * This is the constructor for the Station class. It initializes the hashmap for the train
   * departures.
   */
  public Station() {
    trainDepartureList = new HashMap<>();
  }

  /**
   * This method checks if the train number exists in the hashmap.
   *
   * @param trainNumber the individual number of the train
   * @return boolean
   */
  public boolean trainNumberExists(int trainNumber) {
    return trainDepartureList.containsKey(trainNumber);
  }

  /**
   * This method checks if the destination exists in the hashmap.
   *
   * @param destination is the place where the train is sent to
   * @return boolean
   */
  public boolean destinationExists(String destination) {
    return trainDepartureList.values().stream().anyMatch(
        traindeparture -> traindeparture.getDestination().trim().equals(destination));
  }

  /**
   * This method checks the trains if the new time is before the station time (clock) The new time
   * is just the department time plus the potential delay on the train. So it can also filter the
   * trains with added delay. It will only keep the elements with the new time, not before the
   * clock. And filter them by departure time.
   *
   * @return Iterator
   */
  public Iterator<TrainDeparture> getTrainDepartureSorted() {
    return trainDepartureList.values().stream()
        .filter(traindeparture -> !traindeparture.getNewTime().isBefore(clock))
        .sorted(Comparator.comparing(TrainDeparture::getDepartureTime)).iterator();
  }

  /**
   * getClock returns the clock on the station.
   *
   * @return clock
   */
  public LocalTime getClock() {
    return clock;
  }

  /**
   * This method sets the clock on the station.
   *
   * @param clock is the time on the station
   */
  public void setClock(LocalTime clock) {
    this.clock = clock;
  }

  /**
   * This method sets the departure time, line, train number, destination and track of a train. It
   * adds the train to the hashmap with the train number as the key and the train as the value.
   *
   * @param departureTime the time the train leaves the station
   * @param line          the line the train is on
   * @param trainNumber   the individual number of the train
   * @param destination   the place where the train is sent to
   * @param track         the track the train is departing from
   */

  public void setDeparture(LocalTime departureTime, String line, int trainNumber,
      String destination, int track) {
    TrainDeparture train = new TrainDeparture(departureTime, line, trainNumber, destination, track);
    trainDepartureList.put(train.getTrainNumber(), train);
  }

  /**
   * This method initializes the trains It adds train to the hashmap with the departure time, line,
   * train number, destination and track.
   */
  public void initializeTrain() {
    setDeparture(LocalTime.parse("12:00"), "F1", 122, "Oslo", 1);
    setDeparture(LocalTime.parse("12:01"), "F2", 123, "Drammen", 2);
    setDeparture(LocalTime.parse("12:02"), "F2", 124, "Bodø", 3);
    setDeparture(LocalTime.parse("12:03"), "F3", 125, "Trondheim", 4);
    setDeparture(LocalTime.parse("12:04"), "F4", 126, "Stavanger", 5);
  }

  /**
   * This method goes through the hashmap and returns the train with the train number.
   *
   * @param trainNumber the individual number of the train
   * @return train
   */
  public TrainDeparture getTrainByNumber(int trainNumber) {
    return trainDepartureList.get(trainNumber);
  }
}