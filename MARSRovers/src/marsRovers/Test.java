package marsRovers;

import marsRovers.Rover.Orientation;

import java.io.*;
import java.util.Scanner;


public class Test {

	  public static void main(String[] args) throws FileNotFoundException {
		  
		Scanner scanner = new Scanner(new File(args[0]));
		Rover rover;
		
		int maxCoordsX, maxCoordsY;
		int initialCoordsX, initialCoordsY;
		Orientation orientation;
		String commands;
		
		//First line is map size
         maxCoordsX= scanner.nextInt();
         maxCoordsY= scanner.nextInt();
        
        while(scanner.hasNext())
        {
            initialCoordsX = scanner.nextInt();
            initialCoordsY = scanner.nextInt();
        	
        	switch(scanner.next().toCharArray()[0])
        	{
        	 case 'N': orientation = Orientation.N;
        	 break;
        	 case 'E': orientation = Orientation.E;
        	 break;
        	 case 'S': orientation = Orientation.S;
        	 break;
        	 case 'W': orientation = Orientation.W;
        	 break;
        	 default: orientation = null;
        	}
        	
        	commands = scanner.next();
        	
        	rover = new Rover(maxCoordsX,maxCoordsY,initialCoordsX,initialCoordsY,orientation);
        	rover.SendCommands(commands);
        	System.out.println(rover.GetStatus());
        	
        }
	    
	  }
}
