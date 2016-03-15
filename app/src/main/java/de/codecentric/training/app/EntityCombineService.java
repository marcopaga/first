package de.codecentric.training.app;

import de.codecentric.training.domain.Entity;

public class EntityCombineService {

    public Entity combine(Entity first, Entity second) {
        return new Entity(getString(first, second));
    }

    private String getString(Entity first, Entity second) {
        if(first == null && second == null){
            return "";
        }
        if(first == null){
            return second.getValue();
        }
        if(second == null){
            return first.getValue();
        }
        return first.getValue() + second.getValue();
    }


}
