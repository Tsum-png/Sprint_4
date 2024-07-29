package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    private WebDriver driver;
    //кнопка "заказать" в верхней части страницы
    private By upperOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    //кнопка "заказать" в нижней части страницы
    private By lowerOrderButton = By.cssSelector(".Button_Middle__1CSJM");
    //кнопка "да все привыкли"
    private By cookieButton = By.className("App_CookieButton__3cvqF");
    //таблица с вопросами о важном
    private By tabelWithQuestions = By.xpath("//*[@id=\"root\"]/div/div[1]/div[5]/div[2]/div");
    //вопрос в таблице "вопросы о важном"
    public static final String[] questionsAbout = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};
    //ответ в таблице "вопросы о важном"
    public static final String[] answersAbout = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};

    public Main(WebDriver driver) {
        this.driver = driver;
    }
    //методы для работы с элементами главной страницы

    //ожидание загрузки страницы
    public void waitForLoadButtons() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='Button_Button__ra12g']")));
    }

    //клик по кнопке куки
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    //клик по кнопке "заказать" вверху страницы
    public void clickUpperOrderButton() {
        driver.findElement(upperOrderButton).click();
    }

    //клик по кнопке "заказать" внизу страницы
    public void clickLowerOrderButton() {
        WebElement element1 = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element1);
        driver.findElement(lowerOrderButton).click();
    }

    //прокрутка до таблицы с вопросами о важном
    public void scrollToQuestions() {
        WebElement element2 = driver.findElement(tabelWithQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element2);
    }


}
