package com.xz.cloud.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 
 * @TableName t_storage
 */
@Table(name = "t_storage")
public class Storage implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;

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
     * 总库存
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 总库存
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 已用库存
     */
    public Integer getUsed() {
        return used;
    }

    /**
     * 已用库存
     */
    public void setUsed(Integer used) {
        this.used = used;
    }

    /**
     * 剩余库存
     */
    public Integer getResidue() {
        return residue;
    }

    /**
     * 剩余库存
     */
    public void setResidue(Integer residue) {
        this.residue = residue;
    }


}