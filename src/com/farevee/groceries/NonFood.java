package com.farevee.groceries;

public class NonFood
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
   * Create new NonFood item
   * 
   * @param name
   * @param weight
   * @param price
   */
  public NonFood(String name, Weight weight, int price)
  {
    this.name = name;
    this.weight = weight;
    this.price = price;
  } // NonFood(String, Weight, int)
  
  //+---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Produce a string of the NonFood item's name
   */
  public String toString()
  {
    return this.name;
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
   * Check to see if this and another NonFood item have equal fields
   * 
   * @param other
   * @return
   */
  public boolean equals(NonFood other)
  {
    return this.name.equals(other.name) &&
           this.weight.getAmount() == (other.weight.getAmount()) &&
           this.weight.getUnit().equals(other.weight.getUnit()) &&
           this.price == other.price;
  } // equals(NonFood)
  
  /**
   * Check to see if this and another object are equal
   */
  public boolean equals(Object obj)
  {
    if (this == obj)
      {
        return true;
      } // if object share same memory location
    else if (obj instanceof NonFood)
      {
        // use NonFood equals method
        return this.equals(obj);
      } // else if object is NonFood
    else
      {
        return false;
      } // else
  } // equals(Object)
} // class NonFood
