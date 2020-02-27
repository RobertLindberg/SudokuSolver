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
		m.SetValue(3, 1, 8);
		m.SetValue(3, 3, 4);
		m.SetValue(4, 1, 3);
		m.SetValue(4, 2, 7);
		m.SetValue(4, 3, 1);
		m.SetValue(5, 1, 6);
		m.SetValue(5, 6, 2);
		m.SetValue(5, 7, 4);
		m.SetValue(5, 8, 5);
		m.SetValue(7, 2, 4);
		m.SetValue(7, 4, 2);
		m.SetValue(7, 6, 5);
		m.SetValue(7, 7, 8);
		m.SetValue(8, 0, 7);
		m.SetValue(8, 3, 8);
		m.SetValue(8, 6, 1);

			
		m.print();
		System.out.println(m.ValidBoard());
		m.solve(0, 0);
		m.print();


		}
	}