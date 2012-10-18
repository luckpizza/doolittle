
public class Matrix {

	double[][] original;
	double[][] upper;
	double[][] lower;
	int[] columns;
	int N;
	
	public  Matrix( double[][] original, double[] B)
	{
		this.original = original;
		N = original.length - 1;
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
		for(int i = 0 ;  i < )
		
		return true;
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
