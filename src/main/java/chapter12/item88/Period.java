package chapter12.item88;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException("start before end!");
        }
    }

    public Date getStart() {
        return new Date(this.start.getTime());
    }

    public Date getEnd() {
        return new Date(this.end.getTime());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        if(start.compareTo(end) > 0) {
            throw new InvalidObjectException(start + " after " + end);
        }
    }

    @Override
    public String toString() {
        return this.start + " - " + this.end;
    }
}
