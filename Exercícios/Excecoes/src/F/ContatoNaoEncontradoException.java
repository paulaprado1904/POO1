package F;
public class ContatoNaoEncontradoException extends Exception {
    public ContatoNaoEncontradoException() {
        super("Contato não encontrado.");
    }
}
