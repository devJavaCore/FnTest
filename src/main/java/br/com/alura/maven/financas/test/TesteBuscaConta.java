package br.com.alura.maven.financas.test;

import br.com.alura.maven.financas.model.Conta;
import br.com.alura.maven.financas.util.JPAUtil;

import javax.persistence.EntityManager;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteBuscaConta {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 1);
        System.out.println(conta.getTitular());
        em.getTransaction().commit();
        em.close();
        
    }

}
