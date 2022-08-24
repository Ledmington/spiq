import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import compiler.SpiqCompiler;

public class TestNumberDeclaration {
    @ParameterizedTest
    @ValueSource(ints = { -3, -2, -1, 0, 1, 2, 3 }) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertEquals(SpiqCompiler.getInstance().compile("A is " + number), 0);
    }
}