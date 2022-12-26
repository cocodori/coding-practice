package org.example.application;

import org.example.domain.Router;

import java.util.List;

public interface RouterViewOutputPort {
    List<Router> fetchRouters();
}
