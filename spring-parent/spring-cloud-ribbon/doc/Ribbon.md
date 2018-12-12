### Ribbon的核心组件(均为接口类型)
- ServerList用于获取地址列表。它既可以是静态的(提供一组固定的地址)，也可以是动态的(从注册中心中定期查询地址列表);
- ServerListFilter 仅当使用动态ServerList时使用，用于在原始的服务列表中使用一定策略过虑掉一部分地址;
- IRule:选择一个最终的服务地址作为LB结果。选择策略有轮询、根据响应时间加权、断路器(当Hystrix可用时)等;
- Ribbon在工作时首选会通过ServerList来获取所有可用的服务列表，然后通过ServerListFilter过虑掉一部分地址，最后在剩下的地址中通过IRule选择出一台服务器作为最终结果;


### 主要负载均衡策略
1. 简单轮询负载均衡（RoundRobin)：
    以轮询的方式依次将请求调度不同的服务器，即每次调度执行i = (i + 1) mod n，并选出第i台服务器
2. 随机负载均衡（Random)：
    随机选择状态为UP的Server
3. 加权响应时间负载均衡 （WeightedResponseTime)：
    根据相应时间分配一个weight，相应时间越长，weight越小，被选中的可能性越低
4. 区域感知轮询负载均衡（ZoneAvoidanceRule)：
    复合判断server所在区域的性能和server的可用性选择server

