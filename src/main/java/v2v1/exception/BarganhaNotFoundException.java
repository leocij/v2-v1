package v2v1.exception;

public class BarganhaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BarganhaNotFoundException(String mensagem) {
		super(mensagem);
	}

	public BarganhaNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
