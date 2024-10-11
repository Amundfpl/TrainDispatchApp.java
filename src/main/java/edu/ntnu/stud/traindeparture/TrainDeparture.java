package edu.ntnu.stud.traindeparture;

import java.time.LocalTime;

/**
 * TrainDeparture is the main class for the train dispatch application. It holds the information of
 * the time a train departs, the line it is on and the train number. It also holds the information
 * of the destination, the track the train is departing from and any delays. It also has a method to
 * calculate the new time of the train, if there is a delay.
 *
 * @author Amund
 * @version 0.0.1
 * @since 18.10.2023
 */
public class TrainDeparture {

  private LocalTime departureTime;
  private String line;
  private Integer trainNumber;
  private String destination;
  private int track;
  private LocalTime delay;

  /**
   * This is the constructor for the TrainDeparture class. It takes in the departure time, the line,
   * the train number, the destination and the track. It also sets the delay to 00:00.
   *
   * @param departureTime The time the train departs, a 24_hour clock that does not take date into
   *                      account
   * @param line          The line the train is on. Multiple trains can be on the same line, but it
   *                      has to be at different times. Is displayed on the form "F4" or "B1".
   * @param trainNumber   The number of the train. This is unique for each train inside a 24_hour
   *                      window.
   * @param destination   The destination of the train.
   * @param track         The track the train sets off from. This is a whole number and if a train
   *                      is not set a track, it will be set to -1.
   */
  public TrainDeparture(LocalTime departureTime, String line, int trainNumber, String destination,
      int track) {
    setDepartureTime(departureTime);
    setLine(line);
    setTrainNumber(trainNumber);
    setDestination(destination);
    setTrack(track);
    this.delay = LocalTime.parse("00:00");
  }

  /**
   * This method gets the departure time of the train.
   *
   * @return departureTime
   */
  public LocalTime getDepartureTime() {
    return departureTime;
  }

  /**
   * This method sets the departure time of the train.
   *
   * @param departureTime is the time the train departs
   */
  public void setDepartureTime(LocalTime departureTime) {
    this.departureTime = departureTime;
  }

  /**
   * This method gets the line of the train.
   *
   * @return line
   */
  public String getLine() {
    return line;
  }

  /**
   * This method sets the line of the train.
   *
   * @param line is the line the train is on
   */
  public void setLine(String line) {
    this.line = line;
  }

  /**
   * This method gets the train number of the train.
   *
   * @return trainNumber
   */
  public Integer getTrainNumber() {
    return trainNumber;
  }

  /**
   * This method sets the train number of the train.
   *
   * @param trainNumber is the number of the train
   */
  public void setTrainNumber(int trainNumber) {
    this.trainNumber = trainNumber;
  }

  /**
   * This method gets the destination of the train.
   *
   * @return destination
   */
  public String getDestination() {
    return destination;
  }

  /**
   * This method sets the destination of the train.
   *
   * @param destination is the place where the train is sent to
   */
  public void setDestination(String destination) {
    this.destination = destination;
  }

  /**
   * This method gets the track of the train.
   *
   * @return track
   */
  public int getTrack() {
    return track;
  }

  /**
   * This method sets the track of the train.
   *
   * @param track is the track the train is departing from
   */
  public void setTrack(int track) {
    this.track = track;
  }

  /**
   * This method gets the delay of the train.
   *
   * @return delay
   */
  public LocalTime getDelay() {
    return delay;
  }

  /**
   * This method sets the delay of the train.
   *
   * @param delay is the delay on the train
   */
  public void setDelay(LocalTime delay) {
    this.delay = this.delay.plusHours(delay.getHour()).plusMinutes(delay.getMinute());
  }

  /**
   * This method gets the new time of the train if there is added a delay. If the new time is
   * before the departure time, the new time will be set to the departure time.
   *
   * @return newTime
   */
  public LocalTime getNewTime() {
    LocalTime newTime;
    newTime = departureTime.plusHours(delay.getHour()).plusMinutes(delay.getMinute());
    if (newTime.isBefore(departureTime)) {
      newTime = departureTime;
    }
    return newTime;
  }

}
