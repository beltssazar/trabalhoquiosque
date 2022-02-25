package tecdevnoite.trabalho.controller;


import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tecdevnoite.trabalho.dao.ClienteDao;
import tecdevnoite.trabalho.model.Cliente;
import tecdevnoite.trabalho.model.Genero;

@Controller
public class ClienteController {

	@RequestMapping("cadCliente")
	public String form(Model model) {
		model.addAttribute("genero", Genero.values());
		return "cad_cliente";
		
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(Cliente cliente) {
		System.out.println(cliente.getNome());
		System.out.println(cliente.getIdade());
		System.out.println(cliente.getFaixa_etaria());
		System.out.println(cliente.getEndereco());
		System.out.println(cliente.getNumero());
		System.out.println(cliente.getEmail());
		System.out.println(cliente.getGenero());
		System.out.println(cliente.getProduto());
		
		ClienteDao dao = new ClienteDao();
		
		if (cliente.getId() == null) {
			dao.inserir(cliente);
		}else {
			dao.atualizar(cliente);
		}
		return "redirect:listaClientes";
		
	}
	
	@RequestMapping("listaClientes")
	public String listar(Model model) {
		ClienteDao dao = new ClienteDao();
		model.addAttribute("clientes", dao.listar());
		return "listacliente";
	}
	
	@RequestMapping("excluirCliente")
	public String excluir(long idCliente) {
		ClienteDao dao = new ClienteDao();
		dao.excluir(idCliente);
		return "forward:listaClientes";
		
	}
	
	@RequestMapping("alterarCliente")
	public String alterar(long idCliente, Model model) {
		ClienteDao dao = new ClienteDao();
		model.addAttribute("cliente", dao.buscar(idCliente));
		return "forward:cadCliente";
		
	}
	@RequestMapping("consultarClientes")
	public String listaMasc(Model model) {
		model.addAttribute("masculino", new ClienteDao().contaMasc());
		model.addAttribute("feminino", new ClienteDao().contaFem());
		return "consulta_clientes";
	}
	
}
