/**
 * Created by ressay on 23/11/17.
 */
public class TextDisplayer
{


    public static final int WARNINGS = 1;
    public static final int IMPORTANTCOMMENTS = 2;
    public static final int RANDOMCOMMENTS = 4;
    public static final int COMPILERTEXTS = 8;
    public static final int MOREINFORMATIONS = 16;
    public static final int ERROR = 32;
    public static final int ALLTEXTS = WARNINGS|IMPORTANTCOMMENTS|RANDOMCOMMENTS|COMPILERTEXTS|MOREINFORMATIONS|ERROR;

    public static final int SEMANTICERR = 1;
    public static final int QUADGEN = 2;

    private int printMask = ERROR|COMPILERTEXTS;
    private int moduleMask = SEMANTICERR|QUADGEN;

    private static TextDisplayer _instance = null;

    private TextDisplayer(int printMask) {
        this.printMask = printMask;
    }

    private TextDisplayer() {
    }

    static TextDisplayer getInstance()
    {
        return (_instance == null)? new TextDisplayer():_instance;
    }

    private String getTextType(int type)
    {
        switch (type)
        {
            case WARNINGS: return "WARNINGS";
            case IMPORTANTCOMMENTS: return "IMPORTANTCOMMENTS";
            case RANDOMCOMMENTS: return "RANDOMCOMMENTS";
            case COMPILERTEXTS: return "COMPILERTEXTS";
            case MOREINFORMATIONS: return "MOREINFORMATIONS";
            case ERROR : return "ERROR";
        }
        return "";
    }

    private String getTextModule(int type)
    {
        switch (type)
        {
            case SEMANTICERR: return "SEMANTIC CHECK";
            case QUADGEN: return "QUAD GENERATOR";
        }
        return "";
    }

    public void showText(String text, int typeOfText, int module)
    {
        if((typeOfText & printMask) != 0 && (moduleMask & module) != 0)
            System.out.println(getTextModule(module) + " " + getTextType(typeOfText) + ": " +text);
    }

}
