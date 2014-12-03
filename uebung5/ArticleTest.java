package com.example.foo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link Stock}.
 *
 */
public class ArticleTest {
    
    Article article1;
    
    @before
    public Article createArticleNormal() {
    	int number = 1229;
    	double price = 100.0;
    	int stock = 5;
    	String description = "a";
    	this.article1 = new Article(number,price,stock,description);
    }
    
    
    @Test
    public void constructor2() {
    	int number = 1229;
    	double price = 100.0;
    	String description = "a";
    	try {
    		new Article(number,price,description);
    	} except (Error e) {
    		fail("construcor with 3!");
    	}
    }
    
    @Test (expected = NumberTooBigException.class)
    public void constructorNumberTooBigException() {
    	int number = 1225559;
    	double price = 100.0;
    	String description = "a";
    	new Article(number,price,description);
    }
    
    @Test (expected = NumberTooSmallException.class)
    public void constructorNumberTooSmallException() {
    	int number = 129;
    	double price = 100.0;
    	String description = "a";
    	new Article(number,price,description);
    }
    
    @Test (expected = NegativePriceException.class)
    public void constructorNegativePriceException() {
    	int number = 1209;
    	double price = -100.0;
    	String description = "a";
    	new Article(number,price,description);
    }
    
    @Test (expected = VoidDescriptionException.class)
    public void constructorVoidDescriptionException() {
    	int number = 129;
    	double price = 100.0;
    	String description = "";
    	new Article(number,price,description);
    }
    
    @Test (expected = NegativeStockException.class)
    public Article constructorNegativeStockException() {
    	int number = 1229;
    	double price = 100.0;
    	int stock = -5;
    	String description = "a";
    	new Article(number,price,stock,description);
    }
    
    @Test
    public void augmentPrice() {
    	byte x = 50;
    	this.article1.applyPercentagePrice(x);
    	assertEquals(this.article1.getPrice(), 150, 0.001, "incorrect percentage calculation");
    }

    @Test
    public void reducePrice() {
    	byte x = -50;
    	this.article1.applyPercentagePrice(x);
    	assertEquals(this.article1.getPrice(), 50, 0.001, "incorrect percentage calculation");
    }
    
    @Test
    public void setPrice() {
    	int x = 99;
    	this.article.setPrice(x);
    	assertEquals(this.article1.getPrice(), 99, 0.001, "incorrect");
    }
    
    @Test (expected = NegativePriceException.class)
    public void setPrice() {
    	int x = -99;
    	this.article.setPrice(x);
    }
    
    @Test 
    @Ignore
    public void testToString() {
    //not finished
        assertEquals(""+this.article,"Article: 1229 Price: 100 description:  stock: ","toString make it display correctly");
    }

    @Test
    public void augmentStock() {
    	int x = 50;
    	this.article1.augmentStock(x);
    	assertEquals(this.article1.getStock(), 55, "incorrect");
    }

    @Test (expected = IllegalArgumentException.class)
    public void augmentStock() {
    	int x = -50;
    	this.article1.augmentStock(x);
    }

    @Test
    public void reduceStock() {
    	int x = 3;
    	this.article1.reduceStock(x);
    	assertEquals(this.article1.getStock(), 2, "incorrect ");
    }
    
    @Test (expected = NegativeStockException.class)
    public void reduceStock() {
    	int x = 1000;
    	this.article1.reduceStock(x);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void reduceStock() {
    	int x = -3;
    	this.article1.reduceStock(x);
    }
    
    @Test
    public void setDescription() {
    	String x = "New des";
    	this.article1.setDescription(x);
    	assertEquals(this.article1.getDescription(), x, "incorrect setDescription");
    }

    @Test
    @Ignore
    public void thisIsIgnored() {
    }
}