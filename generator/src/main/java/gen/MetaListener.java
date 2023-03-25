// Generated from java-escape by ANTLR 4.11.1
package gen;
import grammar.*;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MetaParser}.
 */
public interface MetaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MetaParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(MetaParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(MetaParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(MetaParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(MetaParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(MetaParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(MetaParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaParser#nonTerm}.
	 * @param ctx the parse tree
	 */
	void enterNonTerm(MetaParser.NonTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaParser#nonTerm}.
	 * @param ctx the parse tree
	 */
	void exitNonTerm(MetaParser.NonTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaParser#returnedValue}.
	 * @param ctx the parse tree
	 */
	void enterReturnedValue(MetaParser.ReturnedValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaParser#returnedValue}.
	 * @param ctx the parse tree
	 */
	void exitReturnedValue(MetaParser.ReturnedValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaParser#argsValue}.
	 * @param ctx the parse tree
	 */
	void enterArgsValue(MetaParser.ArgsValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaParser#argsValue}.
	 * @param ctx the parse tree
	 */
	void exitArgsValue(MetaParser.ArgsValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaParser#right}.
	 * @param ctx the parse tree
	 */
	void enterRight(MetaParser.RightContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaParser#right}.
	 * @param ctx the parse tree
	 */
	void exitRight(MetaParser.RightContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaParser#grammar_name}.
	 * @param ctx the parse tree
	 */
	void enterGrammar_name(MetaParser.Grammar_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaParser#grammar_name}.
	 * @param ctx the parse tree
	 */
	void exitGrammar_name(MetaParser.Grammar_nameContext ctx);
}