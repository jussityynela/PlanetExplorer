package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	@Test
	public void testCreatePlanetWithThreeObstacles() {
		
		int x = 100;
		int y = 100;
		String obstacles = "(5,5)(9,9),(4,4)";
		PlanetExplorer planetExplorer = new PlanetExplorer(x,y,obstacles);
		
		
	}
}
