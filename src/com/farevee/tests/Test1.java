     package com.farevee.tests;

import java.io.PrintWriter;
import com.farevee.groceries.BulkContainer;
import com.farevee.groceries.BulkFood;
import com.farevee.groceries.BulkItem;
import com.farevee.groceries.Item;
import com.farevee.groceries.ManyPackages;
import com.farevee.groceries.Package;
import com.farevee.groceries.NonFood;
import com.farevee.groceries.Units;
import com.farevee.groceries.Weight;
import com.farevee.shopping.Cart;

/**
 * Tests are modified from tests written by wolterzo
 *
 */
public class Test1
{
  public static void main(String[] args)
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    Cart myCart = new Cart();
    // The store has bananas, priced at 50 cents per pound
    BulkFood bananas = new BulkFood("bananas", Units.POUND, 50, 20);
    // The store has saffron, priced at 1000 cents per gram
    BulkFood saffron = new BulkFood("saffron", Units.GRAM, 1000, 200);
    Item someBananas = new BulkItem(bananas, Units.POUND, 5);
    Item jello = new Package("cherry jello", new Weight(Units.OUNCE, 6), 340);
    Item jellos = new ManyPackages((Package) jello, 8);
    Item bear = new NonFood("Teddy bear", new Weight(Units.KILOGRAM, 1), 1000);
    Item saffrons = new BulkContainer("jar", saffron, Units.GRAM, 2);
    
    myCart.addItem(bear);
    pen.println("bear added, numThings = " + myCart.numThings());
    pen.println("numEntries = " + myCart.numEntries());
    
    myCart.addItem(someBananas);
    pen.println("bananas added, numThings = " + myCart.numThings());
    pen.println("numEntries = " + myCart.numEntries());
    
    myCart.addItem(jello);
    pen.println("jello added, numThings = " + myCart.numThings());
    pen.println("numEntries = " + myCart.numEntries());
    
    myCart.addItem(jellos);
    pen.println("jellos added, numThings = " + myCart.numThings());
    pen.println("numEntries = " + myCart.numEntries());
    
    myCart.addItem(someBananas);
    pen.println("more bananas added, numThings = " + myCart.numThings());
    pen.println("numEntries = " + myCart.numEntries());
    
    myCart.addItem(saffrons);
    pen.println("saffron added, numThings = " + myCart.numThings());
    pen.println("numEntries = " + myCart.numEntries());
    
    myCart.addItem(bear);
    pen.println("another bear added, numThings = " + myCart.numThings());
    pen.println("numEntries = " + myCart.numEntries());
    
    pen.println("--------------------------------");
    myCart.printContents(pen);
    pen.println("--------------------------------");
    
    pen.println("Number of things: " + myCart.numThings());
    pen.println("Number of entries: " + myCart.numEntries());
    pen.println("--------------------------------");
    pen.println("Total Price: " + myCart.getPrice());
    pen.println();
    
    pen.println("MERGING AND REMOVING BEARS!");
    myCart.merge();
    myCart.remove("Teddy bear");
    pen.println("--------------------------------");
    myCart.printContents(pen);
    pen.println("--------------------------------");
    pen.println("Number of things: " + myCart.numThings());
    pen.println("Number of entries: " + myCart.numEntries());
    Weight[] weights = myCart.getWeight();
    pen.println("Weights:");
    for (int i = 0; i < weights.length; i++)
      {
        pen.println(weights[i].toString());
      }
  } // main(String[])
}