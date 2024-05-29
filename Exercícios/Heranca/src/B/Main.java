package B;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CD[] cds = new CD[5];
        DVD[] dvds = new DVD[5];
        VHS[] vhsList = new VHS[5];

        cds[0] = new CD("CD1", "Áudio", "Rock", 10.0F, true, "Cantor1", 9);

        List<String> atoresDVD1 = new ArrayList<>();
        atoresDVD1.add("Juquinha");
        atoresDVD1.add("Ana Banana");
        atoresDVD1.add("Estrela Cadente");
        atoresDVD1.add("Nobrega");
        dvds[0] = new DVD("DVD1", "Vídeo", "Ação", 15.0F, true, atoresDVD1, "Diretor1", 120);

        vhsList[0] = new VHS("VHS1", "Vídeo", "Comédia", 5.0F, true, true);

        // Calcular o número de atores em um DVD
        int numeroAtoresDVD1 = dvds[0].calcularNumeroAtores();
        System.out.println("Número de atores no DVD1: " + numeroAtoresDVD1);

        // Verificar se uma fita VHS está rebobinada
        boolean rebobinadaVHS1 = vhsList[0].isRebobinada();
        System.out.println("A fita VHS1 está rebobinada? " + ((rebobinadaVHS1) ?  "Sim" : "Nao"));

        // Alterar o preço de um CD
        cds[0].setPreco(12.0F);
    }
}
