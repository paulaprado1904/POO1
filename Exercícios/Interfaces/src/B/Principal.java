package B;

public class Principal {
    public static void main(String[] args){
        Veiculo v[] = new Veiculo[5];
        String marcaMaior = "";
        String marcaMenor = "";
        int maior = 0;
        int menor = Integer.MAX_VALUE;


        v[0] = new Carros("Volvo", "2020", "Branco", 1200);
        v[1] = new Carros("Fiat", "Argo", "Vermelho", 900);
        v[2] = new Carros("Ford", "Ka", "Preto", 400);
        v[3] = new Caminhoes("Mitsubishi", "Truck", "Chumbo", 15000);
        v[4] = new Carros("Volks", "Carreta", "Vermelho", 13000);

        for(Veiculo vei : v){
            if (vei.cor().equals("Vermelho")) {
                if(maior < vei.potencial()){
                    maior = vei.potencial();
                    marcaMaior = vei.marca();
                }
                if(menor > vei.potencial()){
                    menor = vei.potencial();
                    marcaMenor = vei.marca();
                }
            }
        }

        System.out.println("Dentre os carros vermelhos, o mais potente eh: " + marcaMaior + ", e o menos potente eh " + marcaMenor);
    }
}
