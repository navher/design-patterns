package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.mementos.EditorCareTaker;
import com.kreitek.editor.mementos.EditorMemento;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final String text;
    private final int lineNumber;

    public UpdateCommand(String text, int lineNumber) {
        this.text = text;
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        EditorCareTaker careTaker = EditorCareTaker.getInstance();
        careTaker.push(new EditorMemento(documentLines));

        if (documentLines.size() > lineNumber)
            documentLines.set(lineNumber, text);
        else
            documentLines.add(text);
    }
}
