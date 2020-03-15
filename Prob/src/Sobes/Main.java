package Sobes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Main {
		
	
	// метод возвращает тариф по заданному диапазону параметров
    
	
	
	static Optional<MTS> chooseTarifPrice(List<MTS> a, double min, double max) throws Exception {  

    	    	
		    for (MTS m : a) {
		       	if (max >= m.getPrice() && min >= m.getPrice())
		  	       	return Optional.of(m);
     	    }
        return Optional.empty();
        	    //Collections.min(a,((b,c)->b.getPrice().compareTo(c.getPrice())));
        		//a.stream().min((b,c)->b.getPrice().compareTo(c.getPrice())).get();
     }
	
			
	    
 public static void main(String[] args) throws Exception  {
		 
	 
   //Создал список тарифов компании
   List<MTS> ar = new ArrayList<>();            
   ar.add(new Start(5, "Start", 23));
   ar.add(new Bezlimit(11, "Bezlimit", 17));
			  

   // подсчитали общее количество клиентов
   System.out.println("Общее количество клиентов: "+ar.stream()
                                                      .mapToInt(MTS::getClient).sum());
		
		
   //создаем компаратор для сортировки по цене тарифа
   List<MTS>ll=ar.stream().sorted((o, o1) -> o.getPrice().compareTo(o1.getPrice()))
		                  .collect(Collectors.toList());
        
   System.out.println(ll);
        	
        
   // выбирает тариф по заданному диапазону
   
     System.out.println(chooseTarifPrice(ll, 16, 22));

 }

}
