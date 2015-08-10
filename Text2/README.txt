首先开启服务器：
mvn exec:java -Dexec.mainClass="chat.com.MyServerSocket"
然后：创建两个客户端，也就是下面代码运行两次
mvn exec:java -Dexec.mainClass="hand.com.StratClient"
最后：进入客户端，点击按钮来发送接收数据