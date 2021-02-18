package com.haydikodlayalim.logging.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogEndpoint {
    //    Logger logger = LoggerFactory.getLogger(LogEndpoint.class);

    @GetMapping //http://localhost:8032/log
    public String getDetails() {
        log.info("getDetails methodu başladı.");
        return internalLogDetail();
    }

    private String internalLogDetail() {
        try {
            log.debug("internalLogDetail methodu başladı.");
            Thread.sleep(1000);
            return "API Mesaj";
        } catch (InterruptedException e) {
            log.error("Hata : {}", e);
        }
        return "";
    }

    /*
    **  Loglama asenkron olmalıdır
    **  Loglama da printStackTrace ve System.out.println() kullanılmamalır. Log formatlarını bozuyor.
    * Formatlarımıza aykırı
    **  Sensitive data olmamalıdır.
    **  Tüm loglar merkezi bir noktada toplanmalıdır.Belirli bir formatta olmalıdır.
    **  Level(Info,warn,debug vs.) dikkatli kullanılmalıdır.
    **  Farklı levellar için farklı appenderlar kullanılabilir.
     */
}
