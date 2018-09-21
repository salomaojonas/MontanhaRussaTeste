
public class PopulaFila implements Runnable{

	private Fila fila;

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("entrou");
		int i, id, te, td;
		for(i=1;i<11; i++){
			td=i*10;
			te=i*20;
			id=i;
			Pessoa pessoa = new Pessoa(id, te, td, this.getFila());
			Thread p = new Thread(pessoa);
			p.start();
		}
		
	}
	
	public PopulaFila(Fila fila){
		this.fila = fila;
	}

	void inicia(){
		Thread alimenta = new Thread(this);
		alimenta.start();
	}
	
	
	
	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}
	
}
