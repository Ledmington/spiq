package compiler;

import gen.spiqBaseVisitor;

public interface Visitable {
    <S, E extends Exception> S accept(spiqBaseVisitor<S> visitor) throws E;
}