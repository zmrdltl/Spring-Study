package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
  private final MemberRepository memberRepository;

  @Autowired
  public SpringConfig(MemberRepository memberRepository){
    this.memberRepository = memberRepository;
  }
  //private DataSource dataSource;

//  @Autowired
//  public SpringConfig(DataSource dataSource) {
//    this.dataSource = dataSource;
//  }
//  @PersistenceContext
//  private EntityManager em;
//  @Autowired
//  public SpringConfig(EntityManager em) {
//    this.em = em;
//  }

  @Bean
  public MemberService memberService(){
    return new MemberService(memberRepository);
  }
//
//  @Bean
//  public TimeTraceAop timeTraceAop() {
//    return new TimeTraceAop();
//  }
//  @Bean
//  public MemberRepository memberRepository(){
    //return new JdbcMemberRepository(dataSource);
    //return new JdbcTemplateMemberRepository(dataSource);
//    return new JpaMemberRepository(em);
//  }
}