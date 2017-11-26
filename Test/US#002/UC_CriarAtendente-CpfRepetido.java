package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UCCriarAtendenteCpfRepetido {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://mfs-eir.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUCCriarAtendenteCpfRepetido() throws Exception {
    driver.get(baseUrl + "/atendente");
    driver.findElement(By.linkText("EIR")).click();
    driver.findElement(By.linkText("Cadastro de Atendente")).click();
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Loncas");
    driver.findElement(By.name("cpf")).clear();
    driver.findElement(By.name("cpf")).sendKeys("lion");
    driver.findElement(By.name("matricula")).clear();
    driver.findElement(By.name("matricula")).sendKeys("039393");
    new Select(driver.findElement(By.name("unidade"))).selectByVisibleText("teste - 0");
    driver.findElement(By.name("telefone")).clear();
    driver.findElement(By.name("telefone")).sendKeys("3030302");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("00009999");
    driver.findElement(By.name("logradouro")).clear();
    driver.findElement(By.name("logradouro")).sendKeys("999999999999999999");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("00009999@ddd");
    driver.findElement(By.name("bairro")).clear();
    driver.findElement(By.name("bairro")).sendKeys("23e23");
    driver.findElement(By.name("complemento")).clear();
    driver.findElement(By.name("complemento")).sendKeys("2323");
    driver.findElement(By.name("cidade")).clear();
    driver.findElement(By.name("cidade")).sendKeys("23452345");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}