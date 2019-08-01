package br.com.alura.maven.financas.test;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.maven.financas.DAO.MovimentacaoDao;
import br.com.alura.maven.financas.model.Conta;
import br.com.alura.maven.financas.model.TipoMovimentacao;
import br.com.alura.maven.financas.util.JPAUtil;

public class TesteFuncoesJPQL {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		
		TypedQuery<Double> typedQuery = em.createNamedQuery("getMediasPorDiaETipo", Double.class);
		
		typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = typedQuery.getResultList();
		
		for (Double media : medias) {
			System.out.println("A media é: "+ media);
		}
		em.getTransaction().commit();
		em.close();
	}
}
