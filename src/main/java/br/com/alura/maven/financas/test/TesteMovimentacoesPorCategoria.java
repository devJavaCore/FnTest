package br.com.alura.maven.financas.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.maven.financas.model.Categoria;
import br.com.alura.maven.financas.model.Conta;
import br.com.alura.maven.financas.model.Movimentacao;
import br.com.alura.maven.financas.model.TipoMovimentacao;
import br.com.alura.maven.financas.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Categoria categoria = new Categoria();
		categoria.setId(2);

		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);

		List<Movimentacao> resultados = query.getResultList();

		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getId());
		}

		em.getTransaction().commit();
		em.close();
	}

}
