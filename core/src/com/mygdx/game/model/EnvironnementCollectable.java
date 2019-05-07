package com.mygdx.game.model;

public abstract class EnvironnementCollectable implements  Collectable{
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
}
