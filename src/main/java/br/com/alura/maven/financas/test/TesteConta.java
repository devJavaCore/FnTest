package br.com.alura.maven.financas.test;

import javax.persistence.EntityManager;

import br.com.alura.maven.financas.model.Conta;
import br.com.alura.maven.financas.util.JPAUtil;


public class TesteConta {

    public static void main(String[] args) {


        Conta conta = new Conta();
        conta.setTitular("Danilo");
        conta.setBanco("Banco do Brasil");
        conta.setAgencia("123");
        conta.setNumero("456");
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        em.close();
    }
}