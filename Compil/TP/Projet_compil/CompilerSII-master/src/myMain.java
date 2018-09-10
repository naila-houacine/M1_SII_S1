import org.antlr.v4.gui.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionMode;

import javax.print.PrintException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * Created by ressay on 23/11/17.
 */
public class myMain extends TestRig
{
    public myMain(String[] args) throws Exception {
        super(args);
    }

    public static void main(String[] args) throws Exception
    {
        myMain m = new myMain(args);
        if(args.length >= 2) {
            m.process();
        }
    }

    public static void addListeners(Parser parser)
    {
        SemanticErrorCheck semanticErrorCheck = new SemanticErrorCheck();
        QuadGenerator quadGenerator = new QuadGenerator(semanticErrorCheck);
        parser.addParseListener(quadGenerator);
        parser.addParseListener(semanticErrorCheck);
    }

    protected void process(Lexer lexer, Class<? extends Parser> parserClass, Parser parser, CharStream input) throws IOException, IllegalAccessException, InvocationTargetException, PrintException {
        lexer.setInputStream(input);
        addListeners(parser);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        if(this.showTokens) {
            Iterator i$ = tokens.getTokens().iterator();

            while(i$.hasNext()) {
                Token tok = (Token)i$.next();
                if(tok instanceof CommonToken) {
                    System.out.println(((CommonToken)tok).toString(lexer));
                } else {
                    System.out.println(tok.toString());
                }
            }
        }

        if(!this.startRuleName.equals("tokens")) {
            if(this.diagnostics) {
                parser.addErrorListener(new DiagnosticErrorListener());
                ((ParserATNSimulator)parser.getInterpreter()).setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
            }

            if(this.printTree || this.gui || this.psFile != null) {
                parser.setBuildParseTree(true);
            }

            if(this.SLL) {
                ((ParserATNSimulator)parser.getInterpreter()).setPredictionMode(PredictionMode.SLL);
            }

            parser.setTokenStream(tokens);
            parser.setTrace(this.trace);

            try {
                Method startRule = parserClass.getMethod(this.startRuleName, new Class[0]);
                ParserRuleContext tree = (ParserRuleContext)startRule.invoke(parser, (Object[])null);
                if(this.printTree) {
                    System.out.println(tree.toStringTree(parser));
                }

                if(this.gui) {
                    org.antlr.v4.gui.Trees.inspect(tree, parser);
                }

                if(this.psFile != null) {
                    org.antlr.v4.gui.Trees.save(tree, parser, this.psFile);
                }
            } catch (NoSuchMethodException var8) {
                System.err.println("No method for rule " + this.startRuleName + " or it has arguments");
            }

        }
    }
}
