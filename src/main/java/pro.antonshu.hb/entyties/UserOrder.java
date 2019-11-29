package pro.antonshu.hb.entyties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_orders")
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "product_cost_at_order_time")
    private Long product_cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(Long product_cost) {
        this.product_cost = product_cost;
    }

    public UserOrder() {
    }

    public UserOrder(Long id, Long user_id, Long product_id, Long product_cost) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.product_cost = product_cost;
    }
}
