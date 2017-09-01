package com.ccl.rain.codegen;

/**
 * @author ccl
 * @date 2017/8/19.
 */
public abstract class Criterion {

    private boolean not;

    public boolean isNot() {
        return not;
    }

    public void not() {
        this.not = true;
    }

    @Override
    public String toString() {
        return isNot() ? " NOT " : "";
    }
}
