观察者模式:
定义了对象之间一对多的依赖, 当一个对象改变时, 它的所有依赖者都会收到通知并自动更新

这样观察者和主体之间松耦合, 主题只知道观察者有update方法可以调用, 不用知道观察者的细节;
观察者只需要实现update方法, 然后注册到主题上即可


设计原则:
为了交互对象之间的松耦合设计而努力


js中的观察者模式特别多:

1. document.addEventListener: 主题是网页或节点元素, 观察者是那些回调函数, 当网页被触发(如被点击),
它会发送事件给回调函数, 回调函数执行

2. websocket: 主题是websocket连接, 观察者是回调函数, 当websocket接收到消息, 它会发送收到的消息给回调函数,
回调函数执行
```
websocket = new WebSocket("ws://localhost:8084/websocket");
...


//接收到消息的回调方法
websocket.onmessage = function(event){
    setMessageInnerHTML(event.data);
}
```