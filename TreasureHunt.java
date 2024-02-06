/**
* This class is responsible for controlling the Treasure Hunt game.<p>
* It handles the display of the menu and the processing of the player's choices.<p>
* It handles all of the display based on the messages it receives from the Town object.
*/
public class TreasureHunt
{
   //Class member variables
   private Town currentTown;
   private Hunter hunter;
   public Chasm chasm;
   //Constructor
   /**
   * Constructs the Treasure Hunt game.
   */
   public TreasureHunt()
   {
      createHunter();
      moveOn();
      showMenu();
     
   }
   
   /**
   * Creates a hunter object at the beginning of the game and populates the class member variable with it.
   */
   public void createHunter()
   {
      System.out.println("TREASURE HUNT\n");
      System.out.println("Going hunting for the big treasure, eh?");
      hunter = new Hunter(Jin.readLine("What's your name, Hunter? "));
   }
   
   /**
   * Displays the menu and receives the choice from the user.<p>
   * The choice is sent to the processChoice() method for parsing.<p>
   * This method will loop until the user chooses to exit.
   */
   public void showMenu()
   {
      char choice;
      do
      {
         System.out.println(currentTown.getLatestNews());
         System.out.println("\n***\n");
         System.out.println(hunter);
         System.out.println(currentTown);
         System.out.println("(B)uy something at the shoppe.");
         System.out.println("(S)ell something at the shoppe.");
         System.out.println("(M)ove on to a different town.");
         System.out.println("(L)ook for trouble!");
         System.out.println("(T)ravel into the Chasm [Only if thou have all the items.");
         System.out.println("Give up the hunt and e(X)it.");
		 choice = Jin.readChar("What's your next move? ");
         processChoice(choice);
      } while (choice != 'X' && choice != 'x');
   }
   
   /**
   * Takes the choice received from the menu and calls the appropriate method to carry out the instructions.
   * @param choice The action to process.
   */
   public void processChoice(char choice)
   {
      if (choice == 'B' || choice == 'b' || choice == 's' || choice == 'S')
         headToTheShop(choice);
      else
         if (choice == 'M' || choice == 'm')
         {
            if (currentTown.leaveTown())
            {
               //This town is going away so print its news ahead of time.
               System.out.println(currentTown.getLatestNews());
               moveOn();
            }
         }
       else
            if (choice == 'L' || choice == 'l')
            {
               currentTown.lookForTrouble();
            }
        else
           if (choice == 'T' || choice == 't')
                {
                  chasm = new Chasm(hunter);
                  if (chasm.checkItem() == false)
                  {
                    System.out.println("You do not have the required items.");
                  }
                  else
                  {
                   chasm.enterChasm();  
                  }
                  
                }
    }
   
   /**
   * Negotiates a purchase or sale between the Hunter and the Shop by passing the relevant information into the Town.
   * @param choice Tells the method whether the Hunter is buying or selling.
   */
   public void headToTheShop(char choice)
   {
      if (choice == 'B' || choice == 'b')
      {
        System.out.println("Water");
        System.out.println("Rope");
        System.out.println("Machete");
        System.out.println("Horse");
        System.out.println("Boat");
         String item = Jin.readLine("What're you lookin' to buy? ");
         int cost = currentTown.checkMarketPrice(item, true);
         if (cost == 0)
            System.out.println("We ain't got none of those.");
         else
         {
            if (Jin.readChar("It'll cost you " + cost + " gold. Buy it (y/n)? ") == 'y')
               currentTown.buyItem(item);
         }
      }
      else
      {
        System.out.println("Water");
        System.out.println("Rope");
        System.out.println("Machete");
        System.out.println("Horse");
        System.out.println("Boat");
         String item = Jin.readLine("What're you lookin' to sell? ");
         int cost = currentTown.checkMarketPrice(item, false);
         if (cost == 0)
            System.out.println("We don't want none of those.");
         else
         {
            if (Jin.readChar("It'll get you " + cost + " gold. Sell it (y/n)? ") == 'y')
               currentTown.sellItem(item);
         }
      }
  }
   
   /**
   * Creates a new town and adds the Hunter to it.
   */
   public void moveOn()
   {
      currentTown = new Town(new Shoppe(Math.random()), getNewTerrain());
      currentTown.hunterArrives(hunter);
   }
  
   
   /**
   * Determines the surrounding terrain for a town, and the item needed in order to cross that terrain.
   * @return A Terrain object.
   */
   public Terrain getNewTerrain()
   {
      double rnd = Math.random();
      if (rnd < .2)
         return new Terrain("Mountains", "Rope");
      else
         if (rnd < .4)
            return new Terrain("Ocean", "Boat");
         else
            if (rnd < .6)
               return new Terrain("Plains", "Horse");
            else
               if (rnd < .8)
                  return new Terrain("Desert", "Water");
               else
                  return new Terrain("Jungle", "Machete");
   }

}