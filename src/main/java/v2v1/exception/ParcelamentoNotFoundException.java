package v2v1.exception;

public class ParcelamentoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParcelamentoNotFoundException(String mensagem) {
		super(mensagem);
	}

	public ParcelamentoNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
