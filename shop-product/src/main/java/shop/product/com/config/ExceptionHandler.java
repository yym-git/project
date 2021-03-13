package shop.product.com.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ym.y
 * @description  自定义规则异常,可以根据控制台设置的规则，返回指定类型的控制异常
 * @package shop.product.com.config
 * @updateUser
 * @date 22:25 2021/2/7
 */
@Slf4j
@Component
public class ExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        //避免中文乱码
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ResponseData responseData =null;
        if(e instanceof FlowException){
            responseData = new ResponseData(-1,"限流");
            log.info("限流");
        }else if(e instanceof ParamFlowException){
            responseData = new ResponseData(-2,"热点参数限流");
            log.info("热点参数限流");
        }else  if(e instanceof SystemBlockException){
            responseData = new ResponseData(-3,"系统规则（负载异常）");
          log.info("系统规则（负载异常）");
        }else  if(e instanceof DegradeException){
            responseData = new ResponseData(-4,"服务降级");
            log.info("服务降级");
        }else if(e instanceof AuthorityException){
            responseData = new ResponseData(-5,"授权规则");
            log.info("授权规则");
        }
        httpServletResponse.getWriter().write(JSON.toJSONString(responseData));
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class ResponseData{
        private int code;
        private String message;
    }
}
