package com.javarush.task.task32.task3209;


import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener {

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);


    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init(){
        initGui();
        FrameListener listener = new FrameListener(this);
        this.addWindowListener(listener);
        this.setVisible(true);
    }

    public void initMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);

        this.getContentPane().add(menuBar, BorderLayout.NORTH);



    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane paneEditor = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", paneEditor);
        JScrollPane paneText = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", paneText);
        tabbedPane.setPreferredSize(new Dimension(300, 800));
        TabbedPaneChangeListener paneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(paneChangeListener);
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);


    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged(){
        if(tabbedPane.getSelectedIndex()==0){
            controller.setPlainText(plainTextPane.getText());
        } else {
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public void undo(){
        try{
        undoManager.undo();}
        catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public void redo(){
        try{
        undoManager.redo();}
        catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public boolean isHtmlTabSelected(){
       if (tabbedPane.getSelectedIndex()==0){
           return true;}
       return false;
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(this, "Welcome!/n This is HTML REDACTOR!","О программе", JOptionPane.INFORMATION_MESSAGE);
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public boolean canUndo(){
        return undoManager.canUndo();
    }

    public boolean canRedo(){
        return undoManager.canRedo();
    }


    public void exit() {
        controller.exit();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                this.showAbout();
                break;
        }
    }
}
