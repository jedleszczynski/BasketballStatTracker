
public class Forward extends Player {
	
	String name;
	String pos;
	int pts;
	int reb;
	int ast;
	double ftp;
	//position specific
	int threePointers;
	int dunks;
	
	
	
	public Forward(String name, String pos, int pts, int reb, int ast, double ftp, int passiveStat, int agressiveStat) {
		super();
		this.name = name;
		this.pos = pos;
		this.pts = pts;
		this.reb = reb;
		this.ast = ast;
		this.ftp = ftp;
		this.threePointers=passiveStat;
		this.dunks=agressiveStat;
	}

	


	@Override
	public String toString() {
		return "Forward [name=" + name + ", pos=" + pos + ", pts=" + pts + ", reb=" + reb + ", ast=" + ast + ", ftp="
				+ ftp + ", threePointers=" + threePointers + ", dunks=" + dunks + "]";
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




	public int getThreePointers() {
		return threePointers;
	}




	public void setThreePointers(int threePointers) {
		this.threePointers = threePointers;
	}




	public int getDunks() {
		return dunks;
	}




	public void setDunks(int dunks) {
		this.dunks = dunks;
	}




	@Override
	public String position() {
		// TODO Auto-generated method stub
		return "Forward";
	}





	public int getAgressiveStat() {
		// TODO Auto-generated method stub
		return getDunks();
	}

	
	public int getPassiveStat() {
		// TODO Auto-generated method stub
		return getThreePointers();
	}

	public void setAgressiveStat(int stat) {
		setDunks(stat);
	}

	public void setPassiveStat(int stat) {
		setThreePointers(stat);
		
	}
	public void printPassiveStat() {
		System.out.print("3pointers: "+this.threePointers);
		
	}

	@Override
	public void printAgressiveStat() {
		System.out.print(" Dunks: "+this.dunks);
		
	}

}
