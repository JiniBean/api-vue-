package kr.co.rland.api.repository;

import kr.co.rland.api.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> { //구현해야할 걸 미리 정해뒀으니 물려받아라 <어느 엔티티, 엔티티식별자의 자료형>
    // 아래와 같이 적은 것은 사용자 Custom 하는 방식임.

    // Custom 해서 사용할 경우, Pageable 기능을 사용하려면 arguments에 Pageable을 추가 해야 함.
    Page<Menu> findByEngNameLike(String engName, Pageable pageable);
}
