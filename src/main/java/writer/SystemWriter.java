package writer;

public class SystemWriter implements OutputWriter {

	@Override
	public void println(String s) {
		System.out.println(s);
	}

	@Override
	public void print(String s) {
		System.out.print(s);
	}

}
