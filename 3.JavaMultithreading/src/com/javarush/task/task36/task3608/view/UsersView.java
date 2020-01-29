package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.List;

public class UsersView implements View {
    private Controller controller;




    @Override
    public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList()){
            System.out.println("All deleted users:");
        } else  System.out.println("All users:");
        if (modelData.getUsers() == null) return;
        List<User> users= modelData.getUsers();
        for (User us:users) {
            System.out.println("\t"+us);
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers(){
        if (controller==null) return;
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers(){
        if (controller==null) return;
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        if (controller==null) return;
        controller.onOpenUserEditForm(id);
    }


}
