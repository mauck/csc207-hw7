package com.farevee.groceries;

public interface Item
{ 
  /**
   * Get the weight of an Item
   */
  public Weight getWeight();
  
  /**
   * Get the price of an item
   * @return
   */
  public int getPrice();
  
  /**
   * Return a string that describes the item
   * @return
   */
  public String toString();
} // interface Item
