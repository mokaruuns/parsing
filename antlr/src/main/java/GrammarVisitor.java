// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath(GrammarParser.MathContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#equation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(GrammarParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#mathItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathItem(GrammarParser.MathItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(GrammarParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#mathSymbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathSymbol(GrammarParser.MathSymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#greek}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreek(GrammarParser.GreekContext ctx);
}