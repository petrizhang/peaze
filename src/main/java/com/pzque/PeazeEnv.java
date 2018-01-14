package com.pzque;

import java.util.HashMap;

/**
 * The type Peaze env.
 */
public class PeazeEnv {
    private PeazeEnv parent;
    private HashMap<String, PeazeValue> symbols;

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
    PeazeValue lookup(String name) {
        // find variable in current scope
        PeazeValue value = this.symbols.getOrDefault(name, null);
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
    boolean contains(String name) {
        return symbols.containsKey(name) ||
                (parent != null && parent.contains(name));
    }

    /**
     * Insert a new symbol to the symbol list.
     *
     * @param name  symbol name
     * @param value symbol value
     */
    void insert(String name, PeazeValue value) {
        assert !symbols.containsKey(name);
        assert !value.isUndefined();
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
    void update(String name, PeazeValue value) {
        assert this.contains(name);
        if (symbols.containsKey(name)) {
            this.symbols.replace(name, value);
            return;
        }
        parent.update(name, value);
    }
}
