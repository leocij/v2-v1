package v2v1.exception;

public class EmprestimoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmprestimoNotFoundException(String mensagem) {
		super(mensagem);
	}

	public EmprestimoNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
