package zbp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2020-02-21 18:08
 */
@RestController
@RefreshScope
public class ConfigClientController
{
    @Value("${config.ds}")
    private String configInfo;

    @Value("config.port")
    private String configPort;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo;
    }
}
