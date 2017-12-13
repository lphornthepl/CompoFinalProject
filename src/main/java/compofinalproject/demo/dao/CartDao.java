package compofinalproject.demo.dao;

import compofinalproject.demo.entity.Cart;

import java.util.List;

public interface CartDao {
    List<Cart> getCarts();
    Cart addCart(Cart cart);
    Cart updateCart(Cart cart);
}
