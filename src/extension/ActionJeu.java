package extension;
import java.util.Scanner;

import client.*;
import client.interfaces.IAJ;

public class ActionJeu implements IAJ {
	public ActionJeu(){}
	
	@Override
	public boolean action(Jeu j) {
		// TODO Auto-generated method stub
	   Scanner reader = new Scanner(System.in);  // Reading from System.in
	   System.out.println("Saisissez un déplacement : z = haut, s = bas, q = gauche, d = droite ");
	   String choix = reader.nextLine();

	   switch(choix){
	   case "z" :
		   if(j.getHero().getPosY()>0)
			   j.getHero().deplacer("haut");
		   break;
	   case "s" :
		   if(j.getHero().getPosY()<j.getMap().getHauteur()-1)
			   j.getHero().deplacer("bas");
		   break;
	   case "q" :
		   if(j.getHero().getPosX()>0)
			   j.getHero().deplacer("gauche");
		   break;
	   case "d" :
		   if(j.getHero().getPosX()<j.getMap().getLargeur()-1)
			   j.getHero().deplacer("droite");
		   break;
	   default:
		   break;
	   }
	   if(j.getEnnemi().getPosX()==j.getHero().getPosX()&&j.getEnnemi().getPosY()==j.getHero().getPosY()){
		   System.out.println("Votre Héro entre en Combat !!");
		   double force_hero = j.getHero().getForce();
		   double force_ennemi = j.getEnnemi().getForce();
		   double vie_hero = j.getHero().getPv();
		   double vie_ennemi = j.getEnnemi().getPv();
		   while(vie_hero>0&&vie_ennemi>0){
			   System.out.println("Vie ennemi = "+vie_ennemi+"-"+force_hero);  
			   vie_ennemi-=force_hero;
			   if(vie_ennemi>0){
				   System.out.println("Vie vie_hero = "+vie_hero+"-"+force_ennemi);  
				   vie_hero-=force_ennemi;
			   }
		   }
		   if(vie_hero<1){
			   System.out.println("Votre hero est mort.");  
		   }else{
			   System.out.println("Vous avez tué l'énnemi et il vous reste "+vie_hero+" pv.");
		   }
		   j.getHero().setPv(vie_hero);
		   j.getEnnemi().setPv(vie_ennemi);
	   }
	   
	   if(j.getHero().getPv()<1)
		   return false;
	   
	   j.afficher();
	   System.out.println();
	   return true;
	}
	
}
