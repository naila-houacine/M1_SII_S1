import java.util.LinkedList;

/**
 * Created by ressay on 23/11/17.
 */
public class Quads
{
    LinkedList<Quad> quads = new LinkedList<>();
    public int addQuad(String s1,String s2,String s3,String s4)
    {
        return addQuad(new Quad(s1,s2,s3,s4));
    }

    public int addQuad(Quad quad)
    {
        quads.add(quad);
        return quads.size()-1;
    }

    public Quad getQuad(int index)
    {
        return quads.get(index);
    }

    public int size()
    {
        return quads.size();
    }
}
