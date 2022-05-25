<center><h1>作业说明</h1></center>

### 一、代码说明

1. MainActivity类：包含wifiReceiver类，你需要对其中的函数进行完善，并注册广播接收器。使广播接收器可以接收到系统发出的WiFi状态改变的系统广播，并修改textView中的相应文字。

本次作业要完成以下目标：
- 打开WiFi：TextView内容显示 "Wifi On"
- 关闭WiFi：TextView内容显示 "Wifi Off"
- 打开WiFi：TextView内容显示 "Wifi On"

**只需修改指定文件：**
- MainActivity

**网络学堂需要提交上述指定文件以及界面图。**


### 二、作业要求

为了实现模拟监控WiFi状态的要求，需要实现对应的广播接收器并进行注册，要求如下：

1. 广播接收器：使用一个广播接收器接收WiFi状态改变时系统发送的广播，并针对wifi的状态对TextView进行修改。

2. 注册广播接收器：要求使用动态方式进行注册

Tips：你可能需要利用**WifiManager**

实验环境与之前相同：
- Android Studio版本： 3.6 
- AVD版本：Pixel 2 API R
- gradle版本：5.6.4