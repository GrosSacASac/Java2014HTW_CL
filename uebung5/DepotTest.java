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
public class StockTest {

    
    @Test
    public void constructor() {
    	try {
    		new Stock(100);
    	} except (Error e) {
    		fail("construcor with an int");
    	}
    }
    
    @Test
    public void constructor2() {
    	try {
    		new Stock();
    	} except (Error e) {
    		fail("basic constructor doesn't work !");
    	}
    }

    @Test
    public void store1Article() {
    	Stock stock = new Stock();
    	Article article1 = new Article(1234,10,15,"a");
    	stock.addArticle(article1);
    	Article article2 = stock.articleFromNumber(1234);
    	assertSame(article2,article1,"Failed save article in stock")
    }

    @Test
    public void store1ArticleThenDelete() {
    	Stock stock = new Stock();
    	Article article1 = new Article(1234,10,15,"a");
    	stock.addArticle(article1);
    	stock.deleteArticle(1234);
    	Article article2 = stock.articleFromNumber(1234);
    	assertEquals(article2,null,"Failed delete article in stock")
    }

    @Test
    public void augmentPriceArticleAll() {
    	Stock stock = new Stock();
    	Article article1 = new Article(1234,100,15,"a");
    	stock.addArticle(article1);
    	Article article2 = new Article(1234,200,15,"a");
    	stock.addArticle(article2);
    	stock.augmentPriceArticleAll((byte)50);
    	assertEquals(article1.getPrice,150,"Failed augmentPriceArticleAll");
    	assertEquals(article2.getPrice,300,"Failed augmentPriceArticleAll");
    }

    @Test
    @Ignore
    public void thisIsIgnored() {
    }
}