package webauto.pages.todoly;

import org.openqa.selenium.By;
import webauto.controls.Button;
import webauto.controls.ControlBase;
import webauto.controls.TextBox;

public class MainPage {
    public Button loginButton = new Button(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]"));

    public Button signUpButton = new Button(By.xpath("//img[@src='/Images/design/pagesignup.png']"));

    public ControlBase errorMessage = new ControlBase(By.id("ErrorMessageText"));


}
