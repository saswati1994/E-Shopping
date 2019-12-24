package com.example.shoppingCart.Controller;

import com.example.shoppingCart.Entity.AddToCartDTO;
import com.example.shoppingCart.Entity.Cart;
import com.example.shoppingCart.Entity.Orders;
import com.example.shoppingCart.Entity.Product;
import com.example.shoppingCart.Repository.CartRepository;
import com.example.shoppingCart.Repository.OrderRepository;
import com.example.shoppingCart.Repository.ProductRepository;
import com.example.shoppingCart.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/shop")
public class ShoppingCartController {

  @Autowired
  CartRepository cartRepository;
  @Autowired
  ProductRepository productRepository;
  @Autowired
  OrderRepository orderRepository;

  @PostMapping("/cart")
  public ResponseEntity<Cart> addToCart(@RequestBody AddToCartDTO addToCart) {

    System.out.println("AddToCart POST Called \n" + addToCart);


    Cart cart = new Cart();
    cart.setUserId(addToCart.getUserId());
    cart.setOrders(addToCart.getItems());
      List<Orders> orders = cart.getOrders();
      for(Orders order:orders) {
          if (order.getQuantity() < 0) {
              return new ResponseEntity("quantity cannot be negative", HttpStatus.BAD_REQUEST);

          }
      }
      for(Orders order:orders) {
          if(order.getQuantity() ==0){
              orderRepository.deleteProduct(order.getProductId());
              return new ResponseEntity("product deleted",HttpStatus.BAD_REQUEST);
          }

      }
    Cart searchCart = new Cart();
    searchCart.setUserId(addToCart.getUserId());
    Example<Cart> cartExamle = Example.of(searchCart);
    List<Cart> carts = cartRepository.findAll(cartExamle);

    if (carts.size() != 0) {

      List<Orders> orderPayload = cart.getOrders();
      List<Orders> ordersDb = carts.get(0).getOrders();

      for (Orders order1 : orderPayload) {
          Boolean doInsertNewRecord = true;
        for (Orders order2 : ordersDb) {



          if (order1.getProductId() == order2.getProductId()) {
            Integer quantity = order2.getQuantity() + order1.getQuantity();
              Integer cart_id =order2.getCartId();
            orderRepository.updateAddress(quantity, order2.getProductId(),cart_id);
            doInsertNewRecord = false;
          }

        }
        if(doInsertNewRecord) {
            Orders newOrders = new Orders();
            newOrders.setQuantity(order1.getQuantity());
            newOrders.setProductId(order1.getProductId());
            newOrders.setCartId(carts.get(0).getCartId());
            try{
                orderRepository.save(newOrders);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
      }

    } else {
      try {
        cartRepository.save(cart);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    return new ResponseEntity( HttpStatus.CREATED);
  }

  @DeleteMapping("/cart")
  public ResponseEntity deleteCartItems() {

    cartRepository.deleteAll();

    return new ResponseEntity("all item deleted", HttpStatus.OK);
  }

  @DeleteMapping("/cart/id")
  public ResponseEntity deleteCartItemsByProductId(
      @RequestParam final Long productId) {

    //orderRepository.deleteById(productId);
    orderRepository.deleteProduct(productId);

    return new ResponseEntity("selected item deleted", HttpStatus.OK);
  }
  @PostMapping("cart/update")
  public ResponseEntity updateQuantity(@RequestParam final Integer quantity) {

      return new ResponseEntity("quantity updated", HttpStatus.OK);
  }
  @GetMapping("/cart")
  public ResponseEntity getCartItems(@RequestParam final Long userId) {
     double totalPrice = 0.00;
      List items = new ArrayList();
      Map productDTO = new HashMap<>();
      Cart cartInstance = new Cart();
      cartInstance.setUserId(userId);
     Example<Cart>cartExample =  Example.of(cartInstance);
     try{
        List<Cart> carts =  cartRepository.findAll(cartExample);
        if(carts.size()!=0){
            Integer cartId  = carts.get(0).getCartId();
            List<Orders> orders = orderRepository.getOrder(cartId);
            for(Orders order:orders){
                Product product = productRepository.findById(order.getProductId()).get();
                totalPrice = totalPrice + (product.getPrice() * order.getQuantity());
                Map cartItem =  new HashMap();
                cartItem.put("productDesc",product);
                cartItem.put("quantity",order.getQuantity());
                items.add(cartItem);
            }
            productDTO.put("items",items);
            productDTO.put("totalPrice",totalPrice);

            return new ResponseEntity(productDTO,HttpStatus.OK);
        }else{
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }

     }catch (Exception e){
         System.out.println(e);
         return new ResponseEntity(HttpStatus.BAD_REQUEST);
     }

  }

}