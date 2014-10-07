package com.farevee.groceries;

public class BulkItem
    implements Item
{
  //+--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  BulkFood food;
  Units unit;
  int amount;
  
  //+--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a new BulkItem item
   * 
   * @param food
   * @param unit
   * @param amount
   */
  public BulkItem(BulkFood food, Units unit, int amount)
  {
    this.food = food;
    this.unit = unit;
    this.amount = amount;
  } // BulkItem(BulkFood, Units, int)
  
  //+---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Produce a string with the weight of the BulkItem and the
   * name of the BulkFood
   */
  public String toString()
  {
    return this.getWeight() + " of " + this.food.toString();
  } // toString()

  /**
   * Get the weight
   */
  public Weight getWeight()
  {
    return new Weight(this.unit, this.amount);
  } // getWeight()

  /**
   * Get the price
   */
  public int getPrice()
  {
    return this.food.pricePerUnit * this.amount;
  } // getPrice()
  
  /**
   * Get the type of food
   * 
   * @return
   */
  public BulkFood getFood()
  {
    return this.food;
  } // getFood()
  
  /**
   * Get the unit
   * 
   * @return
   */
  public Units getUnit()
  {
    return this.unit;
  } // getUnit()
  
  /**
   * Get amount
   * 
   * @return
   */
  public int getAmount()
  {
    return this.amount;
  } // getAmount()
  
  /**
   * Check to see if this and another BulkItem have equal fields
   * 
   * @param other
   * @return
   */
  public boolean equals(BulkItem other)
  {
    return this.food.equals(other.food) &&
           this.unit.equals(other.unit)&&
           this.amount == other.amount;
  } // equals(BulkItem)

  /**
   * Check to see if this and another object are equal
   */
  public boolean equals(Object obj)
  {
    if (this == obj)
      {
        return true;
      } // if object share memory location
    else if (obj instanceof BulkItem)
      {
        // use BulkItem equals method
        return this.equals(obj);    
      } // else if object is BulkItem
    else
      {
        return false;
      } // else
  } // equals(Object)
} // class BulkItem
