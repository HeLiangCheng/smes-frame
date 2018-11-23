1. dubbo启动时检查
     Dubbo缺省会在启动时检查依赖的服务是否可用，不可用时会抛出异常，阻止Spring初始化完成，以便上线时，能及早发现问题，默认check="true" 所以当不启动service服务直接启动web时项目报错问题
     dubbo.properties可以直接配置：dubbo.reference.check=false 强制改变所有 reference 的 check 值，就算配置中有声明，也会被覆盖。
    配置案例：
     <dubbo:reference interface="com.hlc.styd.smes.api.service.UserService" id="userService" check="false" />


2. dubbo直连
    在开发及测试环境下，经常需要绕过注册中心，只测试指定服务提供者，这时候可能需要点对点直连，点对点直联方式，将以服务接口为单位，忽略注册中心的提供者列表。如果是线上需求需要点对点，可在 <dubbo:reference> 中配置 url 指向提供者，将绕过注册中心，多个地址用分号隔开，配置如下:
    <dubbo:reference interface="com.hlc.styd.smes.api.service.UserService" id="userService" timeout="10000" check="false" url="dubbo://192.168.146.4:20884" />


3. dubbo集群容错
    在集群负载均衡时，Dubbo 提供了多种均衡策略，缺省为 random 随机调用。
    Random LoadBalance:随机，按权重设置随机概率。在一个切面上碰撞的概率高，但调用量越大分布越均匀，而且按概率使用权重后也比较均匀，有利于动态调整提供者权重
    RoundRobin LoadBalance：轮循，按公约后的权重设置轮循比率。存在慢的提供者累积请求的问题，比如：第二台机器很慢，但没挂，当请求调到第二台时就卡在那，久而久之，所有请求都卡在调到第二台上
    LeastActive LoadBalance:最少活跃调用数，相同活跃数的随机，活跃数指调用前后计数差,慢的提供者收到更少请求，因为越慢的提供者的调用前后计数差会越大
    ConsistentHash LoadBalance:一致性 Hash，相同参数的请求总是发到同一提供者,当某一台提供者挂时，原本发往该提供者的请求，基于虚拟节点，平摊到其它提供者，不会引起剧烈变动

    配置案例
        <dubbo:reference interface="com.hlc.styd.smes.api.service.UserService" id="userService" timeout="10000" check="false"  cluster="failover" retries="2" loadbalance="random" />


4. dubbo负载均衡
     在集群调用失败时，Dubbo 提供了多种容错方案，缺省为 failover 重试。
     Failover Cluster:失败自动切换，当出现失败，重试其它服务器 1。通常用于读操作，但重试会带来更长延迟。可通过 retries="2" 来设置重试次数(不含第一次)。
     Failfast Cluster:快速失败，只发起一次调用，失败立即报错。通常用于非幂等性的写操作，比如新增记录。
     Failsafe Cluster:失败安全，出现异常时，直接忽略。通常用于写入审计日志等操作。
     Failback Cluster:失败自动恢复，后台记录失败请求，定时重发。通常用于消息通知、邮件、kafka等操作。
     Forking Cluster:并行调用多个服务器，只要一个成功即返回。通常用于实时性要求较高的读操作，但需要浪费更多服务资源。可通过 forks="2" 来设置最大并行数。
     Broadcast Cluster:广播调用所有提供者，逐个调用，任意一台报错则报错 2。通常用于通知所有提供者更新缓存或日志等本地资源信息。

    由于重试机制造成的重复执行，解决方案：
        a. 重新评估服务的过期时间timeout
        b. 使用Failfast Cluster机制关闭重试，或者在重试机制中retries="0"
        c. 使用redis等中间件实现分布式锁机制

    配置案例
        <dubbo:reference interface="com.hlc.styd.smes.api.service.UserService" id="userService" timeout="10000" check="false"  cluster="failover" retries="2" loadbalance="random" />


5. dubbo线程模型
   如果事件处理的逻辑能迅速完成，并且不会发起新的 IO 请求，比如只是在内存中记个标识，则直接在 IO 线程上处理更快，因为减少了线程池调度。但如果事件处理逻辑较慢，或者需要发起新的 IO 请求，比如需要查询数据库，则必须派发到线程池，否则 IO 线程阻塞，将导致不能接收其它请求。
     Dispatcher
       all 所有消息都派发到线程池，包括请求，响应，连接事件，断开事件，心跳等。
       direct 所有消息都不派发到线程池，全部在 IO 线程上直接执行。
       message 只有请求响应消息派发到线程池，其它连接断开事件，心跳等消息，直接在 IO 线程上执行。
       execution 只请求消息派发到线程池，不含响应，响应和其它连接断开事件，心跳等消息，直接在 IO 线程上执行。
       connection 在 IO 线程上，将连接断开事件放入队列，有序逐个执行，其它消息派发到线程池。

    ThreadPool
      fixed 固定大小线程池，启动时建立线程，不关闭，一直持有。(缺省)
      cached 缓存线程池，空闲一分钟自动删除，需要时重建。
      limited 可伸缩线程池，但池中的线程数只会增长不会收缩。只增长不收缩的目的是为了避免收缩时突然来了大流量引起的性能问题。
    配置案例
    <dubbo:protocol name="rest" contextpath="smes-dubbo-consumer" port="8080" server="servlet" dispatcher="all" threadpool="fixed" threads="100" />


6.dubbo订阅，注册
    只订阅
    为方便开发测试，经常会在线下共用一个服务注册中心，这时，如果一个正在开发中的服务提供者注册，可能会影响消费者不能正常运行。可以让服务提供者开发方，只订阅服务(开发的服务可能依赖其它服务)，而不注册正在开发的服务，通过直连测试正在开发的服务。
    <dubbo:registry address="10.20.153.10:9090" register="false" />

    只注册
    如果有两个镜像环境(例如环境A、B)，两个注册中心，有一个服务(例如D)只在其中一个注册中心有部署，另一个注册中心还没来得及部署，而两个注册中心的其它应用都需要依赖此服务，所以需要将服务同时注册到两个注册中心，但却不能让此服务同时依赖两个注册中心的其它服务(其它服务:例如服务A)。可以让服务提供者方，只注册服务到另一注册中心，而不从另一注册中心订阅服务
    <dubbo:registry id="hzRegistry" address="10.20.153.10:9090" />
    <dubbo:registry id="qdRegistry" address="10.20.141.150:9090" subscribe="false" />

    注册中服务分组group
    <dubbo:registry id="hzRegistry" address="10.20.153.10:9090" goup="smes_zk" />

