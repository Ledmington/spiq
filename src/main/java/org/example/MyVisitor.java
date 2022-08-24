package org.example;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import gen.spiqParser.DeclContext;
import gen.spiqParser.ExponentialFormContext;
import gen.spiqParser.FractionContext;
import gen.spiqParser.IntegerContext;
import gen.spiqParser.NormalFormContext;
import gen.spiqParser.NumberContext;
import gen.spiqParser.ProgContext;
import gen.spiqParser.ProgbodyContext;
import gen.spiqParser.SignContext;
import gen.spiqVisitor;

public class MyVisitor<T> implements spiqVisitor<T> {

    @Override
    public T visit(ParseTree tree) {
        throw new Error("Not implemented");
    }

    @Override
    public T visitChildren(RuleNode node) {
        throw new Error("Not implemented");
    }

    @Override
    public T visitTerminal(TerminalNode node) {
        throw new Error("Not implemented");
    }

    @Override
    public T visitErrorNode(ErrorNode node) {
        throw new Error("Not implemented");
    }

    @Override
    public T visitProg(ProgContext ctx) {
        throw new Error("Not implemented");
    }

    @Override
    public T visitProgbody(ProgbodyContext ctx) {
        throw new Error("Not implemented");
    }

    @Override
    public T visitDecl(DeclContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visitNumber(NumberContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visitSign(SignContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visitInteger(IntegerContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visitFraction(FractionContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visitNormalForm(NormalFormContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visitExponentialForm(ExponentialFormContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }
}