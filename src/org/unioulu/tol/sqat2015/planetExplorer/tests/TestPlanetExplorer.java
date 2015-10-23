package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	private static final String empty = "";
	private static final String landing_position = "(0,0,N)";
	@Test
	public void testCreatePlanetWithThreeObstaclesAndReturnValueAfterLanding00N() {
		
		//arrange
		PlanetExplorer planetExplorer = createPlanetWithThreeObstaclesSize100();
		//act and assert
		assertEquals( landing_position, planetExplorer.executeCommand(empty) );		
	}
	
	@Test
	public void testPlanetWithThreeObstaclesAndTurnExplorerRight00E() {
		
		//arrange
		PlanetExplorer planetExplorer = createPlanetWithThreeObstaclesSize100();
		//act and assert
		assertEquals( "(0,0,E)", planetExplorer.executeCommand("r") );		
	}
	
	@Test
	public void testPlanetWithThreeObstaclesAndTurnExplorerLeft00W() {
		
		//arrange

		PlanetExplorer planetExplorer = createPlanetWithThreeObstaclesSize100();
		//act and assert
		assertEquals( "(0,0,W)", planetExplorer.executeCommand("l") );		
	}
	
	@Test
	public void testPlanetWithThreeObstaclesAndMoveExplorerForward01N() {
		
		//arrange

		PlanetExplorer planetExplorer = createPlanetWithThreeObstaclesSize100();
		//act and assert
		assertEquals( "(0,1,N)", planetExplorer.executeCommand("f") );		
	}
	
	@Test
	public void testPlanetWithThreeObstaclesAndMoveExplorerFirstForwardThenBackWards00N() {
		
		//arrange

		PlanetExplorer planetExplorer = createPlanetWithThreeObstaclesSize100();
		//act and assert
		assertEquals( "(0,1,N)", planetExplorer.executeCommand("f") );
		//act and assert
		assertEquals( "(0,0,N)", planetExplorer.executeCommand("b") );		

	}
	
	@Test
	public void testPlanetWithThreeObstaclesAndMovingAndTurningSameTime22E() {
		
		//arrange

		PlanetExplorer planetExplorer = createPlanetWithThreeObstaclesSize100();
		//act and assert
		assertEquals( "(2,2,E)", planetExplorer.executeCommand("ffrff") );
		
	}
	
	@Test
	public void testPlanetWithThreeObstaclesAndMovingAndTurningSameTime52W() {
		
		//arrange

		PlanetExplorer planetExplorer = createPlanetWithThreeObstaclesSize100();
		//act and assert
		assertEquals( "(5,2,W)", planetExplorer.executeCommand("ffrffffffbll") );
		
	}
	
	@Test
	public void testPlanetWithThreeObstaclesAndMovingOverSideBackwards099N() {
		
		//arrange

		PlanetExplorer planetExplorer = createPlanetWithThreeObstaclesSize100();
		//act and assert
		assertEquals( "(0,99,N)", planetExplorer.executeCommand("b"));
		
	}
	
	@Test
	public void testPlanetWithThreeObstaclesAndMovingOverSideForwards01N() {
		
		//arrange

		PlanetExplorer planetExplorer = createPlanetWithThreeObstaclesSize100();
		//act and assert
		planetExplorer.executeCommand("b");
		planetExplorer.executeCommand("f");
		assertEquals( "(0,1,N)", planetExplorer.executeCommand("f"));
		
	}
	
	@Test
	public void testPlanetWithThreeObstaclesAndMovingOverSideXBackwards990E() {
		
		//arrange

		PlanetExplorer planetExplorer = createPlanetWithThreeObstaclesSize100();
		//act and assert
		planetExplorer.executeCommand("r");
		assertEquals( "(99,0,E)", planetExplorer.executeCommand("b"));
		
	}
	
	@Test
	public void testPlanetWithThreeObstaclesAndMovingOverSideXForwards10E() {
		
		//arrange

		PlanetExplorer planetExplorer = createPlanetWithThreeObstaclesSize100();
		//act and assert
		planetExplorer.executeCommand("r");
		planetExplorer.executeCommand("b");
		planetExplorer.executeCommand("f");
		assertEquals( "(1,0,E)", planetExplorer.executeCommand("f"));
		
	}
	
	@Test
	public void testPlacingObstaclesThree() {
		
		//arrange

		PlanetExplorer planetExplorer = createPlanetWithTwoObstaclesSize6();
		//act and assert
		assertEquals( "(1,0,E)", planetExplorer.executeCommand("f"));
		
	}

	PlanetExplorer createPlanetWithTwoObstaclesSize6()
	{
		int x = 6;
		int y = 6;
		String obstacles = "(1,1)(4,5)";
		return new PlanetExplorer(x,y,obstacles);
	}
	
	PlanetExplorer createPlanetWithThreeObstaclesSize100()
	{
		int x = 100;
		int y = 100;
		String obstacles = "(5,5)(9,9),(4,4)";
		return new PlanetExplorer(x,y,obstacles);
	}
}
