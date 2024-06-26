package alura.conversor.principal;

import alura.conversor.api.ConsomeApi;
import alura.conversor.dados.ConverteDados;
import alura.conversor.dados.Moedas;
import alura.conversor.dados.MoedasNome;

import java.util.Scanner;

public class Principal {

    private ConsomeApi consumo = new ConsomeApi();
    private ConverteDados conversor = new ConverteDados();
    private Scanner leitura = new Scanner(System.in);


    public void exibeMenu() {
        System.out.println(String.format("""
                ==============================================================
                            CONVERSOR DE MOEDAS ALURA CHALLENGE
                            
                MOEDAS DISPONIVEIS : DOLAR | EURO | REAL | PESO !
                =============================================================="""));

        System.out.println("Digite o valor a ser convertido:");
        double valorPararConversao = leitura.nextDouble();
        leitura.nextLine();

        System.out.println("Quero Converter para Moeda:");
        var nomePrimeiraMoeda = leitura.nextLine();
        String moeda1 = String.valueOf(MoedasNome.fromPortugues(nomePrimeiraMoeda));


        System.out.println("Para Moeda:");
        var nomeSegundaMoeda = leitura.nextLine();
        String moeda2 = String.valueOf(MoedasNome.fromPortugues(nomeSegundaMoeda));


        var json = consumo.obterDados(moeda1, moeda2);
        var taxa = conversor.obterDados(json, Moedas.class);
        double taxaConversao = taxa.conversion_rate();


        double valorConvetido = valorPararConversao * taxaConversao;

        System.out.println(String.format("""
                O Valor de %.2f em %s 
                É de %.2f quando convertido para %s
                
                Valor Atual usado como Base Para Conversao %.2f
                """, valorPararConversao,nomePrimeiraMoeda, valorConvetido, nomeSegundaMoeda, taxaConversao ));

    }
}