package com.expencetracker.resources;

import com.expencetracker.entity.Category;
import com.expencetracker.services.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public String getAllCategories(HttpServletRequest request) {

        int userId = (Integer) request.getAttribute("userId");

        return "Authenticated userId -- " + userId;

    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(HttpServletRequest request, @RequestBody Map<String, Object> categoryMap) {

        Integer userId = (Integer) request.getAttribute("userId");
        String title = (String) categoryMap.get("title");
        String description = (String) categoryMap.get("description");


        Category category = categoryService.addCategory(userId, title, description);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
}
