package edu.grinnell.csc207.mauckchi.layout;

/**
 * A text block centered within a specified width
 * 
 * @author mauckchi
 */

public class CenteredBlock
    implements TextBlock
{
  //+--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  int width;
  int height;
  // the width in which the text block is centered
  int boxWidth;
  TextBlock contents;

  //+--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   /**
    * Create a new CenteredBlock in a box of the specified width.
    * 
    * @param tb
    * @param width
    */
  CenteredBlock(TextBlock tb, int width) throws Exception
  {
    if (width < tb.width())
      {
        throw new Exception("Invalid width");
      } // if
    else
      {
        this.width = width;
        this.height = tb.height();
        this.boxWidth = tb.width();
        this.contents = tb;
      } // else
  } // CenteredBlock(TextBlock, int)

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
    //if ((i >= 0) && (i <= this.height))
    if ((i >= 0) && (i <= this.contents.height()))
      {
        //return TBUtils.spaces((this.width - this.boxWidth) / 2)
        return TBUtils.spaces((this.width - this.contents.width()) / 2)
               + this.contents.row(i)
               //+ TBUtils.spaces((this.width - this.boxWidth) / 2);
               + TBUtils.spaces((this.width - this.contents.width()) / 2);
      } // if
    else
      {
        throw new Exception("Invalid row");
      } // else
  } // row(int)
} // class CenteredBlock
