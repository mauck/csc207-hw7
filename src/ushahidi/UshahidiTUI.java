package ushahidi;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiLocation;
import edu.grinnell.glimmer.ushahidi.UshahidiWebClient;

public class UshahidiTUI
{
  public static void main(String args[])
    throws Exception
  {
    userInterface();
  } // main()

  /**
   * Implements a textual user interface for filtering Ushahidi incidents
   * 
   * @throws Exception
   */
  public static void userInterface()
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    java.io.BufferedReader eyes;
    java.io.InputStreamReader istream;
    istream = new java.io.InputStreamReader(System.in);
    eyes = new java.io.BufferedReader(istream);
    String url = null;
    String input;
    String toSearchFor;
    int choice; // user's choice of what to filter by
    UshahidiClient webclient;
    boolean gettingURL = true;
    while (gettingURL)
      {
        // make sure url is valid
        try
          {
            pen.println("Enter the url of an Ushahidi database: ");
            pen.print("--> ");
            pen.flush();
            url = eyes.readLine();
            webclient = initialize(url);
            gettingURL = false;
          } // try
        catch (Exception e)
          {
            pen.println("Invalid URL");
          } // catch
      }

    int lat, lon, kilometers;
    while (true)
      {
        try
          {
            webclient = initialize(url);
            pen.println("Enter the number of a category to filter: ");
            pen.println("1: Date");
            pen.println("2: Distance");
            pen.println("3: Title");
            pen.println("quit: quit");
            pen.print("--> ");
            pen.flush();
            input = eyes.readLine();
            if (input.equals("quit"))
              {
                pen.println("Terminated.");
                break;
              } // if quit

            else if (input.length() > 1)
              pen.println("invalid input");
            else
              {
                choice = Integer.valueOf(input);
                switch (choice)
                  {
                    case 1:
                      pen.println("Begin date: ");
                      pen.print("--> ");
                      pen.flush();
                      LocalDateTime date1 = getDate(pen, eyes);
                      pen.println("End date: ");
                      pen.print("--> ");
                      pen.flush();
                      LocalDateTime date2 = getDate(pen, eyes);
                      UshahidiExtensions.findIncidentBetweenDate(webclient,
                                                                 date1, date2);
                      break;
                    case 2:
                      pen.println("Enter a latitude:");
                      pen.print("--> ");
                      pen.flush();
                      lat = Integer.valueOf(eyes.readLine());
                      pen.println("Enter a longitude:");
                      pen.print("--> ");
                      pen.flush();
                      lon = Integer.valueOf(eyes.readLine());
                      pen.println("Enter amount of kilometers:");
                      pen.print("--> ");
                      pen.flush();
                      kilometers = Integer.valueOf(eyes.readLine());
                      UshahidiExtensions.findIncidentWithinDistance
                        (webclient, new UshahidiLocation
                                          (0,"",lat,lon),kilometers);
                      break;
                    case 3:
                      pen.println("Enter a string to search for in titles:");
                      pen.print("--> ");
                      pen.flush();
                      toSearchFor = eyes.readLine();
                      UshahidiExtensions.filterName(webclient, toSearchFor);
                      break;
                  } // switch
              } // else
          } // try
        // report errors during runtime
        catch (Exception e)
          {
            pen.println("Error: " + e.getMessage());
          } // catch
      } // while
  } // userInterface()

  /**
   * Initializes an UshahidiWebClient
   * @param url
   * @return
   * @throws Exception
   */
  private static UshahidiClient initialize(String url)
    throws Exception
  {
    return new UshahidiWebClient(url);
  } // initialize(String)

  /**
   * Get date from user and return a LocalDateTime object
   * @param pen
   * @param eyes
   * @return
   * @throws Exception
   */
  private static LocalDateTime getDate(PrintWriter pen, BufferedReader eyes)
    throws Exception
  {
    int year, month, day, hour, minute;
    pen.println("Enter a year: ");
    year = Integer.valueOf(eyes.readLine());
    pen.println("Enter a month: ");
    month = Integer.valueOf(eyes.readLine());
    pen.println("Enter a day: ");
    day = Integer.valueOf(eyes.readLine());
    pen.println("Enter an hour: ");
    hour = Integer.valueOf(eyes.readLine());
    pen.println("Enter a minute: ");
    minute = Integer.valueOf(eyes.readLine());
    return LocalDateTime.of(year, month, day, hour, minute);
  } // getDate(PrintWriter, BufferedReader)
} // class UshahidiTUI
