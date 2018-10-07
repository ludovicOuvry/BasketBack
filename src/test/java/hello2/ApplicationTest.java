package hello2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hello.Application;
import hello.ProductController;
import hello.Provider;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = Application.class)
public class ApplicationTest {
	/* test d'execution */    
    @Autowired
    private ProductController controller;
    
    @Test
    public void testctrl() throws Exception {
        assertThat(controller).isNotNull();
    }
    

 

    @Test
    public void testGet() throws Exception {
    	controller.getProviderRepo().deleteAll();
    	controller.getProviderRepo().save(new Provider("test", 10));
    	Iterable<Provider> liste =controller.get();
    
    	for (Provider p : liste){
    		assertEquals(p.getName(), "test");
    		assertEquals(p.getAmount(), 10);
    	}
    }

}