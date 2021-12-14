package zorrillo.reto2.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import zorrillo.reto2.model.Order;
import zorrillo.reto2.service.OrderService;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }

    @GetMapping("/all")
    public List<Order>getOrder(){
        return orderService.getAll();
    }
    
    @GetMapping("{id}")
    public Optional<Order>getOrder(@PathVariable("id") Integer id){
        return orderService.getOrder(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int orderId){
        return orderService.delete(orderId);
    }

    @GetMapping("/zona/{zone}")
    public List<Order> getOrderZone(@PathVariable("zone") String zone){
        return orderService.getOrderZone(zone);
    }
    
    //Controller traer ordenes por id vendedor para Reto4 FG
    @GetMapping("/salesman/{id}")
    public List<Order> getBySalesmanId(@PathVariable("id") Integer id){
        return orderService.getSalesManId(id);
    }
    
    //Controller traer ordenes por status y id vendedor para Reto4 FG
    @GetMapping("/state/{status}/{id}")
    public List<Order> getBySalesmanIdAndStatus(@PathVariable("status") String status, @PathVariable("id") Integer id){
        return orderService.getSalesManIdAndStatus(id, status);
    }
    
    //Controller traer ordenes por fecha de registro y id vendedor para Reto4 FG
    @GetMapping("/date/{registerDay}/{id}")
    public List<Order> getByRegisterDayAndSalesManId(@PathVariable("registerDay") String registerDay, @PathVariable("id") Integer id){
        return orderService.getByRegisterDayAndSalesManId(registerDay, id);
    }
}
