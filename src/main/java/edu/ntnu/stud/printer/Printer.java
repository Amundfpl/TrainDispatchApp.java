package edu.ntnu.stud.printer;

import edu.ntnu.stud.station.Station;
import edu.ntnu.stud.stringutlilty.ColorPrint;
import edu.ntnu.stud.traindeparture.TrainDeparture;
import java.time.LocalTime;

/**
 * This class takes care of all the printing output to the user It includes error messages and the
 * menu.
 */

public class Printer {

  /**
   * This field holds the values for the output placement for the train departures.
   */
  private final String trainOutputPlacement = "%-14s | %-4s | %-12s | %-12s | %-5s | %-8s";

  /**
   * This method prints the header for the train departures. It uses the trainOutputPlacement field
   * to place the headers in the correct place.
   */

  public void header() {
    System.out.println(String.format(trainOutputPlacement,
        ColorPrint.ANSI_UNDERLINE + "Departure time",
        "Line",
        "Train number",
        "Destination",
        "Track",
        "Delay" + ColorPrint.ANSI_RESET));
  }

  /**
   * This method prints the menu for the user. It uses the ColorPrint class to color the menu.
   */
  public void menu() {
    System.out.println(ColorPrint.ANSI_PURPLE + "1. Show all departures");
    System.out.println("2. Add a new train");
    System.out.println("3. Assign a track to a departure");
    System.out.println("4. Add a delay to a departure");
    System.out.println("5. Search for a departure by train number");
    System.out.println("6. Search for a departure by destination");
    System.out.println("7. Update the clock");
    System.out.println("8. Exit");
    System.out.println("Enter your choice: ");
  }

  /**
   * This method prints the goodbye message when the user exits the program.
   */

  public void exit() {
    System.out.println("Good bye");
  }

  /**
   * This method prints the message for the user to enter the destination.
   */
  public void enterDestination() {
    System.out.println("Enter the destination: ");
  }

  /**
   * This method prints the message for the user to enter the train number.
   */
  public void enterTrainNumber() {
    System.out.println("Enter a unique train number: ");
  }

  /**
   * This method prints the message for the user to enter the track.
   */
  public void enterTrack() {
    System.out.println("Enter the track like (F1): ");
  }

  /**
   * This method prints the message for the user to enter the delay.
   */
  public void enterDelay() {
    System.out.println("Enter the delay on the format (hh:mm): ");
  }

  /**
   * This method prints the message for the user to enter the line.
   */
  public void enterLine() {
    System.out.println("Enter the line: ");
  }

  /**
   * This method prints the message for the user to enter the departure time.
   */
  public void enterDepartureTime() {
    System.out.println("Enter the departure time: ");
  }

  /**
   * This method prints the current time. It uses the method getClock in the station class to get
   * the time.
   *
   * @param station is the class that holds the clock and the trains
   */
  public void printTime(Station station) {
    System.out.println("Current time: " + station.getClock());
  }

  /**
   * This method prints the message for the user to enter the time.
   */
  public void enterTime() {
    System.out.println("Enter the time on the format (hh:mm): ");
  }

  /**
   * This method prints the train departures. It uses the trainOutputPlacement field to place the
   * train departures in the correct place. The method gets the different values from the train
   * departure class. Inside printTrainDeparture is the use of conditional operators or ternary
   * operators. The conditional operator checks if the track is -1 and displays a "-" instead of -1.
   * If this is false there is a separator that displays the track. It also checks if the delay is
   * 00:00 and displays a "-" instead of 00:00. If the statement is false, through the separator it
   * displays the delay.
   *
   * @param trainDeparture is the class that holds the train information.
   */
  public void printTrainDeparture(TrainDeparture trainDeparture) {
    System.out.println(String.format(trainOutputPlacement,
        trainDeparture.getDepartureTime() + "   " + (trainDeparture.getNewTime()
            .equals(trainDeparture.getDepartureTime()) ? "" : ColorPrint.ANSI_GREEN
            + trainDeparture.getNewTime() + ColorPrint.ANSI_RESET + " "),
        trainDeparture.getLine(),
        trainDeparture.getTrainNumber(),
        trainDeparture.getDestination(),
        trainDeparture.getTrack() == -1 ? "-" : trainDeparture.getTrack(),
        trainDeparture.getDelay() == LocalTime.parse("00:00") ? "-" : trainDeparture.getDelay()));
  }

  /**
   * This method prints the error message destination does not exist.
   */
  public void errorNoDestination() {
    System.out.println(ColorPrint.ANSI_RED
        + "Destination does not exist"
        + ColorPrint.ANSI_RESET);
  }

  /**
   * This method prints the error message train number already exists.
   */
  public void errorTrainNumberExists() {
    System.out.println(ColorPrint.ANSI_RED
        + "Train number already exist"
        + ColorPrint.ANSI_RESET);
  }

  /**
   * This method prints the error message invalid train number.
   */
  public void errorInvalidTrainNumber() {
    System.out.println(ColorPrint.ANSI_RED
        + "Invalid train number input. Have to be a number or combination of numbers like (123)"
        + ColorPrint.ANSI_RESET);
  }

  /**
   * This is the default error message. It only works as a backup if the other error messages does
   * not print.
   */
  public void errorDefault() {
    System.out.println(ColorPrint.ANSI_RED
        + "Invalid input"
        + ColorPrint.ANSI_RESET);
  }

  /**
   * This method prints the error message for invalid line input.
   */
  public void errorLineInput() {
    System.out.println(ColorPrint.ANSI_RED
        + "Invalid line input. Have to be on the format: (F1)"
        + ColorPrint.ANSI_RESET);
  }

  /**
   * This method prints the error message for invalid time given by the user.
   */
  public void errorAfterCurrentTime() {
    System.out.println(ColorPrint.ANSI_RED
        + "Invalid time given. Have to be after current time"
        + ColorPrint.ANSI_RESET);
  }

  /**
   * This method prints the error message for invalid time input.
   */
  public void errorTimeInput() {
    System.out.println(ColorPrint.ANSI_RED
        + "Invalid time input. Have to be like (hh:mm) and cant be more than 23:59"
        + ColorPrint.ANSI_RESET);
  }

  /**
   * This method prints the error message for invalid track input.
   */
  public void errorTrackInput() {
    System.out.println(ColorPrint.ANSI_RED
        + "Invalid track input. Have to be a whole number like (1)"
        + ColorPrint.ANSI_RESET);
  }

  /**
   * This prints the error message that the train number doesn't exist.
   */
  public void errorNoTrainNumber() {
    System.out.println(ColorPrint.ANSI_RED
        + "Train number does not exist"
        + ColorPrint.ANSI_RESET);
  }

  /**
   * This method prints the error message for no given destination.
   */
  public void errorEnterDestination() {
    System.out.println(ColorPrint.ANSI_RED
        + "Please enter a destination"
        + ColorPrint.ANSI_RESET);
  }

  /**
   * This method prints the error message for a too big delay that overwrites the day.
   */
  public void errorDelayLessThanNextDay() {
    System.out.println(ColorPrint.ANSI_RED
        + "Delay can not go past current day"
        + ColorPrint.ANSI_RESET);
  }

  /**
   * This method prints the error message for invalid destination input.
   */
  public void errorDestinationInput() {
    System.out.println(ColorPrint.ANSI_RED
        + "The destination can only consist of letters and has to start with an uppercase letter"
        + ColorPrint.ANSI_RESET);
  }
}
