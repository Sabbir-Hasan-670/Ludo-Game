package test;





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class javaproject{
          public static void main (String [] args) throws IOException
    {
        
        
        
        BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
        
        int counter= 100,iteration=-1; 
        System.out.println ("-----------------------------------------------------Game Board-----------------------------------------------------");
        while (counter > 0){
            if (counter%10 == 0 && counter != 100){
                if(iteration==-1)
                {
                    counter-=9;
                    iteration=1;
                }
                else
                {
                    System.out.print(counter+"\t");
                    counter-=10;
                    iteration=-1; 
                }
                if(counter!=0)
                System.out.print("\n" + counter + "\t"); 
            }
            else
            System.out.print(counter + "\t"); 
            counter+=iteration;
        }
        System.out.println();
        System.out.println ("-------------------------------------END BOARD------------------------------------------------------"); 
        
       String sGame = "y"; 
        
        System.out.println ("Do you want to play? y or N     >  "); 
     
        sGame = in.readLine (); 
        System.out.print ("you are in game ");
        
        while (sGame.equals ("y") || sGame.equals ("y"))
        {
            sGame = startGame(sGame); 
        }
        System.out.println ("\n\n\n\n\t\t\t\t\t\tSEE YA!!");
        
        
    }
          public static String startGame (String start) throws IOException 
          {
              
              BufferedReader in2 = new BufferedReader (new InputStreamReader (System.in));
              
              
              int userPosition = 0; 
              int compPosition = 0; 
              int diceRoll = 0; 
            //  int diceRoll2 = 0; 
              int userRoll = 0;
              int compRoll = 0; 
              String playAgain = "y"; 
			
              int snakesLaddersArray [] = new int [6]; 
             
              snakesLaddersArray [0] = 54;
              snakesLaddersArray [1] = 90;
              snakesLaddersArray [2] = 99;
              snakesLaddersArray [3] = 9;
              snakesLaddersArray [4] = 40;
              snakesLaddersArray [5] = 67;
              
              
              while (playAgain.equals ("y") || playAgain.equals ("y")) 
              {
                  
                /*  if(diceRoll=6) {
                	  System.out.println("you enterd the game");
                  }
                  else {
                	  System.out.print("you need to roll again");
                  }*/
                
                  userRoll =  getDice(diceRoll); 
                  compRoll =  getDice(diceRoll); 
                  System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                  System.out.println ("\t\t\t\t\t------------------------------------------");
                  System.out.println ("\t\t\t\t\t|\tYou Rolled a " + userRoll + "\t\t|"); 
                  System.out.println ("\t\t\t\t\t|\tThe Computer Rolled a " + compRoll + "\t|"); 
                  System.out.println ("\t\t\t\t\t------------------------------------------");
                  
                  
                  userPosition = userPosition + userRoll;
                  
                 
                  compPosition = compPosition + compRoll;
                  
                  
                  
                  
                  userPosition = getP(userPosition, userRoll, snakesLaddersArray);
                  
                  compPosition = compgetP(compPosition, compRoll, snakesLaddersArray, userPosition);
              
                  System.out.println("\t\t\t*************************************************************************");
                  System.out.println ("\t\t\t*\t\tYou are currently on square " + userPosition + "\t\t\t*"); 
                  System.out.println ("\t\t\t*\t\tThe Computer is currently on square " + compPosition + "\t\t*");
                  System.out.println("\t\t\t*************************************************************************");
                  
                 
                  if (userPosition == 100 || compPosition == 100)
                  {
                      userPosition = 0;
                      compPosition = 0;
                      System.out.print ("roll again press y    >  ");
                      playAgain =in2.readLine ();
                      System.out.print ("\n\n\n\n\n\n\n\n\n\n\n\n");
                  }
                  else
                  {
                     
                      System.out.print ("roll again press y     >  ");
                      playAgain = in2.readLine ();
                      
                  }
                  
                  
              }
              
              return playAgain; 
          }
          
          public static int getDice (int diceRoll)
          {
              diceRoll = (int)(Math.random()*6 )+1 ;
              diceRoll = (int)(Math.random()*6 )+1 ; 
              int move = diceRoll ; 
              return move; 
          }
          public static int getP (int userPosition, int userRoll, int snakesLaddersArray []) throws IOException 
          {
              
              
              if(userPosition == snakesLaddersArray[0])
              {
                  userPosition = 19; 
                  System.out.println ("\t\t\t\t~~~~~~~~~~~~~ Bad Luck..You Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
              }
              else if (userPosition == snakesLaddersArray[1]) 
              {
                  userPosition = 48; 
                  System.out.println ("\t\t\t\t~~~~~~~~~~~~~Bad Luck..You Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
                  
              }
              else if (userPosition == snakesLaddersArray[2]) 
              {
                  userPosition = 77; 
                  System.out.println ("\t\t\t\t~~~~~~~~~~~~~Bad Luck..You Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
              }
              else if (userPosition == snakesLaddersArray[3]) 
              {
                  userPosition = 34; 
                  System.out.println ("\t\t\t\t~~~~~~~~~~~~~Great..You Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
                  
              }
              else if (userPosition == snakesLaddersArray[4]) 
              {
                  userPosition = 64; 
                  System.out.println ("\t\t\t\t~~~~~~~~~~~~~Great..You Got A Ladder!! GO UP!!!!~~~~~~~~~~~~~");
                  
              }
              else if (userPosition == snakesLaddersArray[5]) 
              {
                  
                  
                  userPosition = 86; 
                  System.out.println ("\t\t\t\t~~~~~~~~~~~~~Great..You Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
              }
              
              if (userPosition < 0 || userPosition > 112) 
              {
                  System.out.println ("An error has occured please reset the game!!!!!!");
              }
              
              else if (userPosition > 100) 
              {
                  userPosition = userPosition - userRoll; 
                  System.out.println ("Not over 100.. Roll Again"); 
                  
              }
              else if (userPosition == 100)
              {
                  System.out.println ("hurray....you won the game.you got gold madle"); 
                  
              }
              
              
              
              return userPosition; 
              }
          public static int compgetP (int compPosition, int compRoll, int snakesLaddersArray [], int userPosition) throws IOException
          {
              
              if(compPosition == snakesLaddersArray[0])
              {
                  compPosition = 19;
                  System.out.println ("\t\t\t\t~~~~~~~~~~~~~Computer Got Bit By A Snake, HE WENT GO DOWN!!!~~~~~~~~~~~~~");
                  
                  
              }
              else if (compPosition == snakesLaddersArray[1])
              {
                  compPosition = 48;
                  System.out.println ("\t\t\t\t~~~~~~~~~~~~~Computer Got Bit By A Snake, HE WENT GO DOWN!!!~~~~~~~~~~~~~");
                  
              }
              else if (compPosition == snakesLaddersArray[2])
              {
                  compPosition = 77;
                  System.out.println ("\t\t\t\t~~~~~~~~~~~~~Computer Got Bit By A Snake, HE WENT GO DOWN!!!~~~~~~~~~~~~~");
              }
              else if (compPosition == snakesLaddersArray[3])
              {
                  compPosition = 34;
                  System.out.println ("Computer Got TO A Ladder, HE WENT UP!!!");
              }
              else if (compPosition == snakesLaddersArray[4])
              {
                  compPosition = 64;
                  System.out.println ("Computer Got TO A Ladder, HE WENT UP!!!");
                  
              }
              else if (compPosition == snakesLaddersArray[5])
              {
                  compPosition = 86;
                  System.out.println ("Computer Got TO A Ladder, HE WENT UP!!!");
              }
              
              
              if (compPosition < 0 || compPosition > 112) 
              {
                  System.out.println ("An error has occured for the computer, please reset the game!!!!!!");
              }
              
              else if (compPosition > 100) 
              {
                  compPosition = compPosition - compRoll;
                  System.out.println ("Not over 100.. Roll Again"); 
                  
              }
              else if (compPosition == 100 && userPosition != 100)
              {
                  System.out.println ("THE COMPUTER WON, Better luck next time!!!"); 
                  
              }
              
              return compPosition; 
          } 
      }
          
          
          
          

          
          
          
		
