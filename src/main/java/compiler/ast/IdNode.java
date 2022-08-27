package compiler.ast;

import gen.spiqBaseVisitor;

public class IdNode extends Node {

	private final String name;

	public IdNode(final String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public <S, E extends Exception> S accept(final spiqBaseVisitor<S> visitor) throws E {
		return null;
	}
}
