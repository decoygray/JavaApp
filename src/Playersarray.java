
public class Playersarray {
	String name = "beans";
	int shooting = 0;
	int skating = 0;
	int checking = 0;
	int stat = 0;

	
	public Playersarray(String name, String shooting, String skating, String checking){
	
		this.name = name;
		this.shooting = Integer.parseInt(shooting);
		this.skating = Integer.parseInt(skating);
		this.checking = Integer.parseInt(checking);
		this.stat = Integer.parseInt(shooting) + Integer.parseInt(skating) + Integer.parseInt(checking);
		 
		 
	}
	 public int GetStat() 
	    { 
	        return stat; 
	    } 
	 
	
}
