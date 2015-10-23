package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	private static final String empty = "";
	private static final String landing_position = "(0,0,N)";
	@Test
	public void testCreatePlanetWithThreeObstaclesAndReturnValueAfterLanding00N() {
		
		int x = 100;
		int y = 100;
		String obstacles = "(5,5)(9,9),(4,4)";
		PlanetExplorer planetExplorer = new PlanetExplorer(x,y,obstacles);
		AssertEquals( landing_position, planetExplorer.executeCommand(empty) );
		
		
	}
}
