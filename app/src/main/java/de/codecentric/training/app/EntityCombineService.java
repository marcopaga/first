package de.codecentric.training.app;

import de.codecentric.training.domain.Entity;
import org.springframework.util.StringUtils;

public class EntityCombineService {

    public String combine(Entity first, Entity second) {

        if(first == null && second == null){
            return "";
        }

        if(StringUtils.isEmpty(first)){
            return second.getValue();
        }

        if(StringUtils.isEmpty(second)){
            return first.getValue();
        }

        return first.getValue() + second.getValue();
    }
}
