// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMath(GrammarParser.MathContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMath(GrammarParser.MathContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#equation}.
	 * @param ctx the parse tree
	 */
	void enterEquation(GrammarParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#equation}.
	 * @param ctx the parse tree
	 */
	void exitEquation(GrammarParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#mathItem}.
	 * @param ctx the parse tree
	 */
	void enterMathItem(GrammarParser.MathItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#mathItem}.
	 * @param ctx the parse tree
	 */
	void exitMathItem(GrammarParser.MathItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(GrammarParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(GrammarParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#mathSymbol}.
	 * @param ctx the parse tree
	 */
	void enterMathSymbol(GrammarParser.MathSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#mathSymbol}.
	 * @param ctx the parse tree
	 */
	void exitMathSymbol(GrammarParser.MathSymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#greek}.
	 * @param ctx the parse tree
	 */
	void enterGreek(GrammarParser.GreekContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#greek}.
	 * @param ctx the parse tree
	 */
	void exitGreek(GrammarParser.GreekContext ctx);
}