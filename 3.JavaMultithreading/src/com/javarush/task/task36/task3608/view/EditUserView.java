package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public class EditUserView implements View {
    private Controller controller;



    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
        if (modelData.getActiveUser() == null) return;
        System.out.println("\t"+modelData.getActiveUser());
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventUserDeleted(long id){
        if (controller==null) return;
        controller.onUserDelete(id);
    }

    public void fireEventUserChanged(String name, long id, int level){
        if (controller==null) return;
        controller.onUserChange(name, id, level);
    }

}
