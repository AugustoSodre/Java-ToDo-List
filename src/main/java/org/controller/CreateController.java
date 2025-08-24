package org.controller;

import org.DAO.DAO_Operations;
import org.model.Task;

public class CreateController {

    public void create(Task task) {
        DAO_Operations.createTask(task);
    }
}
