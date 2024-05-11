// Generated from spiq.g4 by ANTLR 4.13.1

    package gen;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link spiqParser}.
 */
public interface spiqListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link spiqParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(spiqParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link spiqParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(spiqParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link spiqParser#progbody}.
	 * @param ctx the parse tree
	 */
	void enterProgbody(spiqParser.ProgbodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link spiqParser#progbody}.
	 * @param ctx the parse tree
	 */
	void exitProgbody(spiqParser.ProgbodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link spiqParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(spiqParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link spiqParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(spiqParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link spiqParser#numberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNumberDeclaration(spiqParser.NumberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link spiqParser#numberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNumberDeclaration(spiqParser.NumberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link spiqParser#withoutValueDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterWithoutValueDeclaration(spiqParser.WithoutValueDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link spiqParser#withoutValueDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitWithoutValueDeclaration(spiqParser.WithoutValueDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link spiqParser#withValueDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterWithValueDeclaration(spiqParser.WithValueDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link spiqParser#withValueDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitWithValueDeclaration(spiqParser.WithValueDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link spiqParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(spiqParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link spiqParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(spiqParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link spiqParser#fraction}.
	 * @param ctx the parse tree
	 */
	void enterFraction(spiqParser.FractionContext ctx);
	/**
	 * Exit a parse tree produced by {@link spiqParser#fraction}.
	 * @param ctx the parse tree
	 */
	void exitFraction(spiqParser.FractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normalForm}
	 * labeled alternative in {@link spiqParser#real}.
	 * @param ctx the parse tree
	 */
	void enterNormalForm(spiqParser.NormalFormContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normalForm}
	 * labeled alternative in {@link spiqParser#real}.
	 * @param ctx the parse tree
	 */
	void exitNormalForm(spiqParser.NormalFormContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exponentialForm}
	 * labeled alternative in {@link spiqParser#real}.
	 * @param ctx the parse tree
	 */
	void enterExponentialForm(spiqParser.ExponentialFormContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exponentialForm}
	 * labeled alternative in {@link spiqParser#real}.
	 * @param ctx the parse tree
	 */
	void exitExponentialForm(spiqParser.ExponentialFormContext ctx);
}