package edu.grinnell.csc207.mauckchi.layout;

/**
 * A w-by-h grid of a single character
 * 
 * @author mauckchi
 */
public class Grid
    implements TextBlock
{
  //+--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  int width;
  int height;
  char character;

  //+--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Build a new grid
   */
  public Grid(int width, int height, char ch)
  {
    this.width = width;
    this.height = height;
    this.character = ch;
  } // Grid(int, int, char)

  /**
   * Determine how many rows are in the grid.
   */
  public int height()
  {
    return this.height;
  } // height()

  //+---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Determine how many columns are in the grid.
   */
  public int width()
  {
    return this.width;
  } // width()

  /**
   * Get one row from the grid.
   *
   * @pre i < this.height()
   * @exception Exception
   * if the row number is invalid.
   */
  // I got the idea for using replace to make the grid rows from
  // http://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string-in-java
  public String row(int i)
    // try StringUtils.repeat -- need to download something...
    throws Exception
  {
    if ((i >= 0) && (i <= this.height))
      {
        return new String(new char[this.width]).replace("\0",
                                                        String.valueOf(this.character));
      } // if
    else
      {
        throw new Exception("Invalid row " + i);
      } // else
  } // row(int)

} // class Grid