import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import compiler.SpiqCompiler;

public class TestNumberDeclaration {

    private SpiqCompiler compiler;

    @BeforeEach
    public void setup() {
        compiler = new SpiqCompiler();
    }

    @ParameterizedTest
    @ValueSource(strings = { "-3", "12", "0", "+2" })
    public void integerDeclaration(String number) {
        assertEquals(0, compiler.compile("A is " + number + "."));
    }

    @ParameterizedTest
    @ValueSource(strings = { "5/7", "0/3", "2/0", "-1/12", "+13/31" })
    public void fractionDeclaration(String fraction) {
        assertEquals(0, compiler.compile("A is " + fraction + "."));
    }
}