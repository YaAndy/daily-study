package com.daily.rocketmq.consumer.listener;


import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.order.ConsumeOrderContext;
import com.aliyun.openservices.ons.api.order.MessageOrderListener;
import com.aliyun.openservices.ons.api.order.OrderAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ConsumerOrderListener implements MessageOrderListener {

    private Logger logger = LoggerFactory.getLogger(ConsumerOrderListener.class);

    /**
     * 由于消费者是多线程的，所以对象要用static+set注入，把对象的级别提升到进程，
     * 这样多个线程就可以共用，但是无法调用父类的方法和变量
     */
//	protected static TestDao testDao;
    @Override
    public OrderAction consume(Message message, ConsumeOrderContext consumeOrderContext) {
        try {
            Long startTime = System.currentTimeMillis();
            //TODO  日志记录 消息幂等
            byte[] body = message.getBody();
            String msg = new String(body);//获取到接收的消息，由于接收到的是byte数组，所以需要转换成字符串

            System.out.println("part-order&" + message.getTopic() + "-Receive，msgId: " + message.getMsgID() + ",tag:" + message.getTag() + ",shardingKey:" + message.getShardingKey());

            //TODO 业务逻辑，自行设计
            //testDao.insertDatas();//持久层，这里不再展述，自行补全

            Long endTime = System.currentTimeMillis();
            System.out.println("单次消费耗时：" + (endTime - startTime) / 1000 + "\n msg:" + msg);
        } catch (Exception e) {
            logger.error("MessageListener.consume error:" + e.getMessage(), e);
        }

        logger.info("MessageListener.Receive message");
        //如果想测试消息重投的功能,可以将Action.CommitMessage 替换成Action.ReconsumeLater
        return OrderAction.Success;

    }
}
