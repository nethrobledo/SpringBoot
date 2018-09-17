package com.jobhunt.sample;

import com.jobhunt.sample.bean.QuoteConversionBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@EnableAutoConfiguration
@FeignClient(name="ofx-service")
public interface OfxServiceProxy {

    @GetMapping("/ofx/quote/{currency}/{amount}")
    QuoteConversionBean getOfx(@PathVariable("currency") String currency,
                                 @PathVariable("amount") BigDecimal amount);

    //@GetMapping("/westernunion/quote/{currency}/{amount}")
    //QuoteConversionBean getWesternUnion(@PathVariable("currency") String currency,
    //                           @PathVariable("amount") BigDecimal amount);
}
