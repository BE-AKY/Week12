

import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class TestDemo {

//ADD POSITIVES
	public int addPositive(int a, int b) {
	
	if(a > 0 && b > 0) {
		return (a + b);
	}
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
	
//RANDOM NUMBER SQUARED
	@VisibleForTesting
	public int randomNumberSquared() {
		int randomInt = getRandomInt();
        return randomInt * randomInt;
		}
	
//RANDOM CLASS 
	@VisibleForTesting
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
}
