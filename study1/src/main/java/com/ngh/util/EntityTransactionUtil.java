package com.ngh.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class EntityTransactionUtil {
    private final EntityManagerFactory emf;

    public EntityTransactionUtil(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public  <T> T doTransaction(EntityTransactionFunction<T> function) {
        //엔티티 매니저 팩토리 생성
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작

            // logic(em); // 비지니스 로직
            T result = function.doFunction(em); // 연관관계 사용

            tx.commit();//트랜잭션 커밋
            // 커밋하는 순간, DB에 SQL 전송 (flush)

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        return null;
    }

}
