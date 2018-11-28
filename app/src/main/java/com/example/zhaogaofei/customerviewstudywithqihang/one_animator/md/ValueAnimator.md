##### 第一部分动画篇

###### 动画的分类

android的动画主要分为两类：视图动画（View Animation）和属性动画（Property Animator）

视图动画又分为：逐帧动画（Frame Animation）和补间动画（Tween Animation）

属性动画又包含：ValueAnimator和ObjectAnimation

###### 引入属性动画的原因

1、属性动画能实现视图动画不能实现的功能，而视图动画能实现的功能，属性动画都可以实现
如一定时间内改变一个view的布局颜色，实现渐变效果

2、视图动画仅对指定的布局做动画，而属性动画是通过改变控件某一属性值来做动画的

3、视图动画仅仅是改变视图的显示位置，并没有改变视图的属性，而属性动画是通过改变控件内部的属性来实现动画效果的
第三条可以通过设置点击事件来进行测试，此处不再进行介绍

> ValueAnimator

方法

    ofInt(int... values): 内部自动实例化一个Animator对象，内部传入的是int类型的数据
    在使用animation.getAnimatedValue()获取动画当前运行的状态时，获取的是int类型的值

    setIntValues(int... values)：同ofInt()一样，需要自己实例化Animator对象

    ofArgb(int... values): 同ofInt()，里面传入的是ARGB的值

    ofFloat(float... values): 同ofArgb()，需要自己实例化Animator

    setFloatValues(float... values): 同ofInt()，里面传入的是float的值
    在使用animation.getAnimatedValue()时获取的是float类型的对象

    ofPropertyValuesHolder(PropertyValuesHolder... values): 同ofInt()，里面传入的是PropertyValuesHolder对象
    PropertyValuesHolder: 保存了动画过程中所需要操作的属性和对应的值。
    所有的ofxxx()方法其内部都会走到setValues()方法，而setValues()方法需要传递一个PropertyValuesHolder对象，
    PropertyValuesHolder对象内部有对应的ofxxx()方法。

    setValues(PropertyValuesHolder... values): 设置动画相关的属性和参数

    ofObject(TypeEvaluator evaluator, Object... values): 同ofInt()，里面传入的是对象
    TypeEvaluator: 用以确定Object是什么类型的数据，其实现类有（IntEvaluator、FloatEvaluator等）
    因此传入的对象必须为TypeEvaluator对应的类型

    setObjectValues(Object... values): 同ofObject()，需要自己实例化Animator

    setDuration(long duration): 设置动画时间

    setCurrentPlayTime(long playTime): 设置动画当前执行的时间

    setCurrentFraction(float fraction): 设置动画当前执行的进度

    setStartDelay(long startDelay): 设置动画延迟多久

    setFrameDelay(long frameDelay): 设置动画延迟多少帧

    setRepeatCount(int value): 设置动画执行的次数

    setRepeatMode(@RepeatMode int value): 设置动画执行的模式，即是正序还是倒序执行下一遍

    addUpdateListener(AnimatorUpdateListener listener): 添加监听状态变化的监听

    removeUpdateListener(AnimatorUpdateListener listener): 移除某个监听

    removeAllUpdateListeners(): 移除所有监听

    setInterpolator(TimeInterpolator value): 设置插值器（Interpolator）

    setEvaluator(TypeEvaluator value): 设置估值器（Evaluator）
    当前时间动画运行所需要的值

---
    start(): 开始

    cancel(): 取消

    end(): 结束

    resume(): 开始执行

    pause(): 暂停

    reverse(): 重置

    这六个方法分别对应了AnimatorListener和AnimatorPauseListener中的六中状态
    在添加此监听事件的时候可以使用这两个类的实现类：AnimatorListenerAdapter，
    只实现需要的方法即可

---

    clone(): 克隆一个一样的Animator对象

