
public class Guard extends Player {
	String name;
	String pos;
	int pts;
	int reb;
	int ast;
	double ftp;
	//position specific
	int AlleyUpPasses;
	int steals;

	

	@Override
	public String toString() {
		return "Guard [name=" + name + ", pos=" + pos + ", pts=" + pts + ", reb=" + reb + ", ast=" + ast + ", ftp="
				+ ftp + ", AlleyUpPasses=" + AlleyUpPasses +  ", steals=" + steals
				+ "]";
	}

	public Guard(String name, String pos, int pts, int reb, int ast, double ftp, int passiveStat, int agressiveStat) {
		super();
		this.name = name;
		this.pos = pos;
		this.pts = pts;
		this.reb = reb;
		this.ast = ast;
		this.ftp = ftp;
		this.AlleyUpPasses=passiveStat;
		this.steals=agressiveStat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public int getPts() {
		return pts;
	}

	public void setPts(int pts) {
		this.pts = pts;
	}

	public int getReb() {
		return reb;
	}

	public void setReb(int reb) {
		this.reb = reb;
	}

	public int getAst() {
		return ast;
	}

	public void setAst(int ast) {
		this.ast = ast;
	}

	public double getFtp() {
		return ftp;
	}

	public void setFtp(double ftp) {
		this.ftp = ftp;
	}

	public int getAlleyUpPasses() {
		return AlleyUpPasses;
	}

	public void setAlleyUpPasses(int alleyUpPasses) {
		AlleyUpPasses = alleyUpPasses;
	}

	public int getSteals() {
		return steals;
	}

	public void setSteals(int steals) {
		this.steals = steals;
	}

	@Override
	public String position() {
		// TODO Auto-generated method stub
		return "Guard";
	}



	public int getAgressiveStat() {
		// TODO Auto-generated method stub
		return getSteals();
	}

	@Override
	public int getPassiveStat() {
		// TODO Auto-generated method stub
		return getAlleyUpPasses();
	}

	public void setAgressiveStat(int stat) {
		setSteals(stat);
	}

	public void setPassiveStat(int stat) {
		setAlleyUpPasses(stat);
		
	}

	@Override
	public void printPassiveStat() {
		System.out.print("Alley ups: "+this.AlleyUpPasses);
		
	}

	@Override
	public void printAgressiveStat() {
		System.out.print(" Steals: "+this.steals);
		
	}

}
