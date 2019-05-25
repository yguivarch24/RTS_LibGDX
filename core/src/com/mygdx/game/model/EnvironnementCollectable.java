package com.mygdx.game.model;

public abstract class EnvironnementCollectable extends Environnement implements Collectable {
    
	/** La ressource de la case */
    private Ressource ressource;
	
    public EnvironnementCollectable(int x, int y, String name, Ressource ressource) {
		super(x, y, name);
		this.ressource = ressource;
	}
	
	public EnvironnementCollectable(int x, int y, String name, LiveObject object, Ressource ressource) {
		super(x, y, name, object);
		this.ressource = ressource;
	}

	
    /** Obtenir l'état de la case pour les ressources (contient/vide)*/
    public boolean ressourceEstEpuise(){
        if (ressource.getRessources() == 0){
            return false;
        } else {
            return true;
        }
    }
    
    /** Connaitre la ressource */
    public Ressource getRessource() {
    	return this.ressource;
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

