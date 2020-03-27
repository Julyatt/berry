package com.guosh.servicefeign.feign;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author guosh28325
 * @Description
 * @date 2020-03-22 13:53
 */

@FeignClient(value = "service-hi", fallback = SchehualServiceHi.SchehualServiceHiHystrix.class)
public interface SchehualServiceHi {

    /**
     * feign调用
     * @param name
     * @return
     */
    @GetMapping(value = "hi")
    String sayHiFromClientOne(@RequestParam(value = "name")String name);

    @Component
    class SchehualServiceHiHystrix implements SchehualServiceHi {
        @Override
        public String sayHiFromClientOne(String name) {
            return "sorry" + name;
        }
    }
}
