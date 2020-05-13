
public class Center extends Player {
	String name;
	String pos;
	int pts;
	int reb;
	int ast;
	double ftp;
	//position specific
	int setScreens;
	int blocks;

	public Center(String name, String pos, int pts, int reb, int ast, double ftp, int passiveStat, int agressiveStat) {
		super();
		this.name = name;
		this.pos = pos;
		this.pts = pts;
		this.reb = reb;
		this.ast = ast;
		this.ftp = ftp;
		this.setScreens=passiveStat;
		this.blocks=agressiveStat;
	}

	@Override
	public String toString() {
		return "Center [name=" + name + ", pos=" + pos + ", pts=" + pts + ", reb=" + reb + ", ast=" + ast + ", ftp="
				+ ftp + ", blocks=" + blocks + ", setScreens=" + setScreens +  "]";
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

	public int getBlocks() {
		return blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}

	public int getSetScreens() {
		return setScreens;
	}

	public void setSetScreens(int setScreens) {
		this.setScreens = setScreens;
	}

	@Override
	public String position() {
		// TODO Auto-generated method stub
		return "Center";
	}


	@Override
	public int getAgressiveStat() {
		// TODO Auto-generated method stub
		return getBlocks();
	}

	@Override
	public int getPassiveStat() {
		// TODO Auto-generated method stub
		return getSetScreens();
	}

	public void setAgressiveStat(int stat) {
		setBlocks(stat);
	}

	public void setPassiveStat(int stat) {
		setSetScreens(stat);
		
	}
	public void printPassiveStat() {
		System.out.print("Set Screens: "+this.setScreens);
		
	}

	@Override
	public void printAgressiveStat() {
		System.out.print(" Blocks: "+this.blocks);
		
	}
}
