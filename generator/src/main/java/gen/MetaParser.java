// Generated from java-escape by ANTLR 4.11.1
package gen;
import grammar.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MetaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, TERM=8, NONTERM=9, 
		REGEX=10, CODE=11, VARIABLE=12, WS=13;
	public static final int
		RULE_start = 0, RULE_rule = 1, RULE_term = 2, RULE_nonTerm = 3, RULE_returnedValue = 4, 
		RULE_right = 5, RULE_grammar_name = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "rule", "term", "nonTerm", "returnedValue", "right", "grammar_name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "';'", "'|'", "'returns'", "'['", "']'", "'grammar'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "TERM", "NONTERM", "REGEX", 
			"CODE", "VARIABLE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MetaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public Grammar_nameContext grammar_name() {
			return getRuleContext(Grammar_nameContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MetaParser.EOF, 0); }
		public List<RuleContext> rule_() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleContext rule_(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			grammar_name();
			setState(16); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(15);
				rule_();
				}
				}
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TERM || _la==NONTERM );
			setState(20);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public NonTermContext nonTerm() {
			return getRuleContext(NonTermContext.class,0);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).enterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).exitRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleContext rule_() throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rule);
		try {
			setState(24);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				term();
				}
				break;
			case NONTERM:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				nonTerm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public Term t;
		public Token TERM;
		public Token REGEX;
		public TerminalNode TERM() { return getToken(MetaParser.TERM, 0); }
		public TerminalNode REGEX() { return getToken(MetaParser.REGEX, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			((TermContext)_localctx).TERM = match(TERM);
			setState(27);
			match(T__0);
			setState(28);
			((TermContext)_localctx).REGEX = match(REGEX);
			setState(29);
			match(T__1);
			((TermContext)_localctx).t =  new Term((((TermContext)_localctx).TERM!=null?((TermContext)_localctx).TERM.getText():null), (((TermContext)_localctx).REGEX!=null?((TermContext)_localctx).REGEX.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NonTermContext extends ParserRuleContext {
		public NonTerm nt;
		public Token NONTERM;
		public ReturnedValueContext returnedValue;
		public RightContext right;
		public TerminalNode NONTERM() { return getToken(MetaParser.NONTERM, 0); }
		public List<RightContext> right() {
			return getRuleContexts(RightContext.class);
		}
		public RightContext right(int i) {
			return getRuleContext(RightContext.class,i);
		}
		public ReturnedValueContext returnedValue() {
			return getRuleContext(ReturnedValueContext.class,0);
		}
		public NonTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).enterNonTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).exitNonTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitNonTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonTermContext nonTerm() throws RecognitionException {
		NonTermContext _localctx = new NonTermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nonTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			((NonTermContext)_localctx).NONTERM = match(NONTERM);
			((NonTermContext)_localctx).nt =  new NonTerm((((NonTermContext)_localctx).NONTERM!=null?((NonTermContext)_localctx).NONTERM.getText():null));
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(34);
				((NonTermContext)_localctx).returnedValue = returnedValue();
				_localctx.nt.setReturnValue(((NonTermContext)_localctx).returnedValue.rValue);
				}
			}

			setState(39);
			match(T__0);
			setState(40);
			((NonTermContext)_localctx).right = right();
			_localctx.nt.addAlternative(((NonTermContext)_localctx).right.array);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(42);
				match(T__2);
				setState(43);
				((NonTermContext)_localctx).right = right();
				_localctx.nt.addAlternative(((NonTermContext)_localctx).right.array);
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnedValueContext extends ParserRuleContext {
		public ReturnValue rValue;
		public Token TERM;
		public Token NONTERM;
		public TerminalNode TERM() { return getToken(MetaParser.TERM, 0); }
		public TerminalNode NONTERM() { return getToken(MetaParser.NONTERM, 0); }
		public ReturnedValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnedValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).enterReturnedValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).exitReturnedValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitReturnedValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnedValueContext returnedValue() throws RecognitionException {
		ReturnedValueContext _localctx = new ReturnedValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_returnedValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__3);
			setState(54);
			match(T__4);
			setState(55);
			((ReturnedValueContext)_localctx).TERM = match(TERM);
			setState(56);
			((ReturnedValueContext)_localctx).NONTERM = match(NONTERM);
			setState(57);
			match(T__5);
			((ReturnedValueContext)_localctx).rValue =  new ReturnValue((((ReturnedValueContext)_localctx).TERM!=null?((ReturnedValueContext)_localctx).TERM.getText():null), (((ReturnedValueContext)_localctx).NONTERM!=null?((ReturnedValueContext)_localctx).NONTERM.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RightContext extends ParserRuleContext {
		public ArrayList<ValueToken> array;
		public Token TERM;
		public Token NONTERM;
		public Token CODE;
		public List<TerminalNode> TERM() { return getTokens(MetaParser.TERM); }
		public TerminalNode TERM(int i) {
			return getToken(MetaParser.TERM, i);
		}
		public List<TerminalNode> NONTERM() { return getTokens(MetaParser.NONTERM); }
		public TerminalNode NONTERM(int i) {
			return getToken(MetaParser.NONTERM, i);
		}
		public List<TerminalNode> CODE() { return getTokens(MetaParser.CODE); }
		public TerminalNode CODE(int i) {
			return getToken(MetaParser.CODE, i);
		}
		public RightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_right; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).enterRight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).exitRight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitRight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightContext right() throws RecognitionException {
		RightContext _localctx = new RightContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_right);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((RightContext)_localctx).array =  new ArrayList();
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(67);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TERM:
					{
					setState(61);
					((RightContext)_localctx).TERM = match(TERM);
					_localctx.array.add(new ValueToken((((RightContext)_localctx).TERM!=null?((RightContext)_localctx).TERM.getText():null), Type.TERM));
					}
					break;
				case NONTERM:
					{
					setState(63);
					((RightContext)_localctx).NONTERM = match(NONTERM);
					_localctx.array.add(new ValueToken((((RightContext)_localctx).NONTERM!=null?((RightContext)_localctx).NONTERM.getText():null), Type.NON_TERM));
					}
					break;
				case CODE:
					{
					setState(65);
					((RightContext)_localctx).CODE = match(CODE);
					_localctx.array.add(new ValueToken((((RightContext)_localctx).CODE!=null?((RightContext)_localctx).CODE.getText():null), Type.CODE));
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 2816L) != 0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Grammar_nameContext extends ParserRuleContext {
		public TerminalNode TERM() { return getToken(MetaParser.TERM, 0); }
		public Grammar_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammar_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).enterGrammar_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).exitGrammar_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitGrammar_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Grammar_nameContext grammar_name() throws RecognitionException {
		Grammar_nameContext _localctx = new Grammar_nameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_grammar_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__6);
			setState(72);
			match(TERM);
			setState(73);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\rL\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0004"+
		"\u0000\u0011\b\u0000\u000b\u0000\f\u0000\u0012\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u0019\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003&\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003/\b\u0003\n\u0003\f\u00032\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0004\u0005D\b\u0005\u000b\u0005\f\u0005E\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0000\u0000\u0007"+
		"\u0000\u0002\u0004\u0006\b\n\f\u0000\u0000K\u0000\u000e\u0001\u0000\u0000"+
		"\u0000\u0002\u0018\u0001\u0000\u0000\u0000\u0004\u001a\u0001\u0000\u0000"+
		"\u0000\u0006 \u0001\u0000\u0000\u0000\b5\u0001\u0000\u0000\u0000\n<\u0001"+
		"\u0000\u0000\u0000\fG\u0001\u0000\u0000\u0000\u000e\u0010\u0003\f\u0006"+
		"\u0000\u000f\u0011\u0003\u0002\u0001\u0000\u0010\u000f\u0001\u0000\u0000"+
		"\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0010\u0001\u0000\u0000"+
		"\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000"+
		"\u0000\u0014\u0015\u0005\u0000\u0000\u0001\u0015\u0001\u0001\u0000\u0000"+
		"\u0000\u0016\u0019\u0003\u0004\u0002\u0000\u0017\u0019\u0003\u0006\u0003"+
		"\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0018\u0017\u0001\u0000\u0000"+
		"\u0000\u0019\u0003\u0001\u0000\u0000\u0000\u001a\u001b\u0005\b\u0000\u0000"+
		"\u001b\u001c\u0005\u0001\u0000\u0000\u001c\u001d\u0005\n\u0000\u0000\u001d"+
		"\u001e\u0005\u0002\u0000\u0000\u001e\u001f\u0006\u0002\uffff\uffff\u0000"+
		"\u001f\u0005\u0001\u0000\u0000\u0000 !\u0005\t\u0000\u0000!%\u0006\u0003"+
		"\uffff\uffff\u0000\"#\u0003\b\u0004\u0000#$\u0006\u0003\uffff\uffff\u0000"+
		"$&\u0001\u0000\u0000\u0000%\"\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&\'\u0001\u0000\u0000\u0000\'(\u0005\u0001\u0000\u0000()\u0003\n"+
		"\u0005\u0000)0\u0006\u0003\uffff\uffff\u0000*+\u0005\u0003\u0000\u0000"+
		"+,\u0003\n\u0005\u0000,-\u0006\u0003\uffff\uffff\u0000-/\u0001\u0000\u0000"+
		"\u0000.*\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000"+
		"\u0000\u000001\u0001\u0000\u0000\u000013\u0001\u0000\u0000\u000020\u0001"+
		"\u0000\u0000\u000034\u0005\u0002\u0000\u00004\u0007\u0001\u0000\u0000"+
		"\u000056\u0005\u0004\u0000\u000067\u0005\u0005\u0000\u000078\u0005\b\u0000"+
		"\u000089\u0005\t\u0000\u00009:\u0005\u0006\u0000\u0000:;\u0006\u0004\uffff"+
		"\uffff\u0000;\t\u0001\u0000\u0000\u0000<C\u0006\u0005\uffff\uffff\u0000"+
		"=>\u0005\b\u0000\u0000>D\u0006\u0005\uffff\uffff\u0000?@\u0005\t\u0000"+
		"\u0000@D\u0006\u0005\uffff\uffff\u0000AB\u0005\u000b\u0000\u0000BD\u0006"+
		"\u0005\uffff\uffff\u0000C=\u0001\u0000\u0000\u0000C?\u0001\u0000\u0000"+
		"\u0000CA\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000"+
		"\u0000\u0000EF\u0001\u0000\u0000\u0000F\u000b\u0001\u0000\u0000\u0000"+
		"GH\u0005\u0007\u0000\u0000HI\u0005\b\u0000\u0000IJ\u0005\u0002\u0000\u0000"+
		"J\r\u0001\u0000\u0000\u0000\u0006\u0012\u0018%0CE";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}