package com.leyou.service.item.controller;

import com.leyou.common.vo.PageResult;
import com.leyou.service.item.pojo.Brand;
import com.leyou.service.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author rogercw
 * @Date 2019/3/8
 * @Version 1.0
 **/
@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/page")
    public ResponseEntity<PageResult<Brand>> pageSearch(
            @RequestParam(name = "page",defaultValue = "1") Integer page,
            @RequestParam(name = "rows",defaultValue = "5") Integer size,
            @RequestParam(name = "sortBy",required = false) String sortBy,
            @RequestParam(name = "desc",defaultValue = "false") Boolean isDesc,
            @RequestParam(name = "key",required = false) String key){
        PageResult<Brand> brandList = brandService.findBrandList(page, size, sortBy, isDesc, key);
        if (brandList==null || brandList.getItems().size()==0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(brandList);
    }
}
