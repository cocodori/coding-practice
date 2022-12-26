package org.example.ch01.framework.adapter.input;

import org.example.ch01.application.RouterViewInputPort;
import org.example.ch01.application.RouterViewUseCase;
import org.example.ch01.domain.Router;
import org.example.ch01.domain.RouterType;

import java.util.List;

public class RouterViewCLIAdapter {
    RouterViewUseCase routerViewUseCase;

    public RouterViewCLIAdapter() {
        setAdapters();
    }

    public List<Router> obtainRelatedRouters(String type) {
        return routerViewUseCase.getRouters(
                Router.filterRouterByType(RouterType.valueOf(type))
        );
    }

    private void setAdapters() {
        this.routerViewUseCase = new RouterViewInputPort(RouterViewFileAdapter.getInstance());
    }
}
