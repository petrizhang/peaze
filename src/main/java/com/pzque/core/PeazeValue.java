package com.pzque.core;

public class PeazeValue {
    private PeazeType type = null;
    private Object value = null;

    private PeazeValue() {
    }

    public PeazeType getType() {
        return type;
    }

    private PeazeValue(PeazeType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Boolean isUndefined() {
        return this.type == PeazeType.UNDEFINED;
    }

    public Boolean isNull() {
        return this.type == PeazeType.NULL;
    }

    public PeazeValue(Boolean value) {
        assert value != null;
        this.type = PeazeType.BOOLEAN;
        this.value = value;
    }

    public PeazeValue(Character value) {
        assert value != null;
        this.type = PeazeType.CHARACTER;
        this.value = value;
    }

    public PeazeValue(Integer value) {
        assert value != null;
        this.type = PeazeType.INTEGER;
        this.value = value;
    }

    public PeazeValue(Double value) {
        assert value != null;
        this.type = PeazeType.DOUBLE;
        this.value = value;
    }


    public PeazeValue(PeazeProcedure value) {
        assert value != null;
        this.type = PeazeType.PROCEDURE;
        this.value = value;
    }

    public void setBoolean(Boolean value) {
        assert value != null;
        this.type = PeazeType.BOOLEAN;
        this.value = value;
    }

    public void setCharacter(Character value) {
        assert value != null;
        this.type = PeazeType.CHARACTER;
        this.value = value;
    }

    public void setInteger(Integer value) {
        assert value != null;
        this.type = PeazeType.INTEGER;
        this.value = value;
    }

    public void setDouble(Double value) {
        assert value != null;
        this.type = PeazeType.DOUBLE;
        this.value = value;
    }

    public void setFunction(PeazeProcedure value) {
        assert value != null;
        this.type = PeazeType.PROCEDURE;
        this.value = value;
    }

    public Boolean asBoolean() {
        assert this.type == PeazeType.BOOLEAN;
        return (Boolean) this.value;
    }

    public Character asCharacter() {
        assert this.type == PeazeType.CHARACTER;
        return (Character) this.value;
    }

    public Double asDouble() {
        assert this.type == PeazeType.DOUBLE;
        return (Double) this.value;
    }

    public Integer asInteger() {
        assert this.type == PeazeType.INTEGER;
        return (Integer) this.value;
    }

    public PeazeProcedure asProcedure() {
        assert this.type == PeazeType.PROCEDURE;
        return (PeazeProcedure) this.value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    public static final PeazeValue NULL = new PeazeValue(PeazeType.NULL, null);
    public static final PeazeValue UNDEFINED = new PeazeValue(PeazeType.UNDEFINED, null);
}