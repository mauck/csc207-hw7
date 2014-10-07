package com.farevee.groceries;

public class ManyPackages
    implements Item
{
  //+--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  Package type;
  int count;
  
  //+--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a new ManyPackages item
   * 
   * @param type
   * @param count
   */
  public ManyPackages(Package type, int count)
  {
    this.type = type;
    this.count = count;
  } // ManyPackages(Package, int)
  
  //+---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Produce a string that adds the number of packages onto
   * the package string
   */
  public String toString()
  {
    return count + " \u00D7 " + this.type.toString();
  } // toString()

  /**
   * Get the weight
   */
  public Weight getWeight()
  {
    return new Weight(this.type.weight.unit, this.type.weight.amount * count);
  } // getWeight()

  /**
   * Get the price
   */
  public int getPrice()
  {
    return this.type.price * this.count;
  } // getPrice()
  
  /**
   * Return count
   * 
   * @return
   */
  public int getCount()
  {
    return this.count;
  } // getCount()
  
  /**
   * Get the type of Packages
   * 
   * @return
   */
  public Package getType()
  {
    return this.type;
  }
  
  /** 
   * Check to see if this and another object share the same
   * space in memory
   */
  public boolean equals(Object obj)
  {
    if (this == obj)
      {
        return true;
      } // if objects share memory location
    else
      {
        return false;
      } // else
  } // equals(Object)
} // class ManyPackages
