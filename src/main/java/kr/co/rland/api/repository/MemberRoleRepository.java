package kr.co.rland.api.repository;


import kr.co.rland.api.entity.MemberRole;
import kr.co.rland.api.entity.MemberRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRoleRepository extends JpaRepository<MemberRole, MemberRoleId> {

//    @Query("from MemberRole where ")
//    MemberRole findByIds(Long memberId, Long roleId );
}
