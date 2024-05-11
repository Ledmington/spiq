// Generated from spiq.g4 by ANTLR 4.13.1

    package gen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link spiqParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface spiqVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link spiqParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(spiqParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link spiqParser#progbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgbody(spiqParser.ProgbodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link spiqParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(spiqParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link spiqParser#numberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberDeclaration(spiqParser.NumberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link spiqParser#withoutValueDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithoutValueDeclaration(spiqParser.WithoutValueDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link spiqParser#withValueDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithValueDeclaration(spiqParser.WithValueDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link spiqParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(spiqParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link spiqParser#fraction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFraction(spiqParser.FractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalForm}
	 * labeled alternative in {@link spiqParser#real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalForm(spiqParser.NormalFormContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exponentialForm}
	 * labeled alternative in {@link spiqParser#real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponentialForm(spiqParser.ExponentialFormContext ctx);
}