package org.example.ch01.application;

import org.example.ch01.domain.Router;

import java.util.List;

public interface RouterViewOutputPort {
    List<Router> fetchRouters();
}
