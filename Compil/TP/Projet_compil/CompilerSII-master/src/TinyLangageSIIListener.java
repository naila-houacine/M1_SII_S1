// Generated from TinyLangageSII.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TinyLangageSIIParser}.
 */
public interface TinyLangageSIIListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(TinyLangageSIIParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(TinyLangageSIIParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(TinyLangageSIIParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(TinyLangageSIIParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDec(TinyLangageSIIParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDec(TinyLangageSIIParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TinyLangageSIIParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TinyLangageSIIParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVars(TinyLangageSIIParser.VarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVars(TinyLangageSIIParser.VarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(TinyLangageSIIParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(TinyLangageSIIParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(TinyLangageSIIParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(TinyLangageSIIParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#insts}.
	 * @param ctx the parse tree
	 */
	void enterInsts(TinyLangageSIIParser.InstsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#insts}.
	 * @param ctx the parse tree
	 */
	void exitInsts(TinyLangageSIIParser.InstsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterInst(TinyLangageSIIParser.InstContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitInst(TinyLangageSIIParser.InstContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#affect}.
	 * @param ctx the parse tree
	 */
	void enterAffect(TinyLangageSIIParser.AffectContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#affect}.
	 * @param ctx the parse tree
	 */
	void exitAffect(TinyLangageSIIParser.AffectContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(TinyLangageSIIParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(TinyLangageSIIParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#t}.
	 * @param ctx the parse tree
	 */
	void enterT(TinyLangageSIIParser.TContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#t}.
	 * @param ctx the parse tree
	 */
	void exitT(TinyLangageSIIParser.TContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#opmi}.
	 * @param ctx the parse tree
	 */
	void enterOpmi(TinyLangageSIIParser.OpmiContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#opmi}.
	 * @param ctx the parse tree
	 */
	void exitOpmi(TinyLangageSIIParser.OpmiContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#opma}.
	 * @param ctx the parse tree
	 */
	void enterOpma(TinyLangageSIIParser.OpmaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#opma}.
	 * @param ctx the parse tree
	 */
	void exitOpma(TinyLangageSIIParser.OpmaContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#endEx}.
	 * @param ctx the parse tree
	 */
	void enterEndEx(TinyLangageSIIParser.EndExContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#endEx}.
	 * @param ctx the parse tree
	 */
	void exitEndEx(TinyLangageSIIParser.EndExContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#ifinst}.
	 * @param ctx the parse tree
	 */
	void enterIfinst(TinyLangageSIIParser.IfinstContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#ifinst}.
	 * @param ctx the parse tree
	 */
	void exitIfinst(TinyLangageSIIParser.IfinstContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#el}.
	 * @param ctx the parse tree
	 */
	void enterEl(TinyLangageSIIParser.ElContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#el}.
	 * @param ctx the parse tree
	 */
	void exitEl(TinyLangageSIIParser.ElContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(TinyLangageSIIParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(TinyLangageSIIParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(TinyLangageSIIParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(TinyLangageSIIParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(TinyLangageSIIParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(TinyLangageSIIParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#write}.
	 * @param ctx the parse tree
	 */
	void enterWrite(TinyLangageSIIParser.WriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#write}.
	 * @param ctx the parse tree
	 */
	void exitWrite(TinyLangageSIIParser.WriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangageSIIParser#listID}.
	 * @param ctx the parse tree
	 */
	void enterListID(TinyLangageSIIParser.ListIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangageSIIParser#listID}.
	 * @param ctx the parse tree
	 */
	void exitListID(TinyLangageSIIParser.ListIDContext ctx);
}