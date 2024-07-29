package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Rent {
    private WebDriver driver;
    //поле "когда привезти самокат"
private By data = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input");
    //поле срока аренды
private By rentalPeriod = By.className("Dropdown-control");
    //список сроков аренды
private By rental = By.cssSelector("div.Dropdown-option:nth-child(1)");
    //цвет самоката "чёрный жемчуг"
private By blackColour = By.id("black");
    //цвет самоката "серая безысходность"
    private By grayColour = By.id("grey");
    //поле комментария
private By comment = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");
    //кнопка заказать
private By orderBuy = By.cssSelector("button.Button_Middle__1CSJM:nth-child(2)");
    //окно "хотите оформит заказ?"
private By orderWindow = By.className("Order_Modal__YZ-d3");
    //кнопка "да"
private By buttonYes = By.cssSelector("div.Order_Buttons__1xGrp:nth-child(2) > button:nth-child(2)");
    //окно "заказ оформлен"
private By checkOder = By.className("Order_ModalHeader__3FDaJ");
   public Rent(WebDriver driver) {
        this.driver = driver;
   }
    //методы для работы с элементами страницы заказа

    //заполнить поле "когда привезти самокат"
    public void enterData(String newDate) {
        driver.findElement(data).sendKeys(newDate);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]")).click();
    }
    //клик по полю срока аренды
    public void clickRentalPeriod() {
        driver.findElement(rentalPeriod).click();
    }
    //клик на "сутки"
    public void clickRental() {
        driver.findElement(rental).click();
    }
    //клик на чёрный цвет самоката
    public void clickBlackColour() {
        driver.findElement(blackColour).click();
    }
    //клик на серый цвет самоката
    public void clickGrayColour() {
        driver.findElement(grayColour).click();
    }
    //заполнить поле "комментарий"
    public void comment(String newCom) {
        driver.findElement(comment).sendKeys(newCom);
    }
    //клик на кнопку "заказать"
    public void clickOrderBuy() {
        driver.findElement(orderBuy).click();
    }
    //ожидание появления окна "хотите оформить заказа?"
    public void waitOrderWindow() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement orderModal = wait1.until(ExpectedConditions.visibilityOfElementLocated(orderWindow));
    }
    //клик на кнопку "да"
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }
    //проверка, что появилось сообщение о том, что заказ оформлен
    public void waitCheckOrder(){
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement orderCheck = wait2.until(ExpectedConditions.visibilityOfElementLocated(checkOder));
    }


}
