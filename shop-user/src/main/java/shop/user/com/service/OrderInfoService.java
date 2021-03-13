package shop.user.com.service;


import shop.user.com.entity.OrderInfo;

/**
 * @author ym.y
 * @description
 * @package shop.user.com.service
 * @updateUser
 * @date 15:08 2021/2/7
 */
public interface OrderInfoService {
    OrderInfo queryByKey(String orderId);

    int  createOrderInfo(OrderInfo orderInfo);
}
