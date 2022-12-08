package no.shoppifly;

import io.micrometer.core.instrument.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController()
public class ShoppingCartController implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private final CartService cartService;

    private MeterRegistry meterRegistry;

    private Counter checkOutCounter;
    private Timer checkOutTimer;


    @Autowired
    public ShoppingCartController(CartService cartService, MeterRegistry meterRegistry) {
        this.cartService = cartService;
        this.meterRegistry = meterRegistry;
        checkOutCounter = meterRegistry.counter("checkouts");
        checkOutTimer = meterRegistry.timer("checkout_latency");
    }



    @GetMapping(path = "/cart/{id}")
    public Cart getCart(@PathVariable String id) {
        return cartService.getCart(id);
    }

    /**
     * Checks out a shopping cart. Removes the cart, and returns an order ID
     *
     * @return an order ID
     */


    @PostMapping(path = "/cart/checkout")
    public Map checkout(@RequestBody Cart cart) {

        //Slik som jeg har forstått det så skal resultatet(sum) vises etter 1 time
        checkOutCounter.increment();

        //checkout_latency. thread.sleep for å få litt store verdier
        long time = System.currentTimeMillis();
        String id = cartService.checkout(cart);
        try {
            Thread.sleep(100l);
        }
        catch (Exception ex){

        }
        time = System.currentTimeMillis() - time;

        checkOutTimer.record(Duration.ofMillis(time));

        Map<String, Object> map = new HashMap<>();
        map.put("cartId",id);
        map.put("responseTime", time);
        return map;
    }

    /**
     * Updates a shopping cart, replacing it's contents if it already exists. If no cart exists (id is null)
     * a new cart is created.
     *
     * @return the updated cart
     */
    @PostMapping(path = "/cart")
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.update(cart);
    }

    /**
     * return all cart IDs
     *
     * @return
     */
    @GetMapping(path = "/carts")
    public List<String> getAllCarts() {
        return cartService.getAllsCarts();
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Gauge.builder("cart_count", cartService,
                c -> c.getAllsCarts().size()).register(meterRegistry);

        //penger
        Gauge.builder("cartsvalue", cartService,
                c -> c.total()).register(meterRegistry);

    }
}