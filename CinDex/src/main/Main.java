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
//        CinDex cindex = new CinDex(true);
////        CinDex cindex = new CinDex(false);
//
//        Veiculo veiculo1 = new Veiculo("Carrão", "Carro", 20);
//        try{
//            cindex.cadastrarVeiculo(veiculo1);
//        }catch (VeiculoJaExistenteException e){
//            e.getMessage();
//        }catch(LimiteAtingidoException e){
//            e.getMessage();
//        }catch (TipoVeiculoInvalidoException e){
//            e.getMessage();
//        }catch (VeiculoCapacidadeInvalida e){
//            e.getMessage();
//        }
//        String teste = "";
//        try{
//            teste = cindex.procurarVeiculo("Carrã").getTipoVeiculo();
//        }catch (VeiculoNaoEncontradoException e){
//            System.out.println(e.getMessage()+"\n\n");
//        }
//        System.out.println(teste);
//
//
//
//        Veiculo veiculo2 = new Veiculo("14 Bis", "Avião", 8001);
//        Veiculo veiculo3 = new Veiculo("Carrão", "Carro", 20);
//        Veiculo veiculo4 = new Veiculo("Teste", "Bicicleta", 2);

//        Rota rota1 = new Rota()

//
//        Pacote pacote = new Pacote("000001", 3, 1, 1, 1, veiculo1, )


        Scanner in = new Scanner(System.in);

        int entrada = 0, repositorio, tipo = 0;
        Local objetoLocal = null;
        Pacote objetoPacote = null;
        PessoaAbstrata objetoPessoa = null;
        Rota objetorota = null;
        Veiculo objetoVeiculo = null;
        CinDex cindex = null;

        System.out.println("Bem vindo ao CinDex");
        System.out.println("Digite o tipo de repositório que gostaria de utilizar:");
        System.out.println("(0) Array");
        System.out.println("(1) Lista:");

        repositorio = in.nextInt();
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
            entrada = in.nextInt();
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
                        selecao = in.nextInt();
                        switch (selecao) {
                            case 1: {
                                System.out.print("Digite a coordenada X:");
                                double coordenadaX = in.nextInt();
                                System.out.print("Digite a coordenada Y:");
                                double coordenadaY = in.nextInt();
                                in.nextLine();
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
                                double coordenadaX = in.nextInt();
                                System.out.print("Digite a coordenada Y:");
                                double coordenadaY = in.nextInt();
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
                                double coordenadaX = in.nextInt();
                                System.out.print("Digite a coordenada Y:");
                                double coordenadaY = in.nextInt();
                                try {
                                    Local localEncotrado = cindex.procurarLocal(coordenadaX, coordenadaY);
                                    System.out.println("A Coordenada X do local é " + localEncotrado.getCoordenadax());
                                    System.out.println("A Coordenada Y do local é " + localEncotrado.getCoordenaday());
                                    System.out.println("O logradouro do local é " + localEncotrado.getLogradouro());
                                    System.out.println("A cidade do local é " + localEncotrado.getCidade());
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
                                System.out.print("Digite a coordenada X:");
                                double coordenadaX = in.nextInt();
                                System.out.print("Digite a coordenada Y:");
                                double coordenadaY = in.nextInt();
                                in.nextLine();
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
                        selecao = in.nextInt();
                        switch (selecao) {
                            case 1: {
                                System.out.println("Digite o identificador do Pacote:");
                                String identificador = in.next();
                                System.out.println("Digite o peso do Pacote:");
                                double peso = in.nextInt();
                                System.out.println("Digite a altura do Pacote:");
                                double altura = in.nextInt();
                                System.out.println("Digite a largura do Pacote:");
                                double largura = in.nextInt();
                                System.out.println("Digite o comprimento do Pacote:");
                                double comprimento = in.nextInt();
                                System.out.println("Digite o veículo do Pacote:");
                                String nome = in.next();
                                System.out.println("Digite a rota do Pacote:");
                                String codigo = in.next();
                                try {
                                    objetoPacote = new Pacote(identificador, peso, altura, largura, comprimento,
                                            cindex.procurarVeiculo(nome), cindex.procurarRota(codigo));
                                    try {
                                        cindex.cadastrarPacote(objetoPacote);
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
                                System.out.println("Digite o identificador do Pacote:");
                                String identificador = in.next();
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
                                System.out.println("Digite o identificador do Pacote:");
                                String identificador = in.next();
                                try {
                                    Pacote pacoteEncontrado = cindex.procurarPacote(identificador);
                                    System.out.println("Pacote Nº " + pacoteEncontrado.getIdentificador());
                                    System.out.println("O pacote tem " + pacoteEncontrado.getPeso() + " Kg");
                                    System.out.println("Dimensões do pacote(AxLxC): " + pacoteEncontrado.getAltura() + "x"
                                            + pacoteEncontrado.getLargura() + "x" + pacoteEncontrado.getComprimento());
                                    System.out.println("O pacote será transportado no " + pacoteEncontrado.getVeiculo().getNomeVeiculo());
                                    System.out.println("O pacote está na rota " + pacoteEncontrado.getRota().getCodigo());
                                } catch (PacoteNaoEncontradoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            }
                            case 4: {
                                System.out.println("Digite o identificador do Pacote:");
                                String identificador = in.next();
                                System.out.println("Digite o peso do Pacote:");
                                double peso = in.nextInt();
                                System.out.println("Digite a altura do Pacote:");
                                double altura = in.nextInt();
                                System.out.println("Digite a largura do Pacote:");
                                double largura = in.nextInt();
                                System.out.println("Digite o comprimento do Pacote:");
                                double comprimento = in.nextInt();
                                System.out.println("Digite o veículo do Pacote:");
                                String nome = in.next();
                                System.out.println("Digite a rota do Pacote:");
                                String codigo = in.next();
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
                    while (tipo != 3) {
                        System.out.println("Você está no gerenciamento de Pessoas");
                        System.out.println("O que deseja fazer ?");
                        System.out.println("(1) - Gerenciar Clientes");
                        System.out.println("(2) - Gerenciar Funcionários");
                        System.out.println("(3) - Sair");
                        tipo = in.nextInt();
                        if (tipo == 1) {
                            selecao = 0;
                            System.out.println("(1) - Cadastrar cliente");
                            System.out.println("(2) - Remover cliente");
                            System.out.println("(3) - Procurar cliente");
                            System.out.println("(4) - Atualizar cliente");
                            System.out.println("(5) - Sair");
                            selecao = in.nextInt();
                            in.nextLine();
                            if (selecao == 1) {
                                System.out.println("Digite o nome do cliente:");
                                String nome = in.nextLine();
                                System.out.println("Digite o identificador do cliente:");
                                String identificador = in.next();
                                System.out.println("Qual o sexo do cliente?");
                                String sexo = in.next();
                                System.out.println("Digite a data de nascimento do cliente:");
                                String dataNascimento = in.next();
                                System.out.println("Digite as coordenadas do cliente:");
                                System.out.println("Coordenada X:");
                                double coordenadaX = in.nextInt();
                                System.out.println("Coordenada Y:");
                                double coordenadaY = in.nextInt();
                                System.out.println("Digite o salário do cliente:");
                                double salario = in.nextInt();
                                System.out.println("Digite a matricula do cliente:");
                                String matricula = in.next();
                            } else if (selecao == 2) {
                                System.out.println("Digite o nome do cliente:");
                                String nome = in.nextLine();
                            } else if (selecao == 3) {
                                System.out.println("Digite o nome do cliente:");
                                String nome = in.nextLine();
                            } else if (selecao == 4) {
                                System.out.println("Digite o nome do cliente:");
                                String nome = in.nextLine();
                                System.out.println("Digite o identificador do cliente:");
                                String identificador = in.next();
                                System.out.println("Qual o sexo do cliente?");
                                String sexo = in.next();
                                System.out.println("Digite a data de nascimento do cliente:");
                                String dataNascimento = in.next();
                                System.out.println("Digite as coordenadas do cliente:");
                                System.out.println("Coordenada X:");
                                double coordenadaX = in.nextInt();
                                System.out.println("Coordenada Y:");
                                double coordenadaY = in.nextInt();
                                System.out.println("Digite o salário do cliente:");
                                double salario = in.nextInt();
                                System.out.println("Digite a matricula do cliente:");
                                String matricula = in.next();
                            } else if (selecao == 5) {
                            } else {
                                System.out.println("Opção inválida!");
                            }
                        } else if (tipo == 2) {
                            selecao = 0;
                            System.out.println("(1) - Cadastrar funcionário");
                            System.out.println("(2) - Remover funcionário");
                            System.out.println("(3) - Procurar funcionário");
                            System.out.println("(4) - Atualizar funcionário");
                            System.out.println("(5) - Sair");
                            selecao = in.nextInt();
                            in.nextLine();
                            if (selecao == 1) {
                                System.out.println("Digite o nome do funcionário:");
                                String nome = in.nextLine();
                                System.out.println("Digite o identificador do funcionário:");
                                String identificador = in.next();
                                System.out.println("Qual o sexo do funcionário?");
                                String sexo = in.next();
                                System.out.println("Digite a data de nascimento do funcionário:");
                                String dataNascimento = in.next();
                                System.out.println("Digite as coordenadas do funcionário:");
                                System.out.println("Coordenada X:");
                                double coordenadaX = in.nextInt();
                                System.out.println("Coordenada Y:");
                                double coordenadaY = in.nextInt();
                                System.out.println("Digite o salário do funcionário:");
                                double salario = in.nextInt();
                                System.out.println("Digite a matricula do funcionário:");
                                String matricula = in.next();
                            } else if (selecao == 2) {
                                System.out.println("Digite o nome do funcionário:");
                                String nome = in.nextLine();
                            } else if (selecao == 3) {
                                System.out.println("Digite o nome do funcionário:");
                                String nome = in.nextLine();
                            } else if (selecao == 4) {
                                System.out.println("Digite o nome do funcionário:");
                                String nome = in.nextLine();
                                System.out.println("Digite o identificador do funcionário:");
                                String identificador = in.next();
                                System.out.println("Qual o sexo do funcionário?");
                                String sexo = in.next();
                                System.out.println("Digite a data de nascimento do funcionário:");
                                String dataNascimento = in.next();
                                System.out.println("Digite as coordenadas do funcionário:");
                                System.out.println("Coordenada X:");
                                double coordenadaX = in.nextInt();
                                System.out.println("Coordenada Y:");
                                double coordenadaY = in.nextInt();
                                System.out.println("Digite o salário do funcionário:");
                                double salario = in.nextInt();
                                System.out.println("Digite a matricula do funcionário:");
                                String matricula = in.next();
                            } else if (selecao == 5) {
                            } else {
                                System.out.println("Opção inválida!");
                            }

                        } else {
                            System.out.println("Opção inválida");
                        }
                    }
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
                    selecao = in.nextInt();
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
                            double coordenadaX = in.nextInt();
                            System.out.println("Coordenada Y:");
                            double coordenadaY = in.nextInt();
                            break;
                        }
                        case 2: {
                            System.out.println("Digite o código da Rota:");
                            String codigo = in.next();
                            break;
                        }
                        case 3: {
                            System.out.println("Digite o código da Rota:");
                            String codigo = in.next();
                            break;
                        }
                        case 4: {
                            System.out.println("Digite o código da Rota:");
                            String codigo = in.next();
                            System.out.println("Digite o tipo da Rota:");
                            String tipo = in.next();
                            System.out.println("Digite a periculosidade da Rota:");
                            String periculosidade = in.next();
                            System.out.println("Digite as coordenadas do Local da Rota:");
                            System.out.println("Coordenada X:");
                            double coordenadaX = in.nextInt();
                            System.out.println("Coordenada Y:");
                            double coordenadaY = in.nextInt();
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
                    selecao = in.nextInt();
                    switch (selecao) {
                        case 1: {
                            System.out.println("Digite o nome do Veículo:");
                            String nome = in.next();
                            System.out.println("Digite o tipo do veiculo:");
                            String tipo = in.next();
                            System.out.println("Digite a capacidade do Veículo:");
                            int capacidade = in.nextInt();
                            break;
                        }
                        case 2: {
                            System.out.println("Digite o nome do Veículo:");
                            String nome = in.next();
                            break;
                        }
                        case 3: {
                            System.out.println("Digite o nome do Veículo:");
                            String nome = in.next();
                            break;
                        }
                        case 4: {
                            System.out.println("Digite o nome do Veículo:");
                            String nome = in.next();
                            System.out.println("Digite o tipo do veiculo:");
                            String tipo = in.next();
                            System.out.println("Digite a capacidade do Veículo:");
                            int capacidade = in.nextInt();
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
