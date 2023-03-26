// Generated from java-escape by ANTLR 4.11.1
package gen;
import utils.*;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, TERM=12, NONTERM=13, REGEX=14, CODE=15, WS=16;
	public static final int
		RULE_start = 0, RULE_rule = 1, RULE_term = 2, RULE_nonTerm = 3, RULE_returnedValue = 4, 
		RULE_argsValue = 5, RULE_right = 6, RULE_grammar_name = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "rule", "term", "nonTerm", "returnedValue", "argsValue", "right", 
			"grammar_name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "';'", "'|'", "'returns'", "'['", "']'", "'args'", "'('", 
			"','", "')'", "'utils'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"TERM", "NONTERM", "REGEX", "CODE", "WS"
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
			setState(16);
			grammar_name();
			setState(18); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(17);
				rule_();
				}
				}
				setState(20); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TERM || _la==NONTERM );
			setState(22);
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
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				term();
				}
				break;
			case NONTERM:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
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
			setState(28);
			((TermContext)_localctx).TERM = match(TERM);
			setState(29);
			match(T__0);
			setState(30);
			((TermContext)_localctx).REGEX = match(REGEX);
			setState(31);
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
		public ArgsValueContext argsValue;
		public ReturnedValueContext returnedValue;
		public RightContext right;
		public TerminalNode NONTERM() { return getToken(MetaParser.NONTERM, 0); }
		public List<RightContext> right() {
			return getRuleContexts(RightContext.class);
		}
		public RightContext right(int i) {
			return getRuleContext(RightContext.class,i);
		}
		public ArgsValueContext argsValue() {
			return getRuleContext(ArgsValueContext.class,0);
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
			setState(34);
			((NonTermContext)_localctx).NONTERM = match(NONTERM);
			((NonTermContext)_localctx).nt =  new NonTerm((((NonTermContext)_localctx).NONTERM!=null?((NonTermContext)_localctx).NONTERM.getText():null));
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(36);
				((NonTermContext)_localctx).argsValue = argsValue();
				_localctx.nt.setArgs(((NonTermContext)_localctx).argsValue.array);
				}
			}

			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(41);
				((NonTermContext)_localctx).returnedValue = returnedValue();
				_localctx.nt.setReturnValue(((NonTermContext)_localctx).returnedValue.rValue);
				}
			}

			setState(46);
			match(T__0);
			setState(47);
			((NonTermContext)_localctx).right = right();
			_localctx.nt.addAlternative(((NonTermContext)_localctx).right.array);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(49);
				match(T__2);
				setState(50);
				((NonTermContext)_localctx).right = right();
				_localctx.nt.addAlternative(((NonTermContext)_localctx).right.array);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
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
		public ExtraValue rValue;
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
			setState(60);
			match(T__3);
			setState(61);
			match(T__4);
			setState(62);
			((ReturnedValueContext)_localctx).TERM = match(TERM);
			setState(63);
			((ReturnedValueContext)_localctx).NONTERM = match(NONTERM);
			setState(64);
			match(T__5);
			((ReturnedValueContext)_localctx).rValue =  new ExtraValue((((ReturnedValueContext)_localctx).TERM!=null?((ReturnedValueContext)_localctx).TERM.getText():null), (((ReturnedValueContext)_localctx).NONTERM!=null?((ReturnedValueContext)_localctx).NONTERM.getText():null));
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
	public static class ArgsValueContext extends ParserRuleContext {
		public ArrayList<ExtraValue> array;
		public Token TERM;
		public Token NONTERM;
		public List<TerminalNode> TERM() { return getTokens(MetaParser.TERM); }
		public TerminalNode TERM(int i) {
			return getToken(MetaParser.TERM, i);
		}
		public List<TerminalNode> NONTERM() { return getTokens(MetaParser.NONTERM); }
		public TerminalNode NONTERM(int i) {
			return getToken(MetaParser.NONTERM, i);
		}
		public ArgsValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argsValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).enterArgsValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaListener ) ((MetaListener)listener).exitArgsValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitArgsValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsValueContext argsValue() throws RecognitionException {
		ArgsValueContext _localctx = new ArgsValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_argsValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ArgsValueContext)_localctx).array =  new ArrayList();
			setState(68);
			match(T__6);
			setState(69);
			match(T__7);
			setState(70);
			((ArgsValueContext)_localctx).TERM = match(TERM);
			setState(71);
			((ArgsValueContext)_localctx).NONTERM = match(NONTERM);
			_localctx.array.add(new ExtraValue((((ArgsValueContext)_localctx).TERM!=null?((ArgsValueContext)_localctx).TERM.getText():null), (((ArgsValueContext)_localctx).NONTERM!=null?((ArgsValueContext)_localctx).NONTERM.getText():null)));
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(73);
				match(T__8);
				setState(74);
				((ArgsValueContext)_localctx).TERM = match(TERM);
				setState(75);
				((ArgsValueContext)_localctx).NONTERM = match(NONTERM);
				_localctx.array.add(new ExtraValue((((ArgsValueContext)_localctx).TERM!=null?((ArgsValueContext)_localctx).TERM.getText():null), (((ArgsValueContext)_localctx).NONTERM!=null?((ArgsValueContext)_localctx).NONTERM.getText():null)));
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			match(T__9);
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
		enterRule(_localctx, 12, RULE_right);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((RightContext)_localctx).array =  new ArrayList();
			setState(109); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				ValueToken v;
				setState(106);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TERM:
					{
					setState(86);
					((RightContext)_localctx).TERM = match(TERM);
					v = new ValueToken((((RightContext)_localctx).TERM!=null?((RightContext)_localctx).TERM.getText():null), Type.TERM);
					}
					break;
				case NONTERM:
					{
					setState(88);
					((RightContext)_localctx).NONTERM = match(NONTERM);
					v = new ValueToken((((RightContext)_localctx).NONTERM!=null?((RightContext)_localctx).NONTERM.getText():null), Type.NON_TERM);
					setState(102);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__7) {
						{
						setState(90);
						match(T__7);
						setState(91);
						((RightContext)_localctx).NONTERM = match(NONTERM);
						v.addArg((((RightContext)_localctx).NONTERM!=null?((RightContext)_localctx).NONTERM.getText():null));
						setState(98);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__8) {
							{
							{
							setState(93);
							match(T__8);
							setState(94);
							((RightContext)_localctx).NONTERM = match(NONTERM);
							v.addArg((((RightContext)_localctx).NONTERM!=null?((RightContext)_localctx).NONTERM.getText():null));
							}
							}
							setState(100);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(101);
						match(T__9);
						}
					}

					}
					break;
				case CODE:
					{
					setState(104);
					((RightContext)_localctx).CODE = match(CODE);
					v = new ValueToken((((RightContext)_localctx).CODE!=null?((RightContext)_localctx).CODE.getText():null), Type.CODE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				_localctx.array.add(v);
				}
				}
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 45056L) != 0 );
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
		enterRule(_localctx, 14, RULE_grammar_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__10);
			setState(114);
			match(TERM);
			setState(115);
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
		"\u0004\u0001\u0010v\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0004\u0000\u0013\b\u0000\u000b\u0000\f\u0000\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001\u001b\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"(\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003-\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u00036\b\u0003\n\u0003\f\u00039\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005N\b\u0005\n\u0005\f\u0005Q\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006a\b\u0006\n\u0006\f\u0006d\t\u0006\u0001\u0006\u0003\u0006g\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006k\b\u0006\u0001\u0006\u0004\u0006"+
		"n\b\u0006\u000b\u0006\f\u0006o\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0000\u0000\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000"+
		"\u0000x\u0000\u0010\u0001\u0000\u0000\u0000\u0002\u001a\u0001\u0000\u0000"+
		"\u0000\u0004\u001c\u0001\u0000\u0000\u0000\u0006\"\u0001\u0000\u0000\u0000"+
		"\b<\u0001\u0000\u0000\u0000\nC\u0001\u0000\u0000\u0000\fT\u0001\u0000"+
		"\u0000\u0000\u000eq\u0001\u0000\u0000\u0000\u0010\u0012\u0003\u000e\u0007"+
		"\u0000\u0011\u0013\u0003\u0002\u0001\u0000\u0012\u0011\u0001\u0000\u0000"+
		"\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014\u0012\u0001\u0000\u0000"+
		"\u0000\u0014\u0015\u0001\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000"+
		"\u0000\u0016\u0017\u0005\u0000\u0000\u0001\u0017\u0001\u0001\u0000\u0000"+
		"\u0000\u0018\u001b\u0003\u0004\u0002\u0000\u0019\u001b\u0003\u0006\u0003"+
		"\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u0019\u0001\u0000\u0000"+
		"\u0000\u001b\u0003\u0001\u0000\u0000\u0000\u001c\u001d\u0005\f\u0000\u0000"+
		"\u001d\u001e\u0005\u0001\u0000\u0000\u001e\u001f\u0005\u000e\u0000\u0000"+
		"\u001f \u0005\u0002\u0000\u0000 !\u0006\u0002\uffff\uffff\u0000!\u0005"+
		"\u0001\u0000\u0000\u0000\"#\u0005\r\u0000\u0000#\'\u0006\u0003\uffff\uffff"+
		"\u0000$%\u0003\n\u0005\u0000%&\u0006\u0003\uffff\uffff\u0000&(\u0001\u0000"+
		"\u0000\u0000\'$\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(,\u0001"+
		"\u0000\u0000\u0000)*\u0003\b\u0004\u0000*+\u0006\u0003\uffff\uffff\u0000"+
		"+-\u0001\u0000\u0000\u0000,)\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000"+
		"\u0000-.\u0001\u0000\u0000\u0000./\u0005\u0001\u0000\u0000/0\u0003\f\u0006"+
		"\u000007\u0006\u0003\uffff\uffff\u000012\u0005\u0003\u0000\u000023\u0003"+
		"\f\u0006\u000034\u0006\u0003\uffff\uffff\u000046\u0001\u0000\u0000\u0000"+
		"51\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000"+
		"\u000078\u0001\u0000\u0000\u00008:\u0001\u0000\u0000\u000097\u0001\u0000"+
		"\u0000\u0000:;\u0005\u0002\u0000\u0000;\u0007\u0001\u0000\u0000\u0000"+
		"<=\u0005\u0004\u0000\u0000=>\u0005\u0005\u0000\u0000>?\u0005\f\u0000\u0000"+
		"?@\u0005\r\u0000\u0000@A\u0005\u0006\u0000\u0000AB\u0006\u0004\uffff\uffff"+
		"\u0000B\t\u0001\u0000\u0000\u0000CD\u0006\u0005\uffff\uffff\u0000DE\u0005"+
		"\u0007\u0000\u0000EF\u0005\b\u0000\u0000FG\u0005\f\u0000\u0000GH\u0005"+
		"\r\u0000\u0000HO\u0006\u0005\uffff\uffff\u0000IJ\u0005\t\u0000\u0000J"+
		"K\u0005\f\u0000\u0000KL\u0005\r\u0000\u0000LN\u0006\u0005\uffff\uffff"+
		"\u0000MI\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000"+
		"\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000QO\u0001"+
		"\u0000\u0000\u0000RS\u0005\n\u0000\u0000S\u000b\u0001\u0000\u0000\u0000"+
		"Tm\u0006\u0006\uffff\uffff\u0000Uj\u0006\u0006\uffff\uffff\u0000VW\u0005"+
		"\f\u0000\u0000Wk\u0006\u0006\uffff\uffff\u0000XY\u0005\r\u0000\u0000Y"+
		"f\u0006\u0006\uffff\uffff\u0000Z[\u0005\b\u0000\u0000[\\\u0005\r\u0000"+
		"\u0000\\b\u0006\u0006\uffff\uffff\u0000]^\u0005\t\u0000\u0000^_\u0005"+
		"\r\u0000\u0000_a\u0006\u0006\uffff\uffff\u0000`]\u0001\u0000\u0000\u0000"+
		"ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000ce\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000eg\u0005\n\u0000"+
		"\u0000fZ\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gk\u0001\u0000"+
		"\u0000\u0000hi\u0005\u000f\u0000\u0000ik\u0006\u0006\uffff\uffff\u0000"+
		"jV\u0001\u0000\u0000\u0000jX\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000ln\u0006\u0006\uffff\uffff\u0000mU\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000p\r\u0001\u0000\u0000\u0000qr\u0005\u000b\u0000"+
		"\u0000rs\u0005\f\u0000\u0000st\u0005\u0002\u0000\u0000t\u000f\u0001\u0000"+
		"\u0000\u0000\n\u0014\u001a\',7Obfjo";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}