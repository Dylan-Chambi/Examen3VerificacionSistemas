package mobileauto.activities.whenDOApp;

import mobileauto.controls.Button;
import mobileauto.controls.Label;
import mobileauto.controls.TextBox;
import org.openqa.selenium.By;

public class HomeActivity {
    public Button addTask = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));

    public Button taskItem(String taskName){
        return new Button(By.xpath("//android.widget.TextView[@text='"+taskName+"']"));
    }

}
