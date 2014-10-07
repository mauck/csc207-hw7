package com.farevee.groceries;

import java.io.PrintWriter;

public class GroceryExpt
{
  //+------+--------------------------------------------------------------
  // | Main |
  // +------+
  public static void main(String[] args)
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    // The store has 20 pounds of bananas, priced at 50 cents per pound
    BulkFood bananas = new BulkFood("bananas", Units.POUND, 50, 20);
    pen.println(bananas.toString());
    
    // The store has 200 grams of saffron, priced at 1000 cents per gram
    BulkFood saffron = new BulkFood("saffron", Units.GRAM, 1000, 200);
    pen.println(saffron.toString());
    
    // The store has 100 pounds of jelly beans, priced at 500 cents per pound
    BulkFood jellybeans = new BulkFood("jellybeans", Units.POUND, 100, 500);
    
    BulkItem bananas1 = new BulkItem(bananas, Units.POUND, 3);
    pen.println(bananas1.toString());
    
    BulkItem saffron1 = new BulkItem(saffron, Units.GRAM, 4);
    pen.println(saffron1.toString());
    BulkItem saffron2 = new BulkItem(saffron, Units.GRAM, 4);
    pen.println(saffron1.equals(saffron2));
    
    BulkContainer jellybeans1 = new BulkContainer("bag", jellybeans, Units.POUND, 7);
    pen.println(jellybeans1.toString());
    BulkContainer jellybeans2 = new BulkContainer("bag", jellybeans, Units.POUND, 7);
    pen.println(jellybeans1.equals(jellybeans2));
    
    Package macaroni = new Package("macaroni and cheese", new Weight(Units.OUNCE, 5), 100);
    pen.println(macaroni.toString());
    pen.println(macaroni.getPrice());
    pen.println(macaroni.getWeight());
    pen.println(macaroni.equals(new Package("blueberries", new Weight(Units.OUNCE, 7), 200)));
    pen.println(macaroni.equals(new Package("macaroni and cheese", new Weight(Units.OUNCE, 5), 100)));
    Package macaroni2 = new Package("macaroni and cheese", new Weight(Units.OUNCE, 5), 100);
    pen.println(macaroni.equals(macaroni2));
    
    ManyPackages macaroni1 = new ManyPackages(macaroni, 4);
    pen.println(macaroni1.toString());
    ManyPackages cheese1 = new ManyPackages(new Package("cheese", new Weight(Units.GRAM, 8), 150), 5);
    ManyPackages cheese2 = new ManyPackages(new Package("cheese", new Weight(Units.GRAM, 8), 150), 5);
    pen.println(macaroni1.equals(cheese1));
    pen.println(cheese1.equals(cheese2));
    cheese2 = cheese1;
    pen.println(cheese1.equals(cheese2));
    
    NonFood canopener = new NonFood("can opener", new Weight(Units.GRAM, 4), 700);
    NonFood canopener1 = new NonFood("can opener", new Weight(Units.GRAM, 4), 700);
    pen.println("canopener " + canopener.equals(canopener1));
  } // main
} // class GroceryExpt
