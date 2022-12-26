package org.example.framework.adapter.input;

import org.example.application.RouterViewOutputPort;
import org.example.domain.Router;
import org.example.domain.RouterId;
import org.example.domain.RouterType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RouterViewFileAdapter implements RouterViewOutputPort {
    @Override
    public List<Router> fetchRouters() {
        return readFileAsString();
    }

    private List<Router> readFileAsString() {
        List<Router> routers = new ArrayList<>();
        try (Stream<String> stream = new BufferedReader(
                new InputStreamReader(RouterViewFileAdapter.class.getClassLoader()
                        .getResourceAsStream("router.txt"))).lines()) {
            stream.forEach(line -> {
                String[] routerEntry = line.split(";");
                var id = routerEntry[0];
                var type = routerEntry[1];
                Router router = new Router(RouterType.valueOf(type), RouterId.of(id));
                routers.add(router);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return routers;
    }
}
