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
@Table(name = "tb_brand")
@Data
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    private Character letter;
}
