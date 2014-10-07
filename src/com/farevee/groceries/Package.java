package com.farevee.groceries;

public class Package
    implements Item
{
  //+--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  String name;
  Weight weight;
  int price;
  
  //+--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a new Package item
   * 
   * @param name
   * @param weight
   * @param price
   */
  public Package(String name, Weight weight, int price)
  {
    this.name = name;
    this.weight = weight;
    this.price = price;
  } // Package(String, Weight, int)
  
  //+---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Produce a string of the weight and name of the package
   */
  public String toString()
  {
    return this.weight.amount + " " + this.weight.unit.abbrev + " package " + " of " + name;
  } // toString()

  /**
   * Get the weight
   */
  public Weight getWeight()
  {
    return this.weight;
  } // getWeight()

  /**
   * Get the price
   */
  public int getPrice()
  {
    return this.price;
  } // getPrice()

  /**
   * Check to see if this and another Package have equal fields
   * 
   * @param other
   * @return
   */
  
  // My equals method wasn't working originally because I was comparing
  // Weights, when I actually needed to compare the two fields of the
  // Weights. I realized this thanks to Patrick Slough's version of the
  // method: https://github.com/pslough93/Assignment6/blob/master/src/com/farevee/groceries/Package.java
  public boolean equals(Package other)
  {
    return this.name.equals(other.name) &&
           this.weight.getAmount() == (other.weight.getAmount()) &&
           this.weight.getUnit().equals(other.weight.getUnit()) &&
           this.price == other.price;
  } // equals(Package)
  
  /**
   * Check to see if this and another object are equal
   */
  public boolean equals(Object obj)
  {
    if (this == obj)
      {
        return true;
      } // if objects share memory location
    else if (obj instanceof Package)
      {
        // use Package equals method
        return this.equals((Package) obj);
      } // else if object is Package
    else
      {
        return false;
      } // else
  } // equals(Object)
} // class Package