##### 第二部分绘图篇

> Paint

    //普通设置
    paint.setColor();//设置画笔颜色
    paint.setStrokeWidth (5);//设置画笔宽度
    paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
    paint.setStyle(Paint.Style.FILL);//绘图样式，对于设文字和几何图形都有效
    paint.setTextAlign(Align.CENTER);//设置文字对齐方式，取值：align.CENTER、align.LEFT或align.RIGHT
    paint.setTextSize(12);//设置文字大小

    //样式设置
    paint.setFakeBoldText(true);//设置是否为粗体文字
    paint.setUnderlineText(true);//设置下划线
    paint.setTextSkewX((float) -0.25);//设置字体水平倾斜度，普通斜体字是-0.25
    paint.setStrikeThruText(true);//设置带有删除线效果

    //其它设置
    paint.setTextScaleX(2);//只会将水平方向拉伸，高度不会变


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


