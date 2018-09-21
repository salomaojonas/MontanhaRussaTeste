import java.util.ArrayList;
import java.util.List;


public class Fila {

	private int numeroPessoasFila = 0;
	private ArrayList<Pessoa> pessoasNaFila;
	private Montanha montanha;
	private Vagao vagao;
	
	
	public ArrayList<Pessoa> getPessoasNaFila() {
		return pessoasNaFila;
	}

	public void setPessoasNaFila(ArrayList<Pessoa> pessoasNaFila) {
		this.pessoasNaFila = pessoasNaFila;
	}

	public synchronized boolean aptoParaPopularVagao(Fila fila) {
		return (fila.getPessoasNaFila().size() == fila.getVagao().getQuantidadeCadeiras()) ? true : false ;
	}
	
	
	public Fila() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fila(int numeroPessoasFila) {
		super();
		this.numeroPessoasFila = numeroPessoasFila;
	}

	public Fila(int numeroPessoasFila, Vagao vagao) {
		super();
		this.numeroPessoasFila = numeroPessoasFila;
		this.vagao = vagao;
	}



	public Fila(ArrayList<Pessoa> pessoasFila, Vagao vagao) {
		super();
		this.pessoasNaFila = pessoasFila;
		this.vagao = vagao;
	}

	void entrarFila(){
		synchronized (this) {
			this.numeroPessoasFila++;
		}
	}


	public synchronized void addPessoa(Pessoa pessoa) throws InterruptedException{
		
		pessoa.getFila().getPessoasNaFila().add(pessoa);
		System.out.println("pessoa adicionada "+pessoa.getId() +" | TE: "+pessoa.getTempoEmbarque() + " | TD: "+pessoa.getTempoDesembarque());
		
		if(this.aptoParaPopularVagao(pessoa.getFila())) {
			System.out.println("APTO PARA VOTAR");

			Thread v = new Thread(pessoa.getFila().getVagao());
			v.start();
		}
	}
	
	void removePessoa(Pessoa pessoa){
		
		synchronized (this) {
			ArrayList<Pessoa> pessoas = this.pessoasNaFila;
			for(Pessoa pessoaFIla : pessoas){
				if(pessoaFIla.getId()==pessoa.getId())
					this.pessoasNaFila.remove(pessoa);
			}
		}
		
	}
	
	void zerarFila(){
		this.pessoasNaFila = new ArrayList<Pessoa>();
	}
	
	public int getNumeroPessoasFila() {
		return numeroPessoasFila;
	}

	public void setNumeroPessoasFila(int numeroPessoasFila) {
		this.numeroPessoasFila = numeroPessoasFila;
	}

	public Montanha getMontanha() {
		return montanha;
	}

	public void setMontanha(Montanha montanha) {
		this.montanha = montanha;
	}

	public Vagao getVagao() {
		return vagao;
	}

	public void setVagao(Vagao vagao) {
		this.vagao = vagao;
	}

	

}
