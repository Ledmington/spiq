package compiler.ast.numbers;

import compiler.ast.Node;
import gen.spiqBaseVisitor;

public abstract class NumberNode extends Node {

	public NumberNode() {
		super();
	}

	@Override
	public <S, E extends Exception> S accept(final spiqBaseVisitor<S> visitor) throws E {
		return null;
	}
}
