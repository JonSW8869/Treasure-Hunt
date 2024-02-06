/**
* The Shop class controls the cost of the items in the Treasure Hunt game.<p>
* The Shop class also acts as a go between for the Hunter's buyItem() method.<p>
*/
public class Shoppe
{
   private static final int WATER = 2, ROPE = 4, MACHETE = 6, HORSE = 12, BOAT = 20;
  
   private double markdown;
   //Constructor
   public Shoppe(double md)
   {
     markdown = md;
   }
   
   /**
   * Checks the item entered against the costs listed in the static variables.
   * 
   * @param item The item being checked for cost.
   * @return The cost of the item or 0 if the item is not found.
   */
   public int getCostOfItem(String item)
   {
      if (item.equals("Water"))
         return WATER;
   
      if (item.equals("Rope"))
         return ROPE;
         
      if (item.equals("Machete"))
         return MACHETE;
         
      if (item.equals("Horse"))
         return HORSE;
         
      if (item.equals("Boat"))
         return BOAT;
         
      return 0;
   }

    public int getBuyBackCost(String item)
    {
      return (int)(getCostOfItem(item) * markdown);
    }
}