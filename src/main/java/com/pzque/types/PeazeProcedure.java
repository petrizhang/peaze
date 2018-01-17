package com.pzque.types;

import java.util.List;

import com.pzque.core.PeazeEnv;
import com.pzque.core.PeazeObject;
import com.pzque.parser.PeazeParser.*;

public class PeazeProcedure extends PeazeObject {
    public PeazeProcedure(PeazeEnv env, List<String> params, SequenceContext body) {
        this.env = env;
        this.params = params;
        this.body = body;
    }

    @Override
    public boolean isProcedure() {
        return true;
    }

    @Override
    public boolean isApplicable() {
        return true;
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