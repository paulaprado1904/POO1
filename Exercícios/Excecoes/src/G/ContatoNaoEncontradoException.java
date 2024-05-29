package G;
public class ContatoNaoEncontradoException extends Exception {
    public ContatoNaoEncontradoException() {
        super("Contato não encontrado.");
    }
}
