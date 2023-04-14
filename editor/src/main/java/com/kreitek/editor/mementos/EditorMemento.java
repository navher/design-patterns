package com.kreitek.editor.mementos;

import java.util.ArrayList;
import java.util.List;

public class EditorMemento {
    private List<String> states;

    public EditorMemento(List<String> states) {
        this.states = new ArrayList<>(states);
    }

    public List<String> getState() {
        return this.states;
    }
}
