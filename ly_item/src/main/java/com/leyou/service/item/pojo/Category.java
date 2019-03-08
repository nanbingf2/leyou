package com.leyou.service.item.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author rogercw
 * @Date 2019/3/8
 * @Version 1.0
 **/
@Entity
@Data
@Table(name = "tb_category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long parentId;

    private Boolean isParent;

    private Integer sort;

}
