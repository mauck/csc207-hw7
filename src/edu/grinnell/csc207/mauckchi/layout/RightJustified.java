package edu.grinnell.csc207.mauckchi.layout;

/**
 * A text block that is right-justified within a block
 * of the specified width.
 * 
 * @author mauckchi
 */

public class RightJustified
    implements TextBlock
{
  //+--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  int width;
  int height;
  //the width in which the text block is centered
  int boxWidth;
  TextBlock contents;

  //+--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a new block that is right-justified within a block
   * of the specified width.
   * 
   * @param tb
   * @param width
   */
  RightJustified(TextBlock tb, int width) throws Exception
  {
    if (width < tb.width())
      {
        throw new Exception("Invalid width");
      } // if
    this.width = width;
    this.height = tb.height();
    this.boxWidth = tb.width();
    this.contents = tb;
  } // RightJustified(Textblock, int)

  //+---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
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
    return this.width;
  } // width()

  /**
   * Get the ith row of the block.
   */
  public String row(int i)
    throws Exception
  {
    if ((i >= 0) && (i <= this.height))
      {
        return TBUtils.spaces(this.width - this.contents.row(i).length())
               + this.contents.row(i);
      } // if
    else
      {
        throw new Exception("Invalid row");
      } // else
  } // row(int)
} // class RightJustified
