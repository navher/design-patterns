package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.mementos.EditorCareTaker;

import java.util.ArrayList;

public class UndoCommand implements Command {
    @Override
    public void execute(ArrayList<String> documentLines) {
        EditorCareTaker careTaker = EditorCareTaker.getInstance();
        try{
            documentLines.clear();
            documentLines.addAll(careTaker.pop().getState());
        }catch (NullPointerException e){
            System.out.println("No changes to undo");
        }
    }
}
