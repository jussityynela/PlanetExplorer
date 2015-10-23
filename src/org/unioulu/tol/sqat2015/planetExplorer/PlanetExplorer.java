package org.unioulu.tol.sqat2015.planetExplorer;



// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:
public class PlanetExplorer {
	
	private static final String landing_position = "(0,0,N)";
	private static final Orientation landing_orientation = Orientation.North;
	private int position_X;
	private int position_Y;
	private Orientation orientation;
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		position_X = 0;
		position_Y = 0;
		orientation = landing_orientation;
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
		turnExplorer(command);
		moveExplorer(command);
		
		return getExplorerPosition();
	}

	private void moveExplorer(String command) {
		if(command.equals("f") )
		{
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
		}
		
	}

	private void turnExplorer(String command) {
		if(command.equals("r"))
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
		else if(command.equals("l"))
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
}
