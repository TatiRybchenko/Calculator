package calcu;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class PageHomeCalc {

    //локатор строки поиска.
    @FindBy(how = How.XPATH, using = ".//input[@type='text']")
    private SelenideElement requestInputCalc;

    //локатор линии вввода значений калькулятора
    @FindBy(how = How.XPATH, using = ".//input[@placeholder='0']")
    private SelenideElement  lineInputCalc;

    //локатор кнопки С у  калькулятора
    @FindBy(how = How.XPATH, using =".//*[@data-bem='{\"button2\":{},\"calculator__btn\":{\"action\":\"ce\",\"arg\":null}}']")
    private SelenideElement buttonCalcC;

    //локатор кнопки корень квадратный
    @FindBy(how = How.XPATH, using = ".//*[@data-bem='{\"button2\":{},\"calculator__btn\":{\"action\":\"cmd\",\"arg\":\"√\"}}']")
    private SelenideElement  squareRoot;

    //локатор кнопки = у  калькулятора
    @FindBy(how = How.XPATH, using =".//*[@data-bem='{\"button2\":{},\"calculator__btn\":{\"action\":\"equal\",\"arg\":null}}']")
    private SelenideElement buttonCalcEquals;

    //локатор радиокнопки Rad у калькулятора
    @FindBy(how = How.XPATH, using =".//*[@class='radio-button__radio radio-button__radio_side_right']")
    private SelenideElement radioButtonCalcRad;

    @Step("Проверка значения в строке поиска на странице, что в ней содержится «калькулятор». Проверка что URL в браузере содержит значение запроса на поиск «калькулятор».")
    //метод клика по строке поиска и проврка, что находимся на нужной странице "калькулятор"
    public void getSearchCalc() {
        requestInputCalc.click();
        requestInputCalc.shouldHave(exactValue("калькулятор")); //проверяем что в строке поиска введен "калькулятор"
        requestInputCalc.pressEscape();
        webdriver().shouldHave(url("https://yandex.ru/search/?lr=2&text=%D0%BA%D0%B0%D0%BB%D1%8C%D0%BA%D1%83%D0%BB%D1%8F%D1%82%D0%BE%D1%80")); //проверяем что находимся на нужном  url "калькулятора"
    }

    @Step("Нажимаем на строку ввода в калькуляторе")
    //метод клика по окну калькулятора и  по строке ввода
        public void clickLineCalc() {
        lineInputCalc.click();
 }
    @Step("Вводим значения с клавиатуры: {valueOperation}, для вычисления выражения на калькуляторе")
    //метод ввода данных
        public void fillValidValueLineCalc(String valueOperation) {
        lineInputCalc.setValue(valueOperation);
    }
    @Step("Нажимаем на кнопку в калькуляторе (квадратный корень): sqrt")
    //метод клика по кнопке корень квадратный
        public void clickSquareRoot() {
        squareRoot.click();
    }
    @Step("Нажимаем на кнопку в калькуляторе (сброс) введенных значений: С")
    //метод клика по кнопке C
        public void clickButtonCalcC() {
        buttonCalcC.click();
    }
    @Step("Нажимаем на кнопку в калькуляторе (равно): =")
    //метод клика по кнопке =
        public void clickButtonCalcEquals() {
        buttonCalcEquals.click();
    }
    @Step("Нажимаем на радиокнопку в калькуляторе (радианы): Rad")
    //метод клика по кнопке Rad =
        public void clickRadioButtonCalcRad() {
        radioButtonCalcRad.click();
    }
    @Step("Извлекаем полученное значение, в результате выполнения операции и сравниваем с ожидаемым результатом")
    //метод извлечения результата выполнения операций, возвращает полученное значение
        public String clickResult() {
        lineInputCalc.click();
        return lineInputCalc.getValue();
    }
}

