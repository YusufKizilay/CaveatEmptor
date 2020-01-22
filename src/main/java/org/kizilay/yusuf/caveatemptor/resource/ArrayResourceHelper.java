package org.kizilay.yusuf.caveatemptor.resource;

import java.util.HashSet;
import java.util.Set;

public interface ArrayResourceHelper<R extends BaseResource<D>, D> {


    default  Set<D> toDomain() {
        Set<D> set = new HashSet<>();

        resources().parallelStream().forEach(r -> {
            set.add(r.toDomain());
        });

        return set;
    }

    Set<R> resources();

}
