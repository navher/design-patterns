package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.mementos.EditorCareTaker;
import com.kreitek.editor.mementos.EditorMemento;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;

    public AppendCommand(String text) {
        this.text = text;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        EditorCareTaker careTaker = EditorCareTaker.getInstance();
        careTaker.push(new EditorMemento(documentLines));

        documentLines.add(text);
    }
}
