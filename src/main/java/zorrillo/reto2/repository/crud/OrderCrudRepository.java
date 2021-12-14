package zorrillo.reto2.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import zorrillo.reto2.model.Order;

public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
    //Consultar por zonas
    //{"salesMan.zone":{$eq:"?0"}}
    @Query("{'salesMan.zone':{$eq:'?0'}}")
    public List<Order> getOrderZone(String zone);
    
    //Consultar ordenes por ID del vendedor Reto4 FG
    public List<Order> findBySalesManId(Integer id);
    
    //Consultar ordenes por status y id del vendedor Reto4 FG
    public List<Order> findBySalesManIdAndStatus(Integer id, String status);
    
    //Consultar ordenes por fecha registro y id del vendedor Reto4 FG
    public List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
}
