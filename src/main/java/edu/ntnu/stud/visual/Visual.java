package edu.ntnu.stud.visual;

import edu.ntnu.stud.inputvalidator.InputValidator;
import edu.ntnu.stud.printer.Printer;
import edu.ntnu.stud.station.Station;
import edu.ntnu.stud.stringutlilty.StringUtility;
import edu.ntnu.stud.traindeparture.TrainDeparture;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class takes care of the visual part of the program It obtains the methods from the other
 * classes and uses them to display the information to the user.
 */

public class Visual {

  private final InputValidator validator;
  private final Scanner inputReader;
  private final Station station;
  private final Printer printer;

  /**
   * This is the constructor for the Visual class. It initializes the scanner, the input validator,
   * the station and the printer.
   */

  public Visual() {
    inputReader = new Scanner(System.in);
    validator = new InputValidator();
    station = new Station();
    printer = new Printer();

  }

  /**
   * This method starts the program It displays the menu and asks for input Through a switch-case it
   * gives the user the option to choose between eight different functions.
   */
  public void start() {
    String choice = "0";
    station.initializeTrain();
    while (!choice.equals("8")) {
      printer.menu();
      choice = inputReader.nextLine();
      switch (choice) {
        case StringUtility.SHOW_ALL_DEPARTURES -> showAllDepartures();
        case StringUtility.ADD_TRAIN -> addTrain();
        case StringUtility.ASSIGN_TRACK -> assignTrack();
        case StringUtility.ADD_DELAY -> addDelay();
        case StringUtility.SEARCH_BY_TRAIN_NUMBER -> searchByTrainNumber();
        case StringUtility.SEARCH_BY_DESTINATION -> searchByDestination();
        case StringUtility.UPDATE_CLOCK -> updateClock();
        default -> printer.exit();
      }
    }
  }

  /**
   * This method asks for the information needed to add a train It asks for the departure time, the
   * line, the train number and the destination addTrain uses other methods to check for the
   * validity of the input. It then calls the setDeparture method in the station class and makes a
   * train The train is then added to the hashmap in the station class.
   */

  public void addTrain() {
    LocalTime departureTime = askForDepartureTime();
    String line = askForLine();
    Integer trainNumber = askForTrainNumber();
    String destination = askForDestination();
    station.setDeparture(departureTime, line, trainNumber, destination, -1);
  }

  /**
   * askForDestination asks for the destination of the train. It then sends it to the validator to
   * check if the input is valid and follows the rules. If the input is valid, it returns the
   * destination which is used by the addTrain method. Else it sends a fitting error message to the
   * user.
   *
   * @return destination
   */

  private String askForDestination() {
    String validDestination = "";
    boolean flag = false;
    while (!flag) {
      printer.enterDestination();
      String destination = inputReader.nextLine();
      String validation = validator.checkDestination(destination);
      switch (validation) {
        case "OK" -> {
          validDestination = destination;
          flag = true;
        }
        case "InvalidDestinationInput" -> printer.errorDestinationInput();
        case "Destination does not exist" -> printer.errorNoDestination();
        default -> printer.errorDefault();
      }
    }
    return validDestination;
  }

  /**
   * askForTrainNumber asks for the train number of the train. It then sends it to the validator to
   * check if the input is valid and follows the rules. If the input is valid, it returns the train
   * number which is used by the addTrain method. Else it sends a fitting error message to the
   * user.
   *
   * @return trainNumber
   */

  private Integer askForTrainNumber() {
    int validTrainNumber = 0;
    boolean flag = false;
    while (!flag) {
      printer.enterTrainNumber();
      String trainNumberString = inputReader.nextLine();
      String validation = validator.checkTrainNumber(trainNumberString, station);
      switch (validation) {
        case "OK" -> {
          validTrainNumber = Integer.parseInt(trainNumberString);
          flag = true;
        }
        case "trainNumberError" -> printer.errorTrainNumberExists();
        case "invalidInput" -> printer.errorInvalidTrainNumber();
        default -> printer.errorDefault();
      }
    }
    return validTrainNumber;
  }

  /**
   * askForLine asks for the line of the train. It then sends it to the validator to check if the
   * input is valid and follows the rules. If the input is valid, it returns the line which is used
   * by the addTrain method. Else it sends a fitting error message to the user.
   *
   * @return line
   */

  private String askForLine() {
    String validLine = "";
    boolean flag = false;
    while (!flag) {
      printer.enterLine();
      String line = inputReader.nextLine();
      String validation = validator.checkLine(line);
      if (validation.equals("OK")) {
        validLine = line;
        flag = true;
      } else {
        printer.errorLineInput();
      }
    }
    return validLine;
  }

