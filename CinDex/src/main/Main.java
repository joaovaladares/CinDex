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
        CinDex cindex = new CinDex(true);
//        CinDex cindex = new CinDex(false);

        Veiculo veiculo1 = new Veiculo("Carrão", "Carro", 20);
        try{
            cindex.cadastrarVeiculo(veiculo1);
        }catch (VeiculoJaExistenteException e){
            e.getMessage();
        }catch(LimiteAtingidoException e){
            e.getMessage();
        }catch (TipoVeiculoInvalidoException e){
            e.getMessage();
        }catch (VeiculoCapacidadeInvalida e){
            e.getMessage();
        }
        String teste = "";
        try{
            teste = cindex.procurarVeiculo("Carrã").getTipoVeiculo();
        }catch (VeiculoNaoEncontradoException e){
            System.out.println(e.getMessage());
        }
        System.out.println(teste);



        Veiculo veiculo2 = new Veiculo("14 Bis", "Avião", 8001);
        Veiculo veiculo3 = new Veiculo("Carrão", "Carro", 20);
        Veiculo veiculo4 = new Veiculo("Teste", "Bicicleta", 2);

//        Rota rota1 = new Rota()

//
//        Pacote pacote = new Pacote("000001", 3, 1, 1, 1, veiculo1, )



        Scanner in = new Scanner(System.in);

        int entrada = 0, repositorio;

        System.out.println("Bem vindo ao CinDex");
        System.out.println("Digite o tipo de repositório que gostaria de utilizar:");
        System.out.println("(0) Array");
        System.out.println("(1) Lista:");

        repositorio = in.nextInt();
//        if(repositorio == 1){
//            CinDex cindex = new CinDex(true);
//        }else{
//            CinDex cindex = new CinDex(false);
//        }

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
                                break;
                            }
                            case 2: {
                                System.out.print("Digite a coordenada X:");
                                double coordenadaX = in.nextInt();
                                System.out.print("Digite a coordenada Y:");
                                double coordenadaY = in.nextInt();
                                break;
                            }
                            case 3: {
                                System.out.print("Digite a coordenada X:");
                                double coordenadaX = in.nextInt();
                                System.out.print("Digite a coordenada Y:");
                                double coordenadaY = in.nextInt();
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
                                int peso = in.nextInt();
                                System.out.println("Digite a altura do Pacote:");
                                int altura = in.nextInt();
                                System.out.println("Digite a largura do Pacote:");
                                int largura = in.nextInt();
                                System.out.println("Digite o comprimento do Pacote:");
                                int comprimento = in.nextInt();
                                System.out.println("Digite o veículo do Pacote:");
                                String veiculo = in.next();
                                System.out.println("Digite a rota do Pacote:");
                                String rota = in.next();
                                break;
                            }
                            case 2: {
                                System.out.println("Digite o identificador do Pacote:");
                                String identificador = in.next();
                                break;
                            }
                            case 3: {
                                System.out.println("Digite o identificador do Pacote:");
                                String identificador = in.next();
                                break;
                            }
                            case 4: {
                                System.out.println("Digite o identificador do Pacote:");
                                String identificador = in.next();
                                System.out.println("Digite o peso do Pacote:");
                                int peso = in.nextInt();
                                System.out.println("Digite a altura do Pacote:");
                                int altura = in.nextInt();
                                System.out.println("Digite a largura do Pacote:");
                                int largura = in.nextInt();
                                System.out.println("Digite o comprimento do Pacote:");
                                int comprimento = in.nextInt();
                                System.out.println("Digite o veículo do Pacote:");
                                String veiculo = in.next();
                                System.out.println("Digite a rota do Pacote:");
                                String rota = in.next();
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
                    while (selecao != 5) {
                        System.out.println("Você está no gerenciamento de Pessoas");
                        System.out.println("O que deseja fazer ?");
                        System.out.println("(1) - Cadastrar Pessoa");
                        System.out.println("(2) - Remover Pessoa");
                        System.out.println("(3) - Procurar Pessoa");
                        System.out.println("(4) - Atualizar Pessoa");
                        System.out.println("(5) - Sair");
                        selecao = in.nextInt();
                        in.nextLine();
                        switch (selecao) {
                            case 1: {
                                System.out.println("Digite o nome da pessoa:");
                                String nome = in.nextLine();
                                System.out.println("Digite o identificador da pessoa:");
                                String identificador = in.next();
                                System.out.println("Qual o sexo da pessoa?");
                                String sexo = in.next();
                                System.out.println("Digite a data de nascimento da pessoa:");
                                String dataNascimento = in.next();
                                System.out.println("Digite as coordenadas da pessoa:");
                                System.out.println("Coordenada X:");
                                double coordenadaX = in.nextInt();
                                System.out.println("Coordenada Y:");
                                double coordenadaY = in.nextInt();
                                System.out.println("Digite o salário da pessoa:");
                                double salario = in.nextInt();
                                System.out.println("Digite a matricula da pessoa:");
                                String matricula = in.next();
                                break;
                            }
                            case 2: {
                                System.out.println("Digite o nome da pessoa:");
                                String nome = in.nextLine();
                                break;
                            }
                            case 3: {
                                System.out.println("Digite o nome da pessoa:");
                                String nome = in.nextLine();
                                break;
                            }
                            case 4: {
                                System.out.println("Digite o nome da pessoa:");
                                String nome = in.nextLine();
                                System.out.println("Digite o identificador da pessoa:");
                                String identificador = in.next();
                                System.out.println("Qual o sexo da pessoa?");
                                String sexo = in.next();
                                System.out.println("Digite a data de nascimento da pessoa:");
                                String dataNascimento = in.next();
                                System.out.println("Digite as coordenadas da pessoa:");
                                System.out.println("Coordenada X:");
                                double coordenadaX = in.nextInt();
                                System.out.println("Coordenada Y:");
                                double coordenadaY = in.nextInt();
                                System.out.println("Digite o salário da pessoa:");
                                double salario = in.nextInt();
                                System.out.println("Digite a matricula da pessoa:");
                                String matricula = in.next();
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
