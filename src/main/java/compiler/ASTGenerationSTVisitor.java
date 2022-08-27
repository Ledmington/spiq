package compiler;

import java.util.LinkedList;
import java.util.List;

import compiler.ast.DeclNode;
import compiler.ast.IdNode;
import compiler.ast.Node;
import compiler.ast.NumberNode;
import compiler.ast.ProgBodyNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import gen.spiqBaseVisitor;
import gen.spiqParser.DeclContext;
import gen.spiqParser.NumberContext;
import gen.spiqParser.ProgContext;
import gen.spiqParser.ProgbodyContext;

public class ASTGenerationSTVisitor extends spiqBaseVisitor<Node> {

    private static final String SINGLE_INDENTATION = "  "; // double space

    private String indent = "";
    private final boolean debug = true;

    private void printVarAndProdName(ParserRuleContext ctx) {
        String prefix = "";
        Class<?> ctxClass = ctx.getClass(), parentClass = ctxClass.getSuperclass();
        if (!parentClass.equals(ParserRuleContext.class)) {// parentClass is the var context (and not ctxClass itself)
            prefix = CompilerUtils.lowerizeFirstChar(CompilerUtils.extractCtxName(parentClass.getName()))
                    + ": production #";
        }
        System.out.println(
                indent + prefix + CompilerUtils.lowerizeFirstChar(CompilerUtils.extractCtxName(ctxClass.getName())));
    }

    @Override
    public Node visit(final ParseTree t) {
        if (t == null) {
            return null;
        }
        String temp = indent;
        indent = (indent == null) ? "" : indent + SINGLE_INDENTATION;
        Node result = super.visit(t);
        indent = temp;
        return result;
    }

    @Override
    public Node visitProg(final ProgContext c) {
        if (debug) {
            printVarAndProdName(c);
        }
        return visit(c.progbody());
    }

    @Override
    public Node visitProgbody(final ProgbodyContext c) {
        if (debug) {
            printVarAndProdName(c);
        }
        final List<DeclContext> declarations = c.decl();
        if (debug) {
            System.out.println("Found " + declarations.size() + " declarations");
        }
        final List<DeclNode> nodes = new LinkedList<>();
        for (int i = 0; i < declarations.size(); i++) {
            nodes.add((DeclNode) visit(c.decl(i)));
        }
        return new ProgBodyNode(nodes);
    }

    @Override
    public Node visitDecl(final DeclContext c) {
        if (debug) {
            printVarAndProdName(c);
        }
        return new DeclNode(
                new IdNode(c.ID().getText()), // (IdNode) visit(c.ID()), // TODO solve this
                (NumberNode) visit(c.number()));
    }

    @Override
    public Node visitNumber(final NumberContext c) {
        if (debug) {
            printVarAndProdName(c);
        }

        String sign = "";
        if (c.sign() != null && c.sign().getText().equals("-")) {
            // negative number
            sign = "-";
        }

        if (c.integer() != null) {
            System.out.println("integer: " + c.integer().getText());
        }
        if (c.fraction() != null) {
            System.out.println("fraction: " + c.fraction().getText());
        }
        if (c.real() != null) {
            System.out.println("real: " + c.real().getText());
        }

        return new NumberNode(); // TODO fix
    }
}