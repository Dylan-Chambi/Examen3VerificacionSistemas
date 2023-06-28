package webauto.pages.computerdatabase;

import org.openqa.selenium.By;
import webauto.controls.Button;
import webauto.controls.ControlBase;

public class ComputersPage {
    public Button addNewComputerButton = new Button(By.xpath("//a[@id='add']"));

    public ControlBase computerSuccessfullyCreatedMessage(String computerName) {
        return new ControlBase(By.xpath("//div[contains(text(),'Computer " + computerName + " has been created')]"));
    }
}
