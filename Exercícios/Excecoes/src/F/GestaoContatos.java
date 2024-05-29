package F;
import java.util.ArrayList;

public class GestaoContatos {
    private ArrayList<Contato> familia;
    private ArrayList<Contato> amigos;
    private ArrayList<Contato> profissional;

    public ArrayList<Contato> getFamilia() {
        return familia;
    }

    public void setFamilia(ArrayList<Contato> familia) {
        this.familia = familia;
    }

    public ArrayList<Contato> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Contato> amigos) {
        this.amigos = amigos;
    }

    public ArrayList<Contato> getProfissional() {
        return profissional;
    }

    public void setProfissional(ArrayList<Contato> profissional) {
        this.profissional = profissional;
    }

    public GestaoContatos() {
        this.familia = new ArrayList<>();
        this.amigos = new ArrayList<>();
        this.profissional = new ArrayList<>();
    }

    public void adicionaContato(Contato contato, ArrayList<Contato> lista) {
        lista.add(contato);
    }

    public void eliminaContato(String nome, ArrayList<Contato> lista) throws ContatoNaoEncontradoException {
        Contato contatoRemovido = null;
        for (Contato contato : lista) {
            if (contato.getNome().equals(nome)) {
                contatoRemovido = contato;
                break;
            }
        }

        if (contatoRemovido != null) {
            lista.remove(contatoRemovido);
        } else {
            throw new ContatoNaoEncontradoException();
        }
    }

    public void listaContatos(ArrayList<Contato> lista) {
        for (Contato contato : lista) {
            System.out.println(contato);
        }
    }

    public Contato maisVelho(ArrayList<Contato> lista) {
        Contato maisVelho = lista.get(0);
        for (Contato contato : lista) {
            if (contato.getIdade() > maisVelho.getIdade()) {
                maisVelho = contato;
            }
        }
        return maisVelho;
    }

    public Contato maisNovo(ArrayList<Contato> lista) {
        Contato maisNovo = lista.get(0);
        for (Contato contato : lista) {
            if (contato.getIdade() < maisNovo.getIdade()) {
                maisNovo = contato;
            }
        }
        return maisNovo;
    }
}
