package edu.ntnu.stud.inputvalidator;

import edu.ntnu.stud.station.Station;
import edu.ntnu.stud.traindeparture.TrainDeparture;
import java.time.LocalTime;
import java.util.Iterator;

/**
 * This class takes care of the input validation It checks if the input is valid and returns a
 * string with the error message. If the input is valid, it returns "OK" If the input is invalid, it
 * returns a string with the error message If the input is valid, but there is an error, it returns
 * a string with the error message
 */

public class InputValidator {

  /**
   * This method checks if the input on the format Localtime is valid It also checks if the input is
   * before the current time.
   *
   * @param departureTime is the time the train departs
   * @param station       is the station where the train departs from
   * @return validator
   */

  public String checkLocalTime(String departureTime, Station station) {
    String validator = "OK";
    try {
      if (LocalTime.parse(departureTime).isBefore(station.getClock())) {
        validator = "afterCurrentTime";
      }
    } catch (Exception e) {
      validator = "invalidTimeInput";
    }
    return validator;
  }

  /**
   * This method checks the delay input It checks if the input is valid and if the delay combined
   * with the department is more than 24 hours. New time is the department time and the delay added
   * together. If the hour plus minutes divided by 60 is more than 24 hours you get an error. If the
   * delay is over 24 hours you get an errormessage.
   *
   * @param delayString    is a string of the delay on the format local time
   * @param trainDeparture is the train that is delayed
   * @return validator
   */
  public String checkDelay(String delayString, TrainDeparture trainDeparture) {
    String validator = "OK";
    int hours;
    int minutes;
    try {
      LocalTime delay = LocalTime.parse(delayString);
      hours = delay.getHour() + trainDeparture.getNewTime().getHour();
      minutes = delay.getMinute() + trainDeparture.getNewTime().getMinute();
      if (hours + (minutes) / 60 >= 24) {
        validator = "delayMoreThanNextDay";
      }
    } catch (Exception e) {
      validator = "invalidTimeInput";
    }
    return validator;
  }

  /**
   * This method checks the line input It checks if the input is valid which means they have to
   * start at least with one capital letter and one number If there is necessary for more lines u
   * can add up to two capital letters as the two first characters and up to two numbers as the two
   * last characters. This gives the option of 26*26*10*10 = 67600 different lines If the input is
   * invalid it returns an error message
   *
   * @param line is the line the train is on
   * @return validator
   */

  public String checkLine(String line) {
    String validator = "OK";
    try {
      if (!line.matches("^[A-ZÆØÅ]{1,2}\\d{1,2}$")) {
        validator = "InvalidLineInput";
      }
    } catch (Exception e) {
      validator = "InvalidInput";
    }
    return validator;
  }

  /**
   * This method checks the train number input. It checks if the input is valid and if the train
   * number already exists. If the trainNumber exist it returns an error message otherwise it
   * returns "OK" and it has completed the test
   *
   * @param trainNumber is the number of the train
   * @param station     is the station where the train departs from
   * @return validator
   */

  public String checkTrainNumber(String trainNumber, Station station) {
    String validator = "OK";
    Iterator<TrainDeparture> trainDepartureList = station.getTrainDepartureSorted();
    try {
      Integer.parseInt(trainNumber);
      Iterator<TrainDeparture> it;
      for (it = trainDepartureList; it.hasNext(); ) {
        TrainDeparture trainDeparture = it.next();
        if (trainDeparture.getTrainNumber().equals(Integer.parseInt(trainNumber))) {
          validator = "trainNumberError";
        }
      }
    } catch (Exception e) {
      validator = "invalidInput";
    }
    return validator;
  }

  /**
   * This method checks if the train number already exists It checks if the input is valid and if
   * the train number already exists. If the trainNumber does not exist it returns an error message
   * otherwise it returns "OK" and it has completed the test
   *
   * @param trainNumber is the unique number of the train
   * @param station     is the station where the train departs from
   * @return validator
   */

  public String checkIfTrainNumberExists(String trainNumber, Station station) {
    String validator = "OK";
    try {
      int parsedTrainNumber = Integer.parseInt(trainNumber);

      if (!station.trainNumberExists(parsedTrainNumber)) {
        validator = "noTrainNumber";
      }
    } catch (NumberFormatException e) {
      validator = "Invalid input";
    }
    return validator;
  }

  /**
   * This method checks the destination input. It has to start with a capital letter and can only
   * consist of letters from A-Z and æøå It checks if the input is valid and if the destination
   * exists If the destination does not exist it returns an error message
   *
   * @param destination is the place where the train is sent to
   * @return validator
   */

  public String checkDestination(String destination) {
    String validator = "OK";
    try {
      if (!destination.matches("^[A-ZÆØÅ][a-zæøåA-ZÆØÅ]*$")) {
        validator = "InvalidDestinationInput";
      }
    } catch (Exception ex) {
      validator = "Destination does not exist";
    }
    return validator;
  }

  /**
   * This method checks if the destination already exists It checks if the input is valid and if the
   * destination already exists. The input has to start with a capital letter and can only consist
   * of letters from A-Z and æøå If the destination exist it returns an error message
   *
   * @param destination is the place where the train is sent to
   * @param station     is the station where the train departs from
   * @return validator
   */

  public String checkIfDestinationAlreadyExists(String destination, Station station) {
    String validator = "OK";
    try {
      if (!destination.matches("^[A-ZÆØÅ][a-zæøåA-ZÆØÅ]*$")) {
        validator = "InvalidDestinationInput";
      } else if (!station.destinationExists(destination)) {
        validator = "noDestination";
      }
    } catch (Exception e) {
      validator = "needToEnterDestination";
    }
    return validator;
  }

  /**
   * This method checks the track input It checks if the input is an integer. If the input is
   * invalid it returns an error message
   *
   * @param track is the track the train is departing from
   * @return validator
   */

  public String checkTrack(String track) {
    String validator = "OK";
    try {
      Integer.parseInt(track);
    } catch (Exception e) {
      validator = "Invalid track input";
    }
    return validator;
  }
}
