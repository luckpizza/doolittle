
public class doolittle {

	public static void main(String[] args) {
		Matrix m;
		double[][] original = {{1, 1, 1},{2,2,2}, {3,3,3}};
		m = new Matrix(original);
		for (double[] ds : original) {
			for (double d : ds) {
				System.out.println(d);
			}
		}
		System.out.println(m);
	}
}
