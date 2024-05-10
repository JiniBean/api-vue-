package kr.co.rland.api.controller;

import kr.co.rland.api.entity.Menu;
import kr.co.rland.api.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("menus")
public class MenuController {

    @Autowired
    private MenuRepository repository;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public List<Menu> list(
            @RequestParam(name = "p", required = false, defaultValue = "0") Integer page
            , @RequestParam(name = "s", required = false, defaultValue = "6") Integer size
            , @RequestParam(name = "e", required = false) String engName
    ) {
        //org.springframework.data.domain.Pageable 이니까 주의 같은 이름이 많음.
        //Sort.by("reg_date").descending() 명령어를 통해서 data-set sort 가능, Sort.by 쓸 때에는 DB 컬럼명이 아닌, Entity의 속성명으로 작성해야 함.
        Pageable pageable = PageRequest.of(page, size, Sort.by("engName").descending().and(Sort.by("regDate")));

        //pageable이 반환하는 건, Page<Menu> 형태로 반환. 따라서 List<Menu>에 바로 담을 수 없음.
        Page<Menu> menuPage = null;
        if(engName !=null)
            menuPage= repository.findByEngNameLike("%"+engName+"%", pageable);
        else
            menuPage = repository.findAll(pageable);

        List<Menu> list = menuPage.getContent();


        return list;
    }


    @GetMapping("/search/{engName}")
    public List<Menu> findByEngName(@PathVariable String engName){
        Pageable pageable = PageRequest.of(1,10, Sort.by("engName").descending().and(Sort.by("regDate")));
        Page<Menu> menuPage = repository.findByEngNameLike("%"+engName+"%", pageable);
        List<Menu> list = menuPage.getContent();

        return list;
    }

//    @GetMapping("{id}")
//    public Menu item(@PathVariable Long id){
//        Menu menu = new Menu();
//        return menu;
//    }
}
