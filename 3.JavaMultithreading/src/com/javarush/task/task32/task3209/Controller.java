package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {

    private File currentFile;
    private View view;
    private HTMLDocument document;

    public Controller(View view) {
        this.view = view;
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument(){
        if(document!=null)
            document.removeUndoableEditListener(view.getUndoListener());
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text){
        try {
            resetDocument();
            StringReader reader = new StringReader(text);
            new HTMLEditorKit().read(reader, document,0);
        } catch (Exception e){
            ExceptionHandler.log(e);
        }

    }

    public String getPlainText(){
        StringWriter writer = new StringWriter();
        try {
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
        }catch (Exception e){
            ExceptionHandler.log(e);
        }

        return writer.toString();
    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();

    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        int choose = fileChooser.showOpenDialog(view);
        if(choose == JFileChooser.APPROVE_OPTION){
            currentFile = fileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try {
                FileReader reader = new FileReader(currentFile);
                new HTMLEditorKit().read(reader, document,0);
                view.resetUndo();
            } catch (Exception exp){
                ExceptionHandler.log(exp);
            }
        }
    }

    public void saveDocument() {
        view.selectHtmlTab();
        if(currentFile!=null){
            view.setTitle(currentFile.getName());
            try {
                FileWriter writer = new FileWriter(currentFile);
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        } else saveDocumentAs();
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        int choose = fileChooser.showSaveDialog(view);
        if (choose == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                FileWriter writer = new FileWriter(currentFile);
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }
}
