import java.util.ArrayList;


public class Montanha {

	private Fila fila;
	private Vagao vagao;
	private ArrayList<Pessoa> passageiros;
	
	public Montanha(Fila fila, ArrayList<Pessoa> passageiros) {
		super();
		this.fila = fila;
		this.passageiros = passageiros;
		this.vagao = vagao;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		int i, id, te, td;
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		ArrayList<Pessoa> iniciaFila = new ArrayList<Pessoa>();

		Vagao vagao = new Vagao(5, 60);
		Fila fila = new Fila(iniciaFila, vagao);

		Montanha montanha = new Montanha(fila, pessoas);
		fila.setMontanha(montanha);

		vagao.setMontanha(montanha);

		PopulaFila popular = new PopulaFila(fila);
		popular.inicia();
		
		System.out.println("Fim da execucao");
	}
	
	public void darUmaVolta(){
		
	}

	public Fila getFila() {
		return fila;
	}


	public void setFila(Fila fila) {
		this.fila = fila;
	}


	public Vagao getVagao() {
		return vagao;
	}


	public void setVagao(Vagao vagao) {
		this.vagao = vagao;
	}

	public ArrayList<Pessoa> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(ArrayList<Pessoa> passageiros) {
		this.passageiros = passageiros;
	}



}
