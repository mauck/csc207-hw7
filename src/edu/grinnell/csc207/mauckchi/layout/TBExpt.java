package edu.grinnell.csc207.mauckchi.layout;

import java.io.PrintWriter;

/**
* A series of experiments with the text block layout classes.
*
* @author Samuel A. Rebelsky
* @version 1.2 of September 2014
*/
public class TBExpt
{
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+
  public static void main(String[] args)
    throws Exception
  {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);
    // Create some blocks to use
    TextBlock block = new TextLine("Hello");
    TextBlock block1 = new TextLine("Goodbye");
    TextBlock block2 = new VComposition(block, block1);
    // Print out the block
    TBUtils.print(pen, block);
    pen.println("");

    // testing Grid
    pen.println("Grid:");
    TBUtils.print(pen, new BoxedBlock(new Grid(7, 3, '*')));
    TBUtils.print(pen, new Grid(7, 3, '*'));
    pen.println("");

    // testing TruncatedBlock
    pen.println("TruncatedBlock:");
    TBUtils.print(pen, new TruncatedBlock(new Grid(7, 3, '*'), 6));
    TextBlock tBlock = new TruncatedBlock(block2, 3);
    TBUtils.print(pen, tBlock);
    TBUtils.print(pen, block2);
    pen.println("");

    // testing CenteredBlock
    pen.println("CenteredBlock:");
    TextBlock cBlock = new BoxedBlock(new CenteredBlock(block2, 11));
    TextBlock cBlock1 = (new CenteredBlock(block2, 11));
    TBUtils.print(pen, cBlock);
    TBUtils.print(pen, cBlock1);
    pen.println("");

    // testing RightJustified
    pen.println("RightJustified: ");
    TextBlock rjBlock = new BoxedBlock(new RightJustified(block2, 11));
    TBUtils.print(pen, rjBlock);
    pen.println("");

    // testing BlockPair
    pen.println("BlockPair: ");
    TextBlock bpBlock = new BlockPair(block);
    TextBlock bpBlock1 = new BlockPair(block1);
    TextBlock bpBlock2 = new BlockPair(block2);
    TBUtils.print(pen, bpBlock);
    TBUtils.print(pen, bpBlock1);
    TBUtils.print(pen, bpBlock2);
    pen.println("");

    // testing setContents
    pen.println("setContents: ");
    TextLine tb1 = new TextLine("Hello");
    TextLine tb2 = new TextLine("World");
    TextBlock compound =
        new BoxedBlock(
                       new CenteredBlock(
                                         new BoxedBlock(
                                                        new CenteredBlock(
                                                                          new VComposition(
                                                                                           tb1,
                                                                                           tb2),
                                                                          7)),
                                         15));
    pen.println("ORIGINAL");
    TBUtils.print(pen, compound);
    tb2.setContents("Someone");
    pen.println("UPDATED");
    TBUtils.print(pen, compound);
    tb1.setContents("Nice to meet you, ");
    pen.println("RE-UPDATED");
    TBUtils.print(pen, compound);

    pen.close();
  } // main(String[])
} // class TBExpt
