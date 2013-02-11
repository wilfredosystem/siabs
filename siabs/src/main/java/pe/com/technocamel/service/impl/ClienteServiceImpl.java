package pe.com.technocamel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.technocamel.dao.ClienteDAO;
import pe.com.technocamel.model.Cliente;
import pe.com.technocamel.service.ClienteService;

@Service(value="clienteService")
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	public List<Cliente> listar(int inicio, int limite) {
		return clienteDAO.listar(inicio, limite);
	}

	@Override
	public int getTotal() {
		return clienteDAO.getTotal();
	}
}
