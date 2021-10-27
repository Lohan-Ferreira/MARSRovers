package marsRovers;

public class Rover {
	
	public enum Orientation
	{
		N,E,S,W;
		
	    private static Orientation[] ors = values();
	    public Orientation next()
	    {
	    	
	        return ors[(this.ordinal()+1) % ors.length];
	    }
	    
	    public Orientation previous()
	    {
	    	int idx = this.ordinal()-1;
	    	
	        if(idx < 0) return ors[ors.length - 1];
	        else 		return ors[idx];

	    }
	}
	
	private int maxCoords[];
	private int position[];
	private Orientation orientation;
	
	public Rover(int maxX, int maxY, int initialX, int initialY, Orientation initialOrientation)
	{
		
		maxCoords = new int[]{maxX,maxY};
		position = new int[] {initialX,initialY};
		orientation = initialOrientation;
	}
	

	public void SendCommands(String commands)
	{
		char[] coms = commands.toCharArray();
		
		for(int i=0; i < coms.length; i++)
		{
			if(coms[i] == 'L' || coms[i] == 'R') Rotate(coms[i]);
			else if(coms[i] == 'M') MoveFoward();
			else System.out.println("Ignoring invalid command: " + coms[i]);
		}
	}
	
	
	private void Rotate(char direction)
	{
		if(direction == 'L') orientation = orientation.previous();
		else orientation = orientation.next();
			
	}
	
	private void MoveFoward()
	{
		switch(orientation) {
		
		case N: if(position[1] < maxCoords[1]) position[1] += 1;
		break;
		case E:  if(position[0] < maxCoords[0]) position[0] +=1;
		break;
		case S: if(position[1] > 0)  position[1] -= 1;
		break;
		case W: if(position[0] > 0)   position[0] -= 1;
			
		
		}
	}
	
	public String GetStatus()
	{
		return (position[0] + " " + position[1]+" " +orientation) ;
	}
	

	
}
