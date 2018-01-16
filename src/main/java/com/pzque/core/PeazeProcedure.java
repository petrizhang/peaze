package com.pzque.core;

import java.util.List;

import com.pzque.core.PeazeEnv;
import com.pzque.parser.PeazeParser.*;

public class PeazeProcedure {
    public PeazeProcedure(List<String> params, SequenceContext body) {
        this.env = null;
        this.params = params;
        this.body = body;
    }

    public PeazeEnv getEnv() {
        return env;
    }

    public List<String> getParams() {
        return params;
    }

    public SequenceContext getBody() {
        return body;
    }

    public int getParamCount() {
        return params.size();
    }

    public void setEnv(PeazeEnv env) {
        this.env = env;
    }

    private PeazeEnv env;
    private List<String> params;
    private SequenceContext body;
}