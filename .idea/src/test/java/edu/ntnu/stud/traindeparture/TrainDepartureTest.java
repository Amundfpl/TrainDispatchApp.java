package edu.ntnu.stud.traindeparture;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is a test class for the TrainDeparture class. It tests the methods in the TrainDeparture
 * class. It holds both positive and negative tests.
 */

class TrainDepartureTest {
  /**
   * This field holds the trainDeparture object.
   */
  private TrainDeparture trainDeparture;
  /**
   * This field holds the delay object.
   */
  private LocalTime delay;
  /**
   * This method sets up the trainDeparture object before each test giving it a time, line
   * train number, destination, track and delay.
   * It also sets the delay to 0.
   */
  @BeforeEach
  void setUp() {
    trainDeparture = new TrainDeparture(LocalTime.parse("12:00"), "L1", 123, "Oslo", 1);
    this.delay = LocalTime.parse("00:00");
  }
  @AfterEach
  void tearDown() {
  }

  /**
   * This method tests the getDepartureTime method in the TrainDeparture class with a positive test.
   * It checks if the departure time is 12:00 expecting it to be true.
   */
  @Test
  void getDepartureTimePositive() {
  assertEquals(LocalTime.parse("12:00"), trainDeparture.getDepartureTime(), "Get departure time failed!");
  }

  /**
   * This method tests the getDepartureTime method in the TrainDeparture class with a negative test.
   * It checks if the departure time is 11:00 expecting it to be false.
   */
  @Test
  void setDepartureTimePositive() {
    LocalTime expectedTime = LocalTime.parse("12:00");
    trainDeparture.setDepartureTime(expectedTime);
    assertEquals(expectedTime, trainDeparture.getDepartureTime(), "Get departure time failed!");
  }

  /**
   * This method tests the getDepartureTime method in the TrainDeparture class with a negative test.
   * It checks if the departure time is 11:00 expecting it to be false.
   */
  @Test
  void setDepartureTimeNegative() {
    LocalTime expectedTime = LocalTime.parse("12:00");
    trainDeparture.setDepartureTime(expectedTime);
    assertNotEquals(LocalTime.parse("00:00"), trainDeparture.getDepartureTime(), "Get departure time failed!");
  }

  /**
   * This method tests the getLine method in the TrainDeparture class with a positive test.
   * It checks if the line is L1 expecting it to be true.
   */
  @Test
  void getLinePositive() {
    assertEquals("L1", trainDeparture.getLine(), "Get line failed!");
  }

  /**
   * This method tests the setLine method in the TrainDeparture class with a positive test.
   * It checks if the line is L2 expecting it to be true.
   */
  @Test
  void setLinePositive() {
    trainDeparture.setLine("L2");
    assertEquals("L2", trainDeparture.getLine(), "Get line failed!");
  }

  /**
   * This method tests the setLine method in the TrainDeparture class with a negative test.
   * It checks if the line is L2 expecting it to be false.
   */
  @Test
  void setLineNegative() {
    trainDeparture.setLine("L2");
    assertNotEquals("L1", trainDeparture.getLine(), "Get line failed!");
  }

  /**
   * This method tests the getTrainNumber method in the TrainDeparture class with a positive test.
   * It checks if the train number is 123 expecting it to be true.
   */
  @Test
  void getTrainNumberPositive() {
    assertEquals(123, trainDeparture.getTrainNumber(), "Get train number failed!");
  }

  /**
   * This method tests the setTrainNumber method in the TrainDeparture class with a positive test.
   * It checks if the train number is 123 expecting it to be true.
   */
  @Test
  void setTrainNumberPositive() {
    trainDeparture.setTrainNumber(123);
    assertEquals(123, trainDeparture.getTrainNumber(), "Get train number failed!");
  }

  /**
   * This method tests the setTrainNumber method in the TrainDeparture class with a negative test.
   * It checks if the train number is 123 expecting it to be false.
   */
  @Test
  void setTrainNumberNegative() {
    trainDeparture.setTrainNumber(123);
    assertNotEquals(122, trainDeparture.getTrainNumber(), "Get train number failed!");
  }

  /**
   * This method tests the getDestination method in the TrainDeparture class with a positive test.
   * It checks if the destination is Oslo expecting it to be true.
   */
  @Test
  void getDestinationPositive() {
    assertEquals("Oslo", trainDeparture.getDestination(), "Get destination failed!");
  }

  /**
   * This method tests the setDestination method in the TrainDeparture class with a positive test.
   * It checks if the destination is Drammen expecting it to be true.
   */
  @Test
  void setDestinationPositive() {
    trainDeparture.setDestination("Drammen");
    assertEquals("Drammen", trainDeparture.getDestination(), "Get destination failed!");
  }

  /**
   * This method tests the setDestination method in the TrainDeparture class with a negative test.
   * It checks if the destination is Drammen expecting it to be false.
   */
  @Test
  void setDestinationNegative() {
    trainDeparture.setDestination("Oslo");
    assertNotEquals("Drammen", trainDeparture.getDestination(), "Get destination failed!");
  }

  /**
   * This method tests the getTrack method in the TrainDeparture class with a positive test.
   * It checks if the track is 1 expecting it to be true.
   */

  @Test
  void getTrackPositive() {
    assertEquals(1, trainDeparture.getTrack(), "Get track failed!");
  }

  /**
   * This method tests the setTrack method in the TrainDeparture class with a positive test.
   * It checks if the track is 2 expecting it to be true.
   */
  @Test
  void setTrackPositive() {
    trainDeparture.setTrack(2);
    assertEquals(2, trainDeparture.getTrack(), "Get track failed!");
  }

  /**
   * This method tests the setTrack method in the TrainDeparture class with a negative test.
   * It checks if the track is 2 expecting it to be false.
   */
  @Test
  void setTrackNegative() {
    trainDeparture.setTrack(1);
    assertNotEquals(2, trainDeparture.getTrack(), "Get track failed!");
  }

  /**
   * This method tests the getDelay method in the TrainDeparture class with a positive test.
   * It checks if the delay is 00:00 expecting it to be true.
   */
  @Test
  void getDelayPositive() {
    assertEquals(delay, trainDeparture.getDelay(), "Get delay failed!");
  }

  /**
   * This method tests the setDelay method in the TrainDeparture class with a positive test.
   * It checks if the delay is 00:01 expecting it to be true.
   */
  @Test
  void setDelayPositive() {
    trainDeparture.setDelay(delay);
    assertEquals(delay, trainDeparture.getDelay(), "Get delay failed!");
  }

  /**
   * This method tests the setDelay method in the TrainDeparture class with a negative test.
   * It checks if the delay is 00:01 expecting it to be false.
   */
  @Test
  void setDelayNegative() {
    trainDeparture.setDelay(LocalTime.parse("00:01"));
    assertNotEquals(delay, trainDeparture.getDelay(), "Get delay failed!");
  }

  /**
   * This method tests the getNewTime method in the TrainDeparture class with a positive test.
   * It checks if the new time is 12:00 expecting it to be true.
   */
  @Test
  void getNewTimePositive() {
    assertEquals(LocalTime.parse("12:00"), trainDeparture.getNewTime(), "Get new time failed!");
  }

  /**
   * This method tests the getNewTime method in the TrainDeparture class with a negative test.
   * It checks if the new time is 11:00 expecting it to be false.
   */
  @Test
  void getNewTimeNegative() {
    assertNotEquals(LocalTime.parse("11:00"), trainDeparture.getNewTime(), "Get new time failed!");
  }
}