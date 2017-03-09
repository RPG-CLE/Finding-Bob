package client.interfaces;

public interface IPersonnage {

	double getPv();

	void setPv(double pv);

	double getForce();

	void setForce(double force);

	String getNom();

	void setNom(String nom);

	void setPos(int x, int y);

	int getPosX();

	void setPosX(int x);
	
	int getPosY();

	void setPosY(int y);

	void deplacer(String deplacement);

	String toString();

}