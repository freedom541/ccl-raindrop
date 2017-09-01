package com.ccl.rain.codegen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ccl
 * @date 2017/8/27.
 */
public class UniqueKeyData {

    private final String name;

    private final List<String> columns = new ArrayList<String>();

    public UniqueKeyData(String name) {
        this.name = name;
    }

    public UniqueKeyData(String name, String[] c) {
        this.name = name;
        columns.addAll(Arrays.asList(c));
    }

    public void add(String column) {
        columns.add(column);
    }

    public String getName() {
        return name;
    }

    public List<String> getColumns() {
        return columns;
    }
}
