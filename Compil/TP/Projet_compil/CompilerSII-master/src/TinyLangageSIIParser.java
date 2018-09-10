// Generated from TinyLangageSII.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TinyLangageSIIParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, INT=9, 
		FLOAT=10, SCAN=11, PRINT=12, START=13, IF=14, THEN=15, ELSE=16, ENDIF=17, 
		ID=18, PLUS=19, MINUS=20, MUL=21, DIV=22, SUP=23, INF=24, INTEGERVAL=25, 
		FLOATVAL=26, WHITESPACE=27, STR=28;
	public static final int
		RULE_prog = 0, RULE_declarations = 1, RULE_dec = 2, RULE_type = 3, RULE_vars = 4, 
		RULE_identifier = 5, RULE_val = 6, RULE_insts = 7, RULE_inst = 8, RULE_affect = 9, 
		RULE_exp = 10, RULE_t = 11, RULE_opmi = 12, RULE_opma = 13, RULE_endEx = 14, 
		RULE_ifinst = 15, RULE_el = 16, RULE_comp = 17, RULE_op = 18, RULE_read = 19, 
		RULE_write = 20, RULE_listID = 21;
	public static final String[] ruleNames = {
		"prog", "declarations", "dec", "type", "vars", "identifier", "val", "insts", 
		"inst", "affect", "exp", "t", "opmi", "opma", "endEx", "ifinst", "el", 
		"comp", "op", "read", "write", "listID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'compil'", "'('", "')'", "'{'", "'}'", "';'", "','", "'='", "'intCompil'", 
		"'floatCompil'", "'scancompil'", "'printcompil'", "'start'", "'if'", "'then'", 
		"'else'", "'endif'", null, "'+'", "'-'", "'*'", "'/'", "'>'", "'<'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "INT", "FLOAT", 
		"SCAN", "PRINT", "START", "IF", "THEN", "ELSE", "ENDIF", "ID", "PLUS", 
		"MINUS", "MUL", "DIV", "SUP", "INF", "INTEGERVAL", "FLOATVAL", "WHITESPACE", 
		"STR"
	};
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
	public String getGrammarFileName() { return "TinyLangageSII.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TinyLangageSIIParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TinyLangageSIIParser.ID, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public TerminalNode START() { return getToken(TinyLangageSIIParser.START, 0); }
		public InstsContext insts() {
			return getRuleContext(InstsContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__0);
			setState(45);
			match(ID);
			setState(46);
			match(T__1);
			setState(47);
			match(T__2);
			setState(48);
			match(T__3);
			setState(49);
			declarations();
			setState(50);
			match(START);
			setState(51);
			insts();
			setState(52);
			match(T__4);
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

	public static class DeclarationsContext extends ParserRuleContext {
		public DecContext dec() {
			return getRuleContext(DecContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitDeclarations(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		try {
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(54);
				dec();
				setState(55);
				declarations();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				dec();
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

	public static class DecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitDec(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			type();
			setState(61);
			vars();
			setState(62);
			match(T__5);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TinyLangageSIIParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(TinyLangageSIIParser.FLOAT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class VarsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TinyLangageSIIParser.ID, 0); }
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public VarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitVars(this);
		}
	}

	public final VarsContext vars() throws RecognitionException {
		VarsContext _localctx = new VarsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_vars);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				{
				setState(66);
				match(ID);
				setState(67);
				match(T__6);
				setState(68);
				vars();
				}
				}
				break;
			case 2:
				{
				setState(69);
				match(ID);
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TinyLangageSIIParser.ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(ID);
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

	public static class ValContext extends ParserRuleContext {
		public TerminalNode INTEGERVAL() { return getToken(TinyLangageSIIParser.INTEGERVAL, 0); }
		public TerminalNode FLOATVAL() { return getToken(TinyLangageSIIParser.FLOATVAL, 0); }
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitVal(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_la = _input.LA(1);
			if ( !(_la==INTEGERVAL || _la==FLOATVAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class InstsContext extends ParserRuleContext {
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public InstsContext insts() {
			return getRuleContext(InstsContext.class,0);
		}
		public InstsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterInsts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitInsts(this);
		}
	}

	public final InstsContext insts() throws RecognitionException {
		InstsContext _localctx = new InstsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_insts);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(76);
				inst();
				setState(77);
				match(T__5);
				setState(78);
				insts();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				inst();
				setState(81);
				match(T__5);
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

	public static class InstContext extends ParserRuleContext {
		public AffectContext affect() {
			return getRuleContext(AffectContext.class,0);
		}
		public IfinstContext ifinst() {
			return getRuleContext(IfinstContext.class,0);
		}
		public ReadContext read() {
			return getRuleContext(ReadContext.class,0);
		}
		public WriteContext write() {
			return getRuleContext(WriteContext.class,0);
		}
		public InstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitInst(this);
		}
	}

	public final InstContext inst() throws RecognitionException {
		InstContext _localctx = new InstContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_inst);
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				affect();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				ifinst();
				}
				break;
			case SCAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				read();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 4);
				{
				setState(88);
				write();
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

	public static class AffectContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AffectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterAffect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitAffect(this);
		}
	}

	public final AffectContext affect() throws RecognitionException {
		AffectContext _localctx = new AffectContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_affect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			identifier();
			setState(92);
			match(T__7);
			setState(93);
			exp(0);
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

	public static class ExpContext extends ParserRuleContext {
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public OpmiContext opmi() {
			return getRuleContext(OpmiContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(96);
			t(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(98);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(99);
					opmi();
					setState(100);
					t(0);
					}
					} 
				}
				setState(106);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TContext extends ParserRuleContext {
		public EndExContext endEx() {
			return getRuleContext(EndExContext.class,0);
		}
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public OpmaContext opma() {
			return getRuleContext(OpmaContext.class,0);
		}
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitT(this);
		}
	}

	public final TContext t() throws RecognitionException {
		return t(0);
	}

	private TContext t(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TContext _localctx = new TContext(_ctx, _parentState);
		TContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_t, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(108);
			endEx();
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_t);
					setState(110);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(111);
					opma();
					setState(112);
					endEx();
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class OpmiContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(TinyLangageSIIParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TinyLangageSIIParser.MINUS, 0); }
		public OpmiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opmi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterOpmi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitOpmi(this);
		}
	}

	public final OpmiContext opmi() throws RecognitionException {
		OpmiContext _localctx = new OpmiContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_opmi);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class OpmaContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(TinyLangageSIIParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(TinyLangageSIIParser.DIV, 0); }
		public OpmaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opma; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterOpma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitOpma(this);
		}
	}

	public final OpmaContext opma() throws RecognitionException {
		OpmaContext _localctx = new OpmaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_opma);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if ( !(_la==MUL || _la==DIV) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class EndExContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public EndExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endEx; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterEndEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitEndEx(this);
		}
	}

	public final EndExContext endEx() throws RecognitionException {
		EndExContext _localctx = new EndExContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_endEx);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				identifier();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(T__1);
				setState(125);
				exp(0);
				setState(126);
				match(T__2);
				}
				break;
			case INTEGERVAL:
			case FLOATVAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				val();
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

	public static class IfinstContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(TinyLangageSIIParser.IF, 0); }
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public TerminalNode THEN() { return getToken(TinyLangageSIIParser.THEN, 0); }
		public List<InstsContext> insts() {
			return getRuleContexts(InstsContext.class);
		}
		public InstsContext insts(int i) {
			return getRuleContext(InstsContext.class,i);
		}
		public TerminalNode ENDIF() { return getToken(TinyLangageSIIParser.ENDIF, 0); }
		public ElContext el() {
			return getRuleContext(ElContext.class,0);
		}
		public IfinstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifinst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterIfinst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitIfinst(this);
		}
	}

	public final IfinstContext ifinst() throws RecognitionException {
		IfinstContext _localctx = new IfinstContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifinst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(IF);
			setState(132);
			match(T__1);
			setState(133);
			comp();
			setState(134);
			match(T__2);
			setState(135);
			match(THEN);
			setState(136);
			insts();
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENDIF:
				{
				}
				break;
			case ELSE:
				{
				setState(138);
				el();
				setState(139);
				insts();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(143);
			match(ENDIF);
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

	public static class ElContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(TinyLangageSIIParser.ELSE, 0); }
		public ElContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_el; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterEl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitEl(this);
		}
	}

	public final ElContext el() throws RecognitionException {
		ElContext _localctx = new ElContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_el);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(ELSE);
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

	public static class CompContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitComp(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			exp(0);
			setState(148);
			op();
			setState(149);
			exp(0);
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

	public static class OpContext extends ParserRuleContext {
		public TerminalNode SUP() { return getToken(TinyLangageSIIParser.SUP, 0); }
		public TerminalNode INF() { return getToken(TinyLangageSIIParser.INF, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitOp(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_la = _input.LA(1);
			if ( !(_la==SUP || _la==INF) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ReadContext extends ParserRuleContext {
		public TerminalNode SCAN() { return getToken(TinyLangageSIIParser.SCAN, 0); }
		public ListIDContext listID() {
			return getRuleContext(ListIDContext.class,0);
		}
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitRead(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(SCAN);
			setState(154);
			match(T__1);
			setState(155);
			listID();
			setState(156);
			match(T__2);
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

	public static class WriteContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(TinyLangageSIIParser.PRINT, 0); }
		public TerminalNode STR() { return getToken(TinyLangageSIIParser.STR, 0); }
		public ListIDContext listID() {
			return getRuleContext(ListIDContext.class,0);
		}
		public WriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitWrite(this);
		}
	}

	public final WriteContext write() throws RecognitionException {
		WriteContext _localctx = new WriteContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_write);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(PRINT);
			setState(159);
			match(T__1);
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STR:
				{
				setState(160);
				match(STR);
				}
				break;
			case ID:
				{
				setState(161);
				listID();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(164);
			match(T__2);
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

	public static class ListIDContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ListIDContext listID() {
			return getRuleContext(ListIDContext.class,0);
		}
		public ListIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterListID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitListID(this);
		}
	}

	public final ListIDContext listID() throws RecognitionException {
		ListIDContext _localctx = new ListIDContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_listID);
		try {
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				identifier();
				setState(167);
				match(T__6);
				setState(168);
				listID();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				identifier();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 11:
			return t_sempred((TContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean t_sempred(TContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00b0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3=\n\3\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\5\6I\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\tV\n\t\3\n\3\n\3\n\3\n\5\n\\\n\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\7\fi\n\f\f\f\16\fl\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r"+
		"u\n\r\f\r\16\rx\13\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u0084\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u0090\n\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u00a5\n\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\5\27\u00ae\n\27\3\27\2\4\26\30\30\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,\2\7\3\2\13\f\3\2\33\34\3\2\25\26\3\2\27\30"+
		"\3\2\31\32\2\u00a6\2.\3\2\2\2\4<\3\2\2\2\6>\3\2\2\2\bB\3\2\2\2\nH\3\2"+
		"\2\2\fJ\3\2\2\2\16L\3\2\2\2\20U\3\2\2\2\22[\3\2\2\2\24]\3\2\2\2\26a\3"+
		"\2\2\2\30m\3\2\2\2\32y\3\2\2\2\34{\3\2\2\2\36\u0083\3\2\2\2 \u0085\3\2"+
		"\2\2\"\u0093\3\2\2\2$\u0095\3\2\2\2&\u0099\3\2\2\2(\u009b\3\2\2\2*\u00a0"+
		"\3\2\2\2,\u00ad\3\2\2\2./\7\3\2\2/\60\7\24\2\2\60\61\7\4\2\2\61\62\7\5"+
		"\2\2\62\63\7\6\2\2\63\64\5\4\3\2\64\65\7\17\2\2\65\66\5\20\t\2\66\67\7"+
		"\7\2\2\67\3\3\2\2\289\5\6\4\29:\5\4\3\2:=\3\2\2\2;=\5\6\4\2<8\3\2\2\2"+
		"<;\3\2\2\2=\5\3\2\2\2>?\5\b\5\2?@\5\n\6\2@A\7\b\2\2A\7\3\2\2\2BC\t\2\2"+
		"\2C\t\3\2\2\2DE\7\24\2\2EF\7\t\2\2FI\5\n\6\2GI\7\24\2\2HD\3\2\2\2HG\3"+
		"\2\2\2I\13\3\2\2\2JK\7\24\2\2K\r\3\2\2\2LM\t\3\2\2M\17\3\2\2\2NO\5\22"+
		"\n\2OP\7\b\2\2PQ\5\20\t\2QV\3\2\2\2RS\5\22\n\2ST\7\b\2\2TV\3\2\2\2UN\3"+
		"\2\2\2UR\3\2\2\2V\21\3\2\2\2W\\\5\24\13\2X\\\5 \21\2Y\\\5(\25\2Z\\\5*"+
		"\26\2[W\3\2\2\2[X\3\2\2\2[Y\3\2\2\2[Z\3\2\2\2\\\23\3\2\2\2]^\5\f\7\2^"+
		"_\7\n\2\2_`\5\26\f\2`\25\3\2\2\2ab\b\f\1\2bc\5\30\r\2cj\3\2\2\2de\f\4"+
		"\2\2ef\5\32\16\2fg\5\30\r\2gi\3\2\2\2hd\3\2\2\2il\3\2\2\2jh\3\2\2\2jk"+
		"\3\2\2\2k\27\3\2\2\2lj\3\2\2\2mn\b\r\1\2no\5\36\20\2ov\3\2\2\2pq\f\4\2"+
		"\2qr\5\34\17\2rs\5\36\20\2su\3\2\2\2tp\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3"+
		"\2\2\2w\31\3\2\2\2xv\3\2\2\2yz\t\4\2\2z\33\3\2\2\2{|\t\5\2\2|\35\3\2\2"+
		"\2}\u0084\5\f\7\2~\177\7\4\2\2\177\u0080\5\26\f\2\u0080\u0081\7\5\2\2"+
		"\u0081\u0084\3\2\2\2\u0082\u0084\5\16\b\2\u0083}\3\2\2\2\u0083~\3\2\2"+
		"\2\u0083\u0082\3\2\2\2\u0084\37\3\2\2\2\u0085\u0086\7\20\2\2\u0086\u0087"+
		"\7\4\2\2\u0087\u0088\5$\23\2\u0088\u0089\7\5\2\2\u0089\u008a\7\21\2\2"+
		"\u008a\u008f\5\20\t\2\u008b\u0090\3\2\2\2\u008c\u008d\5\"\22\2\u008d\u008e"+
		"\5\20\t\2\u008e\u0090\3\2\2\2\u008f\u008b\3\2\2\2\u008f\u008c\3\2\2\2"+
		"\u0090\u0091\3\2\2\2\u0091\u0092\7\23\2\2\u0092!\3\2\2\2\u0093\u0094\7"+
		"\22\2\2\u0094#\3\2\2\2\u0095\u0096\5\26\f\2\u0096\u0097\5&\24\2\u0097"+
		"\u0098\5\26\f\2\u0098%\3\2\2\2\u0099\u009a\t\6\2\2\u009a\'\3\2\2\2\u009b"+
		"\u009c\7\r\2\2\u009c\u009d\7\4\2\2\u009d\u009e\5,\27\2\u009e\u009f\7\5"+
		"\2\2\u009f)\3\2\2\2\u00a0\u00a1\7\16\2\2\u00a1\u00a4\7\4\2\2\u00a2\u00a5"+
		"\7\36\2\2\u00a3\u00a5\5,\27\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2"+
		"\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7\5\2\2\u00a7+\3\2\2\2\u00a8\u00a9\5"+
		"\f\7\2\u00a9\u00aa\7\t\2\2\u00aa\u00ab\5,\27\2\u00ab\u00ae\3\2\2\2\u00ac"+
		"\u00ae\5\f\7\2\u00ad\u00a8\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae-\3\2\2\2"+
		"\f<HU[jv\u0083\u008f\u00a4\u00ad";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}