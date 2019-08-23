package com.example.webflux.controller;

import com.google.common.eventbus.Subscribe;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName MonoFluxTest
 * @Description
 * @create 2019/8/23/0023 14:00
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
public class MonoFluxTest {

    public static void main(String[] args) {
        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("接收到的数据："+toString());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
                this.subscription.cancel();
            }

            @Override
            public void onComplete() {
                System.out.println("处理结束");
            }
        };

        String[] strings = {"1","2","3"};
        Flux.fromArray(strings).map(Integer::parseInt).subscribe(subscriber);
        Mono.fromSupplier( () -> 1 ).map(s -> s+1).subscribe(subscriber);

    }



}
