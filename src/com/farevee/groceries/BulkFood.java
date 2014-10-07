package com.farevee.groceries;

public class BulkFood
{
  //+--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  String name;
  Units unit;
  int pricePerUnit;
  int supply;

  //+--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a new BulkFood item
   * 
   * @param name
   * @param unit
   * @param pricePerUnit
   * @param supply
   */
  public BulkFood(String name, Units unit, int pricePerUnit, int supply)
  {
    this.name = name;
    this.unit = unit;
    this.pricePerUnit = pricePerUnit;
    this.supply = supply;
  } // BulkFood(String, Units, int, int)

  //+---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Produce a string of the BulkFood's name
   */
  public String toString()
  {
    return this.name;
  } // toString()

  /**
   * Decrement supply by a specified amount
   * 
   * @param amount
   */
  public void decrementSupply(int amount)
  {
    this.supply -= amount;
  } // decrementSupply(int)

} // class BulkFood
