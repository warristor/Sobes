package Sobes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	// метод возвращает тариф по заданному диапазону параметров
    static MTS chooseTarifPrice(List<MTS> a, double min, double max) {  

    	    	
		    for (MTS m : a) {
		       	if (max >= m.getPrice() && min <= m.getPrice())
		  	       	return m;
     	    }
        return a.get(0);
	}
   

 public static void main(String[] args) {
		
		
   //Создал список тарифов компании
   List<MTS> ar = new ArrayList<>();            
   ar.add(new Start(5, "Start", 23));
   ar.add(new Bezlimit(11, "Bezlimit", 17));
							

   // подсчитали общее количество клиентов
   Stream<MTS> st=ar.stream();
   System.out.println("Общее количество клиентов: "+st.mapToInt(MTS::getClient).sum());
		
		
   //создаем компаратор для сортировки по цене тарифа
   st=ar.stream();
   List<MTS>ll=st.sorted((o, o1) -> o.getPrice().compareTo(o1.getPrice())).collect(Collectors.toList());
        
   System.out.println(ll);
        	
        
   // выбирает тариф по заданному диапазону
   System.out.println(chooseTarifPrice(ll, 20, 30));

 }

}
