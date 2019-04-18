package spring;

public class ExeTimeCalculator implements Calculator{

	private Calculator delegate;
	
	public ExeTimeCalculator(Calculator delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		long result = delegate.factorial(num);
		long end = System.nanoTime();
		long time = end - start;
		System.out.printf("%s.factorial(%d) ExeTime = %d \n", delegate.getClass().getSimpleName(), num, time);
		return result;
	}

	
}
