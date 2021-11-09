package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Gamemap.map;
import Logic.Lifegame;
public class lifegame_test {
	public static map cell=new map(3,3);
	@Before
	public void setUp() throws Exception {
		 cell.deleteAllCell();
    }
	@After
	public void tearDown() throws Exception {
	}
	@Test(timeout=1000)
	public void testDeleteAllCell() {
		cell.randomCell();
		cell.deleteAllCell();
		int[][] a=cell.getGrid();
		int[][] expected = new int[][]{
			{0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
        };
        Assert.assertArrayEquals(expected, a);
	}
	@Test
	public void testGetNeighborCount() {
		int[][] start = new int[][]{
    	    {0,0,0,0,0},
            {0,1,0,1,0},
            {0,0,1,0,0},
            {0,1,1,1,0},
            {0,0,0,0,0}
        };
        cell.setGrid(start);
        Assert.assertEquals(1, cell.getNeighborCount(1, 1));
        Assert.assertEquals(3, cell.getNeighborCount(1, 2));
        Assert.assertEquals(1, cell.getNeighborCount(1, 3));
        Assert.assertEquals(4, cell.getNeighborCount(2, 1));
        Assert.assertEquals(5, cell.getNeighborCount(2, 2));
        Assert.assertEquals(4, cell.getNeighborCount(2, 3));
        Assert.assertEquals(2, cell.getNeighborCount(3, 1));
        Assert.assertEquals(3, cell.getNeighborCount(3, 2));
        Assert.assertEquals(2, cell.getNeighborCount(3, 3));
	}
	@Test
	public void testupdate(){
        int[][] start = new int[][]{
        	    {0,0,0,0,0},
                {0,1,0,1,0},
                {0,0,1,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0}
        };
        cell.setGrid(start);
        Lifegame a=new Lifegame();
        a.update(cell);
        int[][] expected = new int[][]{
        	{0,0,0,0,0},
            {0,0,1,0,0},
            {0,0,0,0,0},
            {0,1,1,1,0},
            {0,0,0,0,0}
        };
        Assert.assertArrayEquals(expected, cell.getGrid());
        a.update(cell);
        expected = new int[][]{
        	{0,0,0,0,0},
            {0,0,0,0,0},
            {0,1,0,1,0},
            {0,0,1,0,0},
            {0,0,0,0,0}
        };
        Assert.assertArrayEquals(expected, cell.getGrid());
        a.update(cell);
        expected = new int[][]{
        	{0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,1,0,0},
            {0,0,1,0,0},
            {0,0,0,0,0}
        };
        Assert.assertArrayEquals(expected, cell.getGrid());
    }
	
}
