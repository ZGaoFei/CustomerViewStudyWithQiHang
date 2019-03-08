##### 第二部分绘图篇

> Paint

    //普通设置
    paint.setColor();//设置画笔颜色
    paint.setARGB(int a, int r, int g, int b);//同样是设置颜色，但是利用ARGB分开设置
    paint.setAlpha(int a); //设置画笔透明度
    paint.setStrokeWidth (5);//设置画笔宽度
    paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
    paint.setStyle(Paint.Style.FILL);//绘图样式，对于设文字和几何图形都有效
        Paint.Style.FILL :填充内部
        Paint.Style.FILL_AND_STROKE ：填充内部和描边
        Paint.Style.STROKE ：仅描边
    paint.setTextAlign(Align.CENTER);//设置文字对齐方式，取值：align.CENTER、align.LEFT或align.RIGHT
    paint.setTextSize(12);//设置文字大小
    paint.reset();// 重置画笔

    paint.setStrokeCap(Paint.Cap cap);//设置线冒样式，取值有Cap.ROUND(圆形线冒)、Cap.SQUARE(方形线冒)、Paint.Cap.BUTT(无线冒)
    paint.setStrokeJoin(Paint.Join join);//设置线段连接处样式，取值有：Join.MITER（结合处为锐角）、Join.Round(结合处为圆弧)、Join.BEVEL(结合处为直线)
    paint.setStrokeMiter(float miter);//设置笔画的倾斜度，90度拿画笔与30拿画笔，画出来的线条样式肯定是不一样的吧
    paint.setPathEffect(PathEffect effect);
    设置路径样式;取值类型是所有派生自PathEffect的子类：ComposePathEffect, CornerPathEffect, DashPathEffect, DiscretePathEffect, PathDashPathEffect, SumPathEffect

    //样式设置
    paint.setFakeBoldText(true);//设置是否为粗体文字
    paint.setUnderlineText(true);//设置下划线
    paint.setTextSkewX((float) -0.25);//设置字体水平倾斜度，普通斜体字是-0.25
    paint.setStrikeThruText(true);//设置带有删除线效果

    //其它设置
    paint.setTextScaleX(2);//只会将水平方向拉伸，高度不会变

    // 字体设置
    paint.setTextSize(float textSize);//设置文字大小
    paint.setFakeBoldText(boolean fakeBoldText);//设置是否为粗体文字
    paint.setStrikeThruText(boolean strikeThruText);//设置带有删除线效果
    paint.setUnderlineText(boolean underlineText);//设置下划线
    paint.setTextAlign(Paint.Align align);//设置开始绘图点位置
    paint.setTextScaleX(float scaleX);//水平拉伸设置
    paint.setTextSkewX(float skewX);//设置字体水平倾斜度，普通斜体字是-0.25，可见往右斜
    paint.setTypeface(Typeface typeface);//字体样式


    paint.setShader(Shader shader)
    paint.setShadowLayer(float radius, float dx, float dy, int shadowColor)
    paint.setDither(boolean dither)
    paint.setColorFilter(ColorFilter filter)
    paint.setXfermode(Xfermode xfermode)
    paint.setFilterBitmap(boolean filter)
    paint.clearShadowLayer()
    paint.breakText(char[] text, int index, int count, float maxWidth, float[] measuredWidth)
    paint.measureText(String text)

> Canvas

    canvas.drawRect(); // 画矩形
    canvas.drawCircle(); // 画圆
    canvas.drawLine(); // 画直线
    canvas.drawLines(); // 画多条直线
    canvas.drawPoint(); // 画点
    canvas.drawPoints(); // 画多个点
    canvas.drawRoundRect(); // 画圆角矩形
    canvas.drawOval(); // 画椭圆
    canvas.drawArc(); // 画圆弧


> Rect 矩形区域




> RectF 同Rect矩形区域




> Path 不规则路径绘制


> Region 可以支持区域的合并、交叉等操作

[参考](/app/src/main/java/com/example/zhaogaofei/customerviewstudywithqihang/two_drawing/customer/PaintAndCanvas3View)


> 贝塞尔曲线

[贝塞尔曲线参考](https://blog.csdn.net/harvic880925/article/details/50995587)


> ColorMatrix

    ColorMatrix()
    ColorMatrix(float[] src)
    ColorMatrix(ColorMatrix src)
    set(ColorMatrix src)
    set(float[] src)
    reset()

    setSaturation(float):整体增强颜色饱和度，即同时增强R,G,B的色彩饱和度
    参考ColorMatrixTestView类

    setScale(float rScale, float gScale, float bScale,float aScale):色彩缩放
    参考PaintAndCanvasColorMatrix1View.drawBitmap8()

    /**
     * 将旋转围绕某一个颜色轴旋转
     * axis=0 围绕红色轴旋转
     * axis=1 围绕绿色轴旋转
     * axis=2 围绕蓝色轴旋转
    */
    setRotate(int axis, float degrees)
    参考ColorMatrixTest1View

    // 矩阵相乘
    setConcat(ColorMatrix matA, ColorMatrix matB)// a * b
    将结果做为当前ColorMatrics实例的颜色矩阵。所以会把当前ColorMatrics实例以前的颜色矩阵给覆盖掉

    preConcat(ColorMatrix prematrix)//当前矩阵a * prematrix
    postConcat(ColorMatrix postmatrix)//prematrix * 当前矩阵a

    float[] getArray()// 返回当前ColorMatrix的矩阵数组


