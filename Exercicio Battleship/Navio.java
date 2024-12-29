import java.util.*;
class Navio {
   private ArrayList<String> celulas;
   private String name;

   void setName(String name){
	this.name = name;
   }

   void setCelulas(ArrayList<String> celulas) {
	this.celulas = celulas;
   }

   String verify(String entrada){
	String result = "errou";
	int index = celulas.indexOf(entrada);

	// CASO ACHE, O INDEX SERÁ UM NUMERO DE 0 AO 2
	if(index >= 0){
	   celulas.remove(entrada);
	   if(celulas.isEmpty()){
		System.out.println("Parabens! Você eliminou o "+name);
		result = "ELIMINADO!!!";
	   }
	   else{
		result = "acertou!";
	   }
	}
	return result;
   }
}