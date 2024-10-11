package edu.ntnu.stud;

import edu.ntnu.stud.visual.Visual;

/**
 * This class is the main class of the program. It starts the program.
 */
public class
TrainDispatchApp {

  /**
   * This method takes care of the SRP (single responsibility principle). It initializes the visual
   * class and starts the program.
   */
  public void init() {
    Visual visual = new Visual();
    visual.start();
  }

  /**
   * The main method, starting the application.
   *
   * @param args is an array of strings that allows passing command line arguments to a Java
   *             program.
   */
  public static void main(String[] args) {
    TrainDispatchApp app = new TrainDispatchApp();
    app.init();
  }
}