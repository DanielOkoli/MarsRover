package thoughtworks.test;

import java.util.InputMismatchException;

public class Rover {

/* Set Variables for N, S E, W to be used in below methods.
 * Set initial variables for facing, direction, xCoordinates of grid border, yCoordinates of grid border, x and y coordinates of rover.
 */
	enum Cardinal{
		N, E, S, W;
		
	}
	Cardinal facing1;
	
	Integer x = 0;
	Integer y = 0;
	Cardinal facing = Cardinal.N;
	
	public static Integer GRID_BORDER_X1 = 0;
	public static Integer GRID_BORDER_X2 = 5;
	public static Integer GRID_BORDER_Y1 = 0;
	public static Integer GRID_BORDER_Y2 = 5;
	
	/*Initial conditions set for values of x, and y before the Rover moves.
	 *Exception thrown if condition not satisfied.
	 *Reference to current to values of x and y to be used in below methods. 
	 */
	public String setPosition(Integer x, Integer y, Cardinal facing) {
		
		if (x < GRID_BORDER_X1 || y < GRID_BORDER_Y1 || x > GRID_BORDER_X2 || y > GRID_BORDER_Y2) {
	        throw new InputMismatchException("Coordinates must be positive and within the boundary!");
	    }		
		this.x = x;
		this.y = y;
		this.facing = facing;
		
		return x + "" + y + "" + facing;
	 }
	
	/* Defining direction by setting the Integer facing = to strings "N", "E", "W" & "S" depending on the Integer facing is set to.
	 * prints new line of Integer x, Integer y and string direction in desired format.
	 */
public String showPosition() {  
    	
    	return (this.x  + " " +  this.y  + " " + facing);  
     }
	
   /* Method execute(commands) should be used to transmit commands to the rover.
	* Defining direction by setting the Integer facing = to strings "N", "E", "W" & "S" depending on the Integer facing is set to.
	* The String commands represents the string 
	* The first Character of the string at each index starting from index = 0 is executed, provided it satisfies the conditions of execute(Character command).
	* Return the values, x, y, and direction for each execute command.
	*/
    public String execute(String commands) {
    	
    	for (int idx = 0; idx < commands.length(); idx++  ) {
    		execute(commands.charAt(idx));
       }
    	return this.x + " " + this.y + " " + facing;
    }
    
/*Method execute(command) should associate each character command with a method (rotateLeft(), rotateRight(), move() or moveAlt()).  
 * Character L rotates rover to the left.
 * Character R rotates rover to the right. 
 * Character M  moves rover one step in the direction facing.
 */
    private void execute(Character command) {
    	switch (command) 
        { 
        case 'L': 
            rotateLeft();
            break; 
        case 'R': 
            rotateRight();
            break; 
        case 'M':
            moveAlt();
            break; 
        case ' ':
        	throw new IllegalArgumentException(
        			"No Empty commands in Rover language please, ensure no spaces in command string"); 
        default: 
            throw new IllegalArgumentException(
    				"Speak in Mars language, please!"); 
        } 
    }
   
 /* Method rotates Rover to the right by establishing two conditions.
  * If a rover executes a clockwise 90 degree turn and the facing > 3 = West, reset to 0 = N.  
  * Otherwise, if a rover executes a clockwise 90 degree turn when initial facing <= 3 = West, new facing  = facing + 1.
  */
    private Cardinal rotateRight() {
    	switch (facing){
 	   case N:
 		   facing = Cardinal.E;
 	     break;
        case E:
     	   facing = Cardinal.S;
  	      break;
        case S:
     	   facing = Cardinal.W;
   	     break;
        case W:
     	   facing = Cardinal.N;
    	     break;
 	   }
	    return facing;
 }
    /* Method rotates Rover to the left by establishing two conditions.
     * If a rover executes a anti-clockwise 90 degree turn and the facing < 0 = North, reset to 3 = W.  
     * Otherwise, if a rover executes a anti-clockwise 90 degree turn and initial facing >= 0 = North, new facing  = facing - 1.
     */    
    private Cardinal rotateLeft() {
    	switch (facing){
 	    case N:
 	        facing1 = Cardinal.W;
 	     break;
        case W:
        	facing1 = Cardinal.S;
  	      break;
        case S:
        	facing1 = Cardinal.E;
   	     break;
        case E:
        	facing1 = Cardinal.N;
    	 break;
     }
    	return facing;
    }
   
