package com.pzque;

class PeazeValue {
    private Object value = null;
    private PeazeType type = null;

    private PeazeValue() {
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

    public PeazeType getType() {
        return type;
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

    static final PeazeValue NULL = new PeazeValue();
}