package com.xz.cloud.entity;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 
 * @TableName t_order
 */
@Table(name = "t_order")
@ToString
public class Order implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 金额
     */
    private Long money;

    /**
     * 订单状态: 0:创建中; 1:已完结
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 产品id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 产品id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 金额
     */
    public Long getMoney() {
        return money;
    }

    /**
     * 金额
     */
    public void setMoney(Long money) {
        this.money = money;
    }

    /**
     * 订单状态: 0:创建中; 1:已完结
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 订单状态: 0:创建中; 1:已完结
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

}