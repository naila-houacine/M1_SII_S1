import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by ressay on 23/11/17.
 */
public class SemanticErrorCheck extends TinyLangageSIIBaseListener
{
    private static final int DECLARED = 1;
    private static final int UNDECLARED = 2;
    private static final int FLOAT = 2;
    private static final int INT = 1;

    private TableS table = new TableS();
    private LinkedList<String> errors = new LinkedList<>();
    private HashMap<ParserRuleContext,Integer> types = new HashMap<>();



    @Override public void exitProg(TinyLangageSIIParser.ProgContext ctx)
    {
        if(errors.size() == 0) { // no errors
            showText("program compiled without errors!",TextDisplayer.COMPILERTEXTS);
            showText("symbols table: ",TextDisplayer.COMPILERTEXTS);
            showText("******************************************************",TextDisplayer.COMPILERTEXTS);
            for (int i = 0; i < table.getSize(); i++) {
                showText(table.getElement(i).toString(),TextDisplayer.COMPILERTEXTS);
            }
            showText("******************************************************",TextDisplayer.COMPILERTEXTS);
        }
        else
        {
            showText("program compiled with the following errors",TextDisplayer.COMPILERTEXTS);
            for (int i = 0; i < errors.size(); i++) {
                showText(errors.get(i),TextDisplayer.ERROR);
            }
        }
    }

    @Override public void exitDec(TinyLangageSIIParser.DecContext ctx)
    {
        int type = (ctx.type().getText().equals("intCompil"))?1:2;

        TinyLangageSIIParser.VarsContext vars = ctx.vars();

        for (;;vars = vars.vars()) // loop over vars
        {
            String varName = vars.getChild(0).getText();
            if(table.containsElement(varName)) {
                errors.add("Double declaration of variable: " + varName);
            }
            else
                table.addElement(new TableS.Element(varName,DECLARED,type,1));
            if(vars.vars() == null)
                return;
        }

    }

    @Override public void exitVal(TinyLangageSIIParser.ValContext ctx)
    {
        addCtxType(ctx,(ctx.INTEGERVAL()!=null)?INT:FLOAT);
    }


    @Override public void exitAffect(TinyLangageSIIParser.AffectContext ctx)
    {
        if(!typesCompatible(getCtxType(ctx.exp()),table.getElement(ctx.identifier().getText()).type))
            errors.add("incompatible types in affectation " + ctx.getText());
        clearMap();
    }

    @Override public void exitIdentifier(TinyLangageSIIParser.IdentifierContext ctx)
    {
        // check if ID has been declared
        if(!table.containsElement(ctx.ID().getText()))
        {
            errors.add("variable " + ctx.ID().getText() + " has not been declared");
            table.addElement(new TableS.Element(ctx.ID().getText(),UNDECLARED,INT|FLOAT,1));
            // adding non declared variable in order to not generate same error again
        }
    }

    @Override public void exitExp(TinyLangageSIIParser.ExpContext ctx)
    {
        if(ctx.exp() == null)
            addCtxType(ctx,getCtxType(ctx.t()));
        else
        {
            if(typesCompatible(getCtxType(ctx.t()),getCtxType(ctx.exp())))
                addCtxType(ctx,getResultingType(getCtxType(ctx.t()),getCtxType(ctx.exp())));
            else {
                addCtxType(ctx, 0); // type 0 will always generate error
                showText("incompatible type between " + ctx.t().getText() + " and " + ctx.exp().getText(),TextDisplayer.IMPORTANTCOMMENTS);
                showText(ctx.t().getText() + " type: " + getCtxType(ctx.t()) + " and " + ctx.exp().getText() + " type: " + getCtxType(ctx.exp()),TextDisplayer.MOREINFORMATIONS);
            }

        }
    }

    @Override public void exitT(TinyLangageSIIParser.TContext ctx)
    {
        if(ctx.t() == null)
            addCtxType(ctx,getCtxType(ctx.endEx()));
        else
        {
            if(typesCompatible(getCtxType(ctx.endEx()),getCtxType(ctx.t())))
                addCtxType(ctx,getResultingType(getCtxType(ctx.t()),getCtxType(ctx.endEx())));
            else {
                addCtxType(ctx, 0); // type 0 will always generate error
                showText("incompatible type between " + ctx.t().getText() + " and " + ctx.endEx().getText(),TextDisplayer.IMPORTANTCOMMENTS);
                showText(ctx.t().getText() + " type: " + getCtxType(ctx.t()) + " and " + ctx.endEx().getText() + " type: " + getCtxType(ctx.endEx()),TextDisplayer.MOREINFORMATIONS);
            }
        }
    }

    @Override public void exitEndEx(TinyLangageSIIParser.EndExContext ctx)
    {
        if(ctx.identifier() != null)
            addCtxType(ctx,table.getElement(ctx.identifier().getText()).type);
        else if(ctx.exp() != null)
            addCtxType(ctx,getCtxType(ctx.exp()));
        else
            addCtxType(ctx,getCtxType(ctx.val()));
    }

    @Override public void visitErrorNode(ErrorNode node)
    {
        errors.add("syntax error " + node.getParent().getText());
    }

    public LinkedList<String> getErrors() {
        return errors;
    }

    private void addCtxType(ParserRuleContext ctx, int type)
    {
        types.put(ctx,type);
    }

    private int getCtxType(ParserRuleContext ctx)
    {
        return types.get(ctx);
    }

    private void clearMap()
    {
        types.clear();
    }

    private static boolean typesCompatible(int t1,int t2)
    {
        return (t1 & t2) != 0;
    }

    private static int getResultingType(int t1,int t2)
    {
        return ((t1 & t2 & FLOAT) != 0)?FLOAT:INT;
    }

    private void showText(String text, int typeOfText)
    {
        TextDisplayer.getInstance().showText(text,typeOfText,TextDisplayer.SEMANTICERR);
    }

    @Override public void exitComp(TinyLangageSIIParser.CompContext ctx)
    {
        clearMap();
    }
}
