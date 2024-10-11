package edu.ntnu.stud.stringutlilty;


/**
 * This class contains different colors for the text in the program.
 */
public class ColorPrint {

  /**
   * This constructor is private to prevent instantiation of the class.
   */
  private ColorPrint() {

  }
  /**
   * This field holds the value for resetting the color.
   */
  public static final String ANSI_RESET = "\u001B[0m";
  /**
   * This field holds the value for the color red.
   */
  public static final String ANSI_RED = "\u001B[31m";
  /**
   * This field holds the value for the color green.
   */
  public static final String ANSI_GREEN = "\u001B[32m";
  /**
   * This field holds the value for the color purple.
   */
  public static final String ANSI_PURPLE = "\u001B[35m";
  /**
   * This field holds the value for underlining the text.
   */
  public static final String ANSI_UNDERLINE = "\u001B[4m";
}
