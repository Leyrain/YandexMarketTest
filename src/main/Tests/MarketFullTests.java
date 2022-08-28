import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;


public class MarketFullTests extends StartUpForMarketFullTests {
    public int pMin = 25000;//Установка цены От
    public int pMax = 35000; //Установка цены До
    public String companySearch = "Lenovo"; //Выбор производителя

    @Test(priority = 1) //Открываем Яндекс.Маркет
    public void OpenMarket() {
        driver.get("https://market.yandex.ru");
    }

    @Test(priority = 2) //Открываем каталог, переходим в разделы "Компьютеры"->"Ноутуки"
    public void NotebookSection() {
        driver.findElement(By.id("catalogPopupButton")).click();
        driver.findElement(By.linkText("Компьютеры")).click();
        driver.findElement(By.linkText("Ноутбуки")).click();
    }

    @Test(priority = 3) //Раскрываем полный список производителей
    public void Company() throws InterruptedException {
        Thread.sleep(2000); //Ожидаем полной прогрузки списка фильтров
        driver.findElement(By.cssSelector("span._2Pukk")).click();
        Thread.sleep(2000); //Ожидаем полного раскрытия списка производителей и появления строки поиска
    }

    @Test(priority = 4) //Вводим производителя в строку поиска
    public void CompanySearch() throws InterruptedException {
        WebElement company = driver.findElements(By.xpath("//*[@class='_3qxDp']")).get(2);
        company.sendKeys(companySearch);
        Thread.sleep(2000); //Ожидаем прогрузки полного списка производителей
    }

    @Test(priority = 5) //Выбираем найденного производителя
    public void CheckboxCompany() {
        WebElement CheckboxCompany = driver.findElement(By.cssSelector("div._2XVtn span._1Mp5C"));
        CheckboxCompany.click();
    }

    @Test(priority = 6) //Устанавливаем минимальную цену
    public void PriceMin() {
        WebElement min = driver.findElements(By.xpath("//*[@class='_3qxDp']")).get(0);
        min.sendKeys(String.valueOf(pMin));
    }

    @Test(priority = 7) //Устанавливаем максимальную цену
    public void PriceMax() throws InterruptedException {
        WebElement max = driver.findElements(By.xpath("//*[@class='_3qxDp']")).get(1);
        max.sendKeys(String.valueOf(pMax));
        Thread.sleep(3000); //ожидаем полной прогрузки списка товаров в соответствии с фильтром
    }

    @Test(priority = 8) //Проверяем соответствие цены товара с установленным фильтром
    public void CheckPriceRange() throws InterruptedException {
        List<WebElement> priceValue = driver.findElements(By.cssSelector("div .Scp0k ._3Dqiq div ._2Ycrt a div span span:not(span.-B-PA)"));
        String result= null;
        if (priceValue.size() > 0) {
            for (int i = 0; i < priceValue.toArray().length; i++) {
                int myValue = Integer.valueOf(priceValue.get(i).getText().replace(" ", ""));
                assertTrue(myValue <= pMax && pMin <= myValue);
                result="Цена товаров соответствует диапазону";
            }
            System.out.println(result);
        } else {
            assertTrue(priceValue.size() > 0, "У выбранного производителя отсутствуют товары соответствующие диапазону или цена отображенных товаров выходит за рамки диапазона");
        }
    }


}




