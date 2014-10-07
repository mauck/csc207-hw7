package com.farevee.shopping;

import java.io.PrintWriter;
import java.util.ArrayList;

import com.farevee.groceries.Item;
import com.farevee.groceries.BulkItem;
import com.farevee.groceries.Package;
import com.farevee.groceries.ManyPackages;
import com.farevee.groceries.Units;
import com.farevee.groceries.Weight;

public class Cart
{
  //+--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  ArrayList<Item> cart;
  int things;
  int entries;
  int price;
  int numPounds;
  int numOunces;
  int numKilograms;
  int numGrams;

  //+--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a new Cart
   */
  public Cart()
  {
    this.cart = new ArrayList<Item>();
    this.things = 0;
    this.entries = 0;
    this.price = 0;
    this.numPounds = 0;
    this.numOunces = 0;
    this.numKilograms = 0;
    this.numGrams = 0;
  } // Cart()

  //+---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Add item to the cart
   * 
   * @param i
   */
  public void addItem(Item i)
  {
    cart.add(i);
    entries++;
    price += i.getPrice();
    if (i instanceof ManyPackages)
      {
        things += ((ManyPackages) i).getCount();
      } // if i is ManyPackages
    else
      things++;
    switch (i.getWeight().getUnit())
      {
        case "pound":
          numPounds += i.getWeight().getAmount();
        case "ounce":
          numOunces += i.getWeight().getAmount();
        case "kilogram":
          numKilograms += i.getWeight().getAmount();
        case "gram":
          numGrams += i.getWeight().getAmount();
      } // switch
  } // addItem(Item)

  /**
   * Get the number of things in the cart
   * 
   * @return
   */
  public int numThings()
  {
    return things;
  } // numThings()

  /**
   * Print the number of entries in the cart
   * count ManyPackages objects as one entry
   * 
   * @return
   */
  public int numEntries()
  {
    return entries;
  } // numEntries()

  /**
   * Print the contents of the cart
   * 
   * @param pen
   */
  public void printContents(PrintWriter pen)
  {
    for (int i = 0; i < cart.size(); i++)
      {
        pen.println(cart.get(i).toString());
      } // for
  } // printContents(PrintWriter)

  /**
   * Compute the total price of the things in the cart
   * 
   * @return
   */
  public int getPrice()
  {
    return price;
  } // getPrice()

  /**
   * Get an array of weights, where each entry is the total
   * of one unit of weight
   * 
   * @return
   */
  public Weight[] getWeight()
  {
    Weight[] weights =
        new Weight[] { new Weight(Units.POUND, numPounds),
                      new Weight(Units.OUNCE, numOunces),
                      new Weight(Units.KILOGRAM, numKilograms),
                      new Weight(Units.GRAM, numGrams) };
    return weights;
  } // getWeight()

  /**
   * Remove all the products with name
   * 
   * @param name
   */
  public void remove(String name)
  {
    for (int i = 0; i < cart.size(); i++)
      {
        if (cart.get(i).toString().equals(name))
          {
            entries--;
            price -= cart.get(i).getPrice();
            if (cart.get(i) instanceof ManyPackages)
              {
                things -= ((ManyPackages) cart.get(i)).getCount();
              } // if i is ManyPackages
            else
              things--;
            switch (cart.get(i).getWeight().getUnit())
              {
                case "pound":
                  numPounds -= cart.get(i).getWeight().getAmount();
                case "ounce":
                  numOunces -= cart.get(i).getWeight().getAmount();
                case "kilogram":
                  numKilograms -= cart.get(i).getWeight().getAmount();
                case "gram":
                  numGrams -= cart.get(i).getWeight().getAmount();
              } // switch
            cart.remove(i);
          } // if names are the same
      } // for
  } // remove(String)

  /**
   * Find identical items and merge them into a single item
   * 
   */
  public void merge()
  {
    for (int i = 0; i < cart.size(); i++)
      {
        for (int j = i + 1; j < cart.size(); j++)
          {
            Item item1 = cart.get(i);
            Item item2 = cart.get(j);
            if ((item1 instanceof Package) && (item2 instanceof Package))
              {
                if (item1.equals(item2))
                  {
                    things--;
                    cart.set(i, new ManyPackages((Package) item1, 2));
                    cart.remove(j);
                    entries--;
                  } // if equal
              } // if both Packages
            if ((item1 instanceof ManyPackages)
                && (item2 instanceof ManyPackages))
              {
                if (item1.equals(item2))
                  {
                    things -=
                        (((ManyPackages) item1).getCount()
                         + ((ManyPackages) item2).getCount() - 1);
                    cart.set(i,
                             new ManyPackages(
                                              ((ManyPackages) item1).getType(),
                                              ((ManyPackages) item1).getCount()
                                                  + ((ManyPackages) item2).getCount()));
                    cart.remove(j);
                    entries--;
                  } // if equal
              } // if both ManyPackages
            if ((item1 instanceof ManyPackages) && (item2 instanceof Package))
              {
                if (item1.equals(item2))
                  {
                    things -= ((ManyPackages) item1).getCount();
                    cart.set(i,
                             new ManyPackages(
                                              ((ManyPackages) item1).getType(),
                                              ((ManyPackages) item1).getCount() + 1));
                    cart.remove(j);
                    entries--;
                  } // if equal
              } // if one ManyPackages and one Package
            if ((item1 instanceof Package) && (item2 instanceof ManyPackages))
              {
                if (item1.equals(item2))
                  {
                    things -= ((ManyPackages) item2).getCount();
                    cart.set(i,
                             new ManyPackages(
                                              ((ManyPackages) item2).getType(),
                                              ((ManyPackages) item2).getCount() + 1));
                    cart.remove(j);
                    entries--;
                  } // if equal
              } // if one Package and one ManyPackages
            if ((item1 instanceof BulkItem) && (item2 instanceof BulkItem))
              {
                if (item1.equals(item2))
                  {
                    things--;
                    cart.set(i,
                             new BulkItem(((BulkItem) item1).getFood(),
                                          ((BulkItem) item1).getUnit(),
                                          ((BulkItem) item1).getAmount()
                                              + ((BulkItem) item2).getAmount()));
                    cart.remove(j);
                    entries--;
                  } // if equal
              } // if both BulkItems
          } // for j
      } // for i
  } // merge()
} // class Cart
