package br.com.transportadora.Teste;

import org.junit.Test;

import br.com.transportadora.DAO.GenericDao;
import br.com.transportadora.DAO.GenericDaoImpl;
import br.com.transportadora.DAO.MotoristaDAO;
import br.com.transportadora.Model.Caminhao;
import br.com.transportadora.Model.Motorista;


public class TesteMotorista {

	@Test
	public void Teste(){
		Caminhao c = new Caminhao();
		Motorista m = new Motorista();
		
		m.setCpf("01010101");
		m.setEndereco("Riso");
		m.setNome("Alan");
		m.setPis("1321as");
		m.setTelefone("1321546");
		
		GenericDao dao = new GenericDaoImpl();
		
		dao.save(m);
		
		c.setMotorista(m);
		c.setPesoMax(100);
		c.setPlaca("RCS2");
		c.setDisponivel(true);
	
		dao.save(c);
		
		MotoristaDAO mDAO = new MotoristaDAO();
		mDAO.listarPorNomeECPF(m);
	}
	
}
