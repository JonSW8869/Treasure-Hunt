public class Chasm
{
  //Variables 
  private Hunter hunter;
  private Terrain terrain;
  private TreasureHunt TreasureHunt;
  
  public Chasm(Hunter h)
  {
    hunter = h;

  }

  public boolean checkItem()
  {

    if(hunter.hasItemInKit("Machete") && hunter.hasItemInKit("Boat") && hunter.hasItemInKit("Rope") && hunter.hasItemInKit("Horse") && hunter.hasItemInKit("Water") == true)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public boolean checkItemDurability()
  {
    String itm = terrain.canCrossTerrain(hunter);
      if (itm != null)
      {
         System.out.println("You used your " + itm + " to cross the " + " Chasm " + "."); 
         if (checkItemBreak())
         {
            hunter.removeItem(itm);
            System.out.println("/n Unfortunately, your " + itm + " broke.");
         }
            
         return true;
      } 
    return false;    
  }

 public boolean checkItemBreak()
   {
      if (Math.random() < .5)
      {
        return true;
      }
     return false;
   }

  public void enterChasm()
  {

    System.out.println("You used the horse to travel down the Chasm.");
    paths("Horse");
    System.out.println("You used the rope to rappel down into the Chasm.");
    paths("Rope");
    System.out.println("You used the Water quench your thirst.");
    paths("Water");
    System.out.println("You used the Machete to collect the treasure.");
    paths("Machete");
    System.out.println("You used the boat to travel away");
    paths("Boat");
    System.out.println("YOU WON");
  }

  
  public void paths(String Item)
  {
 
    //int chance = (int) Math.random() * 10;
    //int chance2 = (int) Math.random() * 10;
    int probabilty = (int) Math.random()*100;
    int postrobability = 50;
    //for (int counter = 0; checkItem() == true && probabilty > postrobability; counter++)
      //item
    int mmmmmm = (int) (Math.random()*100);
    //System.out.println(mmmmmm);

      if (mmmmmm > 50)
      {
        hunter.removeItem(Item);
        System.out.println("You broke your " + Item + ".");
      }
    for (int counting = 0; probabilty > postrobability; counting++)
      {
        if(probabilty < postrobability)
        {
          postrobability = postrobability - 5;
        }
      }
    if (checkItem() == false) //go back to menu
        {
          System.out.println("You died");
          TreasureHunt = new TreasureHunt();
          TreasureHunt.showMenu();
        }

      //failure
      //if item breaks during loop, leave loop

     
  }

//horse
//rope
//water
//machete
//boat

  //n times u do it
  //chance of item breaks
  //chance of redo event
  //chance increase 5% each time. new variable containing number (chance)
}
