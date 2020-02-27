package Sudoku_final_project;

public class Main {

	public static void main(String[] args) {

		Model m = new Model();

		m.SetValue(0, 1, 9);
		m.SetValue(0, 3, 5);
    		m.SetValue(0, 4, 8);
		m.SetValue(0, 7, 3);
		m.SetValue(1, 0, 3);
		m.SetValue(1, 7, 5);
		m.SetValue(1, 8, 8);
		m.SetValue(2, 4, 4);
	    	m.SetValue(2, 8, 9);
	
		m.print();
		System.out.println(m.ValidBoard());
		m.solve(0, 0);
		m.print();

		}
	}
