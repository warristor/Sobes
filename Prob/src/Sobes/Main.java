package Sobes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // метод возвращает тариф по заданному диапазону параметров
    static List<MTS> chooseTarifPrice(List<MTS> listMTS, double min, double max) {

	return listMTS.stream().filter(obj -> max >= obj.getPrice() && min >= obj.getPrice())
		               .collect(Collectors.toList());
    }

    public static void main(String[] args) {

	// Создал список тарифов компании
	List<MTS> listMTS = new ArrayList<>();
	listMTS.add(new Start(5, "Start", 23));
	listMTS.add(new Bezlimit(11, "Bezlimit", 17));

	// подсчитали общее количество клиентов
	Integer sum = listMTS.stream().mapToInt(MTS::getClient).sum();

	// выводим на консоль сумму клиентов
	System.out.println("Общее количество клиентов: " + sum);

//		Optional<Integer> sum = listMTS.stream().map(MTS::getClient)
///                .reduce((intClient1, intClient2) -> intClient1 + intClient2);

	// сортируем тарифы по цене
	listMTS.sort((obj, obj1) -> obj.getPrice().compareTo(obj1.getPrice()));

//		List<MTS> listSorted = listMTS.stream().sorted((obj, obj1) -> obj.getPrice().compareTo(obj1.getPrice()))
//				                       .collect(Collectors.toList());

	// выводим на консоль отсортированый список
	System.out.println(listMTS);

	// выводим тариф на консоль по заданному диапазону
	System.out.println(chooseTarifPrice(listMTS, 17, 22));

    }

}
