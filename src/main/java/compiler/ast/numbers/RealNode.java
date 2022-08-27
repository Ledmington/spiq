package compiler.ast.numbers;

import com.ibm.icu.math.BigDecimal;

public class RealNode extends NumberNode {
    private final BigDecimal value;

    public RealNode(final BigDecimal value) {
        super();
        this.value = value;
    }
}
