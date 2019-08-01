package br.com.alura.maven.financas.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.maven.financas.model.Conta;
import br.com.alura.maven.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		
		String jpql = "select c from Conta c join fetch c.movimentacao";
		
		Query query = em.createQuery(jpql);
		
		List<Conta> todasAsContras = query.getResultList();
		
		for (Conta conta : todasAsContras) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentacoes:");
			System.out.println("Movimentacoes: "+conta.getMovimentacoes());	
		}
		
		
		em.getTransaction().commit();
		em.close();
	}

}
