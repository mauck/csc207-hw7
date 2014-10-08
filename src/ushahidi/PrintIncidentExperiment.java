package ushahidi;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.Month;

import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiLocation;
import edu.grinnell.glimmer.ushahidi.UshahidiTestingClient;
import edu.grinnell.glimmer.ushahidi.UshahidiUtils;
import edu.grinnell.glimmer.ushahidi.UshahidiWebClient;

public class PrintIncidentExperiment
{
  public static void main(String[] args)
    throws Exception
  {
    // Create the output device
    PrintWriter pen = new PrintWriter(System.out, true);

    //A few basic incidents
    UshahidiExtensions.printIncident(pen, UshahidiUtils.SAMPLE_INCIDENT);
    UshahidiExtensions.printIncident(pen, UshahidiUtils.randomIncident());
    UshahidiExtensions.printIncident(pen, UshahidiUtils.randomIncident());

    pen.println("-------------------------------------------------------");

    // A newly created incident
    UshahidiIncident myIncident = new UshahidiIncident(10, "help");
    UshahidiExtensions.printIncident(pen, myIncident);

    pen.println("-------------------------------------------------------");

    //One from a list
    UshahidiClient client = UshahidiUtils.SAMPLE_CLIENT;
    UshahidiExtensions.printIncident(pen, client.nextIncident());

    pen.println("-------------------------------------------------------");

    //One that requires connecting to the server
    UshahidiClient webclient =
        new UshahidiWebClient("http://ushahidi1.grinnell.edu/sandbox/");
    UshahidiExtensions.printIncident(pen, webclient.nextIncident());

    pen.println("-------------------------------------------------------");

    //Create TestingClient and find extremes
    UshahidiTestingClient tests =
        UshahidiExtensions.ushahidiTestingClientCreator();
    UshahidiExtensions.findExtremes(tests);

    pen.println("-------------------------------------------------------");

    //Find extremes using webclient
    UshahidiExtensions.findExtremes(webclient);

    pen.println("-------------------------------------------------------");

    UshahidiTestingClient tests1 =
        UshahidiExtensions.ushahidiTestingClientCreator();
    //Find incidents from TestingClient between January 1, 
    //2000, and September 30, 2015
    UshahidiExtensions.findIncidentBetweenDate(tests1,
                                               LocalDateTime.of(2000,
                                                                Month.JANUARY,
                                                                1, 0, 0),
                                               LocalDateTime.of(2015,
                                                                Month.SEPTEMBER,
                                                                30, 18, 30));

    pen.println("-------------------------------------------------------");

    UshahidiClient webclient1 =
        new UshahidiWebClient("http://ushahidi1.grinnell.edu/sandbox/");
    //Find incidents from webclient between September 7, 2014 (12:00 AM) and
    //September 7, 2014 (3:30 PM)
    UshahidiExtensions.findIncidentBetweenDate(webclient1,
                                               LocalDateTime.of(2014,
                                                                Month.SEPTEMBER,
                                                                7, 0, 0),
                                               LocalDateTime.of(2014,
                                                                Month.SEPTEMBER,
                                                                7, 15, 30));

    pen.println("-------------------------------------------------------");

    UshahidiClient webclient2 =
        new UshahidiWebClient("http://ushahidi1.grinnell.edu/sandbox/");
    //Find incidents from the webclient within 300 miles of Grinnell
    UshahidiExtensions.findIncidentWithinDistance(webclient2,
                                                  new UshahidiLocation(
                                                                       5,
                                                                       "Grinnell",
                                                                       41, -92),
                                                  300);

    pen.println("-------------------------------------------------------");

    UshahidiClient webclient3 =
        new UshahidiWebClient("http://ushahidi1.grinnell.edu/sandbox/");
    //Create new array of incidents from webclient
    UshahidiIncident[] ushahidiArray =
        UshahidiExtensions.buildArrayBetweenDates(webclient3,
                                                  LocalDateTime.of(2013,
                                                                   Month.SEPTEMBER,
                                                                   7, 0, 0),
                                                  LocalDateTime.of(2014,
                                                                   Month.SEPTEMBER,
                                                                   7, 15, 30));
    for (int i = 0; i < ushahidiArray.length; i++)
      {
        UshahidiExtensions.printIncident(pen, ushahidiArray[i]);
      } // for

  } // main(String[])
} // class PrintIncidentExperiment
