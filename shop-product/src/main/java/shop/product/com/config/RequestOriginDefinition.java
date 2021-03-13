package shop.product.com.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ym.y
 * @description  授权规则 自定义流控运用
 * @package shop.product.com.config
 * @updateUser
 * @date 22:13 2021/2/7
 */
@Component
public class RequestOriginDefinition implements RequestOriginParser {

    /**
     * @description   区分来源：通过Request域来获取来源标识
     * @author ym.y
     * @updateUser
     * @date  22:16 2021/2/7
     */
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String  serviceName  = httpServletRequest.getParameter("serviceName");
        if(StringUtils.isEmpty(serviceName)){
            throw new IllegalArgumentException("参数为空");
        }
        return serviceName;
    }
}
