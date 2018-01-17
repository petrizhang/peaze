package com.pzque.core;

import java.util.HashMap;

/**
 * The type Peaze env.
 */
public class PeazeEnv {
    private PeazeEnv parent;
    private HashMap<String, PeazeObject> symbols;

    /**
     * Instantiates a new Peaze env.
     *
     * @param parent the parent
     */
    public PeazeEnv(PeazeEnv parent) {
        this.parent = parent;
        this.symbols = new HashMap<>();
    }

    /**
     * Lookup peaze value.
     *
     * @param name the name
     * @return the peaze value
     */
    public PeazeObject lookup(String name) {
        // find variable in current scope
        PeazeObject value = this.symbols.getOrDefault(name, null);
        // if not find, continue to lookup in parent scope
        if (value == null && parent != null) {
            return this.parent.lookup(name);
        }
        return value;
    }

    /**
     * Test symbol list if contains specific symbol.
     *
     * @param name symbol name
     * @return true or false
     */
    public boolean contains(String name) {
        return symbols.containsKey(name) ||
                (parent != null && parent.contains(name));
    }

    /**
     * Insert a new symbol to the symbol list.
     *
     * @param name  symbol name
     * @param value symbol value
     */
    public void insert(String name, PeazeObject value) {
        assert !symbols.containsKey(name);
        assert !value.isUnSpecified();
        assert !value.isNull();
        symbols.put(name, value);
    }

    /**
     * Update specific name with new value.
     * before invoking this method, you must assure the name to be updated really exists
     * (assure this.contains(name) is true)
     *
     * @param name  the name
     * @param value the value
     */
    public void update(String name, PeazeObject value) {
        assert this.contains(name);
        if (symbols.containsKey(name)) {
            this.symbols.replace(name, value);
            return;
        }
        parent.update(name, value);
    }

    public boolean isGlobal() {
        return this.parent == null;
    }

    public PeazeEnv getParent() {
        return parent;
    }
}
