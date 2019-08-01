package br.com.alura.maven.financas.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.maven.financas.model.Conta;
import br.com.alura.maven.financas.model.TipoMovimentacao;

public class MovimentacaoDao {
	
	private EntityManager em;
	
	

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}



	public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {
		String jpql = "select avg(m.valor) from Movimentacao m " + "where m.tipo = :pTipo "
				+ "group by day(m.data), month(m.data), year(m.data)";

		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		// query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		
		return query.getResultList();
	}

}
