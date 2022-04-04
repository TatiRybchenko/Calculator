package calcu;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class PageHomeSearchYa {

    public static final String URL = "https://yandex.ru/";

    //локатор строки поиска
    @FindBy(how = How.ID, using = "text")
    private SelenideElement requestInput;

    //локатор кнопки "Найти"
    @FindBy(how = How.XPATH, using = ".//button[@type='submit']")
    private SelenideElement searchButton;

    @Step("В строке поиска «Яндекса», вводим значение: {request}. Нажимаем на кнопку «Найти».")
    //метод  выполнения поиска по запросу по нажатию на кнопку "Найти"
    public void search(String request) {
        requestInput.sendKeys(request);
        searchButton.click();
    }

    @Step("Нажимаем на калькулятор, строку ввода")
   //метод  выполнения поиска по запросу по нажатию на кнопку "Enter"
    public void searchEnter(String request) {
        requestInput.sendKeys(request);
        requestInput.pressEnter();
    }

}
