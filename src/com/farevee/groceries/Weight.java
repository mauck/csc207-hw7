package com.farevee.groceries;

public class Weight
{
  //+--------+------------------------------------------------------
  // | Fields |
  // +--------+
  Units unit;
  int amount;
  
  //+--------------+------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a new weight with a given unit and amount
   * 
   * @param unit
   * @param amount
   */
  public Weight(Units unit, int amount)
  {
    this.unit = unit;
    this.amount = amount;
  } // Weight(Units, int)
  
  //+-----------+---------------------------------------------------
  // | Accessors |
  // +-----------+
  /**
   * Get the amount and unit, either plural or singular, depending
   * on amount
   */
  public String toString()
  {
    if (amount > 1)
      {
        return this.amount + " " + this.unit.plural;
      } // if amount > 1
    else
      {
        return this.amount + " " + this.unit.name;
      } // else
  } // toString()
  
  /**
   * Get the name of the units
   * 
   * @return
   */
  public String getUnit()
  {
    return this.unit.name;
  } // getUnit()
  
  /**
   * Get the amount
   * 
   * @return
   */
  public int getAmount()
  {
    return this.amount;
  } // getAmount()
} // class Weight
