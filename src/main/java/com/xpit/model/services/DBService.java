package com.xpit.model.services;

/* Back End - API REST 
 * Service - Camada de Servicos do Controlador Rest 
 * //Classe responsavel por instanciar os dados conforme profile 
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xpit.model.domain.Categoria;
import com.xpit.model.domain.Cidade;
import com.xpit.model.domain.Cliente;
import com.xpit.model.domain.Endereco;
import com.xpit.model.domain.Estado;
import com.xpit.model.domain.ItemPedido;
import com.xpit.model.domain.Pagamento;
import com.xpit.model.domain.PagamentoComBoleto;
import com.xpit.model.domain.PagamentoComCartao;
import com.xpit.model.domain.Pedido;
import com.xpit.model.domain.Produto;
import com.xpit.model.domain.enums.EstadoPagamento;
import com.xpit.model.domain.enums.Perfil;
import com.xpit.model.domain.enums.TipoCliente;
import com.xpit.model.repositories.CategoriaRepository;
import com.xpit.model.repositories.CidadeRepository;
import com.xpit.model.repositories.ClienteRepository;
import com.xpit.model.repositories.EnderecoRepository;
import com.xpit.model.repositories.EstadoRepository;
import com.xpit.model.repositories.ItemPedidoRepository;
import com.xpit.model.repositories.PagamentoRepository;
import com.xpit.model.repositories.PedidoRepository;
import com.xpit.model.repositories.ProdutoRepository;


@Service
public class DBService {
	
	@Autowired // Injetando BCryptPasswordEncoder para encodar senha
	private BCryptPasswordEncoder pe;

	@Autowired // Vai ser instanciado automaticamente CategoriaRepository
	private CategoriaRepository categoriaRepository;

	@Autowired // Vai ser instanciado automaticamente ProdutoRepository
	private ProdutoRepository produtoRepository;

	@Autowired // Vai ser instanciado automaticamente EstadoRepository
	private EstadoRepository estadoRepository;

	@Autowired // Vai ser instanciado automaticamente CidadeRepository
	private CidadeRepository cidadeRepository;

	@Autowired // Vai ser instanciado automaticamente ClienteRepository
	private ClienteRepository clienteRepository;

	@Autowired // Vai ser instanciado automaticamente EnderecoRepository
	private EnderecoRepository enderecoRepository;

	@Autowired // Vai ser instanciado automaticamente pedidoRepository
	private PedidoRepository pedidoRepository;
	@Autowired // Vai ser instanciado automaticamente PagamentoRepository
	private PagamentoRepository pagamentoRepository;

	@Autowired // Vai ser instanciado automaticamente itemPedidoRepository
	private ItemPedidoRepository itemPedidoRepository;

	//Metodo para instanciar a base de teste
	public void instantiateTestDatabase() throws ParseException {

		// Roda a carga de Categorias na tabela Categoria (Persiste os dados no banco H2
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		Categoria cat8 = new Categoria(null, "Games");
		Categoria cat9 = new Categoria(null, "Livros");

		// Carga de Produtos
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		
		Produto p12 = new Produto(null, "Teclado", 140.00);
		Produto p13 = new Produto(null, "Notebook", 1300.00);
		Produto p14 = new Produto(null, "PenDrive", 100.00);
		Produto p15 = new Produto(null, "HD Externo", 400.00);
		Produto p16 = new Produto(null, "No Break", 410.00);
		Produto p17 = new Produto(null, "Monitor 18", 80.00);
		Produto p18 = new Produto(null, "Mouse sem fio", 80.00);
		Produto p19 = new Produto(null, "Chromecast 3 Google", 339.00);
		Produto p20 = new Produto(null, "Headset USB LifeChat", 210.00);
		Produto p21 = new Produto(null, "Scanner portátil Wireless ADS-1250W Brother", 1510.00);
		Produto p22 = new Produto(null, "Computador AIO 24V570 com TV Digital Core i5", 3610.00);
		Produto p23 = new Produto(null, "Office 365 Personal Assinatura Anual", 170.00);
		Produto p24 = new Produto(null, "Windows 10 Home", 799.00);
		Produto p25 = new Produto(null, "Kaspersky Anti-Virus", 30.00);
		Produto p26 = new Produto(null, "Camera de Segurança HD IC3 111", 240.00);
		Produto p27 = new Produto(null, "Roteador wireless 4 portas Dual Band AC750", 170.00);
		Produto p28 = new Produto(null, "Modem ADSL2 + Roteador wireless 4 portas 300mbps", 140.00);
		Produto p29 = new Produto(null, "Organizador p/cabos e fios 19,1mmx2m", 20.00);
		Produto p30 = new Produto(null, "Caixa de som recarregável 50w rms Bluetooth", 200.00);
		Produto p31 = new Produto(null, "Cabo de força p/ CPU 1,5m 3 pinos 1557", 30.00);
		Produto p32 = new Produto(null, "Cabo HDMI 2.0 c/ 2,5m HD25", 30.00);
		Produto p33 = new Produto(null, "Cartucho HP 664XL preto Original (F6V31AB) Para HP Deskjet", 120.00);
		Produto p34 = new Produto(null, "Toner HP 85A Preto Laserjet Original ", 410.00);
		Produto p35 = new Produto(null, "Fita nylon p/impressora matricial LX350/ LX300/ LX300+II Epson", 17.00);
		Produto p36 = new Produto(null, "Tela de projeção 1,80x1,80 retrátil", 410.00);
		Produto p37 = new Produto(null, "Estabilizador bivolt Sol G4 1000va 8 tomadas", 410.00);
		Produto p38 = new Produto(null, "Tablet M10A Android", 710.00);
		Produto p39 = new Produto(null, "Tablet Ipad", 1000.00);
		Produto p40 = new Produto(null, "Tablet Kids, Android 7.1", 310.00);
		Produto p41 = new Produto(null, "Tablet Galaxy Tab A T510 Andr.9.1", 1300.00);
		Produto p42 = new Produto(null, "Zenbook UX433FA-A6342T, Processador i7 (8ª Geracao) 1.8ghz", 6010.00);
		Produto p43 = new Produto(null, "HD externo 2tb usb portátil Elements Western Digital", 610.00);
		Produto p44 = new Produto(null, "HD externo 4tb usb portátil Elements Western Digital", 1200.00);
		Produto p45 = new Produto(null, "Fone de ouvido Bluetooth c/ microfone intra preto", 210.00);
		Produto p46 = new Produto(null, "Maleta p/notebook 15,6", 10.00);
		Produto p47 = new Produto(null, "Projetor Multimídia PowerLite Full HD", 4505.00);
		Produto p48 = new Produto(null, "Dvd -r gravável 4.7gb 120min 16x", 50.00);
		Produto p49 = new Produto(null, "Cd-r gravável (80min/700mb)52x", 40.00);
		Produto p50 = new Produto(null, "Leitor de cartão USB 3.0 AC290", 10.00);

		// Associação Categoria Produto
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		
		cat1.getProdutos().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));

		// Associação Produto Categoria
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		p12.getCategorias().add(cat1);
		p13.getCategorias().add(cat1);
		p14.getCategorias().add(cat1);
		p15.getCategorias().add(cat1);
		p16.getCategorias().add(cat1);
		p17.getCategorias().add(cat1);
		p18.getCategorias().add(cat1);
		p19.getCategorias().add(cat1);
		p20.getCategorias().add(cat1);
		p21.getCategorias().add(cat1);
		p22.getCategorias().add(cat1);
		p23.getCategorias().add(cat1);
		p24.getCategorias().add(cat1);
		p25.getCategorias().add(cat1);
		p26.getCategorias().add(cat1);
		p27.getCategorias().add(cat1);
		p28.getCategorias().add(cat1);
		p29.getCategorias().add(cat1);
		p30.getCategorias().add(cat1);
		p31.getCategorias().add(cat1);
		p32.getCategorias().add(cat1);
		p33.getCategorias().add(cat1);
		p34.getCategorias().add(cat1);
		p35.getCategorias().add(cat1);
		p36.getCategorias().add(cat1);
		p37.getCategorias().add(cat1);
		p38.getCategorias().add(cat1);
		p39.getCategorias().add(cat1);
		p40.getCategorias().add(cat1);
		p41.getCategorias().add(cat1);
		p42.getCategorias().add(cat1);
		p43.getCategorias().add(cat1);
		p44.getCategorias().add(cat1);
		p45.getCategorias().add(cat1);
		p46.getCategorias().add(cat1);
		p47.getCategorias().add(cat1);
		p48.getCategorias().add(cat1);
		p49.getCategorias().add(cat1);
		p50.getCategorias().add(cat1);	

		// Salvando Categorias no categoriaRepository
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9));

		// Salvando Produtos no produtoRepository
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
		produtoRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));


		// Instanciando Estado
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		// Instanciando Cidade
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		// Associando cidades ao estado
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Renato Sanches", "newswebmundi1@gmail.com", "16588302029",
				TipoCliente.PESSOAFISICA, pe.encode("123"));

		cli1.getTelefones().addAll(Arrays.asList("99667666", "22817142"));
		
		Cliente cli2 = new Cliente(null, "Osvaldo Z", "nucleotoys@gmail.com", "31628382740", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("93883843", "22322625"));
		cli2.addPerfil(Perfil.ADMIN);

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		Endereco e3 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "281777012", cli2, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));

		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2,e3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}
