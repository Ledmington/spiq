package compiler.ast;

import compiler.Visitable;

public abstract class Node implements Visitable {

    private final int line = -1;

    public int getLine() {
        return line;
    }
}
