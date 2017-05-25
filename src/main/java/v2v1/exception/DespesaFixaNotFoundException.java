package v2v1.exception;

public class DespesaFixaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DespesaFixaNotFoundException(String mensagem) {
		super(mensagem);
	}

	public DespesaFixaNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
