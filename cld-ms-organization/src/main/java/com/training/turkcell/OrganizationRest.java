package com.training.turkcell;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
@RequestMapping("/org")
public class OrganizationRest {

    @Value("${server.port}")
    public int           port;

    @Autowired
    @Qualifier("loadbalanced")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("direct")
    private RestTemplate restDirect;

    @Autowired
    private EurekaClient ec;

    @GetMapping("/employee/create/{name}")
    public String createEmployee(@PathVariable("name") final String name) {
        String forObjectLoc = this.restTemplate.getForObject("http://EMPLOYEE/employee/greet/" + name,
                                                             String.class);
        return forObjectLoc + " Reponse from org : " + this.port;
    }

    @GetMapping("/employee/create2/{name}")
    public String createEmployee2(@PathVariable("name") final String name) {
        Application applicationLoc = this.ec.getApplication("EMPLOYEE");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(" INSTANCE : " + instanceInfoLoc);
        }
        InstanceInfo n = this.ec.getNextServerFromEureka("EMPLOYEE",
                                                         false);

        String forObjectLoc = this.restDirect.getForObject("http://"
                                                           + n.getIPAddr()
                                                           + ":"
                                                           + n.getPort()
                                                           + "/employee/greet/"
                                                           + name,
                                                           String.class);
        return forObjectLoc + " Reponse2 from org : " + this.port;
    }

}
