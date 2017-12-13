package compofinalproject.demo.controller;

import compofinalproject.demo.entity.Cart;
import compofinalproject.demo.entity.Product;
import compofinalproject.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    CartService cartService;

    @CrossOrigin
    @GetMapping("/cart")
    public ResponseEntity<?> getCarts() {
        List<Cart> carts = cartService.getCarts();
        return ResponseEntity.ok(carts);
    }

    @PutMapping("/Cart")
    public Cart updateCart(@RequestBody Cart cart){
        return cartService.updateCart(cart);
    }
}
