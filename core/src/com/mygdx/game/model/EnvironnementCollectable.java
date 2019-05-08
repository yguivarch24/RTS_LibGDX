package com.mygdx.game.model;

public abstract class EnvironnementCollectable extends Environnement implements Collectable {
    
	public EnvironnementCollectable(int x, int y, String name) {
		super(x, y, name);
		// TODO Auto-generated constructor stub
	}
	
	public EnvironnementCollectable(int x, int y, String name, LiveObject object) {
		super(x, y, name, object);
	}

	/** La ressource de la case */
    Ressource ressource;

    /** Obtenir l'état de la case pour les ressources (contient/vide)*/
    public boolean ressourceEstEpuise(){
        if (ressource.getRessources() == 0){
            return false;
        } else {
            return true;
        }
    }
    
    /** Collecter une certaine quantité de ressource 
     * @param valeuraprendre valeur de la ressource à retirer
     * @param ressource ressource à retirer
     * @param joueur ou on implémente la ressource*/
	public int collecter(int valeuraprendre, Ressource ressource) {
		try {
		ressource.retirer(valeuraprendre);
		} catch (RessourceIndisponibleException e) {
			System.out.println(e.getMessage());
		}
		return valeuraprendre;
		//
	}
    
}
