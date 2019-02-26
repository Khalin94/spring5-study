package chap07;

public class ImpeCalculator implements Calculator{

	public long factorial(long num) {
		long result = 1;
		for(int i = 1; i <= num; i++) {
			result = result * i;
		}
		return result;
	}

}
