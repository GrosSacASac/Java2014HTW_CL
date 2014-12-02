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

    public Article createArticleNormal() {
    	int number = 1229;
    	double price = 100.0;
    	int stock = 5;
    	String description ="a";
    	return new Article(number,price,stock,description);
    }
    
    @Test
    public void constructor() {
    	int number = 1229;
    	double price = 100.0;
    	int stock = 5;
    	String description ="a";
    	try {
    		new Article(number,price,stock,description);
    	} except (Error e) {
    		fail("construcor with 4");
    	}
    }
    
    @Test
    public void constructor2() {
    	int number = 1229;
    	double price = 100.0;
    	String description ="a";
    	try {
    		new Article(number,price,description);
    	} except (Error e) {
    		fail("construcor with 3!");
    	}
    }

    @Test
    public void augmentPrice() {
    	Article article1 = createArticleNormal();
    	byte x = 50;
    	article1.augmentPrice(x)
    	assertEquals(article1.getPrice(), 150, "incorrect percentage calculation");
    }

    @Test
    public void reducePrice() {
    	Article article1 = createArticleNormal();
    	byte x = 50;
    	article1.reducePrice(x)
    	assertEquals(article1.getPrice(), 50, "incorrect percentage calculation");
    }
    
    @Test
    public void setPrice() {
    	Article article1 = createArticleNormal();
    	int x = 99;
    	article1.setPrice(x)
    	assertEquals(article1.getPrice(), 99, "incorrect");
    }

    @Test
    public void augmentStock() {
    	Article article1 = createArticleNormal();
    	int x = 50;
    	article1.augmentStock(x)
    	assertEquals(article1.getStock(), 55, "incorrect");
    }

    @Test
    public void reduceStock() {
    	Article article1 = createArticleNormal();
    	int x = 3;
    	article1.reduceStock(x)
    	assertEquals(article1.getStock(), 2, "incorrect ");
    }
    
    @Test
    public void setDescription() {
    	Article article1 = createArticleNormal();
    	String x = "New des";
    	article1.setDescription(x)
    	assertEquals(article1.getDescription(), x, "incorrect setDescription");
    }

    @Test
    @Ignore
    public void thisIsIgnored() {
    }
}