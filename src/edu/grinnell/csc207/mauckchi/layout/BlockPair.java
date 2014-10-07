package edu.grinnell.csc207.mauckchi.layout;

/**
 * Two copies of the same text block, side by side
 * 
 * @author mauckchi
 */

public class BlockPair
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
   * Create a new block that is made up of two copies of the
   * same original block
   * 
   * @param tb
   */
  public BlockPair(TextBlock tb)
  {
    this.width = 2 * tb.width();
    this.height = tb.height();
    this.contents = tb;
  } // BlockPair(TextBlock)

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
        return this.contents.row(i) + this.contents.row(i);
      } // if
    else
      {
        throw new Exception("Invalid row");
      } // else
  } // row(int)
} // class BlockPair
