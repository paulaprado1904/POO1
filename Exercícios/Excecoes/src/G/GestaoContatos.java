package G;

import java.util.HashMap;

public class GestaoContatos {
    private HashMap<String, Contato> familia;
    private HashMap<String, Contato> amigos;
    private HashMap<String, Contato> profissional;

    public GestaoContatos() {
        this.familia = new HashMap<>();
        this.amigos = new HashMap<>();
        this.profissional = new HashMap<>();
    }

    public void adicionaContato(Contato contato, HashMap<String, Contato> mapa) {
        mapa.put(contato.getNome(), contato);
    }

    public void eliminaContato(String nome, HashMap<String, Contato> mapa) throws ContatoNaoEncontradoException {
        if (mapa.containsKey(nome)) {
            mapa.remove(nome);
        } else {
            throw new ContatoNaoEncontradoException();
        }
    }

    public void listaContatos(HashMap<String, Contato> mapa) {
        for (Contato contato : mapa.values()) {
            System.out.println(contato);
        }
    }

    public Contato maisVelho(HashMap<String, Contato> mapa) {
        Contato maisVelho = null;
        for (Contato contato : mapa.values()) {
            if (maisVelho == null || contato.getIdade() > maisVelho.getIdade()) {
                maisVelho = contato;
            }
        }
        return maisVelho;
    }

    public Contato maisNovo(HashMap<String, Contato> mapa) {
        Contato maisNovo = null;
        for (Contato contato : mapa.values()) {
            if (maisNovo == null || contato.getIdade() < maisNovo.getIdade()) {
                maisNovo = contato;
            }
        }
        return maisNovo;
    }

    public HashMap<String, Contato> getFamilia() {
        return familia;
    }

    public void setFamilia(HashMap<String, Contato> familia) {
        this.familia = familia;
    }

    public HashMap<String, Contato> getAmigos() {
        return amigos;
    }

    public void setAmigos(HashMap<String, Contato> amigos) {
        this.amigos = amigos;
    }

    public HashMap<String, Contato> getProfissional() {
        return profissional;
    }

    public void setProfissional(HashMap<String, Contato> profissional) {
        this.profissional = profissional;
    }
}
