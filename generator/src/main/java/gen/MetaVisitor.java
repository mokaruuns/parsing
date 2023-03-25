// Generated from java-escape by ANTLR 4.11.1
package gen;
import grammar.*;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MetaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MetaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MetaParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(MetaParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(MetaParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(MetaParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#nonTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonTerm(MetaParser.NonTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#returnedValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnedValue(MetaParser.ReturnedValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#argsValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgsValue(MetaParser.ArgsValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#right}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRight(MetaParser.RightContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#grammar_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrammar_name(MetaParser.Grammar_nameContext ctx);
}