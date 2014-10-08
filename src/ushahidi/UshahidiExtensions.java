package ushahidi;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Vector;
import java.util.function.Predicate;

import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiLocation;
import edu.grinnell.glimmer.ushahidi.UshahidiTestingClient;

public class UshahidiExtensions
{
  static PrintWriter pen = new PrintWriter(System.out, true);

  /**
   * Prints an Ushahidi incident in an easy-to-read format
   * 
   * @param p
   * @param incident
   */
  public static void printIncident(PrintWriter p, UshahidiIncident incident)
  {
    p.println("Incident # " + incident.getId() + " : " + incident.getTitle());
    p.println(incident.getDescription());
    p.println("Location: " + incident.getLocation());
    p.println("Status: (Mode: " + incident.getMode() + ", Active: "
              + incident.getActive() + ", " + "Verified: "
              + incident.getVerified() + ")");
  } // printIncident(PrintWriter, UshahidiIncident)

  /**
   * Creates an UshahidiTestingClient with 12 sample incidents
   * 
   * @return test1
   *   a new Ushahidi testing client
   */
  public static UshahidiTestingClient ushahidiTestingClientCreator()
  {
    UshahidiIncident u1 =
        new UshahidiIncident(76, "doing cs", LocalDateTime.of(1995,
                                                              Month.APRIL, 25,
                                                              16, 30),
                             new UshahidiLocation(76, "doing cs", 120, 90),
                             "working on hw", null);
    UshahidiIncident u2 =
        new UshahidiIncident(7, "doing more cs", LocalDateTime.of(2012,
                                                                  Month.MAY, 3,
                                                                  12, 00),
                             new UshahidiLocation(7, "doing more cs", 145, 35),
                             "working on more hw", null);
    UshahidiIncident u3 =
        new UshahidiIncident(423, "i love noyce third",
                             LocalDateTime.of(2001, Month.APRIL, 25, 16, 30),
                             new UshahidiLocation(423, "i love noyce 3rd", 100,
                                                  45), "working on more hw",
                             null);
    UshahidiIncident u4 =
        new UshahidiIncident(
                             22,
                             "eating dinner",
                             LocalDateTime.of(2013, Month.SEPTEMBER, 30, 18, 30),
                             new UshahidiLocation(22, "eating dinner", 0.0, 0.0),
                             "ate dinner", null);
    UshahidiIncident u5 =
        new UshahidiIncident(200, "walking", LocalDateTime.of(2010,
                                                              Month.DECEMBER,
                                                              12, 12, 45),
                             new UshahidiLocation(200, "walking", 45, 62),
                             "walking outside", null);
    UshahidiIncident u6 =
        new UshahidiIncident(
                             43,
                             "eating lunch",
                             LocalDateTime.of(2014, Month.OCTOBER, 6, 12, 00),
                             new UshahidiLocation(43, "eating lunch", 30, 34.5),
                             "ate lunch", null);
    UshahidiIncident u7 =
        new UshahidiIncident(
                             18,
                             "reading a book",
                             LocalDateTime.of(1900, Month.JULY, 15, 16, 15),
                             new UshahidiLocation(18, "reading a book", 12, 100),
                             "good book", null);
    UshahidiIncident u8 =
        new UshahidiIncident(315, "in class", LocalDateTime.of(2014,
                                                               Month.OCTOBER,
                                                               6, 11, 00),
                             new UshahidiLocation(315, "in class", 60, 50),
                             "class time", null);
    UshahidiIncident u9 =
        new UshahidiIncident(700, "drinking coffee",
                             LocalDateTime.of(2006, Month.AUGUST, 1, 20, 30),
                             new UshahidiLocation(700, "drinking coffee", 15,
                                                  39), "coffee", null);
    UshahidiIncident u10 =
        new UshahidiIncident(601, "sleeping", LocalDateTime.of(2011,
                                                               Month.FEBRUARY,
                                                               8, 15, 15),
                             new UshahidiLocation(601, "sleeping", 20, 40),
                             "slept", null);
    UshahidiIncident u11 =
        new UshahidiIncident(3, "eating breakfast",
                             LocalDateTime.of(2013, Month.APRIL, 12, 11, 30),
                             new UshahidiLocation(3, "eating breakfast", 100,
                                                  160), "ate breakfast", null);
    UshahidiIncident u12 =
        new UshahidiIncident(14, "nothing", LocalDateTime.of(2012,
                                                             Month.NOVEMBER, 2,
                                                             2, 0),
                             new UshahidiLocation(14, "nothing", 90, 130),
                             "nothing", null);
    ArrayList<UshahidiIncident> ulist = new ArrayList<UshahidiIncident>();
    ulist.add(u1);
    ulist.add(u2);
    ulist.add(u3);
    ulist.add(u4);
    ulist.add(u5);
    ulist.add(u6);
    ulist.add(u7);
    ulist.add(u8);
    ulist.add(u9);
    ulist.add(u10);
    ulist.add(u11);
    ulist.add(u12);
    UshahidiTestingClient test1 = new UshahidiTestingClient(ulist);
    return test1;
  } // UshahidiTestingClientCreator()

