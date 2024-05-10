package kr.co.rland.api.controller;

import kr.co.rland.api.entity.Category;
import kr.co.rland.api.entity.Menu;
import kr.co.rland.api.repository.CategoryRepository;
import kr.co.rland.api.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private ListCrudRepository<Category, Long> repository;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public List<Category> list() {

        return repository.findAll();
    }

}
