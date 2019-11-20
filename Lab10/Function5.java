/*
 * @author https://github.com/amattu2
 * @desc A implementation of the Function #3 denomenator
 * @date 11/20/2019
 */
public class Function5 extends Function {
	@Override
	public double fnValue(double x) {
		return Math.sin(1 / x);
	}

	public String toString () {
		return "sin(1/x)";
	}
}
