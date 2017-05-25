package v2v1.exception;

public class GanhoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GanhoNotFoundException(String mensagem) {
		super(mensagem);
	}

	public GanhoNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
