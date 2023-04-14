package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.mementos.EditorCareTaker;
import com.kreitek.editor.mementos.EditorMemento;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private final int lineNumber;

    public DeleteCommand(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        EditorCareTaker careTaker = EditorCareTaker.getInstance();
        careTaker.push(new EditorMemento(documentLines));

        documentLines.remove(lineNumber);
    }
}
