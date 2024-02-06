/**
* The Town Class is where it all happens.
* The Town is designed to manage all of the things a Hunter can do in town.
* @author Ivan Turner
*/
public class Town
{
   //Member Variables
   private Hunter hunter;
   private Shoppe shop;
   private Terrain terrain;
   private String townCryer;
   private double toughMeter;
   
   //Constructor
   /**
   * The Town Constructor takes in a shop and the surrounding terrain, but leaves the hunter as null until one arrives.
   * @param s The town's shoppe.
   * @param t The surrounding terrain.
   */
   public Town(Shoppe s, Terrain t)
   {
      shop = s;
      terrain = t;
      hunter = null;
      townCryer = "";
      toughMeter = (int)(Math.random() * 10) + 1;
   }
   
   //Accessors
   public String getLatestNews()             
  {
    return townCryer;
  }
   
   /**
   * Assigns an object to the Hunter in town.
   * @param h The arriving Hunter.
   */
   public void hunterArrives(Hunter h)
   {
      hunter = h;
      townCryer = "Welcome to town, " + hunter.getHunterName() + ".";
   }
   
   /**
   * Determines whether or not a used item has broken.
   * @return true if the item broke.
   */
   public boolean checkItemBreak()
   {
      return Math.random() < .5;
   }
   
   /**
   * Handles the action of the Hunter leaving the town.
   * @return true if the Hunter was able to leave town.
   */
   public boolean leaveTown()
   {
      String itm = terrain.canCrossTerrain(hunter);
      if (itm != null)
      {
         townCryer = "You used your " + itm + " to cross the " + terrain.getTerrainName() + ".";
         
         if (checkItemBreak())
         {
            hunter.removeItem(itm);
            townCryer += "/n Unfortunately, your " + itm + " broke.";
         }
            
         return true;
      }
      
      townCryer = "You can't leave town, " + hunter.getHunterName() + ". You don't have a " +   terrain.getNeededItem() + ".";
      return false;
   }
   
   /**
   * A pathway method that lets the Hunter buy an item.
   * @param item The item being bought.
   */
   public void buyItem(String item)
   {
      if (hunter.buyItem(item, shop))
         townCryer = "Ya' got yerself a " + item + ". Don't come again unless you got the cash.";
      else        
         townCryer = "What're you tryin' ta pull?!";
   }
   
   /**
   * A pathway method that lets the Hunter sell an item.
   * @param item The item being sold.
   */
   public void sellItem(String itm)
   {
      if (hunter.sellItem(itm, shop))
         townCryer = "Nice doing business, same time next week?";
      else   
         townCryer = "Whats going on here?!";
   }

   public void lookForTrouble()
  {
     townCryer = "Finally a worthy opponent";
     townCryer += "\n***\n";
      int goldDiff = (int)(Math.random() * 10) + 1;
      if ((int)(Math.random() * 10) + 1 >= toughMeter)
      {
         townCryer += "I'll get you next time!";
         hunter.changeGold(goldDiff*3);
      }
      else
      {
         townCryer += "I'm just holding back my true power.";
         hunter.changeGold(goldDiff * -1);
         toughMeter -= .5;
      }
     /*if (Math.random() >= toughMeter)
     {
       townCryer = "You will find no quarrel here";
       return;
     }
    

     if (Math.random() >= toughMeter)
     {
       townCryer = "Damn ye for eternity";
       hunter.changeGold((int) Math.random() * 10);
     }
     else
     {
        townCryer = "You however, seem to be maidenless";
        hunter.changeGold((int) Math.random() * -10);
     }*/
  }

     /**
   * Determines and returns the cost of buying or selling an item.
   * @param item The item in question.
   * @param isBuying Whether the item is being bought or sold.
   * @return The cost of buying or selling the item based on the isBuying parameter.
   */
   public int checkMarketPrice(String item, boolean isBuying)
   {
      if (isBuying)
         return shop.getCostOfItem(item);
      else
         return shop.getBuyBackCost(item);
   }
   
   public String toString()
   {
      return "This nice little town is surrounded by " + terrain.getTerrainName() + ".";
   }
}