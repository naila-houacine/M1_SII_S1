// Generated from /home/mohammedi/OpenSourceProjects/master1-sii-assignements/Compil/projet/implementation/src/TP2.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TP2Parser}.
 */
public interface TP2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TP2Parser#start_rule}.
	 * @param ctx the parse tree
	 */
	void enterStart_rule(TP2Parser.Start_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#start_rule}.
	 * @param ctx the parse tree
	 */
	void exitStart_rule(TP2Parser.Start_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(TP2Parser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(TP2Parser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(TP2Parser.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(TP2Parser.VariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TP2Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TP2Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstructions(TP2Parser.InstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstructions(TP2Parser.InstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#instAff}.
	 * @param ctx the parse tree
	 */
	void enterInstAff(TP2Parser.InstAffContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#instAff}.
	 * @param ctx the parse tree
	 */
	void exitInstAff(TP2Parser.InstAffContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#instIf}.
	 * @param ctx the parse tree
	 */
	void enterInstIf(TP2Parser.InstIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#instIf}.
	 * @param ctx the parse tree
	 */
	void exitInstIf(TP2Parser.InstIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#instScan}.
	 * @param ctx the parse tree
	 */
	void enterInstScan(TP2Parser.InstScanContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#instScan}.
	 * @param ctx the parse tree
	 */
	void exitInstScan(TP2Parser.InstScanContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#instPrint}.
	 * @param ctx the parse tree
	 */
	void enterInstPrint(TP2Parser.InstPrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#instPrint}.
	 * @param ctx the parse tree
	 */
	void exitInstPrint(TP2Parser.InstPrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#instFor}.
	 * @param ctx the parse tree
	 */
	void enterInstFor(TP2Parser.InstForContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#instFor}.
	 * @param ctx the parse tree
	 */
	void exitInstFor(TP2Parser.InstForContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#instWhile}.
	 * @param ctx the parse tree
	 */
	void enterInstWhile(TP2Parser.InstWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#instWhile}.
	 * @param ctx the parse tree
	 */
	void exitInstWhile(TP2Parser.InstWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#instCase}.
	 * @param ctx the parse tree
	 */
	void enterInstCase(TP2Parser.InstCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#instCase}.
	 * @param ctx the parse tree
	 */
	void exitInstCase(TP2Parser.InstCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#cases}.
	 * @param ctx the parse tree
	 */
	void enterCases(TP2Parser.CasesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#cases}.
	 * @param ctx the parse tree
	 */
	void exitCases(TP2Parser.CasesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(TP2Parser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(TP2Parser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TP2Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TP2Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TP2Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(TP2Parser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TP2Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(TP2Parser.ValueContext ctx);
}