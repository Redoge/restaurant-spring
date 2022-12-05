package app.redoge.restaurant.service;


import app.redoge.restaurant.entity.OrderStatus;
import app.redoge.restaurant.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusService {
    @Autowired
    private OrderStatusRepository orderStatusDAO;

    public void save(OrderStatus orderStatus) {
        orderStatusDAO.save(orderStatus);
    }
    public List<OrderStatus> getAllOrderStatus() {
        return orderStatusDAO.findAll();
    }

    public OrderStatus getOrderStatusById(Long id) {
        return orderStatusDAO.findById(id).orElse(new OrderStatus());
    }
}
