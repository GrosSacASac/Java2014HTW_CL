package com.example.foo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link Depot}.
 *
 */
public class DepotTest {

    
    @Test
    public void constructor() {
    	try {
    		new Depot(100);
    	} except (Error e) {
    		fail("construcor with an int");
    	}
    }
    
    @Test
    public void constructor2() {
    	try {
    		new Depot();
    	} except (Error e) {
    		fail("basic constructor doesn't work !");
    	}
    }

    @Test
    public void store1Article() {
    	Depot depot = new Depot();
    	Article article1 = new Article(1234,10,15,"a");
    	depot.addArticle(article1);
    	Article article2 = depot.articleFromNumber(1234);
    	assertSame(article2,article1,"Failed save article in depot")
    }

    @Test
    public void store1ArticleThenDelete() {
    	Depot depot = new Depot();
    	Article article1 = new Article(1234,10,15,"a");
    	depot.addArticle(article1);
    	depot.deleteArticle(1234);
    	Article article2 = depot.articleFromNumber(1234);
    	assertEquals(article2,null,"Failed delete article in depot")
    }

    @Test
    public void augmentPriceArticleAll() {
    	Depot depot = new Depot();
    	Article article1 = new Article(1234,100,15,"a");
    	depot.addArticle(article1);
    	Article article2 = new Article(1234,200,15,"a");
    	depot.addArticle(article2);
    	depot.augmentPriceArticleAll((byte)50);
    	assertEquals(article1.getPrice,150,"Failed augmentPriceArticleAll");
    	assertEquals(article2.getPrice,300,"Failed augmentPriceArticleAll");
    }

    @Test
    @Ignore
    public void thisIsIgnored() {
    }
}