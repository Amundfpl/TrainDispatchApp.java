package edu.ntnu.stud.station;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.stud.traindeparture.TrainDeparture;
import java.time.LocalTime;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is a test class for the Station class. It tests the methods in the Station class.
 * It holds both positive and negative tests.
 */

class StationTest {

  /**
   * This field holds the station object.
   */
  private Station station;

  /**
   * This method sets up the station object before each test and adds three trains to the station.
   */
  @BeforeEach
  void setUp() {
    station = new Station();
    station.setDeparture (LocalTime.parse("12:00"), "L1", 123, "Oslo", 1);
    station.setDeparture (LocalTime.parse("11:00"), "L2", 124, "Bodø", 2);
    station.setDeparture (LocalTime.parse("10:00"), "L3", 125, "Drammen", 3);
  }

  @AfterEach
  void tearDown() {
  }

  /**
   * This method tests the trainNumberExists method in the Station class with a positive test.
   * It checks if one of the trains in the station contains the train number 124
   * expecting it to be true.
   */

  @Test
  void trainNumberExistsPositive() {
    assertTrue(station.trainNumberExists(124), "Train number exists failed!");
  }

  /**
   * This method tests the trainNumberExists method in the Station class with a negative test.
   * It checks if one of the trains in the station contains the train number 128
   * with the expected outcome of false.
   */
  @Test
  void trainNumberExistsNegative() {
    assertFalse(station.trainNumberExists(128), "Train number exists failed!");
  }

  /**
   * This method tests the destinationExists method in the Station class with a positive test.
   * It checks if one of the trains in the station contains the destination "oslo"
   * expecting it to be true.
   */

  @Test
  void destinationExistsPositive() {
    assertTrue(station.destinationExists("Oslo"), "Destination exists failed!");
  }

  /**
   * This method tests the destinationExists method in the Station class with a negative test.
   * It checks if one of the trains in the station contains the destination "Mosjøen"
   * with the expected outcome of false.
   */
  @Test
  void destinationExistsNegative() {
    assertFalse(station.destinationExists("Mosjøen"), "Destination exists failed!");
  }

  /**
   * This method tests the getTrainDepartureSorted method in the Station class with a positive test.
   * It checks if the first train in the sorted list of the train departure has the train number 125
   * expecting it to be true.
   * Since the train 125 is the last train added to the list but the first train
   * to depart you can check if it sorts the trains correctly by checking the train number of the
   * first train.
   */

  @Test
  void getTrainDepartureSortedPositive() {
    assertEquals(125, station.getTrainDepartureSorted().next().getTrainNumber(), "Get train departure iterator failed!");
  }

  /**
   * This method tests the getTrainDepartureSorted method in the Station class with a negative test.
   * It has the same logic as the positive test but checks the first train added to the list
   * with the train number 123 in order to check if it sorts the trains correctly by time.
   */
  @Test
  void getTrainDepartureSortedNegative() {
    assertNotEquals(123, station.getTrainDepartureSorted().next().getTrainNumber(), "Get train departure iterator failed!");
  }

  /**
   * This method tests the getClock method in the Station class with a positive test.
   * The station time is 00:00 so it checks if the clock is 00:00
   */

  @Test
  void getClockPositive() {
    assertEquals(LocalTime.parse("00:00"), station.getClock(), "Get clock failed!");
  }

  /**
   * This method tests the setClock method in the Station class with a positive test.
   * First it sets the clock to 12:00 and then uses the getClock method
   * to check if the clock is 12:00.
   */

  @Test
  void setClockPositive() {
    station.setClock(LocalTime.parse("12:00"));
    assertEquals(LocalTime.parse("12:00"), station.getClock(), "Set clock failed!");
  }

  /**
   * This method tests the setClock method in the Station class with a negative test.
   * First it sets the clock to 10:00 and then uses the getClock method to check if the clock is
   * 12:00 expecting it to be false.
   */
  @Test
  void setClockNegative() {
    station.setClock(LocalTime.parse("10:00"));
    assertNotEquals(LocalTime.parse("12:00"), station.getClock(), "Set clock failed!");
  }

  /**
   * This method tests the setDeparture method in the Station class with a positive test.
   * It uses the getTrainDepartureSorted method to check the setDeparture in the setUp method.
   * It checks if the train number is 125.
   */

  @Test
  void setDeparturePositive() {
    assertEquals(125, station.getTrainDepartureSorted().next().getTrainNumber(), "Set departure failed!");
  }

  /**
   * This method tests the setDeparture method in the Station class with a negative test.
   * It uses the getTrainDepartureSorted method to check the setDeparture in the setUp method.
   * It checks if the train number is 124 expecting it to be false.
   */
  @Test
  void setDeparturePositiveNegative() {
    assertNotEquals(124, station.getTrainDepartureSorted().next().getTrainNumber(), "Set departure failed!");
  }

  /**
   * This method tests the getTrainByNumber method in the Station class with a positive test.
   * It checks if the train number is 123.
   */
  @Test
  void getTrainByNumberPositive() {
    assertEquals(123, station.getTrainByNumber(123).getTrainNumber(), "Get train by number failed!");
  }

  /**
   * This method tests the getTrainByNumber method in the Station class with a negative test.
   * It checks if the train number is 125 expecting it to be false.
   */
  @Test
  void getTrainByNumberNegative() {
    assertNotEquals(125, station.getTrainByNumber(123).getTrainNumber(), "Get train by number failed!");
  }
}