    /*Wraps Rover around to the start of the boundary when rover goes past current x,y = 5.
    * When Rover is moving and is facing (N,E,S, or W), and Rover moves past boundary, the x,y then start at the opposite end of the boundary.
    * When Rover is facing N, the Rover starts again at x,y = 0 when Rover moves past the it's north boundary.
    */
    public String move() {
    	switch(facing) {
    	case N:
    		this.y = (y+1)%(GRID_BORDER_Y2+1);
    		break;
    	case E:  
    		this.x = (x+1)%(GRID_BORDER_X2+1);
    	    break;
    	case S: 
    		this.y = ((y-1+(GRID_BORDER_Y2+1)))%(GRID_BORDER_Y2+1);
    	    break;
    	case W:
    		this.x = (x-1+(GRID_BORDER_X2+1))%(GRID_BORDER_X2+1);
           }
    	return this.x + "" + this.y;
    }  
    
    /*Rover cannot go past the boundary when rover goes past when x,y >= 5.
    * When Rover is moving and is facing (N,E,S, or W), and Rover moves towards the boundary, the current x,y cannot go any further then the edge of the boundary.
    * When Rover is facing N, the Rover cannot go past x,y = 5 when Rover moves past the it's north boundary.
    * replace move() with moveAlt() in execute(Character command) method to change conditions and switch movement of Rover from wrap around plateau boundary to bounded plateau. 
    */
    public String moveAlt() {
    	{
        	if (facing == Cardinal.N && (y+1<= GRID_BORDER_Y2) ) {
        		this.y = (y+1);
        	} 
        	if (facing == Cardinal.E && (x+1<= GRID_BORDER_X2) ) {
        		this.x = (x+1);
        	} 
        	if (facing == Cardinal.S && (y-1>=GRID_BORDER_Y1)) {
        		this.y = (y-1);
        	} 
        	if (facing == Cardinal.W && (x-1>=GRID_BORDER_X1)) {
        		this.x = (x-1);
        	}
        	if (facing == Cardinal.N && (y+1>GRID_BORDER_Y2) ) {
        		this.y = y;
        	} 
        	if (facing == Cardinal.E && (x+1>GRID_BORDER_X2) ) {
        		this.x = x;
        	}
        	if (facing == Cardinal.S && (y-1<GRID_BORDER_Y1)) {
        		this.y = y;
        	} 
        	if (facing == Cardinal.W && (x-1<GRID_BORDER_X1)) {
        		this.x = x;	
        	}
         }
        	return this.x + "" + this.y;
         }

    //Set commands, initial x and y coordinate, and direction facing for rover one and rover two.
    
    static String rover1Execute = "LMLMLMLMM";
    static int rover1XCoordinate = 1;
    static int rover1YCoordinate = 2;
    static Cardinal rover1Location = Cardinal.N;
    
    static String rover2Execute = "MMRMMRMRRM";
    static int rover2XCoordinate = 3;
    static int rover2YCoordinate = 3;
    static Cardinal rover2Location = Cardinal.E;
    
    private static Rover initRover(String executeValue, int xCoordinate, int yCoordinate, Cardinal roverLocation) {
    	Rover rover = new Rover();
    	rover.setPosition(xCoordinate, yCoordinate, roverLocation);
    	System.out.println("Rover initialised");
    	rover.execute(executeValue);
    	rover.showPosition();
    	System.out.println("Rover finished");
    	System.out.println("");
		return rover;
    }
    
    private static void startRover(){
    	
    
		Rover rover1 = initRover(rover1Execute, rover1XCoordinate, rover1YCoordinate,rover1Location);
		Rover rover2 = initRover(rover2Execute, rover2XCoordinate, rover2YCoordinate,rover2Location);

    	}
    
    /*The initiator method initRover() initiates Rover One, and then Rover Two.
     * Main method calls startRover(), initiates each Rover, executes commands, and prints put the end position of each position.
     */
   public static void main(String args[]) {

    	startRover();
    }
}	