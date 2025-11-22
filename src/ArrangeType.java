import java.util.Comparator;

public class ArrangeType implements Comparator<Equation> {
    @Override
    public int compare(Equation e1, Equation e2) {
        return e1.getType().compareTo(e2.getType());
    }
}
