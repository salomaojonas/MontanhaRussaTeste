import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;


public class Pessoa implements Runnable{

	private Integer id;
	private Integer tempoEmbarque;
	private Integer tempoDesembarque;
	private static Montanha montanha;
	private Fila fila;
	
	public Pessoa(Integer id, Integer tempoEmbarque, Integer tempoDesembarque, Montanha montanha) {
		super();
		this.id = id;
		this.tempoEmbarque = tempoEmbarque;
		this.tempoDesembarque = tempoDesembarque;
		this.montanha = montanha;
	}

	public Pessoa(Integer id, Integer tempoEmbarque, Integer tempoDesembarque, Fila  fila) {
		super();
		this.id = id;
		this.tempoEmbarque = tempoEmbarque;
		this.tempoDesembarque = tempoDesembarque;
		this.setFila(fila);
	}
	public Pessoa(Integer id, Integer tempoEmbarque, Integer tempoDesembarque) {
		super();
		this.id = id;
		this.tempoEmbarque = tempoEmbarque;
		this.tempoDesembarque = tempoDesembarque;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTempoEmbarque() {
		return tempoEmbarque;
	}

	public void setTempoEmbarque(Integer tempoEmbarque) {
		this.tempoEmbarque = tempoEmbarque;
	}

	public Integer getTempoDesembarque() {
		return tempoDesembarque;
	}

	public void setTempoDesembarque(Integer tempoDesembarque) {
		this.tempoDesembarque = tempoDesembarque;
	}



	public Montanha getMontanha() {
		return montanha;
	}

	public void setMontanha(Montanha montanha) {
		this.montanha = montanha;
	}

	public void run() {
		try {
			this.getFila().addPessoa(this);
			Thread.sleep(1000);
			this.wait();
            this.getMontanha().getVagao().notify();
		} catch (Exception e) {
	//        System.out.println("Thread interrompida");
	    }
		
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}
	
	
	
}
