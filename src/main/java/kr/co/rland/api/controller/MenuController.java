package kr.co.rland.api.controller;

import kr.co.rland.api.entity.Menu;
import kr.co.rland.api.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("menus")
public class MenuController {

    @Autowired
    private MenuRepository repository;

    @GetMapping
    public List<Menu> list(){

        List<Menu> list = repository.findAll();

        return list;
    }

    @GetMapping("{id}")
    public Menu item(@PathVariable Long id){
        Menu menu = new Menu();
        return menu;
    }
}
