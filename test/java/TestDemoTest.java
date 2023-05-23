

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
//PARAMETER SOURCE METHOD
    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
    			Arguments.of(2, 4, 6, false),
    			//ZEROES (Both parameters need to be GREATER Than zero to be FALSE)
    			Arguments.of(0, 0, 0, true),
    			Arguments.of(0, 20, 20, true),
    			Arguments.of(5, 0, 5, true),
    			//NEGATIVES
    			Arguments.of(-7, -3, -10, true),
    			Arguments.of(-10, 0, -10, true),
    			Arguments.of(0, -15, -15, true)
        );
    }

    @Test
    public void assertThatNumberSquaredIsCorrect() {
        //Mock TestDemo class using Mockito.spy
    	TestDemo mockDemo = spy(testDemo);
        
    	doReturn(5).when(mockDemo).getRandomInt();
        
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
    }
    
}
