// Generated from /home/mohammedi/OpenSourceProjects/master1-sii-assignements/Compil/projet/implementation/src/TP2.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TP2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, PROGNAME=30, ID=31, 
		FLOAT=32, INT=33, COMMENT=34, TEXT=35, WS=36;
	public static final int
		RULE_start_rule = 0, RULE_declarations = 1, RULE_variables = 2, RULE_type = 3, 
		RULE_instructions = 4, RULE_instAff = 5, RULE_instIf = 6, RULE_instScan = 7, 
		RULE_instPrint = 8, RULE_instFor = 9, RULE_instWhile = 10, RULE_instCase = 11, 
		RULE_cases = 12, RULE_condition = 13, RULE_expression = 14, RULE_value = 15;
	public static final String[] ruleNames = {
		"start_rule", "declarations", "variables", "type", "instructions", "instAff", 
		"instIf", "instScan", "instPrint", "instFor", "instWhile", "instCase", 
		"cases", "condition", "expression", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'compil'", "'('", "')'", "'{'", "'start'", "'}'", "';'", "','", 
		"'intcompil'", "'floatcompil'", "'='", "'if'", "'then'", "'else'", "'endif'", 
		"'scancompil'", "'printcompil'", "'for'", "'while'", "'match'", "'case'", 
		"'=>'", "'break'", "'>'", "'<'", "'*'", "'/'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "PROGNAME", "ID", "FLOAT", "INT", 
		"COMMENT", "TEXT", "WS"
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
	public String getGrammarFileName() { return "TP2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TP2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Start_ruleContext extends ParserRuleContext {
		public TerminalNode PROGNAME() { return getToken(TP2Parser.PROGNAME, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public Start_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterStart_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitStart_rule(this);
		}
	}

	public final Start_ruleContext start_rule() throws RecognitionException {
		Start_ruleContext _localctx = new Start_ruleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);
			setState(33);
			match(PROGNAME);
			setState(34);
			match(T__1);
			setState(35);
			match(T__2);
			setState(36);
			match(T__3);
			setState(37);
			declarations();
			setState(38);
			match(T__4);
			setState(39);
			instructions();
			setState(40);
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

	public static class DeclarationsContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
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
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitDeclarations(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			type();
			setState(43);
			variables();
			setState(44);
			match(T__6);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8 || _la==T__9) {
				{
				setState(45);
				declarations();
				}
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

	public static class VariablesContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TP2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TP2Parser.ID, i);
		}
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitVariables(this);
		}
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(ID);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(49);
				match(T__7);
				setState(50);
				match(ID);
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__9) ) {
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

	public static class InstructionsContext extends ParserRuleContext {
		public InstAffContext instAff() {
			return getRuleContext(InstAffContext.class,0);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public InstIfContext instIf() {
			return getRuleContext(InstIfContext.class,0);
		}
		public InstScanContext instScan() {
			return getRuleContext(InstScanContext.class,0);
		}
		public InstPrintContext instPrint() {
			return getRuleContext(InstPrintContext.class,0);
		}
		public InstForContext instFor() {
			return getRuleContext(InstForContext.class,0);
		}
		public InstWhileContext instWhile() {
			return getRuleContext(InstWhileContext.class,0);
		}
		public InstCaseContext instCase() {
			return getRuleContext(InstCaseContext.class,0);
		}
		public InstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterInstructions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitInstructions(this);
		}
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instructions);
		int _la;
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				instAff();
				setState(59);
				match(T__6);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << ID))) != 0)) {
					{
					setState(60);
					instructions();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				instIf();
				setState(64);
				match(T__6);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << ID))) != 0)) {
					{
					setState(65);
					instructions();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				instScan();
				setState(69);
				match(T__6);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << ID))) != 0)) {
					{
					setState(70);
					instructions();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				instPrint();
				setState(74);
				match(T__6);
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << ID))) != 0)) {
					{
					setState(75);
					instructions();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				instFor();
				setState(79);
				match(T__6);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << ID))) != 0)) {
					{
					setState(80);
					instructions();
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				instWhile();
				setState(84);
				match(T__6);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << ID))) != 0)) {
					{
					setState(85);
					instructions();
					}
				}

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(88);
				instCase();
				setState(89);
				match(T__6);
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << ID))) != 0)) {
					{
					setState(90);
					instructions();
					}
				}

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

	public static class InstAffContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TP2Parser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InstAffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instAff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterInstAff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitInstAff(this);
		}
	}

	public final InstAffContext instAff() throws RecognitionException {
		InstAffContext _localctx = new InstAffContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instAff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(ID);
			setState(96);
			match(T__10);
			setState(97);
			expression(0);
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

	public static class InstIfContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<InstructionsContext> instructions() {
			return getRuleContexts(InstructionsContext.class);
		}
		public InstructionsContext instructions(int i) {
			return getRuleContext(InstructionsContext.class,i);
		}
		public InstIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterInstIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitInstIf(this);
		}
	}

	public final InstIfContext instIf() throws RecognitionException {
		InstIfContext _localctx = new InstIfContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_instIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__11);
			setState(100);
			match(T__1);
			setState(101);
			condition();
			setState(102);
			match(T__2);
			setState(103);
			match(T__12);
			setState(104);
			instructions();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(105);
				match(T__13);
				setState(106);
				instructions();
				setState(107);
				match(T__14);
				setState(108);
				match(T__6);
				}
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

	public static class InstScanContext extends ParserRuleContext {
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public InstScanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instScan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterInstScan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitInstScan(this);
		}
	}

	public final InstScanContext instScan() throws RecognitionException {
		InstScanContext _localctx = new InstScanContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_instScan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__15);
			setState(113);
			match(T__1);
			setState(114);
			variables();
			setState(115);
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

	public static class InstPrintContext extends ParserRuleContext {
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public TerminalNode TEXT() { return getToken(TP2Parser.TEXT, 0); }
		public InstPrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instPrint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterInstPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitInstPrint(this);
		}
	}

	public final InstPrintContext instPrint() throws RecognitionException {
		InstPrintContext _localctx = new InstPrintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__16);
			setState(118);
			match(T__1);
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(119);
				variables();
				}
				break;
			case TEXT:
				{
				setState(120);
				match(TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(123);
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

	public static class InstForContext extends ParserRuleContext {
		public List<InstAffContext> instAff() {
			return getRuleContexts(InstAffContext.class);
		}
		public InstAffContext instAff(int i) {
			return getRuleContext(InstAffContext.class,i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public InstForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instFor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterInstFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitInstFor(this);
		}
	}

	public final InstForContext instFor() throws RecognitionException {
		InstForContext _localctx = new InstForContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_instFor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__17);
			setState(126);
			match(T__1);
			setState(127);
			instAff();
			setState(128);
			match(T__6);
			setState(129);
			condition();
			setState(130);
			match(T__6);
			setState(131);
			instAff();
			setState(132);
			match(T__2);
			setState(133);
			match(T__3);
			setState(134);
			instructions();
			setState(135);
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

	public static class InstWhileContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public InstWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterInstWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitInstWhile(this);
		}
	}

	public final InstWhileContext instWhile() throws RecognitionException {
		InstWhileContext _localctx = new InstWhileContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_instWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(T__18);
			setState(138);
			match(T__1);
			setState(139);
			condition();
			setState(140);
			match(T__2);
			setState(141);
			match(T__3);
			setState(142);
			instructions();
			setState(143);
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

	public static class InstCaseContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TP2Parser.ID, 0); }
		public CasesContext cases() {
			return getRuleContext(CasesContext.class,0);
		}
		public InstCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterInstCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitInstCase(this);
		}
	}

	public final InstCaseContext instCase() throws RecognitionException {
		InstCaseContext _localctx = new InstCaseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_instCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(ID);
			setState(146);
			match(T__19);
			setState(147);
			match(T__3);
			setState(148);
			cases();
			setState(149);
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

	public static class CasesContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public CasesContext cases() {
			return getRuleContext(CasesContext.class,0);
		}
		public CasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterCases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitCases(this);
		}
	}

	public final CasesContext cases() throws RecognitionException {
		CasesContext _localctx = new CasesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__20);
			setState(152);
			value();
			setState(153);
			match(T__21);
			setState(154);
			instructions();
			setState(155);
			match(T__22);
			setState(156);
			match(T__6);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(157);
				cases();
				}
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

	public static class ConditionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			expression(0);
			setState(161);
			_la = _input.LA(1);
			if ( !(_la==T__23 || _la==T__24) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(162);
			expression(0);
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(165);
				match(T__1);
				setState(166);
				expression(0);
				setState(167);
				match(T__2);
				}
				break;
			case ID:
			case FLOAT:
			case INT:
				{
				setState(169);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(178);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(172);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(173);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__26) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(174);
						expression(5);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(175);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(176);
						_la = _input.LA(1);
						if ( !(_la==T__27 || _la==T__28) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(177);
						expression(4);
						}
						break;
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TP2Parser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(TP2Parser.FLOAT, 0); }
		public TerminalNode ID() { return getToken(TP2Parser.ID, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TP2Listener ) ((TP2Listener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << FLOAT) | (1L << INT))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u00bc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3\61\n\3\3\4\3\4\3\4"+
		"\7\4\66\n\4\f\4\16\49\13\4\3\5\3\5\3\6\3\6\3\6\5\6@\n\6\3\6\3\6\3\6\5"+
		"\6E\n\6\3\6\3\6\3\6\5\6J\n\6\3\6\3\6\3\6\5\6O\n\6\3\6\3\6\3\6\5\6T\n\6"+
		"\3\6\3\6\3\6\5\6Y\n\6\3\6\3\6\3\6\5\6^\n\6\5\6`\n\6\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bq\n\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\5\n|\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00a1\n\16\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00ad\n\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\7\20\u00b5\n\20\f\20\16\20\u00b8\13\20\3\21\3\21"+
		"\3\21\2\3\36\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\7\3\2\13\f\3"+
		"\2\32\33\3\2\34\35\3\2\36\37\3\2!#\2\u00c0\2\"\3\2\2\2\4,\3\2\2\2\6\62"+
		"\3\2\2\2\b:\3\2\2\2\n_\3\2\2\2\fa\3\2\2\2\16e\3\2\2\2\20r\3\2\2\2\22w"+
		"\3\2\2\2\24\177\3\2\2\2\26\u008b\3\2\2\2\30\u0093\3\2\2\2\32\u0099\3\2"+
		"\2\2\34\u00a2\3\2\2\2\36\u00ac\3\2\2\2 \u00b9\3\2\2\2\"#\7\3\2\2#$\7 "+
		"\2\2$%\7\4\2\2%&\7\5\2\2&\'\7\6\2\2\'(\5\4\3\2()\7\7\2\2)*\5\n\6\2*+\7"+
		"\b\2\2+\3\3\2\2\2,-\5\b\5\2-.\5\6\4\2.\60\7\t\2\2/\61\5\4\3\2\60/\3\2"+
		"\2\2\60\61\3\2\2\2\61\5\3\2\2\2\62\67\7!\2\2\63\64\7\n\2\2\64\66\7!\2"+
		"\2\65\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\7\3\2\2\29\67"+
		"\3\2\2\2:;\t\2\2\2;\t\3\2\2\2<=\5\f\7\2=?\7\t\2\2>@\5\n\6\2?>\3\2\2\2"+
		"?@\3\2\2\2@`\3\2\2\2AB\5\16\b\2BD\7\t\2\2CE\5\n\6\2DC\3\2\2\2DE\3\2\2"+
		"\2E`\3\2\2\2FG\5\20\t\2GI\7\t\2\2HJ\5\n\6\2IH\3\2\2\2IJ\3\2\2\2J`\3\2"+
		"\2\2KL\5\22\n\2LN\7\t\2\2MO\5\n\6\2NM\3\2\2\2NO\3\2\2\2O`\3\2\2\2PQ\5"+
		"\24\13\2QS\7\t\2\2RT\5\n\6\2SR\3\2\2\2ST\3\2\2\2T`\3\2\2\2UV\5\26\f\2"+
		"VX\7\t\2\2WY\5\n\6\2XW\3\2\2\2XY\3\2\2\2Y`\3\2\2\2Z[\5\30\r\2[]\7\t\2"+
		"\2\\^\5\n\6\2]\\\3\2\2\2]^\3\2\2\2^`\3\2\2\2_<\3\2\2\2_A\3\2\2\2_F\3\2"+
		"\2\2_K\3\2\2\2_P\3\2\2\2_U\3\2\2\2_Z\3\2\2\2`\13\3\2\2\2ab\7!\2\2bc\7"+
		"\r\2\2cd\5\36\20\2d\r\3\2\2\2ef\7\16\2\2fg\7\4\2\2gh\5\34\17\2hi\7\5\2"+
		"\2ij\7\17\2\2jp\5\n\6\2kl\7\20\2\2lm\5\n\6\2mn\7\21\2\2no\7\t\2\2oq\3"+
		"\2\2\2pk\3\2\2\2pq\3\2\2\2q\17\3\2\2\2rs\7\22\2\2st\7\4\2\2tu\5\6\4\2"+
		"uv\7\5\2\2v\21\3\2\2\2wx\7\23\2\2x{\7\4\2\2y|\5\6\4\2z|\7%\2\2{y\3\2\2"+
		"\2{z\3\2\2\2|}\3\2\2\2}~\7\5\2\2~\23\3\2\2\2\177\u0080\7\24\2\2\u0080"+
		"\u0081\7\4\2\2\u0081\u0082\5\f\7\2\u0082\u0083\7\t\2\2\u0083\u0084\5\34"+
		"\17\2\u0084\u0085\7\t\2\2\u0085\u0086\5\f\7\2\u0086\u0087\7\5\2\2\u0087"+
		"\u0088\7\6\2\2\u0088\u0089\5\n\6\2\u0089\u008a\7\b\2\2\u008a\25\3\2\2"+
		"\2\u008b\u008c\7\25\2\2\u008c\u008d\7\4\2\2\u008d\u008e\5\34\17\2\u008e"+
		"\u008f\7\5\2\2\u008f\u0090\7\6\2\2\u0090\u0091\5\n\6\2\u0091\u0092\7\b"+
		"\2\2\u0092\27\3\2\2\2\u0093\u0094\7!\2\2\u0094\u0095\7\26\2\2\u0095\u0096"+
		"\7\6\2\2\u0096\u0097\5\32\16\2\u0097\u0098\7\b\2\2\u0098\31\3\2\2\2\u0099"+
		"\u009a\7\27\2\2\u009a\u009b\5 \21\2\u009b\u009c\7\30\2\2\u009c\u009d\5"+
		"\n\6\2\u009d\u009e\7\31\2\2\u009e\u00a0\7\t\2\2\u009f\u00a1\5\32\16\2"+
		"\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\33\3\2\2\2\u00a2\u00a3"+
		"\5\36\20\2\u00a3\u00a4\t\3\2\2\u00a4\u00a5\5\36\20\2\u00a5\35\3\2\2\2"+
		"\u00a6\u00a7\b\20\1\2\u00a7\u00a8\7\4\2\2\u00a8\u00a9\5\36\20\2\u00a9"+
		"\u00aa\7\5\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00ad\5 \21\2\u00ac\u00a6\3\2"+
		"\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b6\3\2\2\2\u00ae\u00af\f\6\2\2\u00af"+
		"\u00b0\t\4\2\2\u00b0\u00b5\5\36\20\7\u00b1\u00b2\f\5\2\2\u00b2\u00b3\t"+
		"\5\2\2\u00b3\u00b5\5\36\20\6\u00b4\u00ae\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\37\3\2\2"+
		"\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\t\6\2\2\u00ba!\3\2\2\2\22\60\67?DI"+
		"NSX]_p{\u00a0\u00ac\u00b4\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}