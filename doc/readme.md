
������Ϣ������·�����£�
- schedule/xuannan �Ǹ�·��
- ÿ�� worker ������ʱ�򣬰��Լ�����Ϣע�ᵽfactory �¡�
- strategy �±���������������Ϣ�����������ip���߻�������taskName��kind�ȡ�
- baseTaskType �±�������������Ϣ��������������ִ��Ƶ�ʡ�����beanName�ȡ�
- **Ŀǰ����� strategy �� baseTaskType �Ĺ�ϵ**
```
schedule
    xuannan
        factory
        strategy
        baseTaskType
```

```
schedule
    xuannan
        factory
        strategy
            DemoTask-Strategy
        baseTaskType
            DemoTask
                DemoTask$TEST
                    taskItem
                    server
                        DemoTask$TEST$172.20.29.241$FB7227319EA14B929B398395904CCFC6$0000000033
```

```
schedule
    xuannan
        factory
        strategy
            DemoTask-Strategy - {"strategyName":"DemoTask-Strategy","IPList":["127.0.0.1"],"numOfSingleServer":1,"assignNum":10,"kind":"Schedule","taskName":"DemoTask$TEST","taskParameter":"�й�","sts":"resume"}
        baseTaskType
            DemoTask - {"baseTaskType":"DemoTask","heartBeatRate":2000,"judgeDeadInterval":10000,"sleepTimeNoData":500,"sleepTimeInterval":0,"fetchDataNumber":500,"executeNumber":1,"threadNumber":5,"processorType":"SLEEP","expireOwnSignInterval":1.0,"dealBeanName":"demoTaskBean","taskParameter":"AREA\u003d����,YEAR\u003e30","taskKind":"static","taskItems":["0:{TYPE\u003dA,KIND\u003d1}","1:{TYPE\u003dA,KIND\u003d2}","2:{TYPE\u003dA,KIND\u003d3}","3:{TYPE\u003dA,KIND\u003d4}","4:{TYPE\u003dA,KIND\u003d5}","5:{TYPE\u003dA,KIND\u003d6}","6:{TYPE\u003dA,KIND\u003d7}","7:{TYPE\u003dA,KIND\u003d8}","8:{TYPE\u003dA,KIND\u003d9}","9:{TYPE\u003dA,KIND\u003d10}"],"maxTaskItemsOfOneThreadGroup":0,"version":0,"sts":"resume"}
                DemoTask$TEST
                    taskItem - DemoTask$TEST$172.20.29.241$F313C794088E4F8898CEAA7E06633422$0000000028
                    server - reload=true
                        DemoTask$TEST$172.20.29.241$FB7227319EA14B929B398395904CCFC6$0000000033 - {"uuid":"DemoTask$TEST$172.20.29.241$FB7227319EA14B929B398395904CCFC6$0000000033","id":19012723982549,"taskType":"DemoTask$TEST","baseTaskType":"DemoTask","ownSign":"TEST","ip":"172.20.29.241","hostName":"DJ-OT1HGO","threadNum":5,"registerTime":"2019-01-27 15:45:26","heartBeatTime":"2019-01-27 15:55:58","lastFetchDataTime":"2019-01-27 15:55:58","dealInfoDesc":"����������������:FetchDataCount\u003d123,FetchDataNum\u003d61000,DealDataSucess\u003d60520,DealDataFail\u003d0,DealSpendTime\u003d3071772,otherCompareCount\u003d0","version":329,"isRegister":true,"managerFactoryUUID":"172.20.29.241$DJ-OT1HGO$40AF4D8BA4C34C6385DA347D5504B9CB$0000000038"}
```