package org.unioulu.tol.sqat2015.planetExplorer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID: 153
// Finish time: 
public class PlanetExplorer {
	
	private static final String landing_position = "(0,0,N)";
	private static final Orientation landing_orientation = Orientation.North;
	private int position_X;
	private int position_Y;
	private Orientation orientation;
	private int planetSize_X;
	private int planetSize_Y;
	private List<String> obstacles_list;
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */	
		planetSize_X = x;
		planetSize_Y = y;
		position_X = 0;
		position_Y = 0;
		orientation = landing_orientation;
		
		if(obstacles !=null && !obstacles.isEmpty())
		{
			Pattern p = Pattern.compile("\\)");
			String[] string_array = p.split(obstacles);
			obstacles_list = new ArrayList<String>();
			for(int i=0; i<string_array.length; i++)
				obstacles_list.add( string_array[i] + ")" );
		}
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		char[] character_array = command.toCharArray();
		for( int i = 0; i < character_array.length; i++)
		{
			turnExplorer(character_array[i]);
			moveExplorer(character_array[i]);
		}
		
		return getExplorerPosition();
	}

	private void moveExplorer(char command) {
		if(command == 'f' )
		{
			switch (orientation) {
			case North:
					position_Y += 1;
					break;
        	case East:
        			position_X += 1;
        			break;
        	case South:
        			position_X -= 1;
        			break;
        	case West:
        			position_Y -= 1;
        			break;
			}
		}
		else if(command == 'b' )
		{
			switch (orientation) {
			case North:
					position_Y -= 1;
					break;
        	case East:
        			position_X -= 1;
        			break;
        	case South:
        			position_X += 1;
        			break;
        	case West:
        			position_Y += 1;
        			break;
			}
		}
		checkOverBoundsMovement();
		
	}

	private void checkOverBoundsMovement() {

		if( position_X < 0)
		{
			position_X = planetSize_X + position_X;
		}
		else if( position_X > planetSize_X)
		{
			position_X = position_X - planetSize_X ;
		}
		
		if( position_Y < 0)
		{
			position_Y = planetSize_Y  + position_Y;
		}
		else if( position_Y > planetSize_Y)
		{
			position_Y =  position_Y - planetSize_Y;
		}
		
	}

	private void turnExplorer(char command) {
		if(command == 'r')
			switch (orientation) {
            	case North:
						orientation = Orientation.East;
						break;
            	case East:
            			orientation = Orientation.South;
            			break;
            	case South:
            			orientation = Orientation.West;
            			break;
            	case West:
            			orientation = Orientation.North;
            			break;
			}
		else if(command == 'l')
			switch (orientation) {
            	case North:
						orientation = Orientation.West;
						break;
            	case East:
            			orientation = Orientation.North;
            			break;
            	case South:
            			orientation = Orientation.East;
            			break;
            	case West:
            			orientation = Orientation.South;
            			break;
			}
	}

	private String getExplorerPosition() {
		// Generates API defined string from position and orientation
		StringBuilder positionString = new StringBuilder("(");
		positionString.append(Integer.toString(position_X));
		positionString.append(",");
		positionString.append(Integer.toString(position_Y));
		positionString.append(",");
		switch (orientation) {
    	case North:
    			positionString.append("N)");
				break;
    	case East:
    			positionString.append("E)");
    			break;
    	case South:
    			positionString.append("S)");
    			break;
    	case West:
    			positionString.append("W)");
    			break;
		}
		
		return positionString.toString();
	}

	public String getGrids() {
		
		StringBuilder sb = new StringBuilder();
		for(String s: obstacles_list)
			sb.append(obstacles_list);
		return sb.toString();
	}
}
