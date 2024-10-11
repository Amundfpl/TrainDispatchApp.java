package edu.ntnu.stud.inputvalidator;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.stud.station.Station;
import edu.ntnu.stud.traindeparture.TrainDeparture;
import java.time.LocalTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * This is a test class for the InputValidator class. It tests the methods in the InputValidator
 * class. It holds both positive and negative tests.
 */

class InputValidatorTest {
  /**
   * This field holds the inputValidator object.
   */
  private InputValidator inputValidator;
  /**
   * This field holds the station object.
   */
  private Station testStation;
  /**
   * This field holds the trainDeparture object.
   */
  private TrainDeparture testTrainDeparture;

  /**
   * This method sets up the inputValidator object before each test.
   * It also sets up the station object and the trainDeparture object.
   * The station object is given a departure time, line, train number, destination and track.
   * The trainDeparture object is given a departure time, line, train number, destination and track.
   */
  @BeforeEach
  void setUp() {
    inputValidator = new InputValidator();
    testStation = new Station();
    testTrainDeparture = new TrainDeparture(LocalTime.parse("12:00"), "L1", 122, "Oslo", 2);
    testStation.setDeparture(LocalTime.parse("10:00"), "L2", 123, "Oslo", 1);
  }

  @AfterEach
  void tearDown() {
  }

  /**
   * This method tests the checkLocalTime method in the InputValidator class with a positive test.
   * It checks if the time is 12:00 expecting it to be true.
   */
  @Test
  void checkLocalTimePositive() {
    assertEquals("OK",inputValidator.checkLocalTime("12:00", testStation), "Check local time failed!");
  }

  /**
   * This method tests the checkLocalTime input with a positive test.
   * It checks if the time is 12:00 expecting to get the fitting errormessage.
   */
  @Test
  void checkLocalTimeInvalidTimeInputPositive() {
    assertEquals("invalidTimeInput",inputValidator.checkLocalTime("bomba", testStation), "Check local time failed!");
  }

  /**
   * This method tests the checkLocalTime input with a positive test.
   * It checks if the time is 01:00 expecting to get the fitting errormessage.
   */
  @Test
  void checkLocalTimeAfterCurrentTimePositive() {
    testStation.setClock(LocalTime.parse("01:00"));
    assertEquals("afterCurrentTime",inputValidator.checkLocalTime("00:00", testStation), "Check local time failed!");
  }

  /**
   * This method tests the checkLocalTime input with a negative test.
   * It checks if the time is 02:00 expecting to get the fitting errormessage.
   */
  @Test
  void checkLocalTimeNegative() {
    Station testStation = new Station();
    assertNotEquals("afterCurrentTime",inputValidator.checkLocalTime("02:00", testStation), "Check local time failed!");
  }

  /**
   * This method tests the checkLocalTime input with a positive test.
   * It checks if the time is 01:00 expecting to get OK.
   */

  @Test
  void checkDelayPositive() {
    assertEquals("OK",inputValidator.checkDelay("01:00", testTrainDeparture), "Check delay failed!");
  }

  /**
   * This method tests the delay with a negative test.
   * It checks if the time is 12:00 expecting to be false.
   */
  @Test
  void checkDelayNegative() {
    assertNotEquals("OK",inputValidator.checkDelay("12:00", testTrainDeparture), "Check delay failed!");
  }

  /**
   * This method tests the checkDelay input with a positive test.
   * It checks if the delay is more than the next day expecting to get the fitting errormessage.
   */
  @Test
  void checkDelayMoreThanNextDayPositive() {
    assertEquals("delayMoreThanNextDay",inputValidator.checkDelay("12:00", testTrainDeparture), "Check delay failed!");
  }

  /**
   * This method tests the checkDelay input with a negative test.
   * It checks if the delayinput is invalid expecting to get the fitting errormessage.
   */
  @Test
  void checkDelayInvalidInputPositive() {
    assertEquals("invalidTimeInput",inputValidator.checkDelay("1200", testTrainDeparture), "Check delay failed!");
  }

  /**
   * This method tests the checkLine with a positive test.
   * It checks if the line is L1 expecting to get OK.
   */

  @Test
  void checkLinePositive() {
    assertEquals("OK",inputValidator.checkLine("L1"), "Check line failed!");
  }

  /**
   * This method tests the checkLine with a negative test.
   * It checks if the line is L2 expecting to be false.
   */
  @Test
  void checkLineNegative() {
    assertNotEquals("OK",inputValidator.checkLine("fe2"), "Check line failed!");
  }

  /**
   * This method tests the checkLine input with a positive test.
   * It checks if the line is f02f expecting to get the fitting errormessage.
   */
  @Test
  void checkLineInputPositive() {
    assertEquals("InvalidLineInput",inputValidator.checkLine("f02f"), "Check line failed!");
  }

  /**
   * This method tests the checkLine input with a negative test.
   * It checks if the line is FF22 expecting to not get the fitting errormessage.
   */
  @Test
  void checkLineInputNegative() {
    assertNotEquals("InvalidLineInput",inputValidator.checkLine("FF22"), "Check line failed!");
  }

  /**
   * This method tests the checkTrainNumber with a positive test.
   * It checks if the train number is 123 expecting to get OK.
   */

  @Test
  void checkTrainNumberPositive() {
    assertEquals("OK",inputValidator.checkTrainNumber("436", testStation), "Check train number failed!");
  }

  /**
   * This method tests the checkTrainNumber with a negative test.
   * It checks if the train number is five expecting to be false.
   */
  @Test
  void checkTrainNumberNegative() {
    assertNotEquals("OK",inputValidator.checkTrainNumber("five", testStation), "Check train number failed!");
  }

