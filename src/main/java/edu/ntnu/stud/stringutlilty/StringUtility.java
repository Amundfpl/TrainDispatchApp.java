package edu.ntnu.stud.stringutlilty;

/**
 * This class contains name of the menu options.
 */

public class StringUtility {

  /**
   * This constructor is private to prevent instantiation of the class.
   */
  private StringUtility() {
  }

  /**
   * Constant representing the option to show all departures. This constant is used to indicate that
   * the program should show all departures when a user selects the corresponding option.
   */
  public static final String SHOW_ALL_DEPARTURES = "1";

  /**
   * Constant representing the option to add a new train. This constant is used to indicate that the
   * program should add a new train when a user selects the corresponding option.
   */
  public static final String ADD_TRAIN = "2";

  /**
   * Constant representing the option to assign a track to a departure. This constant is used to
   * indicate that the program should assign a track to a departure when a user selects the
   * corresponding option.
   */
  public static final String ASSIGN_TRACK = "3";

  /**
   * Constant representing the option to add a delay to a departure. This constant is used to
   * indicate that the program should add a delay to a departure when a user selects the
   * corresponding option.
   */
  public static final String ADD_DELAY = "4";

  /**
   * Constant representing the option to search for a departure by train number. This constant is
   * used to indicate that the program should search for a departure by train number when a user
   * selects the corresponding option.
   */
  public static final String SEARCH_BY_TRAIN_NUMBER = "5";

  /**
   * Constant representing the option to search for a departure by destination. This constant is
   * used to indicate that the program should search for a departure by destination when a user
   * selects the corresponding option.
   */
  public static final String SEARCH_BY_DESTINATION = "6";

  /**
   * Constant representing the option to update the clock. This constant is used to indicate that
   * the program should update the clock when a user selects the corresponding option.
   */
  public static final String UPDATE_CLOCK = "7";
}
