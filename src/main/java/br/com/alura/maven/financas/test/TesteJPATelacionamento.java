package br.com.alura.maven.financas.test;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.maven.financas.model.Conta;
import br.com.alura.maven.financas.model.Movimentacao;
import br.com.alura.maven.financas.model.TipoMovimentacao;
import br.com.alura.maven.financas.util.JPAUtil;

public class TesteJPATelacionamento {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setAgencia("0505");
		conta.setBanco("Banamericano");
		conta.setNumero("9876");
		conta.setTitular("Rogerio");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Cinema");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("40.0"));
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		em.close();

	}
}
