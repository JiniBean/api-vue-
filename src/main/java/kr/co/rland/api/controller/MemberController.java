package kr.co.rland.api.controller;

import kr.co.rland.api.entity.Member;
import kr.co.rland.api.entity.MemberRole;
import kr.co.rland.api.entity.MemberRoleId;
import kr.co.rland.api.repository.MemberRepository;
import kr.co.rland.api.repository.MemberRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("members")
public class MemberController {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private MemberRoleRepository roleRepository;

    //api/members/email/newlec@newlecture.com
    @GetMapping("email/{email}")
    ResponseEntity<Member> getByEmail(@PathVariable String email) {
        Member member = repository.findByEmail(email);

        if (member != null)
            return ResponseEntity.ok(member);


//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(member);

//      return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(member);

        return ResponseEntity.notFound().build();
    }

//    @GetMapping()
//    public List<MemberRole> getRolesById(Long memberId, Long roleId){
//       MemberRoleId memberRoleId = MemberRoleId.builder().id(roleId).memberId(memberId).build();
//       List<MemberRole> memberRoles = roleRepository.findAllById(memberRoleId);
//    }

}
