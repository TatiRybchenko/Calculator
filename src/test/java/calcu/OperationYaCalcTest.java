package calcu;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OperationYaCalcTest {

    // перед каждым тестом, запускаем браузер хром, выполняем поиск онлайн калькулятора. Проверяем что онлайн-калькулятор найден. Очищаем все значения перед вводом.
    @Before
    public void setUp(){
        final String request = "калькулятор";

        PageHomeSearchYa pageHome = open(PageHomeSearchYa.URL, PageHomeSearchYa.class);
            pageHome.search(request);
        PageHomeCalc pageHomeCalc = page(PageHomeCalc.class);
            pageHomeCalc.getSearchCalc();
            pageHomeCalc.clickButtonCalcC();
            pageHomeCalc.clickLineCalc();
    }

    //  Очищаем все значения по кнопке С. После выполнения операций. Закрываем браузер.
    @After
    public void tearDown(){
        PageHomeCalc pageHomeCalc = page(PageHomeCalc.class);
            pageHomeCalc.clickButtonCalcC();
    }

    // тестом, проверяется значение выражения sqrt(144) = 12, значения вводятся через клавиатуру
    @Test
    @DisplayName("Запуск онлайн яндекс калькулятора. Выполнение операции sqrt(144) = 12 в онлайн калькуляторе, с корректными значениями")
    @Description("Выполнение операции sqrt(144) = 12, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
    public void clickElementSearchSquareRootOperation() {

        final String valueOperation = "144";
        final String expectedResult = "12";

    PageHomeCalc pageHomeCalc = page(PageHomeCalc.class);
        pageHomeCalc.fillValidValueLineCalc(valueOperation);
        pageHomeCalc.clickSquareRoot();
        pageHomeCalc.clickButtonCalcEquals();

        String actualResult = pageHomeCalc.clickResult();

        assertEquals("Некорректное значение, при вычисление операции sqrt(144): не равно 12", expectedResult, actualResult);
    }

    // тестом, проверяется значение выражения cos(Pi/2) = 0, значения вводятся через клавиатуру
    @Test
    @DisplayName("Запуск онлайн яндекс калькулятора. Выполнение операции cos(Pi/2) = 0 в онлайн калькуляторе, с корректными значениями")
    @Description("Выполнение операции cos(Pi/2) = 0, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
    public void clickElementSearchСosinePiOperation() {

        final String valueOperation= "cp/2)";
        final String expectedResult = "0";

        PageHomeCalc pageHomeCalc = page(PageHomeCalc.class);
            pageHomeCalc.fillValidValueLineCalc(valueOperation);
            pageHomeCalc.clickButtonCalcEquals();
            pageHomeCalc.clickRadioButtonCalcRad();

        String actualResult = pageHomeCalc.clickResult();

        assertEquals("Некорректное значение, при вычисление операции cos(Pi/2): не равно 0 ", expectedResult, actualResult);
    }

    // тестом, проверяется значение выражения 1,5 * 100 = 150, значения вводятся через клавиатуру
    @Test
    @DisplayName("Запуск онлайн яндекс калькулятора. Выполнение операции 1,5 * 100 = 150 в онлайн калькуляторе, с корректными значениями")
    @Description("Выполнение операции 1,5 * 100 = 150, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
    public void clickElementSearchMultiplicationOperation() {

        final String valueOperation= "1,5*100";
        final String expectedResult = "150";

        PageHomeCalc pageHomeCalc = page(PageHomeCalc.class);
            pageHomeCalc.fillValidValueLineCalc(valueOperation);
            pageHomeCalc.clickButtonCalcEquals();

        String actualResult = pageHomeCalc.clickResult();

        assertEquals("Некорректное значение, при вычисление операции  1,5 * 100: не равно 150 ", expectedResult, actualResult);
    }

}
