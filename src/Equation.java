import javax.swing.*;
import java.time.Instant;

public abstract class Equation implements Comparable<Equation> {
    private double Result;
    private String type;
    private Instant creationTime;

    public Equation(String type, double Result) {
        this.Result = Result;
        this.type = type;
    }

    public Equation(String type) {
        this(type, 0);
    }

    public double getResult() {
        return Result;
    }

    public String getType() {
        return type;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public abstract double computeResult();

    @Override
    public int compareTo(Equation o) {
        return creationTime.compareTo(o.creationTime);
    }
}

