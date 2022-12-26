package org.example.framework.adapter.input;

import org.example.application.RouterViewInputPort;
import org.example.application.RouterViewUseCase;
import org.example.domain.Router;
import org.example.domain.RouterType;

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
        this.routerViewUseCase = new RouterViewInputPort(RouterViewFileAdapter.get);
    }
}
