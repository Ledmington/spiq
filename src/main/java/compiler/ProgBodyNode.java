package compiler;

import gen.spiqBaseVisitor;

import java.util.List;

public class ProgBodyNode extends Node {

	private final List<DeclNode> declarations;

	public ProgBodyNode(final List<DeclNode> nodes) {
		super();
		declarations = nodes;
	}

	public List<DeclNode> getDeclarations() {
		return declarations;
	}

	@Override
	public <S, E extends Exception> S accept(final spiqBaseVisitor<S> visitor) throws E {
		return null;
	}
}
