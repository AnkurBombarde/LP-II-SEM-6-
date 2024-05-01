/*4.  Implement a solution for a Constraint Satisfaction Problem using Branch and Bound and Backtracking for n-queens problem or a graph coloring problem. */
public class Nqueen {
	final int N = 4;

	void printSolution(int matrix[][])
	{
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 1)
					System.out.print(" Q ");
				else
					System.out.print(" . ");
			}
			System.out.println();
		}
	}

	
	boolean isSafe(int matrix[][], int row, int col)
	{
		int i, j;

		for (i = 0; i < col; i++)
			if (matrix[row][i] == 1)
				return false;

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (matrix[i][j] == 1)
				return false;

		for (i = row, j = col; j >= 0 && i < N; i++, j--)
			if (matrix[i][j] == 1)
				return false;

		return true;
	}


	boolean solveNQUtil(int matrix[][], int col)
	{
		
		if (col >= N)
			return true;

	
		for (int i = 0; i < N; i++) {
			
		
			if (isSafe(matrix, i, col)) {
				
				matrix[i][col] = 1;

				if (solveNQUtil(matrix, col + 1) == true)
					return true;

				matrix[i][col] = 0; 
			}
		}


		return false;
	}


	boolean solveNQ()
	{
		int matrix[][] = { { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 },
						{ 0, 0, 0, 0 },
						{ 0, 0, 0, 0 } };

		if (solveNQUtil(matrix, 0) == false) {
			System.out.print("Solution does not exist");
			return false;
		}

		printSolution(matrix);
		return true;
	}

	public static void main(String args[])
	{
		Nqueen q = new Nqueen();
		q.solveNQ();
	}
}