  /**
   * This method tests the checkTrainNumber input with a positive test.
   * It checks if the train number is three expecting to get the fitting errormessage.
   */
  @Test
  void checkTrainNumberInputPositive() {
    assertEquals("invalidInput",inputValidator.checkTrainNumber("three", testStation), "Check train number failed!");
  }

  /**
   * This method tests the checkTrainNumber input with a positive test.
   * It checks if the train number is 123 expecting to get the fitting errormessage.
   */
  @Test
  void checkTrainNumberErrorPositive() {
    assertEquals("trainNumberError",inputValidator.checkTrainNumber("123", testStation), "Check train number failed!");
  }

  /**
   * This method tests the checkTrainNumber input with a negative test.
   * It checks if the train number is 3 expecting to get the fitting errormessage.
   */
  @Test
  void checkTrainNumberErrorNegative() {
    assertNotEquals("trainNumberError",inputValidator.checkTrainNumber("3", testStation), "Check train number failed!");
  }

  /**
   * This method tests the checkIfTrainNumberExists with a positive test.
   * It checks if the train number is 123 expecting to get OK.
   */
  @Test
  void checkIfTrainNumberExistsPositive() {
    assertEquals("OK",inputValidator.checkIfTrainNumberExists("123", testStation), "Check if no train number failed!");
  }

  /**
   * This method tests the checkIfTrainNumberExists with a negative test.
   * It checks if the train number is 543 expecting to be false.
   */
  @Test
  void checkIfTrainNumberExistsNegative() {
    assertNotEquals("OK",inputValidator.checkIfTrainNumberExists("543", testStation), "Check if no train number failed!");
  }

  /**
   * This method tests the checkIfTrainNumberDontExists input with a positive test.
   * It checks if the train number is 171 expecting to get the fitting errormessage.
   */
  @Test
  void checkIfTrainNumberDontExistPositive() {
    assertEquals("noTrainNumber",inputValidator.checkIfTrainNumberExists("171", testStation), "Check if no train number failed!");
  }

  /**
   * This method tests the checkIfTrainNumberDontExists input with a negative test.
   * It checks if the train number is 123 expecting to not get the fitting errormessage.
   */
  @Test
  void checkIfTrainNumberDontExistNegative() {
    assertNotEquals("noTrainNumber",inputValidator.checkIfTrainNumberExists("123", testStation), "Check if no train number failed!");
  }

  /**
   * This method tests the checkDestination with a positive test.
   * It checks if the destination is Oslo expecting to get OK.
   */

  @Test
  void checkDestinationPositive() {
    assertEquals("OK",inputValidator.checkDestination("Oslo"), "Check destination failed!");
  }

  /**
   * This method tests the checkDestination with a negative test.
   * It checks if the destination is bodø expecting to be false.
   */
  @Test
  void checkDestinationNegative() {
    assertNotEquals("OK",inputValidator.checkDestination("bodø"), "Check destination failed!");
  }

  /**
   * This method tests the checkDestination input with a positive test.
   * It checks if the destination is Os1o expecting to get the fitting errormessage.
   */
  @Test
  void checkDestinationInputPositive() {
    assertEquals("InvalidDestinationInput",inputValidator.checkDestination("Os1o"), "Check destination failed!");
  }

  /**
   * This method tests the checkDestination input with a negative test.
   * It checks if the destination is Oslo expecting to not get the fitting errormessage.
   */
  @Test
  void checkDestinationInputNegative() {
    assertNotEquals("InvalidDestinationInput",inputValidator.checkDestination("Oslo"), "Check destination failed!");
  }

  /**
   * This method tests the checkIfDestinationAlreadyExists with a positive test.
   * It checks if the destination is Oslo expecting to get OK.
   */

  @Test
  void checkIfDestinationAlreadyExistsPositive() {
    assertEquals("OK",inputValidator.checkIfDestinationAlreadyExists("Oslo", testStation), "Check if destination already exists failed!");
  }

  /**
   * This method tests the checkIfDestinationAlreadyExists with a negative test.
   * It checks if the destination is Bodø expecting to be false.
   */
  @Test
  void checkIfDestinationAlreadyExistsNegative() {
    assertNotEquals("OK",inputValidator.checkIfDestinationAlreadyExists("Bodø", testStation), "Check if destination already exists failed!");
  }

  /**
   * This method tests the checkIfNoDestination input with a positive test.
   * It checks if the destination is Drammen expecting to get the fitting errormessage.
   */
  @Test
  void checkIfNoDestinationPositive() {
    assertEquals("noDestination",inputValidator.checkIfDestinationAlreadyExists("Drammen", testStation), "Check if destination already exists failed!");
  }

  /**
   * This method tests the checkIfNoDestination input with a negative test.
   * It checks if the destination is Oslo expecting to not get the fitting errormessage.
   */
  @Test
  void checkIfNoDestinationNegative() {
    assertNotEquals("noDestination",inputValidator.checkIfDestinationAlreadyExists("Oslo", testStation), "Check if destination already exists failed!");
  }

  /**
   * This method tests the checkTrack with a positive test.
   * It checks if the track is 1 expecting to get OK.
   */

  @Test
  void checkTrackPositive() {
    assertEquals("OK",inputValidator.checkTrack("1"), "Check track failed!");
  }

  /**
   * This method tests the checkTrack with a negative test.
   * It checks if the track is 2 expecting to be false.
   */
  @Test
  void checkTrackNegative() {
    assertNotEquals("OK",inputValidator.checkTrack("bomba"), "Check track failed!");
  }
}