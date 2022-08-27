package compiler.ast.numbers;

import java.math.BigInteger;

public class FractionNode extends NumberNode {
    private final BigInteger numerator;
    private final BigInteger denominator;

    public FractionNode(final BigInteger numerator, final BigInteger denominator) {
        super();
        this.numerator = numerator;
        this.denominator = denominator;
    }
}
