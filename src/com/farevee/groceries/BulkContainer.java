package com.farevee.groceries;

public class BulkContainer
    extends BulkItem
{
  //+--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  String container;
  
  //+--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a new BulkContainer item
   * 
   * @param container
   * @param food
   * @param unit
   * @param amount
   */
  public BulkContainer(String container, BulkFood food, Units unit, int amount)
  {
    super(food, unit, amount);
    this.container = container;
  } // BulkContainer(String, BulkFood, Units, int)
  
  //+---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Produce a string that adds the container to the string
   * returned by the BulkItem
   */
  public String toString()
  {
    return this.container + " of " + super.toString();
  } // toString()

  /**
   * Check to see if this and another BulkContainer have equal fields
   * 
   * @param other
   * @return
   */
  public boolean equals(BulkContainer other)
  {
    return this.container.equals(other.container) &&
           super.equals(other);
  } // equals(BulkContainer)
  
/**
 * Check to see if this and another object are equal
 */
  public boolean equals(Object obj)
  {
    if (this == obj)
      {
        return true;
      } // if objects share memory location
    else if (obj instanceof BulkContainer)
      {
        // use BulkContainer equals method
        return this.equals(obj);
      } // else if object is BulkContainer
    else
      {
        return false;
      } // else
  } // equals(Object)
} // class BulkContainer
