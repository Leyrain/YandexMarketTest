import org.testng.annotations.Test;

public class YandexMarketTest extends StartUp{

    @Test
    public void GoToNotebook(){
        MainPageCheck mainPageCheck= new MainPageCheck();
        mainPageCheck.goToNotebookPage();
    }
}
