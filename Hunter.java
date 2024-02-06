/**
* Hunter Class
* This class represents the treasure hunter character (the player) in the Treasure Hunt game.
* @author Ivan Turner
*/
public class Hunter
{
   //Keeps the items in the kit separate.
   public static final char KIT_DELIMITER = ';';
   
   //Class member variables.
   private String hunterName;
   private String kit;
   private int gold;
   
   //Constructor
/**
* The base constructor of a Hunter assigns the name to the hunter and an empty kit.
*
* @param name The hunter's name.
*/
   public Hunter(String name)
   {
      hunterName = name;
      kit = "";
   }
   
   //Accessors
   
/**
* Accesses the hunter's name.
*
* @return The hunter's name.
*/
   public String getHunterName()       {return hunterName;}
   
/**
* Accesses the hunter's kit.
*
* @return The hunter's kit.
*/
   public String getKit()              {return kit;}
   

  
   
/**
* Searches the kit String for a specified item.
*
* @param item The search item
*
* @return true if the item is found.
*/
   public boolean hasItemInKit(String item)
   {
      int placeholder = 0;
      
      while (placeholder < kit.length() - 1)
      {
         int endOfItem = kit.indexOf(KIT_DELIMITER, placeholder);
         String tmpItem = kit.substring(placeholder, endOfItem);
         //System.out.println(tmpItem);
         placeholder = endOfItem + 1;
         if (tmpItem.equals(item))
            return true;
      }
      
      return false;
   }

  /**
* Adds an item to the end of the String representing the hunter's kit.  
* A KIT_DELIMITER character is added to the end of the of String.
*
* @param item The item to be added to the kit.
*/
  
   public boolean addItem(String item){
   if (hasItemInKit(item) == false)
  {
    kit += item + KIT_DELIMITER;
    return true;
  }
    return false;
  }
   
//removes item from kit

 public void removeItem(String item)
   {
      int itmIdx = kit.indexOf(item);
   
      if (itmIdx < 0)
         return;
     
      String tmpKit = kit.substring(0, itmIdx);
      int endIdx = kit.indexOf(KIT_DELIMITER, itmIdx);
      tmpKit += kit.substring(endIdx + 1);
      
      kit = tmpKit;
   }

  /*public void itemDurability()
  {
    
  }*/

  
/**
* @return A string representation of the hunter.
*/
   public String toString()
   {
      return hunterName + " has " + kit + "" + gold;
   }


/**
* Buys an item from a shop.
* 
* @param item The item the hunter is buying.
* @param s The Shop from which the Hunter is buying the item.
*
* @return true if the item is successfully bought.
*/   
   public boolean buyItem(String item, Shoppe shop)
   {
      int costItem = shop.getCostOfItem(item);
      
     if (costItem == 0 || gold < costItem || hasItemInKit(item))
      {
         return false;
      }
     
      gold -= costItem;
      addItem(item);
      return true;
   }

   public boolean sellItem(String item, Shoppe shop)
   {
      int sellCost = shop.getBuyBackCost(item);
     
      if (sellCost <= 0 || !hasItemInKit(item))
      {
         return false;
      }
     
      gold += sellCost;
      removeItem(item);
      return true;
   }

   public void changeGold(int modifier)   
   {
      gold += modifier;
      if (gold < 0)
         gold = 0;
   }
}