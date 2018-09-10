import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by ressay on 23/11/17.
 */
public class QuadGenerator extends TinyLangageSIIBaseListener
{

    private LinkedList<String> stack = new LinkedList<>();
    private Quads quads = new Quads();
    private int cptTemps = 0;
    SemanticErrorCheck semanticErrorCheck;

    public QuadGenerator(SemanticErrorCheck semanticErrorCheck) {
        this.semanticErrorCheck = semanticErrorCheck;
    }


    @Override public void exitProg(TinyLangageSIIParser.ProgContext ctx)
    {
        if(semanticErrorCheck.getErrors().size()>0)
            return;
        quads.addQuad("END","","","");
        showText("generated quads: ",TextDisplayer.COMPILERTEXTS);
        showText("******************************************************",TextDisplayer.COMPILERTEXTS);
        for (int i = 0; i < quads.size(); i++) {
            showText(i + ": " + quads.getQuad(i).toString(),TextDisplayer.COMPILERTEXTS);
        }
        showText("******************************************************",TextDisplayer.COMPILERTEXTS);
    }

    @Override public void exitAffect(TinyLangageSIIParser.AffectContext ctx)
    {
        showText("exitAffect start: " +" head of stack is " + stack.getLast(),TextDisplayer.RANDOMCOMMENTS);
        String t1 = stack.removeLast();
        quads.addQuad("=",t1,"",ctx.identifier().getText());
        showText("exitAffect adding quad " + quads.getQuad(quads.size()-1),TextDisplayer.RANDOMCOMMENTS);
    }

    @Override public void exitExp(TinyLangageSIIParser.ExpContext ctx)
    {
        if(ctx.exp() != null)
        {
            String t1 = stack.removeLast();
            String t2 = stack.removeLast();
            String temp = "Temp"+(++cptTemps);
            quads.addQuad(ctx.opmi().getText(),t2,t1,temp);
            stack.add(temp);
            showText("exitExp adding quad " + quads.getQuad(quads.size()-1),TextDisplayer.RANDOMCOMMENTS);
        }
        else
        {
            showText("exitExp head of stack is: " + stack.getLast()+ " stack size " + stack.size(),TextDisplayer.RANDOMCOMMENTS);
        }
    }

    @Override public void exitT(TinyLangageSIIParser.TContext ctx)
    {
        if(ctx.t() != null)
        {
            String t1 = stack.removeLast(),t2 = stack.removeLast();
            String temp = "Temp"+(++cptTemps);
            quads.addQuad(ctx.opma().getText(),t2,t1,temp);
            stack.add(temp);
            showText("exitT adding quad " + quads.getQuad(quads.size()-1),TextDisplayer.RANDOMCOMMENTS);
        }
        else
        {
            showText("exitT head of stack is: " + stack.getLast() + " stack size " + stack.size(),TextDisplayer.RANDOMCOMMENTS);
        }
    }

    @Override public void exitEndEx(TinyLangageSIIParser.EndExContext ctx)
    {
        if(ctx.exp() == null) {
            stack.add(ctx.getText());
            showText("exitEndEx: case exp == null adding "+ ctx.getText(),TextDisplayer.RANDOMCOMMENTS);
        }
        else
        {
            showText("exitEndEx: case exp = null adding nothing "+ stack.getLast(),TextDisplayer.RANDOMCOMMENTS);
        }
    }

    int saveCondition;
    @Override public void exitComp(TinyLangageSIIParser.CompContext ctx)
    {
        showText("exitComp start: " +" head of stack is " + stack.getLast(),TextDisplayer.RANDOMCOMMENTS);
        String t1 = stack.removeLast();
        String t2 = stack.removeLast();
        saveCondition = quads.addQuad((ctx.op().getText().compareTo(">") == 0)?"BLE":"BGE",t2,t1,"");
        showText("exitComp adding quad " + quads.getQuad(quads.size()-1),TextDisplayer.RANDOMCOMMENTS);

    }

    @Override public void exitEl(TinyLangageSIIParser.ElContext ctx)
    {
        quads.getQuad(saveCondition).set(3,""+(quads.size()+1));
        saveCondition = quads.addQuad("BR","","","");
    }

    @Override public void exitIfinst(TinyLangageSIIParser.IfinstContext ctx)
    {
        quads.getQuad(saveCondition).set(3,""+quads.size());
    }

    private void showText(String text, int typeOfText)
    {
        TextDisplayer.getInstance().showText(text,typeOfText,TextDisplayer.QUADGEN);
    }

}
