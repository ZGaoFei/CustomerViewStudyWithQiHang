##### 硬件加速

    硬件加速是在API11加入，默认关闭，在API14是默认打开的

    优点：
        硬件加速提高了Android系统显示和刷新的速度
    缺点：
        1、 兼容性问题:由于是将绘制函数转换成OpenGL命令来绘制，定然会存在OpenGL并不能完全支持原始绘制函数的问题，所以这就会造成在打开GPU加速时，效果会失效的问题。
        2、内存消耗问题:由于需要OpenGL的指令，所以需要把系统中的OpenGL相关的包加载到内存中来，所以单纯OpenGL API调用就会占用8MB，而实际上会占用更多内存；
        3、电量消耗问题:多使用了一个部件，当然会更耗电


一些特殊函数硬件加速开始支持的平台等级参考：[《google官方文档：硬件加速》](https://developer.android.com/guide/topics/graphics/hardware-accel.html)

###### 禁用硬件加速

1.在AndroidManifest.xml文件为application标签添加如下的属性即可为整个应用程序开启/关闭硬件加速：

    <application android:hardwareAccelerated="true" ...>


2.在Activity 标签下使用 hardwareAccelerated 属性开启或关闭硬件加速：

    <activity android:hardwareAccelerated="false" />

3.在Window 层级使用如下代码开启硬件加速：(Window层级不支持关闭硬件加速)

    getWindow().setFlags(
    WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
    WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);

4.View 级别如下关闭硬件加速：（view 层级上不支持开启硬件加速）

    setLayerType(View.LAYER_TYPE_SOFTWARE, null);

或者使用android:layerType=”software”来关闭硬件加速：比如

    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:orientation="vertical"
        android:paddingLeft="2dp"
        android:layerType="software"
        android:paddingRight="2dp" >

> setXfermode(Xfermode xfermode) 之 PorterDuffXfermode

    Xfermode一共有三个子类：AvoidXfermode，PixelXorXfermode，PorterDuffXfermode
    AvoidXfermode，PixelXorXfermode：已经过时，并且在SDK中已经找不到对应的类

    PorterDuffXfermode的使用方法参考XfermodeView
    里面对PorterDuff.Mode里面的所有类型均有实现

    XfermodeView：PorterDuffXfermode类的各种模式叠加效果
    TwitterLogoView：Twitter logo高亮效果
    CircleBitmapView：实现了圆角图片和倒影的功能
    EraserView：橡皮擦的功能
    ScratchCardView：橡皮擦功能具体实现刮刮卡功能


