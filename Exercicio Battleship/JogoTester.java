import java.util.*;
class JogoTester {
   private ArrayList<Navio> listaNavios = new ArrayList<Navio>();
   private GameHelper helper = new GameHelper();
   private int numOfGuesses = 0;

   private void configJogo(){
	Navio shipp1 = new Navio();
	Navio shipp2 = new Navio();
	Navio shipp3 = new Navio();

	shipp1.setName("Titanic");
	shipp2.setName("Raquel Cruzeiros");
	shipp3.setName("Mario Cruzeiros");

	listaNavios.add(shipp1);
	listaNavios.add(shipp2);
	listaNavios.add(shipp3);

	for(Navio shippToLocate:listaNavios){
	   ArrayList<String> locais = helper.placeDotCom(3);
	   shippToLocate.setCelulas(locais);
	}

	System.out.println("Seu objetivo é destruir o máximo de navios possiveis!");
	System.out.println("Boa sorte :)");
   }

   private void comecarJogo(){
	while(!listaNavios.isEmpty()){
	   String entradaUsuario = helper.getUserInput("Digite uma célula: ");
	   verificarEntrada(entradaUsuario);
	}
	acabarJogo();
   }

   private void verificarEntrada(String entrada){
	numOfGuesses++;
	String result = "errou";
	for(Navio shippToVerify:listaNavios){
	   result = shippToVerify.verify(entrada);

	   if(result.equals("acertou!")){
		break;
	   }
	   if(result.equals("ELIMINADO!!!")){
		listaNavios.remove(shippToVerify);
		break;
	   }
	}
	System.out.println(result);
   }

   private void acabarJogo(){
	System.out.println("Você eliminou todos os navios !");
	if(numOfGuesses <= 18){
	   System.out.println("Você usou "+numOfGuesses+" tentativas. Muito estrategísta.");
	}
	else{
	   System.out.println("Você usou "+numOfGuesses+" tentativas. Ainda bem que não é uma guerra de verdade...");
	}
   }

   public static void main(String[] args){
	JogoTester jogo = new JogoTester();
	jogo.configJogo();
	jogo.comecarJogo();
   }

}