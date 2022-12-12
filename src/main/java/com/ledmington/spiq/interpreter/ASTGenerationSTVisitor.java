/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import com.ledmington.spiq.interpreter.ast.DeclNode;
import com.ledmington.spiq.interpreter.ast.IdNode;
import com.ledmington.spiq.interpreter.ast.Node;
import com.ledmington.spiq.interpreter.ast.ProgBodyNode;
import com.ledmington.spiq.interpreter.ast.numbers.FractionNode;
import com.ledmington.spiq.interpreter.ast.numbers.IntegerNode;
import com.ledmington.spiq.interpreter.ast.numbers.NumberNode;
import com.ledmington.spiq.interpreter.ast.numbers.RealNode;
import com.ledmington.spiq.interpreter.vm.SpiqVM;
import com.ledmington.spiq.interpreter.vm.VariableType;

import gen.spiqBaseVisitor;
import gen.spiqParser.DeclContext;
import gen.spiqParser.NumberDeclarationContext;
import gen.spiqParser.ProgContext;
import gen.spiqParser.ProgbodyContext;
import gen.spiqParser.WithValueDeclarationContext;
import gen.spiqParser.WithoutValueDeclarationContext;

// TODO change name
public class ASTGenerationSTVisitor extends spiqBaseVisitor<Node> {

    private static final String SINGLE_INDENTATION = "  "; // double space

    private String indent = "";
    private String varName = null;
    private final boolean debug;

    private final SpiqVM vm;

    public ASTGenerationSTVisitor(final SpiqVM vm, final boolean debug) {
        super();
        this.vm = vm;
        this.debug = debug;
    }

    public ASTGenerationSTVisitor(final SpiqVM vm) {
        this(vm, true);
    }

    private void printVarAndProdName(ParserRuleContext ctx) {
        String prefix = "";
        Class<?> ctxClass = ctx.getClass(), parentClass = ctxClass.getSuperclass();
        if (!parentClass.equals(ParserRuleContext.class)) { // parentClass is the var context (and not ctxClass itself)
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

        varName = c.ID().getText();

        final DeclNode result = new DeclNode(
                new IdNode(varName), // (IdNode) visit(c.ID()), // TODO solve this
                (NumberNode) visit(c.numberDeclaration()));
        varName = null;
        return result;
    }

    @Override
    public Node visitNumberDeclaration(final NumberDeclarationContext c) {
        if (debug) {
            printVarAndProdName(c);
        }

        if (c.withValueDeclaration() != null) {
            return visit(c.withValueDeclaration());
        }
        if (c.withoutValueDeclaration() != null) {
            return visit(c.withoutValueDeclaration());
        }

        throw new IllegalArgumentException("What kind of number declaration is \"" + c.getText() + "\"?");
    }

    @Override
    public Node visitWithoutValueDeclaration(final WithoutValueDeclarationContext c) {
        if (debug) {
            printVarAndProdName(c);
        }

        if (c.INTEGER() != null) {
            vm.newVariable(varName, VariableType.INTEGER);
            return new IntegerNode(new BigInteger("0"));
        }
        if (c.FRACTION() != null || c.RATIONAL() != null) {
            vm.newVariable(varName, VariableType.RATIONAL);
            return new FractionNode(new BigInteger("0"), new BigInteger("1"));
        }
        if (c.REAL() != null) {
            vm.newVariable(varName, VariableType.REAL);
            return new RealNode(new BigDecimal("0.0"));
        }
        if (c.NUMBER() != null) {
            vm.newVariable(varName, VariableType.NUMBER);
            return new RealNode(new BigDecimal(0.0));
        }

        throw new IllegalArgumentException("What kind of number declaration is \"" + c.getText() + "\"?");
    }

    @Override
    public Node visitWithValueDeclaration(final WithValueDeclarationContext c) {
        if (debug) {
            printVarAndProdName(c);
        }

        String sign = "";
        if (c.SIGN() != null && c.SIGN().getText().equals("-")) {
            // negative number
            sign = "-";
        }

        if (c.integer() != null) {
            return new IntegerNode(new BigInteger(sign + c.integer().getText()));
        }

        if (c.fraction() != null) {
            return new FractionNode(
                    new BigInteger(sign + c.fraction().num.getText()),
                    new BigInteger(c.fraction().den.getText()));
        }

        if (c.real() != null) {
            System.out.println("real: " + c.real().getText());
            return new RealNode(new BigDecimal(sign + c.real().getText()));
        }

        throw new IllegalArgumentException("What kind of number is \"" + c.getText() + "\"?");
    }
}
