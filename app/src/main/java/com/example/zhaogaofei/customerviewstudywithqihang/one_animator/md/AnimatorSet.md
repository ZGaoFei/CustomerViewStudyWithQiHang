##### 第一部分动画篇

> XML方式添加动画

    animation对应的res下的文件夹是anim
    animator对应的res下的文件夹是animator

    <animator />:对应ValueAnimator
    <objectAnimator />:对应ObjectAnimator
    <set />:对应AnimatorSet

    获取动画方式：
    animation：AnimationUtils.loadAnimation(context, R.anim.alpha_animation);
    animator：AnimatorInflater.loadAnimator(context, R.animtor.***);

    个人感觉使用XML方式来添加属性动画没有代码方式添加的方便

> set集合动画

    set标签对应的实体方法为AnimatorSet，使用方式和Animation一致

    示例：
    <set
      android:ordering=["together" | "sequentially"]>

        <objectAnimator
            android:propertyName="string"
            android:duration="int"
            android:valueFrom="float | int | color"
            android:valueTo="float | int | color"
            android:startOffset="int"
            android:repeatCount="int"
            android:repeatMode=["repeat" | "reverse"]
            android:valueType=["intType" | "floatType"]/>

        <animator
            android:duration="int"
            android:valueFrom="float | int | color"
            android:valueTo="float | int | color"
            android:startOffset="int"
            android:repeatCount="int"
            android:repeatMode=["repeat" | "reverse"]
            android:valueType=["intType" | "floatType"]/>

        <set>
            ...
        </set>
    </set>

---

> AnimatorSet

    playTogether(Animator... items):
    playTogether(Collection<Animator> items):

    playSequentially(Animator... items):
    playSequentially(List<Animator> items):
    下面单独讲

    cancel():

    end():

    pause():

    resume():

    start():

    clone():

    reverse():


-----
    前面三个方法的设置：
    在AnimatorSet中设置以后，会覆盖单个ObjectAnimator中的设置；
    即如果AnimatorSet中没有设置，那么就以ObjectAnimator中的设置为准。如果AnimatorSet中设置以后，ObjectAnimator中的设置就会无效。

    setTarget(Object target):
    用于设置动画的目标对象，如果设置将覆盖Set内所有动画的setTarget()目标，
    由于只能设置一个目标，因此如果内部动画作用多个对象，则这个方法就不能设置

    setInterpolator(TimeInterpolator interpolator):
    用于设置set的加速度，如果设置，则覆盖掉内部动画所有的setInterpolator()
    如果需要给单个动画设置自己的interpolator，则set不需要设置这个方法

    setDuration(long duration):
    用于设置set动画执行一次的时长，如果设置将覆盖set内所有动画设置的duration
    如果需要给单个动画设置自己的duration，则set不需要设置这个方法

    setStartDelay(long startDelay):
    设置延时开始动画时长，这个方法不会覆盖set内单个动画的startDelay时长

    这个方法仅针对性的延长AnimatorSet激活时间的，对单个动画的延时设置没有影响。
    AnimatorSet真正激活延时 = AnimatorSet.startDelay+第一个动画.startDelay
    在AnimatorSet激活之后，第一个动画绝对是会开始运行的，后面的动画则根据自己是否延时自行处理。

    具体差异参考AnimatorSetActivity中delayAnimator1()和delayAnimator2()和和delayAnimator3()方法产生的效果差


---

    doAnimationFrame(long frameTime):

    Builder play(Animator anim):
    class Builder:
    下面单独讲


> playTogether() or playSequentially()

    playTogether(Animator... items)：内部传入多个动画

    playTogether(Collection<Animator> items)：使用集合将多个动画保存

    多个动画同时开始

    playSequentially(Animator... items)：内部传入多个动画

    playSequentially(List<Animator> items)：使用集合将多个动画保存

    多个动画按照顺序依次开始，当一个动画结束后，下一个动画才会开始
    如果上一个动画设置了无限循环，那么下一个动画将不会开始

    playTogether和playSequentially只负责到点激活动画
    动画的执行由动画本身来控制

> 设置组合动画的无限循环效果

    AnimatorSet内部没有设置动画执行的次数设置，因此可以通过设置每一个动画为无限循环动画
    然后使用playTogether()来开始动画


> AnimatorSet.Builder

    Builder的作用是为了更方便的组合动画

    new AnimatorSet().play()来获取Builder对象，里面传入要播放的动画
    以这个动画为参考点，来添加其他动画

    Builder：

    Builder with(Animator anim):
    和前面的动画一起执行

    Builder before(Animator anim):
    执行完前面的动画后才执行这个动画

    Builder after(Animator anim):
    先执行这个动画再执行前面的动画

    Builder after(long delay):
    延迟delay秒后再执行动画

    play(Animator anim)表示当前在播放哪个动画，
    另外的with(Animator anim)、before(Animator anim)、after(Animator anim)
    都是以play中的当前所播放的动画为基准的。

    Builder类里面的方法返回的都是Builder对象，因此可以通过链式调用
    new AnimatorSet().play().with().before().after();

    举例：
    objectAnimator1、objectAnimator2、objectAnimator3

    new AnimatorSet().play(objectAnimator1).with(objectAnimator2).before(objectAnimator3);
    objectAnimator1和objectAnimator2一起执行，然后执行objectAnimator3

    new AnimatorSet().play(objectAnimator1).with(objectAnimator2).after(objectAnimator3);
    objectAnimator3先执行，然后objectAnimator1和objectAnimator2一起执行


> AnimatorSet监听器

    使用的监听和ValueAnimatorhe与ObjectAnimator的一样，均是Animator内部的监听

    public static interface AnimatorListener {
        /**
         * 当AnimatorSet开始时调用
         */
        void onAnimationStart(Animator animation);

        /**
         * 当AnimatorSet结束时调用
         */
        void onAnimationEnd(Animator animation);

        /**
         * 当AnimatorSet被取消时调用
         */
        void onAnimationCancel(Animator animation);

        /**
         * 当AnimatorSet重复时调用，由于AnimatorSet没有设置repeat的函数，所以这个方法永远不会被调用
         */
        void onAnimationRepeat(Animator animation);
    }

    通过new AnimatorSet().addListener(AnimatorListener);方式添加

    AnimatorSet监听器只是用来监听AnimatorSet的执行过程，与内部动画无关
    AnimatorSet没有设置循环的方法，监听无法监听循环的过程



