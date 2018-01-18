package com.pzque.types;

import com.pzque.core.PeazeObject;

abstract public class PeazeNumber
        extends PeazeObject
        implements Comparable<PeazeNumber> {

    public boolean eq(PeazeNumber rhs) {
        return this.compareTo(rhs) == 0;
    }

    public boolean le(PeazeNumber rhs) {
        return this.compareTo(rhs) <= 0;
    }

    public boolean ge(PeazeNumber rhs) {
        return this.compareTo(rhs) >= 0;
    }

    public boolean lt(PeazeNumber rhs) {
        return this.compareTo(rhs) < 0;
    }

    public boolean gt(PeazeNumber rhs) {
        return this.compareTo(rhs) > 0;
    }

    @Override
    public int compareTo(PeazeNumber o) {
        double lhs = this.asJavaDouble();
        double rhs = o.asJavaDouble();
        if (lhs > rhs) {
            return 1;
        } else if (lhs < rhs) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public abstract Double asJavaDouble();

    public abstract void setNegative();

    public abstract PeazeNumber add(PeazeNumber rhs);

    public abstract PeazeNumber acceptAdd(PeazeNumberInteger lhs);

    public abstract PeazeNumber acceptAdd(PeazeNumberRational lhs);

    public abstract PeazeNumber acceptAdd(PeazeNumberReal lhs);

    public abstract PeazeNumber sub(PeazeNumber rhs);

    public abstract PeazeNumber acceptSub(PeazeNumberInteger lhs);

    public abstract PeazeNumber acceptSub(PeazeNumberRational lhs);

    public abstract PeazeNumber acceptSub(PeazeNumberReal lhs);
}
