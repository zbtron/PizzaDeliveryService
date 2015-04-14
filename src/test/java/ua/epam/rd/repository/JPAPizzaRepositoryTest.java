package ua.epam.rd.repository;

import ua.epam.rd.repository.template.UTRepositoryTestsTemplate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;

import ua.epam.rd.domain.Order;
import ua.epam.rd.domain.Pizza;
import ua.epam.rd.domain.PizzaType;

public class JPAPizzaRepositoryTest extends UTRepositoryTestsTemplate {

	private static final Logger logger = LogManager.getLogger(JPAPizzaRepositoryTest.class);
	
    @Autowired
    private PizzaRepository pizzaRepository;

//    @Test
//    public void testSave() {
//    	
//    	// !!! clean table before and after every test
//    	
//    	jdbcTemplate.execute("insert ...");
//    	
//        Pizza pizza = new Pizza();
//        pizza.setName("Meet");
//        pizza.setType(PizzaType.MEET);
//        pizza.setPrice(123.1);        
//    	
//        Order order = new Order();
//        order.addItems(pizza, pizza);
//        orderRepository.save(order);
//        
//        assertNotNull(id);
//        
 //       fail("The test case is a prototype.");
//    
//   }
    
    @Test
    public void saveIfInputNewPizzaThenReturnNotNull() {
    	logger.info("saveIfInputNewPizzaThenReturnNotNull() started");
    	
        Pizza pizza = new Pizza();
        pizza.setName("Meet");
        pizza.setType(PizzaType.MEET);
        pizza.setPrice(123.1);        
        
        Long id = pizzaRepository.save(pizza);
        System.out.println("actual: " + id);
        
        assertNotNull(id);
        
 //       fail("The test case is a prototype.");
    }

    @Test
    public void getPizzaByIdIfInputPizzaIdThenReturnThisPizza() {
    	logger.info("getPizzaByIdIfInputPizzaIdThenReturnThisPizza() started");
        Pizza pizza = new Pizza();
        pizza.setName("Meet");
        pizza.setType(PizzaType.MEET);
        pizza.setPrice(123.1);        
        
        pizzaRepository.save(pizza);

        Long expected = pizza.getId();
        System.out.println("expected: " + expected);
        Long actual = pizzaRepository.getPizzaById(pizza.getId()).getId();
        System.out.println("actual: " + actual);
        
        assertEquals(expected, actual);
 
 //       fail("The test case is a prototype.");
    }

    @Test
    public void updateIfInputPizzaForUpdateThenGetUpdatedPizzaPromDb() {
    	logger.info("updateIfInputPizzaForUpdateThenGetUpdatedPizzaPromDb() started");
        Pizza pizza = new Pizza();
        pizza.setName("Meet");
        pizza.setType(PizzaType.MEET);
        pizza.setPrice(123.1);        
        
        pizzaRepository.save(pizza);
        pizza.setType(PizzaType.TOMATO);
        pizzaRepository.update(pizza);
        
        PizzaType expected = PizzaType.TOMATO;
        System.out.println("expected: " + expected);
        PizzaType actual = pizzaRepository.getPizzaById(pizza.getId()).getType();
        System.out.println("actual: " + actual);
        
        assertEquals(expected, actual);
        
//        fail("The test case is a prototype.");
    }

    @Test
    public void deleteIfInputPizzaForDeleteThenReturnNull() {
    	logger.info("deleteIfInputPizzaForDeleteThenReturnNull() started");
        Pizza pizza = new Pizza();
        pizza.setName("Meet");
        pizza.setType(PizzaType.MEET);
        pizza.setPrice(123.1);        
        
        pizzaRepository.save(pizza);
        Long id = pizza.getId();
        pizzaRepository.delete(pizza);
        
        System.out.println(id);
        Object actual = pizzaRepository.getPizzaById(id);
        System.out.println("actual: " + actual);
        
        assertNull(actual);
        
//       fail("The test case is a prototype.");
    }

}