  /**
   * Prints out the incidents with the lowest and highest id
   * 
   * @param client
   * @throws Exception
   */
  public static void findExtremes(UshahidiClient client)
    throws Exception
  {
    UshahidiIncident max = new UshahidiIncident(0, "");
    UshahidiIncident min = new UshahidiIncident(Integer.MAX_VALUE, "");
    UshahidiIncident current;
    while (client.hasMoreIncidents())
      {
        current = client.nextIncident();
        if (current.getId() > max.getId())
          max = current;

        if (current.getId() < min.getId())
          min = current;
      } // while more incidents
    printIncident(pen, max);
    pen.println("max id: " + max.getId());
    printIncident(pen, min);
    pen.println("min id: " + min.getId());
  } // findExtremes(UshahidiClient)

  /**
   * Prints all incidents that happen between two given dates
   * 
   * @param client
   * @param time1
   * @param time2
   * @throws Exception
   */
  public static void findIncidentBetweenDate(UshahidiClient client,
                                             LocalDateTime time1,
                                             LocalDateTime time2)
    throws Exception
  {
    if (time1.compareTo(time2) > 0) //make sure that time1 comes first
      {
        LocalDateTime temp = time1;
        time1 = time2;
        time2 = temp;
      } // if time1 comes after time 2
    UshahidiIncident current;

    while (client.hasMoreIncidents())
      {
        current = client.nextIncident();
        if ((current.getDate().compareTo(time1) > 0 && 
            current.getDate().compareTo(time2) < 0)
            || current.getDate().compareTo(time1) == 0
            || current.getDate().compareTo(time2) == 0)
          printIncident(pen, current);
      } // while more incidents
  } // findIncidentsBetweenDate(UshahidiClient, LocalDateTime, LocalDateTime) 

  /**
   * Builds an ArrayList of all the incidents that fall between two given dates
   * 
   * Figured out how to convert from ArrayList to Array from
   * http://stackoverflow.com/questions/5374311/convert
   * -arrayliststring-to-string
   * 
   * @param client
   * @param time1
   * @param time2
   * @return ushahidiArray
   *   an array of filtered Ushahidi incidents
   * @throws Exception
   */
  public static UshahidiIncident[]
    buildArrayBetweenDates(UshahidiClient client, LocalDateTime time1,
                           LocalDateTime time2)
      throws Exception
  {
    if (time1.compareTo(time2) > 0)
      {
        LocalDateTime temp = time1;
        time1 = time2;
        time2 = temp;
      } // if time1 comes after time2
    UshahidiIncident current;
    ArrayList<UshahidiIncident> ushahidiIncidentList =
        new ArrayList<UshahidiIncident>();
    while (client.hasMoreIncidents())
      {
        current = client.nextIncident();
        if ((current.getDate().compareTo(time1) > 0 
            && current.getDate().compareTo(time2) < 0)
            || current.getDate().compareTo(time1) == 0
            || current.getDate().compareTo(time2) == 0)
          {
            ushahidiIncidentList.add(current);
          } // if current incident's date is between time1 and time2
      } // while more incidents
    UshahidiIncident[] ushahidiArray =
        new UshahidiIncident[ushahidiIncidentList.size()];
    ushahidiArray = ushahidiIncidentList.toArray(ushahidiArray);
    return ushahidiArray;
  } // buildArrayBetweenDates(UshahidiClient, LocalDateTime, LocalDateTime)

