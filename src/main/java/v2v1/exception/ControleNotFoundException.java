package v2v1.exception;

public class ControleNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ControleNotFoundException(String mensagem) {
		super(mensagem);
	}

	public ControleNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
