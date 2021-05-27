package repository;

import domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);

        int lastProduct = tmp.length - 1;
        tmp[lastProduct] = product;
        products = tmp;

    }

    public Product[] getAll() {
        return products;
    }

    public void removeById(int id) {
        if (products.length == 0) {
            return;
        }

        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if ((product.getId() != id)) {
                tmp[index] = product;
            }
        }
        products = tmp;

    }


}
