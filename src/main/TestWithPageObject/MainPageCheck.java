import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageCheck extends BasePage{
    @FindBy(id = "catalogPopupButton")
    private WebElement catalogButtonElement;
//
//    private final By computerInCatalog = By.linkText("Компьютеры");
//    private final WebElement computerInCatalogElement = driver.findElement(computerInCatalog);
//
//    private final By noteBookInCatalog = By.linkText("Ноутбуки");
//    private final WebElement notebookInCatalog = driver.findElement(noteBookInCatalog);

    public MainPageCheck() {
        driver.get("https://market.yandex.ru");
        PageFactory.initElements(driver, this);
    }

    public MainPageCheck goToNotebookPage() {
        catalogButtonElement.click();
//        computerInCatalogElement.click();
//        notebookInCatalog.click();
        return this;
    }
}





