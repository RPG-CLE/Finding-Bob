package extension;

import java.util.Observable;
import java.util.Observer;

import framework.MethodAutorun;

@MethodAutorun(run="jeMeLance")
public class Moniteur implements Observer {

	public void jeMeLance(){
		System.out.println("je suis LE( THE) moniteur et je me lance");
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg);
		
	}

	
	
}
