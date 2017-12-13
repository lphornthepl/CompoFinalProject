package compofinalproject.demo.service;

import compofinalproject.demo.dao.CartDao;
import compofinalproject.demo.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService  {

    @Autowired
    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    CartDao cartDao;

    @Override
    public List<Cart> getCarts() {
        return cartDao.getCarts();
    }

    @Override
    public Cart addCart(Cart cart) {
        return cartDao.addCart(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        return cartDao.updateCart(cart);
    }
}
