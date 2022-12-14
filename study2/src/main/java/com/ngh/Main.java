package com.ngh;


import com.ngh.domain.*;
import com.ngh.domain.key.ParentIdClass;
import com.ngh.util.EntityTransactionUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("study1");
        EntityTransactionUtil etu = new EntityTransactionUtil(emf);

        etu.doTransaction((EntityManager em) -> {
            logic(em);
            return null;
        });


        etu.doTransaction((EntityManager em) -> {
            proxyTest(em);

            // compositeKey(em);
            // joinStrategy(em); // 조인 전략
            // singleTableStrategy(em); // 단일 테이블 전략
            // tablePerClassStrategy(em); // 구현 클래스마다 테이블 전략
            return null;
        });

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    private static void proxyTest(EntityManager em) {
        Member id1 = em.find(Member.class, "id1");

        em.remove(id1);
        System.out.println(id1.getTeam());

        System.out.println(id1.getAge());

    }

    private static void compositeKey(EntityManager em) {
        ParentIdClassNonIdentify pini = new ParentIdClassNonIdentify();
        pini.setId1("i1");
        pini.setId2("i2");

        em.persist(pini);

        em.find(ParentIdClassNonIdentify.class, new ParentIdClass("i1", "i2"));

        ChildIdClassNonIdentify cini = new ChildIdClassNonIdentify();
        cini.setId("c1");
        cini.setParent(pini);

        em.persist(cini);


    }

    private static void joinStrategy(EntityManager em) {
        NaverJoinStrategy naverJoinStrategy = new NaverJoinStrategy();
        naverJoinStrategy.setSiteId("test");
        naverJoinStrategy.setNickName("nickTest");
        naverJoinStrategy.setCreatedDate(LocalDateTime.now());

        em.persist(naverJoinStrategy);

        DaumJoinStrategy daumJoinStrategy = new DaumJoinStrategy();
        daumJoinStrategy.setSiteId("test");
        daumJoinStrategy.setKakaoId("kakao");

        em.persist(daumJoinStrategy);
    }

    private static void singleTableStrategy(EntityManager em) {
        NaverSingleTableStrategy naverSingleTableStrategy = new NaverSingleTableStrategy();
        naverSingleTableStrategy.setSiteId("test");
        naverSingleTableStrategy.setNickName("nickTest");

        em.persist(naverSingleTableStrategy);
    }

    private static void tablePerClassStrategy(EntityManager em) {
        NaverTablePerClassStrategy naverTablePerClassStrategy = new NaverTablePerClassStrategy();
        naverTablePerClassStrategy.setSiteId("test");
        naverTablePerClassStrategy.setNickName("nickTest");

        em.persist(naverTablePerClassStrategy);
    }

    public static void logic(EntityManager em) {

        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setName("현");
        member.setAge(1);

        //등록
        em.persist(member);

        String id2 = "id2";
        Member member2 = new Member();
        member2.setId(id2);
        member2.setName("현2");
        member2.setAge(2);

        //등록
        em.persist(member2);

        //수정 - 수정할때, 한 컬럼만 수정해도 모든 컬럼이 수정되는 SQL 이 생성된다.
        member.setAge(20);

        Team team = new Team();
        team.setName("team1");

        em.persist(team);
        member.setTeam(team);
        member2.setTeam(team);

        //한 건 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember=" + findMember.getName() + ", age=" + findMember.getAge());
        // 이때까지 쓰기지연 SQL 저장소에 쿼리 저장

        //목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members.size=" + members.size());
        // JPQL 을 사용했기 때문에 flush 가 발생한다.

        //삭제
        // em.remove(member);
        // 이때는 쓰기지연 SQL 저장소에 쿼리 저장

        em.detach(member);
        // 준영속

        em.merge(member);
        // 병합 -> 1차캐시에서 먼저 검색, 없으면 DB 에서 검색 (id 가준으로 검색)
    }
}
