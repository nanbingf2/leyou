package com.leyou.service.item.service;

import com.leyou.service.item.mapper.CategoryMapper;
import com.leyou.service.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author rogercw
 * @Date 2019/3/8
 * @Version 1.0
 **/
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> findListByParentId(Long parentId){
        Category category=new Category();
        category.setParentId(parentId);
        List<Category> categoryList = categoryMapper.select(category);
        return categoryList;
    }
}
