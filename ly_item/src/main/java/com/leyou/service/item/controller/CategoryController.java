package com.leyou.service.item.controller;

import com.leyou.service.item.pojo.Category;
import com.leyou.service.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author rogercw
 * @Date 2019/3/8
 * @Version 1.0
 **/
@RestController
@RequestMapping("category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/list")
    public ResponseEntity<List<Category>> findListByParentId(@RequestParam(value = "pid",defaultValue = "0") Long parentId){
        if(parentId == null ||parentId <0){
            // pid为null或者小于等于0，响应400
            return ResponseEntity.badRequest().build();
        }
        List<Category> categoryList = categoryService.findListByParentId(parentId);
        if (categoryList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryList);
    }
}
