package compofinalproject.demo.service;

import compofinalproject.demo.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCarts();
    Cart addCart(Cart cart);
    Cart updateCart(Cart cart);
}
