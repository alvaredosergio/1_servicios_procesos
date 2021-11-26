package program;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		Generator gen = new Generator(numbers);
		gen.start();


		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gen.setActivo(false);

	}

}
