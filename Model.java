package Sudoku_final_project;

public class Model {
	
	private int [][] board;
	
	public Model() {
		board = new int[9][9];
		Clear();
	
	}
	/**
	 * A method that gets the value at row x, column y.
	 * 
	 */
	
	public int GetValue(int x, int y) {
		return board[x][y];
	
	}
	
	/**
	 * A method that sets the value for the square at row x, column y.
	 */
	public void SetValue(int x, int y, int val) {
		board[x][y] = val;
		
	}
	
	/**
	 * Sets all values to 0.
	 */
	public void Clear() {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				board[x][y] = 0;
			}
		}
	}
	
	/**
	 * Checks if the square at row x, column y is empty.
	 */
	
	public boolean CheckEmpty (int x, int y) {
		if (board[x][y] == 0) {
			return true;
		}
			
		return false;
				
	}
	
	/**
	 * Checks if a given integer at position (x,i) satisfies the restrictions of row x.
	 */
	
	public boolean CheckRow (int x, int val) {

		for (int i = 0; i < 9; i++) {
			if (board[x][i] == val) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if a given integer at position (y,i) satisfies the restrictions of column y.
	 */
	
	
	public boolean CheckColumn (int y, int val) {

		for (int i = 0; i < 9; i++) {
			if (board[i][y] == val) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if a given integer satisfies the restrictions for the 3x3-box that (x,y) lies in.
	 */
	
	
	public boolean CheckBox (int x, int y, int val) {
		
		int xref = x - (x % 3);
		int yref = y - (y % 3);
		
		for (int i = xref; i < xref + 3; i++) {
			for (int j = yref; j < yref + 3; j++) {
				if (board[i][j] == val) {
					return false;
				}
				
			}

		}
		return true;
	}
	
	/**
	 * Checks if all restrictions are satisfied for a given integer at position (x,y)
	 */
	
	public boolean CheckAll (int x, int y, int val) {

		return (CheckRow(x,val) && CheckColumn (y, val) && CheckBox(x, y, val));
	}
	
	/**
	 * Prints the sudoku into the console
	 */
	
	public void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Checks if the initially inserted sudoku satisfies the restrictions (for non-zeroes only)
	 */
	
	public boolean ValidBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!CheckEmpty(i,j)) {
					int val = board[i][j];
					SetValue(i, j, 0);
					if(!CheckAll(i, j, val)) {
						SetValue(i, j, val);
						return false;
					}
					SetValue(i, j, val);
					
				}
			}
		}
		return true;
	}

	/**
	 * The solution method. Calls on ValidBoard() before initializing a solution attempt. 
	 */
	
    public boolean solve(int x, int y) {
    	
    	if (!ValidBoard()) {
    		System.out.println("Invalid input, try another one.");
    		return false;
    	}
    	
        for (int row = 0; row < 9; row++) {
        	for (int col = 0; col < 9; col++) {
        		if (CheckEmpty(row,col)) {
        			for (int num = 1; num <= 9; num++) {
        				if (CheckAll(row, col, num)) {
        					SetValue(row,col,num);
        					if (solve(row,col)) {
        						return true;
        					} 
        					else {
        						SetValue(row,col,0);
        						}
        				}
        			}

        			return false; 
        		}
        	}
         }

         return true; 
	}

}