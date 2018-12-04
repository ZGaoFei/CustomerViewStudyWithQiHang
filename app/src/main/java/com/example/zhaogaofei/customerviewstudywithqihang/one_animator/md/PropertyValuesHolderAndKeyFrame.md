##### 第一部分动画篇

> PropertyValuesHolder

    PropertyValuesHolder：其中保存了动画过程中所需要操作的属性和对应的值
    ValueAnimator和ObjectAnimator的内部实现都是基于PropertyValuesHolder
    PropertyValuesHolder中有对应的of***()方法，并且内部有实现对应的***PropertyValuesHolder

    在PropertyValuesHolder中来通过反射的方式来获取到对应的target的set***()方法，
    设置对应的target的属性，因此target需要包含有set对应属性的方法
    因此属性动画的实现实际上系统只是提供时间上的切换，具体的属性的修改还是通过我们自己实现

> ofPropertyValuesHolder()方法

    这个方法是ValueAnimator和ObjectAnimator的

    使用方法和其他的of方法一致，前提是实例化对应的PropertyValuesHolder对象
    具体看ValuesHolderAndKeyFrameActivity中的例子

    其他方法：
    // 设置动画的Evaluator
    public void setEvaluator(TypeEvaluator evaluator)
    // 用于设置ofFloat所对应的动画值列表
    public void setFloatValues(float... values)
    // 用于设置ofInt所对应的动画值列表
    public void setIntValues(int... values)
    // 用于设置ofKeyframe所对应的动画值列表
    public void setKeyframes(Keyframe... values)
    // 用于设置ofObject所对应的动画值列表
    public void setObjectValues(Object... values)
    // 设置动画属性名
    public void setPropertyName(String propertyName)


> ofObject()方法

    PropertyValuesHolder内部的ofObject()方法，对应于实现ValueAnimator和ObjectAnimator的
    ofObject()方法

    ofObject(String propertyName, TypeEvaluator evaluator,Object... values)
    propertyName：属性的名字
    evaluator：对应的估值器
    values：操作动画属性的值

    具体参考ValuesHolderAndKeyFrameActivity中的例子

---

> KeyFrame

    关键帧，用来定义动画执行到当前时间的帧，即当前时间应该显示的位置
    关键帧必须包含两个原素，第一时间点，第二位置

    对应的方法有：
    ofInt(float,int)
    ofFloat(float, float)
    ofObject(float,object)
    表示对应的关键帧的属性值，即位置

    ofInt(float)
    ofFloat(float)
    只设置了时间值，没有设置位置值
    可以结合setValue()方法来一起使用
    setFraction()设置时间值

    setInterpolator()
    设对应帧的插值器（加速器）
    可以给单一帧添加插值器
    如果给当前帧添加插值器，那么在上一帧到当前帧的进度值计算过程中会使用这个插值器。

    如果去掉第0帧，将以第一个关键帧为起始位置
    如果去掉结束帧，将以最后一个关键帧为结束位置
    使用Keyframe来构建动画，至少要有两个或两个以上帧，如果只有一帧会报IndexOutOfBoundsException

    可以使用KeyFrame来操作多属性
    利用ofPropertyValuesHolder()内可以传可变长个值

    详细参考ValuesHolderAndKeyFrameActivity




