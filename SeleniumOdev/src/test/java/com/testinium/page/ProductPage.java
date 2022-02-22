package com.testinium.page;

import com.testinium.methods.Methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ProductPage {

    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage() {
        methods = new Methods();
    }

    public void selectProduct() {
        methods.sendKey(By.id("search-input"), "kitap");
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.click(By.cssSelector(".pr-img-link"));
        methods.scrollWithAction(By.cssSelector(".pr__htabs"));
        methods.selectByText(By.cssSelector("select#review-sort-selection"),"Oylama (Yüksek > Düşük)");
        methods.waitBySeconds(2);
    }

    public void attributeTest(){
        String attribute = methods.getAttribute(By.cssSelector(".logo-text>a>img"),"title");
        System.out.println("Alınan text:"+attribute);
        logger.info("Alınan text:"+attribute);
    }

    public void textControlTest(){
        String text = methods.getText(By.cssSelector(".common-sprite"));
        System.out.println("Alınan text:"+ text);
        logger.info("Alınan text:"+text);
    }

    public void valueControlTest(){
        methods.sendKey(By.id("search-input"),"testinium");
        String value = methods.getValue(By.id("search-input"));
        System.out.println("Alınan deger:"+value);
        logger.info("Alınan deger:"+value);
        Assert.assertEquals("testinium",value);
        methods.waitBySeconds(2);
    }
}
