package zorrillo.reto2.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zorrillo.reto2.model.Order;
import zorrillo.reto2.repository.crud.OrderCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public Order save(Order order) {
        return orderCrudRepository.save(order);
    }

    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(Integer id) {
        return orderCrudRepository.findById(id);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }

    public List<Order> getOrderZone(String zone) {
        return orderCrudRepository.getOrderZone(zone);
    }

    // Consulta Orden por Id del vendedor Reto4 FG
    public List<Order> getSaleManId(Integer id) {
        return orderCrudRepository.findBySalesManId(id);
    }

    // Consulta Orden por status y Id del vendedor Reto4 FG
    public List<Order> getSaleManIdAndStatus(Integer id, String status) {
        return orderCrudRepository.findBySalesManIdAndStatus(id, status);
    }

    // Consulta Orden por fecha de Registro y Id del vendedor Reto4 FG
    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id) {
        try {
            return orderCrudRepository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
