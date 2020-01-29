package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Controller {

    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;



    public void setModel(Model model) { this.model = model; }

    public void onShowAllUsers(){
        if(model==null) return;
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers(){
        if(model==null) return;
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView) { this.editUserView = editUserView; }

    public void onOpenUserEditForm(long id) {
        if(model==null) return;
        model.loadUserById(id);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete(long id){
        if(model==null) return;
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }

    public void onUserChange(String name, long id, int level){
        if(model==null) return;
        model.changeUserData(name, id, level);
        usersView.refresh(model.getModelData());
    }
}
