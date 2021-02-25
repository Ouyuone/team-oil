package com.ouyu.tech.team_oil.register_oil.config;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EurekaStateChangeListener {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        //System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务下线 ");
        log.info(event.getServerId() + "\t" + event.getAppName() + " 服务下线 ");
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        //System.err.println(instanceInfo.getAppName() + " 进行注册 ");
        log.info(instanceInfo.getAppName() + " 进行注册 ");
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        //System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约 ");
            log.info(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约 ");
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        //System.err.println(" 注册中心启动 ");
        log.info(" 注册中心启动 ");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        //System.err.println("Eureka Server启动 ");
        log.info("Eureka Server启动 ");
    }
}