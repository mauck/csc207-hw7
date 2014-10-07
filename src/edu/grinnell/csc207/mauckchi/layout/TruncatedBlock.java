package edu.grinnell.csc207.mauckchi.layout;

/**
 * A text block truncated to a specified width
 * 
 * @author mauckchi
 */

public class TruncatedBlock
    implements TextBlock
{
  //+--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  int width;
  int height;
  TextBlock contents;

  //+--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a new truncated block of the specified width.
   *
   * @param tb
   * @param width
   */
  public TruncatedBlock(TextBlock tb, int width)
  {
    this.width = width;
    this.height = tb.height();
    this.contents = tb;
  } // TruncatedBlock(TextBlock, int)

  
  //+---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Get the ith row of the block.
   */
  public String row(int i)
    throws Exception
  {
    if ((i >= 0) && (i <= this.height))
      {
        return this.contents.row(i).substring(0, width);
      } // if
    else
      {
        throw new Exception("Invalid row " + i);
      } // else
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height()
  {
    return this.height;
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width()
  {
    return Math.min(width, this.contents.width());
  } // width()
} // class TruncatedBlock
