package Sobes;

public abstract class MTS {

	private Integer client;
	private String tarif;
	private Double price;

	MTS(int c, String t, double p) {
		this.client = c;
		this.tarif = t;
		this.price = p;
	}

	Integer getClient() {
		return client;
	}

	Double getPrice() {
		return price;
	}

	String getTarif() {
		return tarif;
	}

	void setClient(int c) {
		this.client = c;
	}

	void setPrice(double p) {
		this.price = p;
	}

	void setTarif(String s) {
		this.tarif = s;
	}

	@Override
	public String toString() {
		return "Клиент=" + client + "  Тариф=" + tarif + " Цена=" + price + "\n";

	}

}
