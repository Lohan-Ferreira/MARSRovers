package marsRovers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import marsRovers.Rover.Orientation;

class ExtraTest {

	Rover rover;
	
	@Test //Same as first test input from file
	void test1() {

		rover = new Rover(5,5,1,2,Orientation.N);
		rover.SendCommands("LMLMLMLMM");
		assertEquals("1 3 N", rover.GetStatus());
	}
	
	@Test //Same as second test input from file
	void test2() {

		rover = new Rover(5,5,3,3,Orientation.E);
		rover.SendCommands("MMRMMRMRRM");
		assertEquals("5 1 E", rover.GetStatus());
	}
	
	@Test
	void test3() {

		rover = new Rover(5,5,1,1,Orientation.E);
		rover.SendCommands("MMMMMMMMMSRM");
		assertEquals("5 0 S", rover.GetStatus());
	}

}
