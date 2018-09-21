import java.util.ArrayList;


public class Vagao implements Runnable{

	private Integer quantidadeCadeiras;
	private Integer tempoViagem;
	private ArrayList<Pessoa> passageiros;
	
	private Fila fila;
	private Montanha montanha;


	
	
	
	public boolean vagaoCheio(){
		Boolean b;
		b = (passageiros.size() == quantidadeCadeiras) ? true : false;
		return b;
	}
	
	public Vagao(Integer quantidadeCadeiras, Integer tempoViagem) {
		super();
		this.quantidadeCadeiras = quantidadeCadeiras;
		this.tempoViagem = tempoViagem;
	}

	public synchronized void addPassageiroFila(Pessoa pessoa) throws InterruptedException {
		pessoa.getMontanha().getFila().addPessoa(pessoa);
		this.removerPassageiroVagao(pessoa);
	}

	public synchronized void reiniciarVagao(){
		synchronized (this) {
			this.passageiros = new ArrayList<Pessoa>();
		}
	}
	
	public synchronized boolean addPessoaVagao(Pessoa pessoa){
		if(!vagaoCheio()){
			System.out.println("Pode entrar, tem vaga");
			ArrayList<Pessoa> passageiros = this.getPassageiros();
			passageiros.add(pessoa);
			this.setPassageiros(passageiros);
			return true;
		}else{
			System.out.println("Vagão tá cheio");
			return false;
		}
	}
	public synchronized void removerPassageiroVagao(Pessoa pessoa){
		this.getPassageiros().remove(pessoa);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			try {
				System.out.println("vagao comecando");
				Thread.sleep(tempoViagem * 1000);  //volta da montanha
				System.out.println("fim vagao");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
	
	void inicia(){
		
	}
	
	
	
	
	
	
	
	public Integer getTempoViagem() {
		return tempoViagem;
	}

	public void setTempoViagem(Integer tempoViagem) {
		this.tempoViagem = tempoViagem;
	}

	public Integer getQuantidadeCadeiras() {
		return quantidadeCadeiras;
	}

	public void setQuantidadeCadeiras(Integer quantidadeCadeiras) {
		this.quantidadeCadeiras = quantidadeCadeiras;
	}


	public ArrayList<Pessoa> getPassageiros() {
		return passageiros;
	}


	public void setPassageiros(ArrayList<Pessoa> passageiros) {
		this.passageiros = passageiros;
	}

	public Montanha getMontanha() {
		return montanha;
	}

	public void setMontanha(Montanha montanha) {
		this.montanha = montanha;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}

}
