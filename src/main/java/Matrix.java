
public class Matrix {

	double[][] original;
	double[][] upper;
	double[][] lower;
	int[] columns;
	int N;
	
	public  Matrix( double[][] original)
	{
		this.original = original;
		N = original.length ;
		upper = original.clone();
		lower = new double[N][N];
		columns = new int[N];
		for(int i = 0 ; i < N ; ++i)
		{
			columns[i] = i + 1;
		}
	}
	
	public boolean triangulate()
	{
		for(int diag = 0; diag < N ; ++diag){
			for(int j = diag ; j < N + 1  ; ++j){
				for(int i = diag + 1 ;  i < N  ; ++i){
					if(diag == j){
						if(upper[diag][diag] != 0){
							lower[i][j] = upper[i][j]/upper[diag][diag]; 
						}else{
							swapRow(diag, diag + 1);
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
	
	private void swapColumn(int i, int j){
		
	}
	
	
	@Override
	public String toString() {
		
		String ret = "original = \n";
		
		for (double[] row : original) {
			for (double d : row) {
				ret += " " + d + " ";
			}
			ret += " \n";
		}

		ret += "upper = \n";
		
		for (double[] row : upper) {
			for (double d : row) {
				ret += " " + d + " ";
			}
			ret += " \n";
		}
		
		ret += "lower = \n";
		
		for (double[] row : lower) {
			for (double d : row) {
				ret += " " + d + " ";
			}
			ret += " \n";
		}
		ret += "\n columnas = \n";
		for (int d : columns) {
			ret += " " + d + " ";
		}
		return ret;
	}
}
