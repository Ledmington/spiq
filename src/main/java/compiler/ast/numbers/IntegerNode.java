package compiler.ast.numbers;

import java.math.BigInteger;

public class IntegerNode extends NumberNode {
    private final BigInteger value;

    public IntegerNode(final BigInteger value) {
        super();
        this.value = value;
    }
}
