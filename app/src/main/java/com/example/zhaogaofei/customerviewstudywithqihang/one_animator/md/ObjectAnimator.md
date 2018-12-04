##### 第一部分动画篇

> ObjectAnimator

    继承者ValueAnimator，重写了内部相关的of***方法和实现方式

    setPropertyName(String propertyName):设置属性的名字

    ofInt(Object target, String propertyName)

    ofArgb(Object target, String propertyName)

    ofFloat(Object target, String propertyName)

    ofObject(Object target, String propertyName, TypeEvaluator evaluator)

    ofPropertyValuesHolder(Object target)

    上面对应的of***方法均增加了两个参数，

    target：动画执行的对象
    propertyName：执行动画的对象所具有的属性

    (1)、拼接set函数的方法：
    上面我们也说了是首先是强制将属性的第一个字母大写，
    然后与set拼接，就是对应的set函数的名字。注意，只是强制将属性的第一个字母大写，后面的部分是保持不变的。
    反过来，如果我们的函数名命名为setScalePointX(float ),那我们在写属性时可以写成”scalePointX”或者写成“ScalePointX”都是可以的，
    即第一个字母大小写可以随意，但后面的部分必须与set方法后的大小写保持一致。

    (2)、如何确定函数的参数类型：
    我们在讲ValueAnimator的时候说过，动画过程中产生的数字值与构造时传入的值类型是一样的。
    由于ObjectAnimator与ValueAnimator在插值器和Evaluator这两步是完全一样的，
    而当前动画数值的产生是在Evaluator这一步产生的，所以ObjectAnimator的动画中产生的数值类型也是与构造时的类型一样的。

    3）、从ObjectAnimator的流程可以看到，ObjectAnimator只负责把动画过程中的数值传到对应属性的set函数中就结束了，
    注意传给set函数以后就结束了！set函数就相当我们在ValueAnimator中添加的监听的作用，
    set函数中的对控件的操作还是控件本身来实现。

    (4)、set函数调用频率是多少：
    由于我们知道动画在进行时，每隔十几毫秒会刷新一次，所以我们的set函数也会每隔十几毫秒会被调用一次。

    通过反射的方式获取propertyName对应的setProperty()方法，然后调用target的setProperty()方法，
    来改变target的属性



