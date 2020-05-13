
public abstract class Player {
	
	
	
	
	public Player() {}
	//Returns the position for the player
	public abstract String position();
	
	
	public abstract int getAgressiveStat();
	public abstract void setAgressiveStat(int stat);
	public abstract int getPassiveStat();
	public abstract void setPassiveStat(int stat);
	public abstract String getName();
	public abstract void setName(String name);
	public abstract String getPos();
	public abstract void setPos(String pos);
	public abstract int getPts();
	public abstract void setPts(int pts);
	public abstract int getReb();
	public abstract void setReb(int reb);
	public abstract int getAst();
	public abstract void setAst(int ast);
	public abstract double getFtp();
	public abstract void setFtp(double ftp);
	public abstract void printPassiveStat();
	public abstract void printAgressiveStat();

		
	
	
	
	//I'd like each Player to have attributes POINTS, REBOUNDS, ASSISTS and additional attributes specific for each position
	// f. ex. for CENTER : BLOCKS, , Screens set, Post Scores
	// 		  for POINT GUARD: Alley Up passes, Ankle Breakers, Steals
	// 		  for Forwards: 3pt made, DUNKS 	 

}
