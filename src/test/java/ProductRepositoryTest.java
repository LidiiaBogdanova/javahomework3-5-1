import domain.Book;
import domain.Product;
import exception.NotFoundException;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();

    @Test
    public void ShouldAddedProduct() {
        Book book1 = new Book(1, "Kolobok", 100, "Pupkin");
        repository.save(book1);
        Product[] products = repository.getAll();
        repository.removeById(1);
        products = repository.getAll();
        Product[] expected = new Product[0];
        assertArrayEquals(expected, products);
    }

    @Test
    public void ShouldThrowException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(2));

    }
}
