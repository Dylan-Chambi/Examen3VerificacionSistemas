package mobileauto.test;

import mobileauto.activities.whenDOApp.CreateTaskActivity;
import mobileauto.activities.whenDOApp.DeleteConfirmDialog;
import mobileauto.activities.whenDOApp.HomeActivity;
import mobileauto.activities.whenDOApp.UpdateTaskActivity;
import mobileauto.session.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CreateUpdateDeleteTaskTest {

    private HomeActivity homeActivity = new HomeActivity();
    private CreateTaskActivity createTaskActivity = new CreateTaskActivity();
    private UpdateTaskActivity updateTaskActivity = new UpdateTaskActivity();
    private DeleteConfirmDialog deleteConfirmDialog = new DeleteConfirmDialog();

    @Test
    public void verifySomething(){
        // create task
        String taskName = "Dylan task" + new Date().getTime();

        homeActivity.addTask.click();
        createTaskActivity.titleTask.setText(taskName);
        createTaskActivity.saveTask.click();
        Assertions.assertTrue(homeActivity.taskItem(taskName).isControlDisplayed(), "ERROR: Task was not created");

        // update task
        String taskNameUpdated = "Dylan task updated" + new Date().getTime();
        homeActivity.taskItem(taskName).click();
        updateTaskActivity.titleTask.setText(taskNameUpdated);
        updateTaskActivity.saveTask.click();
        Assertions.assertTrue(homeActivity.taskItem(taskNameUpdated).isControlDisplayed(), "ERROR: Task was not updated");

        // delete task
        homeActivity.taskItem(taskNameUpdated).click();
        updateTaskActivity.deleteTask.click();
        deleteConfirmDialog.deleteTask.click();
        Assertions.assertFalse(homeActivity.taskItem(taskNameUpdated).isControlDisplayed(), "ERROR: Task was not deleted");
    }

    @AfterEach
    public void close(){
        Session.getSession().closeSession();
    }
}
