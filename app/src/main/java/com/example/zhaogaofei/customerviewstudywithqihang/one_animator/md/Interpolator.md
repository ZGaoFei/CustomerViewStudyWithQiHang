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

> 自定义interpolator

    通过实现Interpolator，然后实现getInterpolation()方法

    插值器就是从动画运行的一段时间中取出某一刻，来通过然后实现getInterpolation()来计算当前时间运行的位置


用来计算这个公式的工具推荐一个网站
[Interpolator](http://inloop.github.io/interpolator/)

获取到公式后可以模仿已有的插值器来做

