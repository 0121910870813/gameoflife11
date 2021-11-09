package Logic;

import Gamemap.map;
public class Lifegame {
	public Lifegame()
	{
		
	}
	//繁衍
    public void update(map cell) {
    	int length = cell.getmaxLength();
        int width = cell.getmaxWidth();
        int[][] newGrid = new int[length + 2][width + 2];
        int[][] grid = cell.getGrid();
        for (int i = 1; i <= length; i++)
            for (int j = 1; j <= width; j++)
                switch (cell.getNeighborCount(i, j)) {
                    case 2:
                        newGrid[i][j] = grid[i][j]; //细胞状态保持不变
                        break;
                    case 3:
                        newGrid[i][j] = 1; // Cell is alive.
                        break;
                    default:
                        newGrid[i][j] = 0; // Cell is dead.
                }
        cell.setGrid(newGrid);
        cell.addnowGeneration();
    }
    public void update1(map cell) {
        int[][] newGrid = new int[cell.getmaxLength() + 2][cell.getmaxWidth() + 2];
        int[][] grid = cell.getGrid();
        for (int i = 1; i <= cell.getmaxLength(); i++)
            for (int j = 1; j <= cell.getmaxWidth(); j++)
                {
            	    if(cell.getNeighborCount(i, j)==2)
            	    	newGrid[i][j] = grid[i][j]; //细胞状态保持不变
            	    else if(cell.getNeighborCount(i, j)==3)
            	    	newGrid[i][j] = 1; // Cell is alive.
            	    else
            	    	newGrid[i][j] = 0; // Cell is dead.
                }
        cell.setGrid(newGrid);
        cell.addnowGeneration();
    }
}
