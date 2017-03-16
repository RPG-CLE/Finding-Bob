package framework;

public class ThreadAutorun extends Thread {
	  private IExtensionDesc exten;
	  
	  public ThreadAutorun(IExtensionDesc exten) {
		    this.exten = exten;
	}
	  
	  public void run() {
			PartieProvider.getInstance().getObjetByDesc(exten);
	  }
	}
