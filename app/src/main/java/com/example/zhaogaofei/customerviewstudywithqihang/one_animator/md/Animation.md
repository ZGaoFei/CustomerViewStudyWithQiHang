##### 第一部分动画篇

animation部分由以下四部分组成

    alpha 渐变透明度动画

    scale 渐变尺寸伸缩动画

    translate 平移动画

    rotate 旋转动画

存放的位置为res/anim文件夹下，以R.anim.xxx来获取动画

animation是以上四种类型动画的父类，在以上四种类型的动画中都可以使用，具有的属性：

    android:duration        动画持续时间，以毫秒为单位 

    android:fillAfter       如果设置为true，控件动画结束时，将保持动画最后时的状态

    android:fillBefore      如果设置为true,控件动画结束时，还原到开始动画前的状态

    android:fillEnabled     与android:fillBefore 效果相同，都是在动画结束时，将控件还原到初始化状态

    android:repeatCount     重复次数

    android:repeatMode      重复类型，有reverse和restart两个值，reverse表示倒序回放，restart表示重新放一遍，必须与repeatCount一起使用才能看到效果。因为这里的意义是重复的类型，即回放时的动作。

    android:interpolator    设定插值器，其实就是指定的动作效果，比如弹跳效果等，不在这小节中讲解，后面会单独列出一单讲解。

> alpha

自身属性：

    android:fromAlpha   动画开始的透明度，从0.0 --1.0 ，0.0表示全透明，1.0表示完全不透明

    android:toAlpha     动画结束时的透明度，也是从0.0 --1.0 ，0.0表示全透明，1.0表示完全不透明

具体看例子：alpha_animation.xml

> scale

自身属性：

    android:fromXScale    起始的X方向上相对自身的缩放比例，浮点值，比如1.0代表自身无变化，0.5代表起始时缩小一倍，2.0代表放大一倍；

    android:toXScale      结尾的X方向上相对自身的缩放比例，浮点值；

    android:fromYScale    起始的Y方向上相对自身的缩放比例，浮点值，

    android:toYScale      结尾的Y方向上相对自身的缩放比例，浮点值；

    android:pivotX        缩放起点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，当为数值时，表示在当前View的左上角，即原点处加上50px，做为起始缩放点；如果是50%，表示在当前控件的左上角加上自己宽度的50%做为起始点；如果是50%p，那么就是表示在当前的左上角加上父控件宽度的50%做为起始点x轴坐标。（具体意义，后面会举例演示）

    android:pivotY        缩放起点Y轴坐标，取值及意义跟android:pivotX一样。

具体看例子：scale_animation.xml

> translate

自身属性：

    android:fromXDelta     起始点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，具体意义已在scale标签中讲述，这里就不再重讲

    android:fromYDelta     起始点Y轴从标，可以是数值、百分数、百分数p 三种样式；

    android:toXDelta       结束点X轴坐标

    android:toYDelta       结束点Y轴坐标

具体看例子：translate_animation.xml

> rotate

自身属性：

    android:fromDegrees     开始旋转的角度位置，正值代表顺时针方向度数，负值代码逆时针方向度数

    android:toDegrees       结束时旋转到的角度位置，正值代表顺时针方向度数，负值代码逆时针方向度数

    android:pivotX          缩放起点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，具体意义已在scale标签中讲述，这里就不再重讲

    android:pivotY          缩放起点Y轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p

具体看例子：rotate_animation.xml

> set 标签

set 标签的作用就是将各种动画效果组合到一起来展示，所具有的属性都是animation的

具体看例子：set_animation.xml

> 获取R.anim.xxx

    Animation animation = AnimationUtils.loadAnimation(this, R.anim.xxx);
    view.startAnimation(animation);