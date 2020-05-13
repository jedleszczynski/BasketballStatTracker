import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;

public class Driver {


	public static void main(String[] args) {
		System.out.println("Welcome to Basketball Sport Tracker 2.0");
		Game theGame = new Game();
		boolean keeplooping=true;
		while (keeplooping==true)
		{
			System.out.println("1. Load Game from a  File");
			System.out.println("2. Display current Box Score");
			System.out.println("3. Modify Game");
			System.out.println("4. Save current game box score to file");
			System.out.println("5. Quit");
			int choice = getIntFromUser("Choose an option from 1-5: ");
			switch(choice)
			{ 
			case 1 : 
				System.out.println("	You chose option 1"); 
				System.out.println("Enter file name :");
				String filename=scanString.nextLine();
				theGame=readGameFromFile(filename);
				break; 
			case 2 : 
				System.out.println("	You chose option 2");
				displayTheGame(theGame);
				break; 
			case 3 : 
				System.out.println("	You chose option 3");
				EditBoxScore(theGame);
				break;
			case 4 : 
				System.out.println("	You chose option 6");
				saveCurrentGameToFile(theGame);
				break; 
			case 5 : 
				System.out.println("	Thank you for using the program");
				keeplooping=false;
				break;
			default: 
				System.out.println("Invalid response");      
			}
		}





	}
	private static Scanner scanString=new Scanner(System.in);
	public static int getIntFromUser(String prompt)
	{
		int return_value =-1;


		boolean badInput = true;
		while (badInput)
		{
			System.out.print(prompt);
			String whatTheUserTyped = scanString.nextLine();
			try{
				// I have to try and extract an int from whatTheUserTyped
				return_value = Integer.parseInt(whatTheUserTyped);
				badInput = false;
			}catch(NumberFormatException e)
			{
				System.out.println("Error, you didn't enter an int: " + whatTheUserTyped);
			}
		}

		return return_value;
	}
	private static void displayTheGame(Game theGame) {
		if(theGame.points_scored==-1) {
			System.out.println("Game not loaded yet! Please load a game from a file");
		}
		else
		{
			System.out.println(theGame.date+" "+theGame.HomeTeam+" "+theGame.points_scored+" vs "+theGame.points_lost+" "+theGame.OpposingTeam+"\n" );
			System.out.print(theGame.HomeTeam.toUpperCase()+" STATS Total Points: "+theGame.getTeamPts()+", Total Rebounds: "+theGame.getTeamReb()+
					", Total Assists: "+theGame.getTeamAst()+", Team ftp: "+Math.round(100*theGame.getTeamFtp())+"%"+underline);
			for (int i = 0; i< theGame.BoxScore.size(); i++)
			{
				// this will call the toString function of a Point,
				// which isn't the correct format
				System.out.print("Index "+i+" "+theGame.BoxScore.get(i).getName()+" "+
						theGame.BoxScore.get(i).getPos()+" Pts:"+
						theGame.BoxScore.get(i).getPts()+" Reb:"+
						theGame.BoxScore.get(i).getReb()+" Ast:"+
						theGame.BoxScore.get(i).getAst()+" Ftp: "+
						Math.round(100*theGame.BoxScore.get(i).getFtp())+"% ");
				theGame.BoxScore.get(i).printPassiveStat();
				theGame.BoxScore.get(i).printAgressiveStat();
				System.out.println("\n"+underline);
				
				

			}
		}
	}
	private static Game  readGameFromFile(String file_name)
	{
		File file = new File(file_name);
		ArrayList<Player> BoxScore= new ArrayList<Player>();
		Game aGame = new Game();


		try {
			Scanner scanner = new Scanner(file);
			String date=scanner.nextLine();
			String HomeTeam=scanner.next().trim();
			String points_scored_str=scanner.nextLine().trim();
			String OpposingTeam=scanner.next().trim();
			String points_lost_str=scanner.nextLine().trim();
			int points_scored=Integer.parseInt(points_scored_str);
			int points_lost=Integer.parseInt(points_lost_str);
			aGame= new Game(date,HomeTeam,points_scored,OpposingTeam,points_lost,BoxScore);
			while (scanner.hasNextLine()) {
				
				String name =scanner.next().trim();
				String pos =scanner.next().trim();
				String pts_str = scanner.next().trim();
				String reb_str = scanner.next().trim();
				String ast_str = scanner.next().trim();
				String ftp_str = scanner.next().trim();
				String passiveStat_str=scanner.next().trim();
				String agressiveStat_str=scanner.nextLine().trim();
				int pts=Integer.parseInt(pts_str);
				int reb=Integer.parseInt(reb_str);
				int ast=Integer.parseInt(ast_str);
				int agressiveStat=Integer.parseInt(agressiveStat_str);
				int passiveStat=Integer.parseInt(passiveStat_str);
				double ftp=Double.parseDouble(ftp_str);
				Player thePlayer;
				if(pos.equals("C")) {
					thePlayer=new Center(name,pos,pts,reb,ast,ftp,passiveStat,agressiveStat);
					//BoxScore.add(thePlayer);
					//System.out.println("You added: "+thePlayer);
				}
				else if(pos.equals("F")) {
					thePlayer=new Forward(name,pos,pts,reb,ast,ftp,passiveStat,agressiveStat);
					//BoxScore.add(thePlayer);
					//System.out.println("You added: "+thePlayer);
				}
				else  {
					thePlayer=new Guard(name,pos,pts,reb,ast,ftp,passiveStat,agressiveStat);
					//BoxScore.add(thePlayer);
					//System.out.println("You added: "+thePlayer);
				}
				BoxScore.add(thePlayer);
				

			}
			System.out.println("You loaded game:"+aGame);
			aGame.calculateTotals();
		}
		catch (FileNotFoundException e) {
			System.out.println("Erorr! File not found : "+file_name);
		}
		return aGame;
	}
	private static void saveCurrentGameToFile(Game theGame)
	{
		if(theGame.points_scored==-1) {
			System.out.println("Game not loaded yet! Please load a game from a file.");
		}
		else
		{


			String filename=getStringFromUser("Enter the name for the file : ");
			File file = new File(filename);
			try {
				// creates the file
				file.createNewFile();

				// creates a FileWriter Object (like the Scanner used to read in a file)
				FileWriter writer = new FileWriter(file); 

				// Writes the content to the file
				String endln = "\r\n";
				writer.write(theGame.date+endln+theGame.HomeTeam+" "+
						theGame.points_scored+endln+theGame.OpposingTeam+" "+theGame.points_lost+endln);


				for (int i = 0; i< theGame.BoxScore.size(); i++)
				{

					writer.write(theGame.BoxScore.get(i).getName().toString()+" "+
							theGame.BoxScore.get(i).getPos()+" "+
							theGame.BoxScore.get(i).getPts()+" "+
							theGame.BoxScore.get(i).getReb()+" "+
							theGame.BoxScore.get(i).getAst()+" "+
							theGame.BoxScore.get(i).getFtp()+" "+
							theGame.BoxScore.get(i).getPassiveStat()+" "+
							theGame.BoxScore.get(i).getAgressiveStat()+" "+endln);
				}

				writer.flush();
				writer.close();

			} catch (IOException e) {
				System.out.println("Error!");

			}

			System.out.println("Saved to file succesfully");
		}
	}
	private static String getStringFromUser( String prompt) {
		System.out.println(prompt);
		String UserInput=scanString.nextLine();
		return UserInput;
	}
	private static void EditBoxScore(Game theGame) {
		if(theGame.points_scored==-1) {
			System.out.println("Game not loaded yet! Please load a game from a file");
		}
		else
		{
			displayTheGame(theGame);
			int i=ScanForIndexInRange("Enter player at index that you want to change: ", 0, (theGame.BoxScore.size()-1));
			System.out.println("What stat do you want to change : ");
			System.out.println("1. Pts");
			System.out.println("2. Reb");
			System.out.println("3. Assists");
			System.out.println("4. FT% ");
			if(theGame.BoxScore.get(i).position().equals("Center")) {
				System.out.println("5.Set Screens");	
				System.out.println("6.Blocks");	
			}
			else if(theGame.BoxScore.get(i).position().equals("Forward")) {
				System.out.println("5.Three pointers");	
				System.out.println("6. Dunks");	
			}
			else  {// A guard
				System.out.println("5.Alley up passes ");	
				System.out.println("6. Steals");	
			}
			System.out.println("7. Cancel");
			int choice = getIntFromUser("Choose an option from 1-7: ");
			switch(choice)
			{ 
			case 1 : 

				System.out.println("Current pts : "+theGame.BoxScore.get(i).getPts());
				theGame.BoxScore.get(i).setPts(getIntFromUser("Change to: "));
				break; 
			case 2 : 
				System.out.println("Current reb : "+theGame.BoxScore.get(i).getReb());
				theGame.BoxScore.get(i).setReb(getIntFromUser("Change to: "));
				break; 
			case 3 : 
				System.out.println("Current ast : "+theGame.BoxScore.get(i).getAst());
				theGame.BoxScore.get(i).setAst(getIntFromUser("Change to: "));
				break;
			case 4 : 
				System.out.println("Current ftp : "+theGame.BoxScore.get(i).getFtp());
				theGame.BoxScore.get(i).setFtp(ScanForDoubleInRange("Change to: ", 0, 1));

				break; 
			case 5 : 
				System.out.println("Current  : "+theGame.BoxScore.get(i).getPassiveStat());
				theGame.BoxScore.get(i).setPassiveStat(getIntFromUser("Change to: "));
				break; 
			case 6 : 
				System.out.println("	You chose option 6");

				System.out.println("Current  : "+theGame.BoxScore.get(i).getAgressiveStat());
				theGame.BoxScore.get(i).setAgressiveStat(getIntFromUser("Change to: "));
				break; 
			case 7 : 
				break;
			default: 
				System.out.println("Invalid response");      
			}
		}
	}
	private static int ScanForIndexInRange(String prompt, int min, int max)
	{
		int ReturnValue =-1;
		if(min>max)
		{
			System.out.println("Can't perform operation");
			return -1;
		}

		boolean badInput = true;
		while (badInput)
		{
			System.out.print(prompt);
			String whatTheUserTyped = scanString.nextLine();
			try{
				ReturnValue = Integer.parseInt(whatTheUserTyped);
				badInput = false;

				if ((ReturnValue<min) || (ReturnValue>max)){
					System.out.println("Please, enter a number that is from "+min+" - "+max+" range!");
					badInput=true;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Error, you didn't enter an int: " + whatTheUserTyped);
			}

		}


		return ReturnValue;
	}
	private static double ScanForDoubleInRange(String prompt, double min, double max)
	{
		double ReturnValue =-1.0;
		if(min>max)
		{
			System.out.println("Can't perform operation");
			return -1.0;
		}

		boolean badInput = true;
		while (badInput)
		{
			System.out.print(prompt);
			String whatTheUserTyped = scanString.nextLine();
			try{
				ReturnValue = Double.parseDouble(whatTheUserTyped);
				badInput = false;

				if ((ReturnValue<min) || (ReturnValue>max)){
					System.out.println("Please, enter a number that is from "+min+" - "+max+" range!");
					badInput=true;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Error, you didn't enter a double: " + whatTheUserTyped);
			}

		}

		//

		return ReturnValue;
	}
	static String underline="\n_________________________________________________________________________________________\n";
}	

