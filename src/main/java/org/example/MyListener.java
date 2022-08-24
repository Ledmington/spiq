package org.example;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import gen.spiqListener;
import gen.spiqParser.DeclContext;
import gen.spiqParser.ExponentialFormContext;
import gen.spiqParser.FractionContext;
import gen.spiqParser.IntegerContext;
import gen.spiqParser.NormalFormContext;
import gen.spiqParser.NumberContext;
import gen.spiqParser.ProgContext;
import gen.spiqParser.ProgbodyContext;
import gen.spiqParser.SignContext;

public class MyListener implements spiqListener {

    @Override
    public void visitTerminal(TerminalNode node) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void enterProg(ProgContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exitProg(ProgContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void enterProgbody(ProgbodyContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exitProgbody(ProgbodyContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void enterDecl(DeclContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exitDecl(DeclContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void enterNumber(NumberContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exitNumber(NumberContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void enterSign(SignContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exitSign(SignContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void enterInteger(IntegerContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exitInteger(IntegerContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void enterFraction(FractionContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exitFraction(FractionContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void enterNormalForm(NormalFormContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exitNormalForm(NormalFormContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void enterExponentialForm(ExponentialFormContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exitExponentialForm(ExponentialFormContext ctx) {
        // TODO Auto-generated method stub
        
    }
    
}
