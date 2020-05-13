import java.util.ArrayList;

public class Game {
	String date;
	String HomeTeam;
	int points_scored;
	String OpposingTeam;
	int points_lost;
	int teamPts=0;
	int teamReb=0;
	int teamAst=0;
	double teamFtp=0.0;
	
	public ArrayList<Player> BoxScore= new ArrayList<Player>();
	



	public Game(String date, String homeTeam, int points_scored, String opposingTeam, int points_lost) {
		super();
		this.date = date;
		HomeTeam = homeTeam;
		this.points_scored = points_scored;
		OpposingTeam = opposingTeam;
		this.points_lost = points_lost;
		calculateTotals();
	}

	public void calculateTotals() {
		teamPts=AddPtsRecursively(BoxScore, 0);
		double Totalftp=0.0;
		int numberOfPlayers=0;
		for (int i = 0; i< BoxScore.size(); i++) {
			numberOfPlayers++;
			teamReb+=BoxScore.get(i).getReb();
			teamAst+=BoxScore.get(i).getAst();
			Totalftp=Totalftp+BoxScore.get(i).getFtp();
			teamFtp=Totalftp/(i+1);
			
			
		}
	}
	public Integer ReccursiveTotals(int i)
	{
		if(i==BoxScore.size()-1)
		{
			;
		}
		
		return i;	
		
	}
	
	public static Integer AddPtsRecursively(ArrayList<Player> list, int index )
	{
		if (index == list.size()-1)
		{
			return list.get(index).getPts();
		}
		return list.get(index).getPts()+ AddPtsRecursively(list,index+1);
		
	}



	public int getTeamPts() {
		return teamPts;
	}

	public void setTeamPts(int teamPts) {
		this.teamPts = teamPts;
	}

	public int getTeamReb() {
		return teamReb;
	}

	public void setTeamReb(int teamReb) {
		this.teamReb = teamReb;
	}

	public int getTeamAst() {
		return teamAst;
	}

	public void setTeamAst(int teamAst) {
		this.teamAst = teamAst;
	}

	public double getTeamFtp() {
		return teamFtp;
	}

	public void setTeamFtp(double teamFtp) {
		this.teamFtp = teamFtp;
	}

	public Game(String date, String homeTeam, int points_scored, String opposingTeam, int points_lost, ArrayList<Player> boxScore) {
		super();
		this.date = date;
		HomeTeam = homeTeam;
		this.points_scored = points_scored;
		OpposingTeam = opposingTeam;
		this.points_lost = points_lost;
		this.BoxScore= boxScore;
		// TODO Auto-generated constructor stub
	}







	public Game() {
		this.points_scored=-1;
		// TODO Auto-generated constructor stub
	}







	@Override
	public String toString() {
		return "Game [ " + date + " "+HomeTeam+" "+ points_scored+" vs " + OpposingTeam +" "+  points_lost + "]";
	}

}
