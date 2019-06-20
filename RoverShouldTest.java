package thoughtworks.test;

import org.junit.jupiter.api.Test;

import thoughtworks.test.Rover.Cardinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverShouldTest {

/*I apologise as I was not able to successfully run the test due to the error below which I persistently kept getting, despite trying a variation of junit configurations.
 *Error occurred during initialisation of boot layer
  java.lang.module.FindException: Module C:\Users\name\eclipse-workspace\MarsTest\src not found
 *However I have provided a series of tests that I used at each stage of developing this application to test the behaviour of my program.
 *I've tried to be as accurate as possible, and hopefully these tests cases do compile and have outputs which match mines, but if not these are the series of tests that have been implemented to ensure that the rover moves as expected.
 *Additionally, I have also provided another main application (located in the folder Mars) which runs without a junit test case, incase this test does not compile.
 */
	   
	Rover rover = new Rover();
	
	   /*  TurnRight test ensures that rotateRight() behaves as expected. 
	    *  Execution of commands "RRRR" should ensure that Rover makes a full clockwise turn to its initial position
	    */
		@Test
		public void testTurnRight() {
			String output = rover.execute("R");
			assertEquals("0 0 E", output);
		
		}
	
		@Test
		public void testTurnRight2() {
			String output2 = rover.execute("RR");
			assertEquals("0 0 S", output2);
			
		}
		
		@Test
		public void testTurnRight3() {
			String output3 = rover.execute("RRR");
			assertEquals("0 0 W", output3);
			
		}
		
		@Test
		public void testTurnRight4() {
			String output4 = rover.execute("RRRR");
			assertEquals("0 0 N", output4);
			
		}
		
	   /*TurnLeft test ensures that rotateLeft() behaves as expected. 
		*Execution of commands "LLLL" should ensure that Rover makes a full anti-clockwise turn to its initial position
		*/	
		@Test
		public void testTurnLeft() {
			String output = rover.execute("L");
			assertEquals("0 0 W", output);
			
		}
		
		@Test
		public void testTurnLeft2() {
			String output2 = rover.execute("LL");
			assertEquals("0 0 S", output2);
			
		}
		
		@Test
		public void testTurnLeft3() {
			String output3 = rover.execute("LLL");
			assertEquals("0 0 E", output3);
		
		}
		
		@Test
		public void testTurnLeft4() {
			String output4 = rover.execute("LLLL");
			assertEquals("0 0 N", output4);
		
		}
		
		/*MoveUp test ensures that moveAlt() or move() behaves as expected. 
		*Execution of commands "MMM" should ensure that Rover moves up by 3.
		*/	
		@Test
		public void testMoveUp() {
			String output = rover.execute("M");
			assertEquals("0 1 N", output);
	   	
		}
		
		@Test
		public void testMoveUp2() {
			String output2 = rover.execute("MMM");
			assertEquals("0 2 N", output2);
	   	
		}
		
		/*MoveWrapBottonUp test ensures that moveAlt() behaves as expected. 
		*Execution of commands "MMMMMM" should ensure that Rover starts again at y = 0.
		*/
		@Test
		public void testMoveWrapBottomToUp() {
			String output = rover.execute("MMMMMM");
			assertEquals("0 0 N", output);
				
		}
		
		@Test
		public void testMoveWrapBottomToUp2() {
			String output2 = rover.execute("MMMMMMM");
			assertEquals("0 1 N", output2);
			
		}
		
		/*MoveWrapDown test ensures that moveAlt() behaves as expected. 
		*Execution of commands "LLM" should ensure that Rover starts again at y = 5.
		*/
		@Test
		public void testMoveWrapDown() {
			String output = rover.execute("LLM");
			assertEquals("0 5 S", output);
			
		}
		
		@Test
		public void testMoveWrapDown2() {
			String output2 = rover.execute("LLMMMMMMM");
			assertEquals("0 5 S", output2);
			
		}
	   
	   /*MoveRight test ensures that moveAlt() or move() behaves as expected. 
		*Execution of commands "RM" should ensure that Rover moves right by 1.
		*/	
		@Test
		public void testMoveRight() {
			String output = rover.execute("RM");
			assertEquals("1 0 E", output);
			
		}
		
		@Test
		public void testMoveRight2() {
			String output2 = rover.execute("RMMMMM");
			assertEquals("5 0 E", output2);
			
		}
		
		/*MoveWrapLeft test ensures that moveAlt() behaves as expected. 
		*Execution of commands "LM" should ensure that Rover starts again at x = 0.
		*/
		@Test
		public void testMoveWrapLeft() {
			String output = rover.execute("LM");
			assertEquals("5 0 W", output);
			
		}
		
		@Test
		public void testMoveWrapLeft2() {
			String output2 = rover.execute("LMMMMMMM");
			assertEquals("0 0 W", output2);
			
		}
		
	   /*MoveLefttoRight test ensures that moveAlt() behaves as expected. 
		*Execution of commands "RMMMMMMMMMMM" should ensure that Rover starts again at x = 5.
		*/
		@Test
		public void testMoveWrapLefttoRight() {
			String output = rover.execute("RMMMMMM");
			assertEquals("0 0 E", output);
			
		}
		
		@Test
		public void testMoveWrapLefttoRight2() {
			String output2 = rover.execute("RMMMMMMMMMMM");
			assertEquals("5 0 E", output2);
			
		}
		
		/*MoveBounded test ensures that move() behaves as expected. 
		*Execution of commands "RMMMMMM" should ensure that Rover cannot go past x = 5.
		*/
		@Test
		public void testMoveBounded() {
			String output = rover.execute("RMMMMMM");
			assertEquals("5 0 E", output);
			
		}
		
		@Test
		public void testMoveBounded2() {
			String output2 = rover.execute("RRMMMMMM");
			assertEquals("0 0 S", output2);
			
		}
		
		@Test
		public void testMoveBounded3() {
			String output3 = rover.execute("RRRMMMMMM");
			assertEquals("0 0 W", output3);
			
		}
		
		@Test
		public void testMoveBounded4() {
			String output4 = rover.execute("RRRRMMMMMM");
			assertEquals("0 5 N", output4);
			
		}
	   
	   /*Outputs test ensures that Rover behaves as expected. 
		*Execution of commands "LMLMLMLMM" from point (1,2,N) ensures output = (1,3,N)
		*Execution of commands "MMRMMRMRRM" from point (3,3,E) ensures output = (5,1,E)
		*/
		@Test
		public void testOutputs() {
		//  When Integer x = 1, Integer y = 2, and Facing = N
		    String output = rover.execute("LMLMLMLMM");
		    assertEquals("1 3 N", output);
			
		}
		
		@Test
		public void testOutputs2() {
		//	When Integer x = 3, Integer y = 3, and Facing = E
			String output2 = rover.execute("MMRMMRMRRM");
			assertEquals("5 1 E", output2);
		
		}
		
	   /*false language test ensures that Rover throws exception if commands are not 'M', 'L' or 'R'.. 
		*Execution of commands "LMLMLMLMMA" from point (1,2,N) ensures output != (1,3,N)
		*Execution of commands "MMRMMRMRRMA" from point (3,3,E) ensures output != (5,1,E)
		*Execution of commands "M M" from point (0,0,N) throws exception if commands have spacing between them.
		*/
		@Test
		public void falseLanguage() {
			String output = rover.execute("LMLMLMLMMA");
			assertEquals("1 3 N", output);
			
		}
		
		@Test
		public void falseLanguage2() {
			String output2 = rover.execute("MMRMMRMRRMS");
			assertEquals("5 1 E", output2);
			
		}
		@Test
		public void falseLanguage3() {
			String output3 = rover.execute("M M");
			assertEquals("0 2 N", output3);
			
		}
	   
		/*initial coordinates test ensures that Rover throws exception if starting position is outside Mars Plateau where 0 < x, y <= 5.
		*Execution of commands "M" from point (-1,0,E) cannot produce output (0,0,E) due to exceptions.
		*/
		@Test
		public void initialCoordinates() {
			String output = rover.setPosition(-1,0,Cardinal.E);
			assertEquals("-1 0 E", output);
			
		}
		
		/*Facing to String test ensures that Rover's enum position is converted to a String.
		*/
		@Test
		public void FacingToString() {
		//For Initial conditions Integer x = 0, Integer y = 0, and Facing = N ;
			String output = rover.showPosition();
			assertEquals("N", output);
			
		}
		
		public void FacingToString2() {
	    //For Initial conditions Integer x = 0, Integer y = 0, and Facing = E ;
				String output = rover.showPosition();
				assertEquals("E", output);
				
			}
		
		public void FacingToString3() {
	    //For Initial conditions Integer x = 0, Integer y = 0, and Facing = S ;
				String output = rover.showPosition();
				assertEquals("S", output);
				
			}
		
		public void FacingToString4() {
			//For Initial conditions Integer x = 0, Integer y = 0, and Facing = W ;
				String output = rover.showPosition();
				assertEquals("W", output);
				
			}
		
	}

