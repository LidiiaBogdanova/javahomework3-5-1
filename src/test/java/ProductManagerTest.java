import domain.Book;
import domain.Product;
import domain.Smartphone;
import manager.ProductManager;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    ProductManager manager = new ProductManager(new ProductRepository());

    @Test
    public void IfArrayNothing() {
        Product[] products = manager.searchBy("Pupkin");
        assertEquals(0, products.length);
    }
    @Test
    public void IfArrayWithoutCorrectTypes() {
        Product product=new Product();
        manager.add(product);
        Product[] products = manager.searchBy("Pupkin");
        assertEquals(0, products.length);
    }

    @Test
    public void IfArrayWithOneBookCorrectSearch() {
        Book book1 = new Book(1, "Kolobok", 100, "Pupkin");
        manager.add(book1);
        Product[] products = manager.searchBy("Pupkin");
        assertEquals(1, products.length);
        assertSame(book1, products[0]);

    }
    @Test
    public void IfArrayWithOneBookIncorrectSearch() {
        Book book1 = new Book(1, "Kolobok", 100, "Pupkin");
        manager.add(book1);
        Product[] products = manager.searchBy("Pushkin");
        assertEquals(0, products.length);
    }
    @Test
    public void IfArrayWithOneSmartphoneCorrectSearchName() {
        Smartphone smartphone=new Smartphone(1,"Iphone11", 100500,"Apple");
        manager.add(smartphone);
        Product[] products = manager.searchBy("Iphone");
        assertEquals(1, products.length);
        assertSame(smartphone, products[0]);
    }
    @Test
    public void IfArrayWithOneSmartphoneInCorrectSearchName() {
        Smartphone smartphone=new Smartphone(1,"Iphone11", 100500,"Apple");
        manager.add(smartphone);
        Product[] products = manager.searchBy("Samsung");
        assertEquals(0, products.length);
    }
    @Test
    public void IfArrayWithOneSmartphoneCorrectSearchProducer() {
        Smartphone smartphone=new Smartphone(1,"Iphone11", 100500,"Apple");
        manager.add(smartphone);
        Product[] products = manager.searchBy("Apple");
        assertEquals(1, products.length);
        assertSame(smartphone, products[0]);
    }
    @Test
    public void IfArrayMixedDifferentNamesCorrectSearch(){
        Book book1 = new Book(1, "Kolobok", 100, "Pupkin");
        manager.add(book1);
        Smartphone smartphone=new Smartphone(1,"Iphone11", 100500,"Apple");
        manager.add(smartphone);
        Product[] products= manager.searchBy("Pupkin");
        assertEquals(1, products.length);
    }
    @Test
    public void IfArrayMixedDifferentNamesInCorrectSearch(){
        Book book1 = new Book(1, "Kolobok", 100, "Pupkin");
        manager.add(book1);
        Smartphone smartphone=new Smartphone(1,"Iphone11", 100500,"Apple");
        manager.add(smartphone);
        Product[] products= manager.searchBy("Pushkin");
        assertEquals(0, products.length);
    }
    @Test
    public void IfArrayMixedSameNamesCorrectSearch(){
        Book book1 = new Book(1, "Iphone11", 100, "Pupkin");
        manager.add(book1);
        Smartphone smartphone=new Smartphone(1,"Iphone11", 100500,"Apple");
        manager.add(smartphone);
        Product[] products= manager.searchBy("Iphone11");
        assertEquals(2, products.length);
    }
    @Test
    public void IfArrayMixedSameNamesInCorrectSearch(){
        Book book1 = new Book(1, "Kolobok", 100, "Pupkin");
        manager.add(book1);
        Smartphone smartphone=new Smartphone(1,"Iphone11", 100500,"Apple");
        manager.add(smartphone);
        Product[] products= manager.searchBy("Samsung");
        assertEquals(0, products.length);
    }


}
