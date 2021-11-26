package program;

import java.util.List;
import java.util.Random;

public class Generator extends Thread {
	private List<Integer> numbers;
	boolean activo;

	public Generator(List<Integer> numbers) {
		super();
		this.numbers = numbers;
		this.activo = true;
	}
	

	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	@Override
	public void run() {
		while (activo) {
			int n=new Random().nextInt(30);
			for (int i = 0; i < n; i++) {
				numbers.add(new Random().nextInt(1000));
				System.out.println("Generating...");
				for(Integer num : numbers){
					System.out.println(num);
				}
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("End process.");
		}
	}
}
