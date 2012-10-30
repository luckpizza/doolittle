/**
 * Class that defines different matrixes for 
 * doing the doolittle algorithm and been able to print 
 * some interesting things.
 * @author luckpizza
 *
 */
public class Matrix {

	final double[][] original;	//original matrix Ab
	double[][] upper;		//upper matrix: will contain the factorized matrix
	double[][] lower;		// will contain the m numbers used for the factorization
	int[] columns;		//will contain the information if any cloumn swap has been done
	int N;
	int addToSwap = 0;
	
	/**
	 * 
	 * @param original matrix Ab to be factorized
	 */
	public  Matrix( double[][] original)
	{
		this.original = original;
		N = original.length ;
		upper = new double[N][N];
		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < original.length; j++) {
				upper[i][j] = original[i][j];
			}
		}
		lower = new double[N][N];
		columns = new int[N];
		for(int i = 0 ; i < N ; ++i)
		{
			columns[i] = i + 1;
		}
	}
	
	/**
	 * 	Triangulates the matrix using doolittle
	 *  
	 */
	public boolean triangulate()
	{
		for(int diag = 0; diag < N ; ++diag){
			for(int j = diag ; j < N  ; ++j){
				for(int i = diag + 1 ;  i < N  ; ++i){
					if(diag == j){
						if(upper[diag][diag] != 0){
							lower[i][j] = upper[i][j]/upper[diag][diag]; 
							addToSwap = 0;
						}else{
							addToSwap++;
							if(addToSwap == N)
								return false;
							swapRow(diag, diag + addToSwap);
							i--;
							continue;
						}
					}
					upper[i][j] = upper[i][j] - upper[diag][j] * lower[i][diag];
				}
			}
			lower[diag][diag] = 1;
		}
		return true;
	}
	
	private void swapRow(int i, int j){
		double[] tempRow;
		tempRow = upper[i];
		upper[i] = upper[j];
		upper[j] = tempRow;
		tempRow = lower[i];
		lower[i] = lower[j];
		lower[i] = tempRow;
	}
	
	/**
	 * Don't really get why would I want to swap columns... but if you want
	 * @param i the index of one of the columns to be swapped 
	 * @param j the other index of column
	 */
	public void swapColumn(int i, int j){
		double temp;
		int col;
		for(int idx = 0 ; idx < N ; ++idx ){
			temp = upper[idx][i];
			upper[idx][i] = upper[idx][j];
			upper[idx][j] = temp;
			temp = lower[idx][i];
			lower[idx][i] = lower[idx][j];
			lower[idx][j] = temp;
		}
		col = columns[i];
		columns[i] = columns[j];
		columns[j] = col;
	}
	
	
	public double[] calculateYVector(){
		double[] y = new double[N];
		double sum = 0;
		for(int i = 0 ; i < N ; ++i){
			sum = 0;
			for( int j = 0; j < i ; ++j){
				sum+= lower[i][j]*y[j];
			}
			y[i] = original[i][N] - sum;
			
		}
		return y;
	}
	
	public double[] calculateXVector(){
		double[] x = new double[N];
		double[] y = this.calculateYVector();
		double sum = 0;
		double rta = 0;
		for(int i = N-1 ; i >= 0 ; --i){
			sum = 0;
			for( int j = i + 1; j < N; ++j){
				sum += upper[i][j]*x[j];
			}
			rta = y[i] - sum;
			rta = rta / upper[i][i];
			x[i] = rta;
		}
		return x;
	}
	
	private static String matrixToString(double[][] matrix)
	{
		String ret = "";
		for (double[] row : matrix) {
			for (double d : row) {
				ret += " " + d + " ";
			}
			ret += " \n";
		}
		return ret;
	}
	
	@Override
	public String toString() {
		
		String ret = "original = \n";
		ret += matrixToString(original);
		ret += "upper = \n";
		ret += matrixToString(upper);
		ret += "lower = \n";		
		ret += matrixToString(lower);
		
		ret += "\n columnas = \n";
		for (int d : columns) {
			ret += " " + d + " ";
		}
		return ret;
	}
}
