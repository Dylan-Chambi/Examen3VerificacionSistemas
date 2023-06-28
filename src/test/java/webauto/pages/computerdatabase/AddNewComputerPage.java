package webauto.pages.computerdatabase;

import org.openqa.selenium.By;
import webauto.controls.Button;
import webauto.controls.TextBox;

public class AddNewComputerPage {
    public TextBox computerNameTextBox = new TextBox(By.xpath("//input[@id='name']"));
    public TextBox introducedDateTextBox = new TextBox(By.xpath("//input[@id='introduced']"));
    public TextBox discontinuedDateTextBox = new TextBox(By.xpath("//input[@id='discontinued']"));

    public Button companySelector = new Button(By.xpath("//select[@id='company']"));

    public Button companyOption(String company) {
        return new Button(By.xpath("//select[@id='company']/option[text()='" + company + "']"));
    }

    public Button createThisComputerButton = new Button(By.xpath("//input[@value='Create this computer']"));
}
