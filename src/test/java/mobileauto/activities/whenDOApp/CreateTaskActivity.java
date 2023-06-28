package mobileauto.activities.whenDOApp;

import mobileauto.controls.Button;
import mobileauto.controls.TextBox;
import org.openqa.selenium.By;

public class CreateTaskActivity {
    public TextBox titleTask = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));

    public Button saveTask = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
}
