package com.kreitek.editor.mementos;

import java.util.ArrayList;
import java.util.List;

public class EditorCareTaker {
    List<EditorMemento> mementos = new ArrayList<>();
    private static volatile EditorCareTaker caretaker = null;
    private EditorCareTaker(){
        if(caretaker != null){
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }
    public static EditorCareTaker getInstance(){
        if(caretaker == null){
            synchronized (EditorCareTaker.class){
                if(caretaker == null){
                    caretaker = new EditorCareTaker();
                }
            }
        }
        return caretaker;
    }
    public void push(EditorMemento state){
        mementos.add(state);
    }
    public EditorMemento pop(){

        if(mementos.size() > 0) {
            int lastIndex = mementos.size() - 1;
            EditorMemento memento = mementos.get(lastIndex);
            mementos.remove(lastIndex);
            return memento;
        }
        return null;

    }
}
