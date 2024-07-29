package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Order {
    private WebDriver driver;
    //поле "имя"
    private By nameField = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");
    //поле "фамилия"
    private By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    //поле "адрес"
private By address = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    //поле "станция метро"
private By subwayStation = By.xpath(".//input[@placeholder='* Станция метро']");
//список станций метро
    private By stations = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]/button");
    //поле "телефон"
private By telephoneNumber = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    //кнопка "далее"
private By furtherButton = By.cssSelector(".Button_Middle__1CSJM");
    public Order(WebDriver driver) {
        this.driver = driver;}
//методы для работы с элементами страницы заказа
    //ожидание загрузки страницы
public void waitForLoadPage(){
    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(3));
    wait3.until(ExpectedConditions.visibilityOfElementLocated(nameField));
}
    //заполнить поле "имя"
    public void enterInputName(String newName) {
        driver.findElement(nameField).sendKeys(newName);
    }
    //заполнить поле "фамилия"
    public void enterSurname(String newSurname) {
        driver.findElement(surname).sendKeys(newSurname);
    }
    //заполнить поле адресс
    public void enterAddress(String newAddress) {
        driver.findElement(address).sendKeys(newAddress);
    }
    //заполнить поле "станция метро"
    public void enterSubwayStation() {
        driver.findElement(subwayStation).click();
        driver.findElement(stations).click();

    }
    //заполнить поле "телефон"
    public void enterTelephoneNumber(String newTelephoneNumber) {
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(telephoneNumber));
        driver.findElement(telephoneNumber).sendKeys(newTelephoneNumber);
    }
    //клик по кнопке "далее"
    public void clickFurtherButton() {
        driver.findElement(furtherButton).click();
    }

    }
