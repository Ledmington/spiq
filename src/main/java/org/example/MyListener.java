package org.example;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import gen.spiqListener;
import gen.spiqParser.ProgContext;
import gen.spiqParser.ProgbodyContext;

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
    
}
