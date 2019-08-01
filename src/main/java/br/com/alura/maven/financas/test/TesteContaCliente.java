package br.com.alura.maven.financas.test;

import javax.persistence.EntityManager;

import br.com.alura.maven.financas.model.Cliente;
import br.com.alura.maven.financas.model.Conta;
import br.com.alura.maven.financas.util.JPAUtil;

public class TesteContaCliente {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Glauco");
		cliente.setEndereco("Rua Naldano, 123");
		cliente.setProfissao("Futebolista");
		
		Conta conta = new Conta();
		conta.setId(1);
		
		cliente.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}
