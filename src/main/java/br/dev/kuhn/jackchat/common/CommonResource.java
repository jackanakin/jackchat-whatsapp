package br.dev.kuhn.jackchat.common;

import br.dev.kuhn.jackchat.common.exceptions.ResourceNotFoundException;

public interface CommonResource {
    default Object checkFound(final Object resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }

        return resource;
    }
}
