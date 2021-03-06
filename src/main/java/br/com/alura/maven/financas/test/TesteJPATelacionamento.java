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
		conta.setAgencia("1105");
		conta.setBanco("Bametindos");
		conta.setNumero("9816");
		conta.setTitular("Perna");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Cinema");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("40.0"));
		movimentacao.setConta(conta);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		em.close();

	}
}
