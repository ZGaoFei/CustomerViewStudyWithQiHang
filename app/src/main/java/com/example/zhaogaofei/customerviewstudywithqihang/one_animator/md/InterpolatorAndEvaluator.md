##### 第一部分动画篇

> interpolator

插值器，是animation的一个属性，因此alpha、scale、translate、rotate、set都具有这个属性

    AccelerateDecelerateInterpolator   在动画开始与介绍的地方速率改变比较慢，在中间的时候加速

    AccelerateInterpolator             在动画开始的地方速率改变比较慢，然后开始加速

    AnticipateInterpolator             开始的时候向后然后向前甩

    AnticipateOvershootInterpolator    开始的时候向后然后向前甩一定值后返回最后的值

    BounceInterpolator                 动画结束的时候弹起

    CycleInterpolator                  动画循环播放特定的次数，速率改变沿着正弦曲线

    DecelerateInterpolator             在动画开始的地方快然后慢

    LinearInterpolator                 以常量速率改变

    OvershootInterpolator              向前甩一定值后再回到原来位置

对应的xml中的属性

    AccelerateDecelerateInterpolator    @android:anim/accelerate_decelerate_interpolator

    AccelerateInterpolator              @android:anim/accelerate_interpolator

    AnticipateInterpolator              @android:anim/anticipate_interpolator

    AnticipateOvershootInterpolator     @android:anim/anticipate_overshoot_interpolator

    BounceInterpolator                  @android:anim/bounce_interpolator

    CycleInterpolator                   @android:anim/cycle_interpolator

    DecelerateInterpolator              @android:anim/decelerate_interpolator

    LinearInterpolator                  @android:anim/linear_interpolator

    OvershootInterpolator               @android:anim/overshoot_interpolator

    通过android:interpolator="@android:anim/overshoot_interpolator"来设置插值器
    代码中通过设置animation.setInterpolator(new AccelerateDecelerateInterpolator());
    来添加插值器

> 自定义interpolator 简单了解

    通过实现Interpolator，然后实现getInterpolation()方法

    插值器就是从动画运行的一段时间中取出某一刻，来通过然后实现getInterpolation()来计算当前时间运行的位置


用来计算这个公式的工具推荐一个网站
[Interpolator](http://inloop.github.io/interpolator/)

获取到公式后可以模仿已有的插值器来做


> interpolator相关数据的关系

我们一般自定义插值器都是继承自Interpolator，Interpolator又继承自TimeInterpolator
而TimeInterpolator里面只有一个方法:

    float getInterpolation(float input);

    返回值为float类型，表示当前实际想要显示的进度。取值可以超过1也可以小于0，超过1表示已经超过目标值，小于0表示小于开始位置。
    表示动画的数值进度，它的对应的数值范围是我们通过ofInt(),ofFloat()等来指定的，这个返回值就表示当前时间所对应的数值的进度。

    参数input为float类型，它取值范围是0到1，表示当前动画的进度，此值是匀速增加的，在指定的时间内匀速的从0到1运行

    我们在添加动画运行状态的监听的时候可以在通过 animation.getAnimatedValue();
    来获取当前动画运行的值。

    关系：
        input: 动画匀速运行的进度

        getInterpolation()返回值：通过动画运行的进度input来获取当前运行的数值的进度

        animation.getAnimatedValue()：动画运行的当前值，初始值 + （结束值 - 初始值）* getInterpolation()返回值
        这个值的运算是由Evaluator来实现的

----

> Evaluator

把小数进度转换成对应的数值位置

    对应动画里面的setEvaluator()方法可以知道Evaluator的基类是TypeEvaluator
    其实现类有：

    ArgbEvaluator

    FloatArrayEvaluator

    FloatEvaluator

    IntArrayEvaluator

    IntEvaluator

    PathDataEvaluator：不做研究

    PointFEvaluator：(x, y)

    RectEvaluator：（left, top, right, bottom）

    以上的实现类中的实现都遵循一个公式：
    初始值 + （结束值 - 初始值）* getInterpolation()
    初始值 + （结束值 - 初始值）* fraction


> TypeEvaluator

TypeEvaluator内部只有一个方法：

    T evaluate(float fraction, T startValue, T endValue);

    使用泛型来通过对应的设置返回对应的类型

    fraction：对应于interpolator中返回的值，表示当前动画的数值进度，百分制的小数表示。

    startValue和endValue分别对应of***(int start, int end)中的start和end的数值，同时参数类型也是一一对应的


> ArgbEvaluator

    通过setEvaluator()来添加

    两种方式：
        1、使用ofInt();
        里面传入对应的颜色值，以16进制形式传入（0x000000），8位，每两位表示ARGB中的一个
        然后设置通过setEvaluator(new ArgbEvaluator());

        2、使用ofArgb();
        里面传入对应的颜色值，以16进制形式传入（0x000000）
        这种方式不需要再设置setEvaluator();

我们可以通过重写加速器改变数值进度来改变数值位置，也可以通过改变Evaluator中进度所对应的数值来改变数值位置。


> Animator.onObject()

    ofObject(TypeEvaluator evaluator, Object... values)

    这个方法必须设置一个TypeEvaluator来对应传入的object

    具体可以参考AnimatorTwoActivity中的两个例子






