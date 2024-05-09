package kr.co.rland.api.repository;

import kr.co.rland.api.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> { //구현해야할 걸 미리 정해뒀으니 물려받아라 <어느 엔티티, 엔티티식별자의 자료형>
}
