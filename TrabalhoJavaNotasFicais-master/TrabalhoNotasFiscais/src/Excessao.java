
public class Excessao extends Exception {

	private static final long serialVersionUID = -5977373508888201087L;

	public Excessao(String msg) {
		super("Erro na opera��o: " + msg);
	}
}