  /**
   * askForDepartureTime asks for the departure time of the train. It then sends it to the validator
   * to check if the input is valid and follows the rules. If the input is valid, it returns the
   * departure time which is used by the addTrain method. Else it sends a fitting error message to
   * the user.
   *
   * @return departureTime
   */

  private LocalTime askForDepartureTime() {
    LocalTime validTime = LocalTime.parse("00:00");
    boolean flag = false;
    while (!flag) {
      printer.enterDepartureTime();
      String departureTime = inputReader.nextLine();
      String validation = validator.checkLocalTime(departureTime, station);
      switch (validation) {
        case "OK" -> {
          validTime = LocalTime.parse(departureTime);
          flag = true;
        }
        case "afterCurrentTime" -> printer.errorAfterCurrentTime();
        case "invalidInput" -> printer.errorTimeInput();
        default -> printer.errorDefault();
      }
    }
    return validTime;
  }

  /**
   * showAllDepartures prints all the trains in the hashmap. The method gets the sorted trains from
   * a getTrainDepartureSorted in the station class. It uses the iterator to go through the hashmap
   * and print the information of each train. It also prints the current time of the station.
   */

  public void showAllDepartures() {
    printer.printTime(station);
    Iterator<TrainDeparture> trainDepartureList = station.getTrainDepartureSorted();
    printer.header();
    Iterator<TrainDeparture> it;
    for (it = trainDepartureList; it.hasNext(); ) {
      TrainDeparture trainDeparture = it.next();
      printer.printTrainDeparture(trainDeparture);
    }
  }

  /**
   * assignTrack asks for the track of the train. It then sends it to the validator to check if the
   * input is valid and follows the rules. First it takes in the train number to check if the train
   * exists. Then it iterates through the sorted trainDepartureList to find the train with the train
   * number. It then sets the track of the train.
   */

  public void assignTrack() {
    int track;
    int trainNumber;
    showAllDepartures();
    trainNumber = enterExistingTrainNumber();
    track = enterTrack();
    for (Iterator<TrainDeparture> it = station.getTrainDepartureSorted(); it.hasNext(); ) {
      TrainDeparture trainDeparture = it.next();
      if (trainDeparture.getTrainNumber().equals(trainNumber)) {
        trainDeparture.setTrack(track);
      }
    }
  }

  /**
   * enterTrack asks for the track of the train. It then sends it to the validator to check if the
   * input is valid and follows the rules. If the input is valid, it returns the track which is used
   * by the assignTrack method. Else it sends a fitting error message to the user.
   *
   * @return track
   */

  public Integer enterTrack() {
    boolean flag = false;
    int track = 0;
    while (!flag) {
      printer.enterTrack();
      String trackString = inputReader.nextLine().trim();
      String trackValidation = validator.checkTrack(trackString);
      if (trackValidation.equals("OK")) {
        track = Integer.parseInt(trackString);
        flag = true;
      } else {
        printer.errorTrackInput();
      }
    }
    return track;
  }

  /**
   * enterExistingTrainNumber asks for a train number of an existing train. It then sends it to the
   * validator to check if the input is valid and follows the rules. If the input is valid, it
   * returns the train number to an existing train. Else it sends a fitting error message to the
   * user.
   *
   * @return existingTrainNumber
   */

  public Integer enterExistingTrainNumber() {
    boolean flag = false;
    int existingTrainNumber = 0;
    while (!flag) {
      printer.enterTrainNumber();
      String trainNumberString = inputReader.nextLine().trim();
      String validation = validator.checkIfTrainNumberExists(trainNumberString, station);
      switch (validation) {
        case "OK" -> {
          existingTrainNumber = Integer.parseInt(trainNumberString);
          flag = true;
        }
        case "noTrainNumber" -> printer.errorNoTrainNumber();
        case "trainNumberError" -> printer.errorInvalidTrainNumber();
        default -> printer.errorDefault();
      }
    }
    return existingTrainNumber;
  }

  /**
   * enterDelay asks for the delay of the train. First it get the right train by asking for the
   * unique train number. It then sends the delay to the validator to check if the input is valid
   * and follows the Local time format. If the input is valid, it returns the delay which is used by
   * the addDelay method. Else it sends a fitting error message to the user.
   *
   * @param trainNumber is the unique number of the train
   * @return delay
   */

