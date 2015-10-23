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
		for(int i = 0; i < 99; i )
		planetExplorer.executeCommand("ffrffffffbll"); 
		assertEquals( "(0,99,N)", planetExplorer.executeCommand("ffrffffffbll") );
		
	}
	
	PlanetExplorer createPlanetWithThreeObstaclesSize100()
	{
		int x = 100;
		int y = 100;
		String obstacles = "(5,5)(9,9),(4,4)";
		return new PlanetExplorer(x,y,obstacles);
	}
}
