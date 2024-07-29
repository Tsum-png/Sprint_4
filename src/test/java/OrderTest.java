import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.Main;
import PageObject.Order;
import PageObject.Rent;

@RunWith(Parameterized.class)
public class OrderTest {

    private WebDriver driver;

    private final String newName;
    private final String newSurname;
    private final String newAddress;
    private final String newTelephoneNumber;
    private final String newDate;
    private final String newCom;

    public OrderTest(String newName, String newSurname, String newAddress, String newTelephoneNumber,
                     String newDate, String newCom) {
        this.newName = newName;
        this.newSurname = newSurname;
        this.newAddress = newAddress;
        this.newTelephoneNumber = newTelephoneNumber;
        this.newDate = newDate;
        this.newCom = newCom;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Олежа", "Букин", "домовая 24", "+78528955614", "28.05.2024", "Привезите быстро"},
                {"Вася", "Пупкин", "Лиственная 24", "+79232487510", "02.09.2024", "Привезите медленно"},
        };
    }

    @Test
    public void upOrderTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new Main(driver).waitForLoadButtons();
        new Main(driver).clickCookieButton();
        new Main(driver).clickUpperOrderButton();
        new Order(driver).waitForLoadPage();
        new Order(driver).enterInputName(newName);
        new Order(driver).enterSurname(newSurname);
        new Order(driver).enterAddress(newAddress);
        new Order(driver).enterSubwayStation();
        new Order(driver).enterTelephoneNumber(newTelephoneNumber);
        new Order(driver).clickFurtherButton();
        new Rent(driver).enterData(newDate);
        new Rent(driver).clickRentalPeriod();
        new Rent(driver).clickRental();
        new Rent(driver).clickBlackColour();
        new Rent(driver).clickGrayColour();
        new Rent(driver).comment(newCom);
        new Rent(driver).clickOrderBuy();
        new Rent(driver).waitOrderWindow();
        new Rent(driver).clickButtonYes();
        new Rent(driver).waitCheckOrder();
        driver.quit();
}

    @Test
    public void downOrderTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new Main(driver).waitForLoadButtons();
        new Main(driver).clickCookieButton();
        new Main(driver).clickLowerOrderButton();
        new Order(driver).waitForLoadPage();
        new Order(driver).enterInputName(newName);
        new Order(driver).enterSurname(newSurname);
        new Order(driver).enterAddress(newAddress);
        new Order(driver).enterSubwayStation();
        new Order(driver).enterTelephoneNumber(newTelephoneNumber);
        new Order(driver).clickFurtherButton();
        new Rent(driver).enterData(newDate);
        new Rent(driver).clickRentalPeriod();
        new Rent(driver).clickRental();
        new Rent(driver).clickBlackColour();
        new Rent(driver).clickGrayColour();
        new Rent(driver).comment(newCom);
        new Rent(driver).clickOrderBuy();
        new Rent(driver).waitOrderWindow();
        new Rent(driver).clickButtonYes();
        new Rent(driver).waitCheckOrder();
        driver.quit();
    }
}
