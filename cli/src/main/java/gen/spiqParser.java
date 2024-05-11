// Generated from spiq.g4 by ANTLR 4.13.1

    package gen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class spiqParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IS=1, SIGN=2, PLUS=3, MINUS=4, SLASH=5, DOT=6, EXP=7, A=8, AN=9, INTEGER=10, 
		NUMBER=11, FRACTION=12, RATIONAL=13, REAL=14, DIGIT=15, ID=16, WHITESP=17, 
		ERR=18;
	public static final int
		RULE_prog = 0, RULE_progbody = 1, RULE_decl = 2, RULE_numberDeclaration = 3, 
		RULE_withoutValueDeclaration = 4, RULE_withValueDeclaration = 5, RULE_integer = 6, 
		RULE_fraction = 7, RULE_real = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "progbody", "decl", "numberDeclaration", "withoutValueDeclaration", 
			"withValueDeclaration", "integer", "fraction", "real"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'is'", null, "'+'", "'-'", "'/'", "'.'", "'e'", "'a'", "'an'", 
			"'integer'", "'number'", "'fraction'", "'rational'", "'real'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IS", "SIGN", "PLUS", "MINUS", "SLASH", "DOT", "EXP", "A", "AN", 
			"INTEGER", "NUMBER", "FRACTION", "RATIONAL", "REAL", "DIGIT", "ID", "WHITESP", 
			"ERR"
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
	public String getGrammarFileName() { return "spiq.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public spiqParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public ProgbodyContext progbody() {
			return getRuleContext(ProgbodyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(spiqParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof spiqVisitor ) return ((spiqVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			progbody();
			setState(19);
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
	public static class ProgbodyContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(spiqParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(spiqParser.DOT, i);
		}
		public ProgbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).enterProgbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).exitProgbody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof spiqVisitor ) return ((spiqVisitor<? extends T>)visitor).visitProgbody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgbodyContext progbody() throws RecognitionException {
		ProgbodyContext _localctx = new ProgbodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_progbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(21);
				decl();
				setState(22);
				match(DOT);
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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
	public static class DeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(spiqParser.ID, 0); }
		public TerminalNode IS() { return getToken(spiqParser.IS, 0); }
		public NumberDeclarationContext numberDeclaration() {
			return getRuleContext(NumberDeclarationContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof spiqVisitor ) return ((spiqVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(ID);
			setState(29);
			match(IS);
			setState(30);
			numberDeclaration();
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
	public static class NumberDeclarationContext extends ParserRuleContext {
		public WithoutValueDeclarationContext withoutValueDeclaration() {
			return getRuleContext(WithoutValueDeclarationContext.class,0);
		}
		public WithValueDeclarationContext withValueDeclaration() {
			return getRuleContext(WithValueDeclarationContext.class,0);
		}
		public NumberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).enterNumberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).exitNumberDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof spiqVisitor ) return ((spiqVisitor<? extends T>)visitor).visitNumberDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberDeclarationContext numberDeclaration() throws RecognitionException {
		NumberDeclarationContext _localctx = new NumberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_numberDeclaration);
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case A:
			case AN:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				withoutValueDeclaration();
				}
				break;
			case SIGN:
			case DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				withValueDeclaration();
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
	public static class WithoutValueDeclarationContext extends ParserRuleContext {
		public TerminalNode A() { return getToken(spiqParser.A, 0); }
		public TerminalNode NUMBER() { return getToken(spiqParser.NUMBER, 0); }
		public TerminalNode FRACTION() { return getToken(spiqParser.FRACTION, 0); }
		public TerminalNode RATIONAL() { return getToken(spiqParser.RATIONAL, 0); }
		public TerminalNode REAL() { return getToken(spiqParser.REAL, 0); }
		public TerminalNode AN() { return getToken(spiqParser.AN, 0); }
		public TerminalNode INTEGER() { return getToken(spiqParser.INTEGER, 0); }
		public WithoutValueDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withoutValueDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).enterWithoutValueDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).exitWithoutValueDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof spiqVisitor ) return ((spiqVisitor<? extends T>)visitor).visitWithoutValueDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithoutValueDeclarationContext withoutValueDeclaration() throws RecognitionException {
		WithoutValueDeclarationContext _localctx = new WithoutValueDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_withoutValueDeclaration);
		int _la;
		try {
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case A:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(A);
				setState(37);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30720L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case AN:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(AN);
				setState(39);
				match(INTEGER);
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
	public static class WithValueDeclarationContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public FractionContext fraction() {
			return getRuleContext(FractionContext.class,0);
		}
		public RealContext real() {
			return getRuleContext(RealContext.class,0);
		}
		public TerminalNode SIGN() { return getToken(spiqParser.SIGN, 0); }
		public WithValueDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withValueDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).enterWithValueDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).exitWithValueDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof spiqVisitor ) return ((spiqVisitor<? extends T>)visitor).visitWithValueDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithValueDeclarationContext withValueDeclaration() throws RecognitionException {
		WithValueDeclarationContext _localctx = new WithValueDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_withValueDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIGN) {
				{
				setState(42);
				match(SIGN);
				}
			}

			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(45);
				integer();
				}
				break;
			case 2:
				{
				setState(46);
				fraction();
				}
				break;
			case 3:
				{
				setState(47);
				real();
				}
				break;
			}
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
	public static class IntegerContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(spiqParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(spiqParser.DIGIT, i);
		}
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof spiqVisitor ) return ((spiqVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50);
				match(DIGIT);
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
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
	public static class FractionContext extends ParserRuleContext {
		public IntegerContext num;
		public IntegerContext den;
		public TerminalNode SLASH() { return getToken(spiqParser.SLASH, 0); }
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public FractionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fraction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).enterFraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).exitFraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof spiqVisitor ) return ((spiqVisitor<? extends T>)visitor).visitFraction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FractionContext fraction() throws RecognitionException {
		FractionContext _localctx = new FractionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fraction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			((FractionContext)_localctx).num = integer();
			setState(56);
			match(SLASH);
			setState(57);
			((FractionContext)_localctx).den = integer();
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
	public static class RealContext extends ParserRuleContext {
		public RealContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real; }
	 
		public RealContext() { }
		public void copyFrom(RealContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalFormContext extends RealContext {
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public TerminalNode DOT() { return getToken(spiqParser.DOT, 0); }
		public NormalFormContext(RealContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).enterNormalForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).exitNormalForm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof spiqVisitor ) return ((spiqVisitor<? extends T>)visitor).visitNormalForm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExponentialFormContext extends RealContext {
		public List<TerminalNode> DIGIT() { return getTokens(spiqParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(spiqParser.DIGIT, i);
		}
		public TerminalNode EXP() { return getToken(spiqParser.EXP, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode DOT() { return getToken(spiqParser.DOT, 0); }
		public TerminalNode SIGN() { return getToken(spiqParser.SIGN, 0); }
		public ExponentialFormContext(RealContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).enterExponentialForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof spiqListener ) ((spiqListener)listener).exitExponentialForm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof spiqVisitor ) return ((spiqVisitor<? extends T>)visitor).visitExponentialForm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealContext real() throws RecognitionException {
		RealContext _localctx = new RealContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_real);
		int _la;
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new NormalFormContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				integer();
				setState(60);
				match(DOT);
				setState(61);
				integer();
				}
				break;
			case 2:
				_localctx = new ExponentialFormContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(DIGIT);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(64);
					match(DOT);
					setState(66); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(65);
						match(DIGIT);
						}
						}
						setState(68); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DIGIT );
					}
				}

				setState(72);
				match(EXP);
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SIGN) {
					{
					setState(73);
					match(SIGN);
					}
				}

				setState(76);
				integer();
				}
				break;
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
		"\u0004\u0001\u0012P\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0004\u0001\u0019\b\u0001\u000b\u0001\f\u0001\u001a\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0003"+
		"\u0003#\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004)\b\u0004\u0001\u0005\u0003\u0005,\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u00051\b\u0005\u0001\u0006\u0004\u00064\b\u0006\u000b"+
		"\u0006\f\u00065\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004\bC\b\b\u000b"+
		"\b\f\bD\u0003\bG\b\b\u0001\b\u0001\b\u0003\bK\b\b\u0001\b\u0003\bN\b\b"+
		"\u0001\b\u0000\u0000\t\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0000"+
		"\u0001\u0001\u0000\u000b\u000eQ\u0000\u0012\u0001\u0000\u0000\u0000\u0002"+
		"\u0018\u0001\u0000\u0000\u0000\u0004\u001c\u0001\u0000\u0000\u0000\u0006"+
		"\"\u0001\u0000\u0000\u0000\b(\u0001\u0000\u0000\u0000\n+\u0001\u0000\u0000"+
		"\u0000\f3\u0001\u0000\u0000\u0000\u000e7\u0001\u0000\u0000\u0000\u0010"+
		"M\u0001\u0000\u0000\u0000\u0012\u0013\u0003\u0002\u0001\u0000\u0013\u0014"+
		"\u0005\u0000\u0000\u0001\u0014\u0001\u0001\u0000\u0000\u0000\u0015\u0016"+
		"\u0003\u0004\u0002\u0000\u0016\u0017\u0005\u0006\u0000\u0000\u0017\u0019"+
		"\u0001\u0000\u0000\u0000\u0018\u0015\u0001\u0000\u0000\u0000\u0019\u001a"+
		"\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0001\u0000\u0000\u0000\u001b\u0003\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0005\u0010\u0000\u0000\u001d\u001e\u0005\u0001\u0000\u0000\u001e\u001f"+
		"\u0003\u0006\u0003\u0000\u001f\u0005\u0001\u0000\u0000\u0000 #\u0003\b"+
		"\u0004\u0000!#\u0003\n\u0005\u0000\" \u0001\u0000\u0000\u0000\"!\u0001"+
		"\u0000\u0000\u0000#\u0007\u0001\u0000\u0000\u0000$%\u0005\b\u0000\u0000"+
		"%)\u0007\u0000\u0000\u0000&\'\u0005\t\u0000\u0000\')\u0005\n\u0000\u0000"+
		"($\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000)\t\u0001\u0000\u0000"+
		"\u0000*,\u0005\u0002\u0000\u0000+*\u0001\u0000\u0000\u0000+,\u0001\u0000"+
		"\u0000\u0000,0\u0001\u0000\u0000\u0000-1\u0003\f\u0006\u0000.1\u0003\u000e"+
		"\u0007\u0000/1\u0003\u0010\b\u00000-\u0001\u0000\u0000\u00000.\u0001\u0000"+
		"\u0000\u00000/\u0001\u0000\u0000\u00001\u000b\u0001\u0000\u0000\u0000"+
		"24\u0005\u000f\u0000\u000032\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u00006\r\u0001\u0000"+
		"\u0000\u000078\u0003\f\u0006\u000089\u0005\u0005\u0000\u00009:\u0003\f"+
		"\u0006\u0000:\u000f\u0001\u0000\u0000\u0000;<\u0003\f\u0006\u0000<=\u0005"+
		"\u0006\u0000\u0000=>\u0003\f\u0006\u0000>N\u0001\u0000\u0000\u0000?F\u0005"+
		"\u000f\u0000\u0000@B\u0005\u0006\u0000\u0000AC\u0005\u000f\u0000\u0000"+
		"BA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000"+
		"\u0000DE\u0001\u0000\u0000\u0000EG\u0001\u0000\u0000\u0000F@\u0001\u0000"+
		"\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0005"+
		"\u0007\u0000\u0000IK\u0005\u0002\u0000\u0000JI\u0001\u0000\u0000\u0000"+
		"JK\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LN\u0003\f\u0006\u0000"+
		"M;\u0001\u0000\u0000\u0000M?\u0001\u0000\u0000\u0000N\u0011\u0001\u0000"+
		"\u0000\u0000\n\u001a\"(+05DFJM";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}