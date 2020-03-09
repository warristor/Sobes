package Sobes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	// метод возвращает тариф по заданному диапазону параметров
    static void chooseTarifPrice(List<MTS> a, double min, double max) {  

		for (MTS m : a) {
			if (max >= m.getPrice() | min <= m.getPrice())
				System.out.println(m);
		}

	}

	//подсчитывает количество клиентов////
	static int getSumClient(List<MTS> a) { 

		int sum = 0;
		for (MTS m : a) {
			sum += m.getClient();
		}
		return sum;
	}

	public static void main(String[] args) {
		
		
		//Создал список тарифов компании
		List<MTS> ar = new ArrayList<>();            
		ar.add(new Bezlimit(11, "Bezlimit", 17));
		ar.add(new Start(5, "Start", 23));

		
		// подсчитали общее количество клиентов
		System.out.println(getSumClient(ar));       

		
		//создаем компаратор для сортировки по цене тарифа
		Comparator<MTS> comp = (o, o1) -> o.getPrice().compareTo(o1.getPrice());
		ar.sort(comp);
		System.out.println(ar);

		// выбирает тариф по заданному диапазону
		chooseTarifPrice(ar, 20, 30);

	}

}
