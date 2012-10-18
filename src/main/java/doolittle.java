
public class doolittle {

	public static void main(String[] args) {
		Matrix m;
//		double[][] original = {{1, 3, 4, 1},{2,6,13, 3}, {1, 5, 7, 2}};
		double[][] original = {{0, 1, 2, 3},{1,0,1, 1}, {1, 1, 0, 1}};

	//	double[][] original = {{1, 2, 3, 4},{5,6,7, 8}, {9, 10, 13, 12}};
		m = new Matrix(original);
		for (double[] ds : original) {
			for (double d : ds) {
				System.out.println(d);
			}
		}
		System.out.println(m);
		System.out.println("TRIANGULATING!");
		m.triangulate();
		System.out.println(m);
	}
}
