package main;

import fachada.CinDex;
import Local.*;
import Pacote.*;
import Pessoa.*;
import Rota.*;
import Veiculo.*;
import erros.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int entrada = 0, repositorio, tipoPessoa = 0;
        Local objetoLocal;
        Pacote objetoPacote;
        Cliente objetoCliente;
        Funcionario objetoFuncionario;
        Rota objetoRota;
        Veiculo objetoVeiculo;
        CinDex cindex;

        System.out.println("Bem vindo ao CinDex");
        System.out.println("Digite o tipo de repositório que gostaria de utilizar:");
        System.out.println("(0) Array");
        System.out.println("(1) Lista");
        System.out.print("Minha opção é: ");
        repositorio = Integer.parseInt(in.nextLine());
        if (repositorio == 1) {
            cindex = new CinDex(true);
        } else {
            cindex = new CinDex(false);
        }

        while (entrada != 6) {
            int selecao = 0;
            System.out.println("O que deseja fazer ?");
            System.out.println("(1) - Gerenciar Locais");
            System.out.println("(2) - Gerenciar Pacotes");
            System.out.println("(3) - Gerenciar Pessoas");
            System.out.println("(4) - Gerenciar Rotas");
            System.out.println("(5) - Gerenciar Veículos");
            System.out.println("(6) - Sair");
            entrada = Integer.parseInt(in.nextLine());
            switch (entrada) {
                case 1:
                    while (selecao != 5) {
                        System.out.println("Você está no gerenciamento de Locais");
                        System.out.println("O que deseja fazer ?");
                        System.out.println("(1) - Cadastrar Local");
                        System.out.println("(2) - Remover Local");
                        System.out.println("(3) - Procurar Local");
                        System.out.println("(4) - Atualizar Local");
                        System.out.println("(5) - Sair");
                        selecao = Integer.parseInt(in.nextLine());
                        switch (selecao) {
                            case 1: {
                                System.out.print("Digite a coordenada X:");
                                double coordenadaX = Double.parseDouble(in.nextLine());
                                System.out.print("Digite a coordenada Y:");
                                double coordenadaY = Double.parseDouble(in.nextLine());
                                System.out.print("Digite o logradouro:");
                                String logradouro = in.nextLine();
                                System.out.print("Digite a cidade:");
                                String cidade = in.nextLine();
                                System.out.print("Digite o bairro:(Opcional)");
                                String bairro = in.nextLine();
                                if (!bairro.equals("")) {
                                    objetoLocal = new Local(coordenadaX, coordenadaY, logradouro, cidade, bairro);
                                } else {
                                    objetoLocal = new Local(coordenadaX, coordenadaY, logradouro, cidade);
                                }

                                try {
                                    cindex.cadastrarLocal(objetoLocal);
                                    System.out.println("\n\n------ Local cadastrado com sucesso ------\n\n");
                                } catch (LogradouroInvalidoException | BairroInvalidoException | CidadeInvalidaException
                                        | LocalJaCadastradoException | LimiteAtingidoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            }
                            case 2: {
                                System.out.print("Digite a coordenada X:");
                                double coordenadaX = Double.parseDouble(in.nextLine());
                                System.out.print("Digite a coordenada Y:");
                                double coordenadaY = Double.parseDouble(in.nextLine());
                                try {
                                    cindex.removerLocal(coordenadaX, coordenadaY);
                                    System.out.println("\n\n------ Local removido com sucesso ------\n\n");
                                } catch (LocalNaoEncontradoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            }
                            case 3: {
                                System.out.print("Digite a coordenada X:");
                                double coordenadaX = Double.parseDouble(in.nextLine());
                                System.out.print("Digite a coordenada Y:");
                                double coordenadaY = Double.parseDouble(in.nextLine());
                                try {
                                    Local localEncotrado = cindex.procurarLocal(coordenadaX, coordenadaY);
                                    System.out.println("A Coordenada X do local é " + localEncotrado.getCoordenadax());
                                    System.out.println("A Coordenada Y do local é " + localEncotrado.getCoordenaday());
                                    System.out.println("O logradouro do local é " + localEncotrado.getLogradouro());
                                    System.out.println("A cidade do local é " + localEncotrado.getCidade());
                                    System.out.println("\n");
                                    if (localEncotrado.getBairro() != null) {
                                        System.out.println("O bairro do local é " + localEncotrado.getBairro());
                                    }

                                } catch (LocalNaoEncontradoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            }
                            case 4: {
                                System.out.print("Digite a coordenada X: ");
                                double coordenadaX = Double.parseDouble(in.nextLine());
                                System.out.print("Digite a coordenada Y: ");
                                double coordenadaY = Double.parseDouble(in.nextLine());
                                System.out.print("Digite o logradouro: ");
                                String logradouro = in.nextLine();
                                System.out.print("Digite a cidade: ");
                                String cidade = in.nextLine();
                                System.out.print("Digite o bairro(Opcional): ");
                                String bairro = in.nextLine();
                                if (!bairro.equals("")) {
                                    objetoLocal = new Local(coordenadaX, coordenadaY, logradouro, cidade, bairro);
                                } else {
                                    objetoLocal = new Local(coordenadaX, coordenadaY, logradouro, cidade);
                                }

                                try {
                                    cindex.atualizarLocal(objetoLocal);
                                    System.out.println("\n\n------ Local atualizado com sucesso ------\n\n");
                                } catch (LocalNaoEncontradoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            }
                            case 5:
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    }
                    break;
                case 2:
                    while (selecao != 5) {
                        System.out.println("Você está no gerenciamento de Pacotes");
                        System.out.println("O que deseja fazer ?");
                        System.out.println("(1) - Cadastrar Pacote");
                        System.out.println("(2) - Remover Pacote");
                        System.out.println("(3) - Procurar Pacote");
                        System.out.println("(4) - Atualizar Pacote");
                        System.out.println("(5) - Sair");
                        selecao = Integer.parseInt(in.nextLine());
                        switch (selecao) {
                            case 1: {
                                System.out.print("Digite o identificador do Pacote:");
                                String identificador = in.nextLine();
                                System.out.print("Digite o peso do Pacote:");
                                double peso = Double.parseDouble(in.nextLine());
                                System.out.print("Digite a altura do Pacote:");
                                double altura = Double.parseDouble(in.nextLine());
                                System.out.print("Digite a largura do Pacote:");
                                double largura = Double.parseDouble(in.nextLine());
                                System.out.print("Digite o comprimento do Pacote:");
                                double comprimento = Double.parseDouble(in.nextLine());
                                System.out.print("Digite o veículo do Pacote:");
                                String nome = in.nextLine();
                                System.out.print("Digite a rota do Pacote:");
                                String codigo = in.nextLine();
                                try {
                                    objetoPacote = new Pacote(identificador, peso, altura, largura, comprimento,
                                            cindex.procurarVeiculo(nome), cindex.procurarRota(codigo));
                                    try {
                                        cindex.cadastrarPacote(objetoPacote);
                                        System.out.println("\n\n------ Pacote cadastrado com sucesso ------\n\n");
                                    } catch (DimensaoInvalidaException | VeiculoInvalidoException | PesoMaximoException
                                            | PacoteJaCadastradoException | RotaInvalidaException
                                            | IdentificadorInvalidoException | LimiteAtingidoException e) {
                                        System.out.println("\n\n----------------- ERRO -----------------");
                                        System.out.println(e.getMessage() + "\n\n");
                                    }
                                } catch (RotaNaoEncontradaException | VeiculoNaoEncontradoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            }
                            case 2: {
                                System.out.print("Digite o identificador do Pacote:");
                                String identificador = in.nextLine();
                                try {
                                    cindex.removerPacote(identificador);
                                    System.out.println("\n\n------ Pacote removido com sucesso ------\n\n");
                                } catch (PacoteNaoEncontradoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            }
                            case 3: {
                                System.out.print("Digite o identificador do Pacote:");
                                String identificador = in.nextLine();
                                try {
                                    Pacote pacoteEncontrado = cindex.procurarPacote(identificador);
                                    System.out.println("Pacote Nº " + pacoteEncontrado.getIdentificador());
                                    System.out.println("O pacote tem " + pacoteEncontrado.getPeso() + " Kg");
                                    System.out.println("Dimensões do pacote(AxLxC): " + pacoteEncontrado.getAltura() + "x"
                                            + pacoteEncontrado.getLargura() + "x" + pacoteEncontrado.getComprimento());
                                    System.out.println("O pacote será transportado no " + pacoteEncontrado.getVeiculo().getNomeVeiculo());
                                    System.out.println("O pacote está na rota " + pacoteEncontrado.getRota().getCodigo());
                                    System.out.println("\n");
                                } catch (PacoteNaoEncontradoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            }
                            case 4: {
                                System.out.print("Digite o identificador do Pacote:");
                                String identificador = in.nextLine();
                                System.out.print("Digite o peso do Pacote:");
                                double peso = Double.parseDouble(in.nextLine());
                                System.out.print("Digite a altura do Pacote:");
                                double altura = Double.parseDouble(in.nextLine());
                                System.out.print("Digite a largura do Pacote:");
                                double largura = Double.parseDouble(in.nextLine());
                                System.out.print("Digite o comprimento do Pacote:");
                                double comprimento = Double.parseDouble(in.nextLine());
                                System.out.print("Digite o veículo do Pacote:");
                                String nome = in.nextLine();
                                System.out.print("Digite a rota do Pacote:");
                                String codigo = in.nextLine();
                                try {
                                    objetoPacote = new Pacote(identificador, peso, altura, largura, comprimento, cindex.procurarVeiculo(nome), cindex.procurarRota(codigo));
                                    try {
                                        cindex.atualizarPacote(objetoPacote);
                                        System.out.println("\n\n------ Pacote atualizado com sucesso ------\n\n");
                                    } catch (VeiculoInvalidoException | PacoteNaoEncontradoException | RotaInvalidaException e) {
                                        System.out.println("\n\n----------------- ERRO -----------------");
                                        System.out.println(e.getMessage() + "\n\n");
                                    }
                                } catch (RotaNaoEncontradaException | VeiculoNaoEncontradoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            }
                            case 5:
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    }
                    break;
                case 3:
                    while (tipoPessoa != 3) {
                        System.out.println("Você está no gerenciamento de Pessoas");
                        System.out.println("O que deseja fazer ?");
                        System.out.println("(1) - Gerenciar Clientes");
                        System.out.println("(2) - Gerenciar Funcionários");
                        System.out.println("(3) - Sair");
                        tipoPessoa = Integer.parseInt(in.nextLine());
                        switch (tipoPessoa) {
                            case 1:
                                selecao = 0;
                                while(selecao != 5) {
                                    System.out.println("(1) - Cadastrar cliente");
                                    System.out.println("(2) - Remover cliente");
                                    System.out.println("(3) - Procurar cliente");
                                    System.out.println("(4) - Atualizar cliente");
                                    System.out.println("(5) - Sair");
                                    selecao = Integer.parseInt(in.nextLine());
                                    switch (selecao) {
                                        case 1: {
                                            System.out.print("Digite o nome do cliente:");
                                            String nome = in.nextLine();
                                            System.out.print("Digite o identificador do cliente:");
                                            String identificador = in.nextLine();
                                            System.out.print("Qual o sexo do cliente?");
                                            String sexo = in.nextLine();
                                            System.out.print("Digite a data de nascimento do cliente:");
                                            String dataNascimento = in.nextLine();
                                            System.out.println("Digite as coordenadas do cliente:");
                                            System.out.print("Coordenada X:");
                                            double coordenadaX = Double.parseDouble(in.nextLine());
                                            System.out.print("Coordenada Y:");
                                            double coordenadaY = Double.parseDouble(in.nextLine());
                                            try{
                                                objetoCliente = new Cliente(nome, identificador,sexo, dataNascimento,
                                                        cindex.procurarLocal(coordenadaX, coordenadaY));

                                            } catch (LocalNaoEncontradoException e) {
                                                objetoCliente = new Cliente(nome, identificador,sexo, dataNascimento);
                                            }
                                            try{
                                                cindex.cadastrarCliente(objetoCliente);
                                                System.out.println("\n\n------ Cliente cadastrado com sucesso ------\n\n");
                                            }catch (ClienteJaCadastradoException | LimiteAtingidoException
                                                    | CpfInvalidoException | SexoInvalidoException
                                                    | DataNascimentoInvalidaException e){
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");
                                            }
                                            break;
                                        }
                                        case 2: {
                                            System.out.println("Digite o CPF do cliente:");
                                            String identificador = in.nextLine();
                                            try{
                                                cindex.removerCliente(identificador);
                                                System.out.println("\n\n------ Cliente removido com sucesso ------\n\n");
                                            } catch (ClienteNaoEncontradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");
                                            }
                                            break;
                                        }
                                        case 3: {
                                            System.out.println("Digite o CPF do cliente:");
                                            String identificador = in.nextLine();
                                            try {
                                                Cliente clienteEncontrado = cindex.procurarCliente(identificador);
                                                System.out.println("Cliente: " + clienteEncontrado.getNome());
                                                System.out.println("Sexo: " + clienteEncontrado.getSexo());
                                                System.out.println("Data de nascimento: " + clienteEncontrado.getDataNascimento());
                                                System.out.println("CPF: " + clienteEncontrado.getCodigo());
                                                if(clienteEncontrado.getLocal() != null){
                                                    System.out.println("Local: (" + clienteEncontrado.getLocal().getCoordenadax()
                                                            + "," + clienteEncontrado.getLocal().getCoordenaday() + ")");
                                                    System.out.println(clienteEncontrado.getLocal().getLogradouro());
                                                    System.out.println(clienteEncontrado.getLocal().getCidade());
                                                }
                                                System.out.println("\n");
                                            } catch (ClienteNaoEncontradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");
                                            }
                                            break;
                                        }
                                        case 4: {
                                            System.out.println("Digite o nome do cliente:");
                                            String nome = in.nextLine();
                                            System.out.println("Digite o identificador do cliente:");
                                            String identificador = in.nextLine();
                                            System.out.println("Qual o sexo do cliente?");
                                            String sexo = in.nextLine();
                                            System.out.println("Digite a data de nascimento do cliente:");
                                            String dataNascimento = in.nextLine();
                                            System.out.println("Digite as coordenadas do cliente:");
                                            System.out.println("Coordenada X:");
                                            double coordenadaX = Double.parseDouble(in.nextLine());
                                            System.out.println("Coordenada Y:");
                                            double coordenadaY = Double.parseDouble(in.nextLine());
                                            try{
                                                objetoCliente = new Cliente(nome, identificador,sexo, dataNascimento,
                                                        cindex.procurarLocal(coordenadaX, coordenadaY));

                                            } catch (LocalNaoEncontradoException e) {
                                                objetoCliente = new Cliente(nome, identificador,sexo, dataNascimento);
                                            }
                                            try{
                                                cindex.atualizarCliente(objetoCliente);
                                                System.out.println("\n\n------ Cliente atualizado com sucesso ------\n\n");
                                            } catch (ClienteNaoEncontradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");
                                            }
                                            break;
                                        }
                                        case 5:
                                            break;
                                        default:
                                            System.out.println("Opção inválida!");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                selecao = 0;
                                while(selecao != 5) {
                                    System.out.println("(1) - Cadastrar funcionário");
                                    System.out.println("(2) - Remover funcionário");
                                    System.out.println("(3) - Procurar funcionário");
                                    System.out.println("(4) - Atualizar funcionário");
                                    System.out.println("(5) - Sair");
                                    selecao = Integer.parseInt(in.nextLine());
                                    switch (selecao) {
                                        case 1: {
                                            System.out.println("Digite o nome do funcionário:");
                                            String nome = in.nextLine();
                                            System.out.println("Digite o identificador do funcionário:");
                                            String identificador = in.nextLine();
                                            System.out.println("Qual o sexo do funcionário?");
                                            String sexo = in.nextLine();
                                            System.out.println("Digite a data de nascimento do funcionário:");
                                            String dataNascimento = in.nextLine();
                                            System.out.println("Digite o salário do funcionário:");
                                            double salario = Double.parseDouble(in.nextLine());
                                            System.out.println("Digite a matricula do funcionário:");
                                            String matricula = in.nextLine();
                                            objetoFuncionario = new Funcionario(nome, identificador, sexo,
                                                    dataNascimento, salario, matricula);
                                            try {
                                                cindex.cadastrarFuncionario(objetoFuncionario);
                                                System.out.println("\n\n------ Funcionário cadastrado com sucesso ------\n\n");
                                            } catch (IdentificadorFuncionarioInvalidoException | SexoInvalidoException
                                                    | FuncionarioJaCadastradoException | DataNascimentoInvalidaException
                                                    | LimiteAtingidoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");
                                            }
                                            break;
                                        }
                                        case 2: {
                                            System.out.println("Digite o CPF do funcionário:");
                                            String identificador = in.nextLine();
                                            try{
                                                cindex.removerFuncionario(identificador);
                                                System.out.println("\n\n------ Funcionário removido com sucesso ------\n\n");
                                            } catch (FuncionarioNaoEncontradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");
                                            }
                                            break;
                                        }
                                        case 3: {
                                            System.out.println("Digite o CPF do funcionário:");
                                            String identificador = in.nextLine();
                                            try {
                                                Funcionario funcionarioEncontrado = cindex.procurarFuncionario(identificador);
                                                System.out.println("Funcionário: " + funcionarioEncontrado.getNome());
                                                System.out.println("Matricula: " + funcionarioEncontrado.getCodigo());
                                                System.out.println("Sexo: " + funcionarioEncontrado.getSexo());
                                                System.out.println("Data de nascimento: " + funcionarioEncontrado.getDataNascimento());
                                                System.out.println("Salário: R$" + funcionarioEncontrado.getSalario());
                                                System.out.println("\n");
                                            } catch (FuncionarioNaoEncontradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");
                                            }
                                            break;
                                        }
                                        case 4: {
                                            System.out.println("Digite o nome do funcionário:");
                                            String nome = in.nextLine();
                                            System.out.println("Digite o identificador do funcionário:");
                                            String identificador = in.nextLine();
                                            System.out.println("Qual o sexo do funcionário?");
                                            String sexo = in.nextLine();
                                            System.out.println("Digite a data de nascimento do funcionário:");
                                            String dataNascimento = in.next();
                                            System.out.println("Digite o salário do funcionário:");
                                            double salario = Double.parseDouble(in.nextLine());
                                            System.out.println("Digite a matricula do funcionário:");
                                            String matricula = in.nextLine();
                                            objetoFuncionario = new Funcionario(nome, identificador, sexo,
                                                    dataNascimento, salario, matricula);
                                            try {
                                                cindex.atualizarFuncionario(objetoFuncionario);
                                                System.out.println("\n\n------ Funcionário atualizado com sucesso ------\n\n");
                                            } catch (FuncionarioNaoEncontradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");
                                            }
                                            break;
                                        }
                                        case 5:
                                            break;
                                        default:
                                            System.out.println("Opção inválida!");
                                            break;
                                    }
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                    }
                    tipoPessoa = 0;
            break;
            case 4:
                while (selecao != 5) {
                    System.out.println("Você está no gerenciamento de Rotas");
                    System.out.println("O que deseja fazer ?");
                    System.out.println("(1) - Cadastrar Rota");
                    System.out.println("(2) - Remover Rota");
                    System.out.println("(3) - Procurar Rota");
                    System.out.println("(4) - Atualizar Rota");
                    System.out.println("(5) - Sair");
                    selecao = Integer.parseInt(in.nextLine());
                    switch (selecao) {
                        case 1: {
                            System.out.println("Digite o código da Rota:");
                            String codigo = in.next();
                            System.out.println("Digite o tipo da Rota:");
                            String tipo = in.next();
                            System.out.println("Digite a periculosidade da Rota:");
                            String periculosidade = in.next();
                            System.out.println("Digite as coordenadas do Local da Rota:");
                            System.out.println("Coordenada X:");
                            double coordenadaX = Double.parseDouble(in.nextLine());
                            System.out.println("Coordenada Y:");
                            double coordenadaY = Double.parseDouble(in.nextLine());
                            try{
                                objetoRota = new Rota(periculosidade, tipo, codigo,
                                        cindex.procurarLocal(coordenadaX, coordenadaY));
                                try{
                                    cindex.cadastrarRota(objetoRota);
                                    System.out.println("\n\n------ Rota cadastrada com sucesso ------\n\n");
                                } catch (CodigoInvalidoException | TipoInvalidoException
                                        | PericulosidadeInvalidaException | LocalInvalidoException
                                        | LimiteAtingidoException | RotaJaCadastradaException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                            } catch (LocalNaoEncontradoException e) {
                                System.out.println("\n\n----------------- ERRO -----------------");
                                System.out.println(e.getMessage() + "\n\n");
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Digite o código da Rota:");
                            String codigo = in.nextLine();
                            try {
                                cindex.removerRota(codigo);
                                System.out.println("\n\n------ Rota removida com sucesso ------\n\n");
                            } catch (RotaNaoEncontradaException e) {
                                System.out.println("\n\n----------------- ERRO -----------------");
                                System.out.println(e.getMessage() + "\n\n");
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("Digite o código da Rota:");
                            String codigo = in.nextLine();
                            try{
                                Rota rotaEncontrada = cindex.procurarRota(codigo);
                                System.out.println("Código da rota: " + rotaEncontrada.getCodigo());
                                System.out.println("Rota " + rotaEncontrada.getTipo() + " e "
                                        + rotaEncontrada.getPericulosidade());
                                System.out.println("A rota tem " + rotaEncontrada.getDistancia() + " Km de distância");
                                System.out.println("O destino da rota é: ("
                                        + rotaEncontrada.getLocal().getCoordenadax() + ","
                                        + rotaEncontrada.getLocal().getCoordenaday() + ")");
                                System.out.println("\n");
                            } catch (RotaNaoEncontradaException e) {
                                System.out.println("\n\n----------------- ERRO -----------------");
                                System.out.println(e.getMessage() + "\n\n");
                            }
                            break;
                        }
                        case 4: {
                            System.out.println("Digite o código da Rota:");
                            String codigo = in.nextLine();
                            System.out.println("Digite o tipo da Rota:");
                            String tipo = in.nextLine();
                            System.out.println("Digite a periculosidade da Rota:");
                            String periculosidade = in.nextLine();
                            System.out.println("Digite as coordenadas do Local da Rota:");
                            System.out.println("Coordenada X:");
                            double coordenadaX = Double.parseDouble(in.nextLine());
                            System.out.println("Coordenada Y:");
                            double coordenadaY = Double.parseDouble(in.nextLine());
                            try{
                                objetoRota = new Rota(periculosidade, tipo, codigo,
                                        cindex.procurarLocal(coordenadaX, coordenadaY));
                                try{
                                    cindex.atualizarRota(objetoRota);
                                    System.out.println("\n\n------ Rota atualizada com sucesso ------\n\n");
                                } catch (RotaNaoEncontradaException | LocalInvalidoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                            } catch (LocalNaoEncontradoException e) {
                                System.out.println("\n\n----------------- ERRO -----------------");
                                System.out.println(e.getMessage() + "\n\n");
                            }
                            break;
                        }
                        case 5:
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                }
                break;
            case 5:
                while (selecao != 5) {
                    System.out.println("Você está no gerenciamento de Veículos");
                    System.out.println("O que deseja fazer ?");
                    System.out.println("(1) - Cadastrar Veículo");
                    System.out.println("(2) - Remover Veículo");
                    System.out.println("(3) - Procurar Veículo");
                    System.out.println("(4) - Atualizar Veículo");
                    System.out.println("(5) - Sair");
                    selecao = Integer.parseInt(in.nextLine());
                    switch (selecao) {
                        case 1: {
                            System.out.println("Digite o nome do Veículo:");
                            String nome = in.nextLine();
                            System.out.println("Digite o tipo do veiculo:");
                            String tipo = in.nextLine();
                            System.out.println("Digite a capacidade do Veículo:");
                            int capacidade = Integer.parseInt(in.nextLine());
                            objetoVeiculo = new Veiculo(nome, tipo, capacidade);
                            try{
                                cindex.cadastrarVeiculo(objetoVeiculo);
                                System.out.println("\n\n------ Veículo cadastrado com sucesso ------\n\n");
                            } catch (VeiculoJaExistenteException | TipoVeiculoInvalidoException
                                    | VeiculoCapacidadeInvalida | LimiteAtingidoException e) {
                                System.out.println("\n\n----------------- ERRO -----------------");
                                System.out.println(e.getMessage() + "\n\n");
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Digite o nome do Veículo:");
                            String nome = in.nextLine();
                            try{
                                cindex.removerVeiculo(nome);
                                System.out.println("\n\n------ Veículo removido com sucesso ------\n\n");
                            } catch (VeiculoNaoEncontradoException e) {
                                System.out.println("\n\n----------------- ERRO -----------------");
                                System.out.println(e.getMessage() + "\n\n");
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("Digite o nome do Veículo:");
                            String nome = in.nextLine();
                            try{
                                Veiculo veiculoEncontrado = cindex.procurarVeiculo(nome);
                                System.out.println(veiculoEncontrado.getNomeVeiculo());
                                System.out.println("Tipo: " + veiculoEncontrado.getTipoVeiculo());
                                System.out.println("Capacidade: " + veiculoEncontrado.getCapacidadeVeiculo());
                                System.out.println("\n");
                            } catch (VeiculoNaoEncontradoException e) {
                                System.out.println("\n\n----------------- ERRO -----------------");
                                System.out.println(e.getMessage() + "\n\n");
                            }
                            break;
                        }
                        case 4: {
                            System.out.println("Digite o nome do Veículo:");
                            String nome = in.nextLine();
                            System.out.println("Digite o tipo do veiculo:");
                            String tipo = in.nextLine();
                            System.out.println("Digite a capacidade do Veículo:");
                            int capacidade = Integer.parseInt(in.nextLine());
                            objetoVeiculo = new Veiculo(nome, tipo, capacidade);
                            try{
                                cindex.atualizarVeiculo(objetoVeiculo);
                                System.out.println("\n\n------ Veículo atualizado com sucesso ------\n\n");
                            } catch (VeiculoNaoEncontradoException e) {
                                System.out.println("\n\n----------------- ERRO -----------------");
                                System.out.println(e.getMessage() + "\n\n");
                            }
                            break;
                        }
                        case 5:
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                }
            case 6:
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }
}
}