  /**
   * Filters all of the Ushahidi incidents that have a title that contains name
   * @param client
   * @param name
   * @return vec
   *   a vector of filtered Ushahidi incidents
   * @throws Exception
   */
  public static Vector<UshahidiIncident> filterName(UshahidiClient client,
                                                    String name)
    throws Exception
  {
    UshahidiIncident current;
    Vector<UshahidiIncident> vec = new Vector<UshahidiIncident>();
    while (client.hasMoreIncidents())
      { //http://stackoverflow.com/questions/2275004/in-java-how-to-check-
        //if-a-string-contains-a-substring-ignoring-the-case
        current = client.nextIncident();
        if (current.getTitle().toLowerCase().contains(name.toLowerCase()))
          {
            printIncident(pen, current);
            vec.add(current);
          }
      } // while more incidents
    return vec;
  } // filterName(UshahidiClient, String)

  /**
   * Creates a vector of all the incidents that fall within a certain distance
   * of a given location
   * 
   * @param client
   * @param loc
   * @param distance
   * @return vec
   *   a vector of filtered Ushahidi incidents
   * @throws Exception
   */
  public static Vector<UshahidiIncident>
    findIncidentWithinDistance(UshahidiClient client, UshahidiLocation loc,
                               double distance)
      throws Exception
  {
    UshahidiIncident current;
    Vector<UshahidiIncident> vec = new Vector<UshahidiIncident>();
    while (client.hasMoreIncidents())
      {
        current = client.nextIncident();

        if (haversine(loc.getLatitude(), loc.getLongitude(),
                      current.getLocation().getLatitude(),
                      current.getLocation().getLongitude()) <= distance)
          {
            vec.add(current);
            printIncident(pen, current); // print the incidents for 
                                         // testing purposes
          } // if current incident's location is within distance of location
      } // while more incidents
    return vec;
  } // findIncidentWithinDistance(UshahidiClient, UshahidiLocation, double)

  /**
   * Computes the distance between two geographic points
   * 
   * @param lat1
   * @param lon1
   * @param lat2
   * @param lon2
   */
  private static double haversine(double lat1, double lon1, double lat2,
                                  double lon2)
  {
    //stolen from http://rosettacode.org/wiki/Haversine_formula#Java
    double R = 6378.1;
    double dLat = Math.toRadians(lat2 - lat1);
    double dLon = Math.toRadians(lon2 - lon1);
    lat1 = Math.toRadians(lat1);
    lat2 = Math.toRadians(lat2);

    double a =
        Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2)
            * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
    double c = 2 * Math.asin(Math.sqrt(a));
    return R * c;
  } // haversine(double, double, double, double)

  /**
   * A generalized filter for Ushahidi Incidents
   * @param client
   * @param pred
   * @return ushahidiVector
   *   a vector of filtered Ushahidi incidents
   */
  public static
    Vector<UshahidiIncident>
    UshahidiVectorFilter(UshahidiClient client, 
                         Predicate<UshahidiIncident> pred)
  {
    Vector<UshahidiIncident> ushahidiVector = new Vector<UshahidiIncident>();
    UshahidiIncident current = null;
    while (client.hasMoreIncidents())
      {  
        if (pred.test(current))
          {
            ushahidiVector.add(current);
          } // if pred is true
      } // while more incidents
    return ushahidiVector;
  } // UshahidiVectorFilter(UshahidiClient, Predicate<UshahidiIncident>)

} // class UshahidiExtensions