  public LocalTime enterDelay(int trainNumber) {
    boolean flag = false;
    LocalTime delay = LocalTime.parse("00:00");
    while (!flag) {
      printer.enterDelay();
      String delayString = inputReader.nextLine();
      String delayValidation = validator.checkDelay(delayString,
          station.getTrainByNumber(trainNumber));
      switch (delayValidation) {
        case "OK" -> {
          delay = LocalTime.parse(delayString);
          flag = true;
        }
        case "invalidTimeInput" -> printer.errorTimeInput();
        case "delayMoreThanNextDay" -> printer.errorDelayLessThanNextDay();
        default -> printer.errorDefault();
      }
    }
    return delay;
  }

  /**
   * addDelay asks for the delay of the train. It shows all the departures so u can see the train
   * number of the train you want to add delay to. Furthermore, it asks for the train number of the
   * train you want to add delay to. It then sends the delay to the enterDelay method which checks
   * the input. It then iterates through the sorted trainDepartureList to find the train with the
   * train number. It then sets the delay of the train with the right train number.
   */

  public void addDelay() {
    int trainNumber;
    LocalTime delay = null;
    showAllDepartures();
    trainNumber = enterExistingTrainNumber();
    delay = enterDelay(trainNumber);
    for (Iterator<TrainDeparture> it = station.getTrainDepartureSorted(); it.hasNext(); ) {
      TrainDeparture trainDeparture = it.next();
      if (trainDeparture.getTrainNumber().equals(trainNumber)) {
        trainDeparture.setDelay(delay);
      }
    }
  }

  /**
   * searchByTrainNumber shows all the departures so u can see the train number of the train you
   * want to search for. It then asks for the train number of the train you want to search for. The
   * method then sends the train number to a different function to check the input. After the input
   * is cleared, it iterates through the sorted trainDepartureList to find the train with the train
   * number. It then prints the information of the train with the right train number.
   */

  public void searchByTrainNumber() {
    int trainNumber;
    showAllDepartures();
    trainNumber = enterExistingTrainNumber();
    for (Iterator<TrainDeparture> it = station.getTrainDepartureSorted(); it.hasNext(); ) {
      TrainDeparture trainDeparture = it.next();
      if (trainDeparture.getTrainNumber().equals(trainNumber)) {
        printer.header();
        printer.printTrainDeparture(trainDeparture);
      }
    }
  }

  /**
   * searchByDestination asks for the destination and then sends it to a different function to check
   * the input. It then iterates through the sorted trainDepartureList to find the trains with the
   * given destination. It then prints the information of the trains with the right destination.
   */

  public void searchByDestination() {
    String destination;
    showAllDepartures();
    destination = askForExistingDestination();
    for (Iterator<TrainDeparture> it = station.getTrainDepartureSorted(); it.hasNext(); ) {
      TrainDeparture trainDeparture = it.next();
      if (trainDeparture.getDestination().trim().equals(destination)) {
        printer.header();
        printer.printTrainDeparture(trainDeparture);
      }
    }
  }

  /**
   * This method checks the input for an existing destination, it also checks if the destination
   * exists. If the input is valid, it returns the destination which is used by the
   * searchByDestination method. Else it sends a fitting error message to the user.
   *
   * @return destination
   */
  public String askForExistingDestination() {
    boolean flag = false;
    String destination = "";
    while (!flag) {
      printer.enterDestination();
      String destinationString = inputReader.nextLine().trim();
      String destinationValidation = validator.checkIfDestinationAlreadyExists(destinationString,
          station);
      switch (destinationValidation) {
        case "OK" -> {
          destination = destinationString;
          flag = true;
        }
        case "InvalidDestinationInput" -> printer.errorDestinationInput();
        case "noDestination" -> printer.errorNoDestination();
        case "needToEnterDestination" -> printer.errorEnterDestination();
        default -> printer.errorDefault();
      }

    }
    return destination;
  }

  /**
   * updateClock asks for the time of the station. It then sends it to the validator to check if the
   * input is valid and follows the Local time format. If the input is valid, it returns the time
   * and updates the clock of the station.
   */

  public void updateClock() {
    boolean flag = false;
    while (!flag) {
      printer.enterTime();
      String time = inputReader.nextLine();
      String delayValidation = validator.checkLocalTime(time, station);
      switch (delayValidation) {
        case "OK" -> {
          LocalTime newTime = LocalTime.parse(time);
          station.setClock(newTime);
          flag = true;
        }
        case "afterCurrentTime" -> printer.errorAfterCurrentTime();
        case "invalidTimeInput" -> printer.errorTimeInput();
        default -> printer.errorDefault();
      }
    }
  }
}