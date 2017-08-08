# AutoFlowLayout
### 一、AutoFlowLayout应用场景
流式布局，在很多标签类的场景中可以用的；而网格布局在分类中以及自拍九宫格等场景很常见。如下所示：
![](http://upload-images.jianshu.io/upload_images/3985563-8c7c5401f2602718.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
如此使用频繁而又实现简单的控件，怎能不自己撸一个呢？控件，还是定制的好啊。
### 二、AutoFlowLayout实现效果
先介绍下自己撸的这个控件的功能及效果。
#### 1.功能
**流式布局**
-  自动换行
- 行数自定：单行/多行
- 支持单选/多选
- 支持行居中/靠左显示
- 支持添加/删除子View
- 支持子View点击/长按事件

**网格布局**
-  行数/列数自定
-  支持单选/多选
- 支持添加/删除子View
- 支持子View点击/长按事件
- 支持添加多样式分割线及横竖间隔
#### 2.效果
下面以gif图的形式展现下实现的效果，样式简单了些，不过依然能展示出这个简单控件的多功能实用性。  

**流式布局** 

![](http://upload-images.jianshu.io/upload_images/3985563-a0d0d19ddb77a9df.gif?imageMogr2/auto-orient/strip)
     
![](http://upload-images.jianshu.io/upload_images/3985563-e3ae7ae58423c373.gif?imageMogr2/auto-orient/strip)  

**网格布局** 

![](http://upload-images.jianshu.io/upload_images/3985563-3723ba8a6b0c1114.gif?imageMogr2/auto-orient/strip)  

最后一个是带间隔以及分割线的，由于录屏原因，只在跳过去的一瞬间显示了粉红色的一条线。真实如下图所示，可以定义横竖间距的大小，以及分割线的颜色，宽度。  
![](http://upload-images.jianshu.io/upload_images/3985563-ba1e847f4c039f3c.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
### 三、AutoFlowLayout使用
#### 1.添加依赖
①.在项目的 build.gradle 文件中添加
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
②.在 module 的 build.gradle 文件中添加依赖
```
dependencies {
	        compile 'com.github.LRH1993:AutoFlowLayout:1.0.5'
	}
```
#### 2.属性说明
下表是自定义的属性说明，可在xml中声明，同时有对应的get/set方法，可在代码中动态添加。
![](http://upload-images.jianshu.io/upload_images/3985563-9cc258fb8363af39.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
#### 3.使用示例
**布局**
```
<?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent">
    <com.example.library.AutoFlowLayout
        android:id="@+id/afl_cotent"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
</RelativeLayout>
```
**代码设置数据**
```
mFlowLayout.setAdapter(new FlowAdapter(Arrays.asList(mData)) {
            @Override
            public View getView(int position) {
                View item = mLayoutInflater.inflate(R.layout.special_item, null);
                TextView tvAttrTag = (TextView) item.findViewById(R.id.tv_attr_tag);
                tvAttrTag.setText(mData[position]);
                return item;
            }
        });
```
与ListView,GridView使用方式一样，实现FlowAdapter即可。
