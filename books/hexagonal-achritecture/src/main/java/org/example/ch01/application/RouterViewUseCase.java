package org.example.ch01.application;

import org.example.ch01.domain.Router;

import java.util.List;
import java.util.function.Predicate;

public interface RouterViewUseCase {
    List<Router> getRouters(Predicate<Router> filter);
}
