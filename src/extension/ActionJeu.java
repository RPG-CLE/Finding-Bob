package extension;
import java.util.Scanner;

import client.*;
import client.Character;

public class ActionJeu implements IAJ {
	@Override
	public void action(Game game) {
		// TODO Auto-generated method stub
	   Scanner reader = new Scanner(System.in);  // Reading from System.in
	   System.out.println("Saisissez un déplacement : z = haut, s = bas, q = gauche, d = droite ");
	   String choix = reader.nextLine();
	   
	   switch(choix){
	   case "z" :
		   ((Character)game.getPlayer()).move(Direction.UP);
		   break;
	   case "s" :
		   ((Character)game.getPlayer()).move(Direction.DOWN);
		   break;
	   case "q" :
		   ((Character)game.getPlayer()).move(Direction.LEFT);
		   break;
	   case "d" :
		   ((Character)game.getPlayer()).move(Direction.RIGHT);
		   break;
	   default:{return;}
	   }
	   
	   if(game.getMonster().getX()==game.getMonster().getX()&&game.getMonster().getY()==game.getPlayer().getY()){
		   System.out.println("Votre Héro entre en Combat !!");
		   double playerStrength = ((Character)game.getPlayer()).getStrength();
		   double monsterStrength = ((Character)game.getMonster()).getStrength();
		   double playerLife = ((Character)game.getPlayer()).getHp();
		   double monsterLife = ((Character)game.getMonster()).getHp();
		   while(playerLife> 0 && monsterLife > 0){
			   System.out.println("Vie ennemi = "+monsterLife+"-"+playerStrength);  
			   monsterLife-=playerStrength;
			   if(monsterLife>0){
				   System.out.println("Vie vie_hero = "+playerLife+"-"+monsterStrength);  
				   playerLife-=monsterStrength;
			   }
		   }
		   if(playerLife<1){
			   System.out.println("Votre hero est mort.");  
		   }else{
			   System.out.println("Vous avez tué l'énnemi et il vous reste "+playerLife+" pv.");
		   }
		   ((Character)game.getPlayer()).setHp(playerLife);
		   ((Character)game.getMonster()).setHp(monsterLife);
	   }
	   if(((Character)game.getPlayer()).getHp() > 0){
		   game.show();
		   action(game);
	   }
	   else{
		   return;   
	   }
	   
	}
	
}
