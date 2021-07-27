package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MemberController {
  private final MemberService memberService;


  //생성자주입
  @Autowired //자동으로 controller와 service와 연결
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/members/new")
  public String createForm(){
    return "members/createMemberForm";
  }

  @PostMapping("/members/new")
  public String create(MemberForm form){
    Member member = new Member();
    member.setName(form.getName().toString());

    System.out.println("member = " + member.getName());
    memberService.join(member);
    return "redirect:/";
  }

  @GetMapping("/members")
  public String List(Model model){
    List<Member> members = memberService.findMembers();
    model.addAttribute("members", members);
    return "members/memberList";
  }
}
