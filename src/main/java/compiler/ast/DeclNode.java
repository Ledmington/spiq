package compiler.ast;

import gen.spiqBaseVisitor;

public class DeclNode extends Node {

	private final IdNode id;
	private final NumberNode number;

	public DeclNode(final IdNode id, final NumberNode number) {
		super();
		this.id = id;
		this.number = number;
	}

	@Override
	public <S, E extends Exception> S accept(final spiqBaseVisitor<S> visitor) throws E {
		return null;
	}
}
