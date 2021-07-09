# MyJetpack
    研究一下JetPack
# LifeCycle
### LifeCycle的好处
    1.帮组开发者建立可感知生命周期的组件
    2.组件在其内部管理自己的生命周期，从而降低模块耦合度
    3.降低内存泄漏发声的可能性
    4.Activity Fragment Service Application均有LifeCycle的支持
# ViewModel
### 问题的关键
    1.瞬态数据丢失
    2.异步调用的内存泄漏
    3.类膨胀提高维护难度和测试难度
### ViewModel的作用
    1.它是介于View和Model之间的桥梁
    2.使视图和数据能够分离，也能保持通信
### 关系链
    不管生命周期怎么变化，viewModel上的数据是不会搜影响的，因为它单独存在。  
![Image text](https://github.com/cbb294609622/MyJetpack/blob/master/img/viewmodel1.png)  
### ViewModel的小提示
    1.不要向ViewModel中传入Context，会导致内存泄漏
    2.如果要使用Context，请使用AndroidViewModel中的Application         
# LiveData
### LiveData和ViewModel的关系
    在ViewModel中的数据发生变化时，会通知页面
### LiveData和ViewModel关系图
![Image text](https://github.com/cbb294609622/MyJetpack/blob/master/img/clipboard.png)        
### LiveData的优势
    1.确保界面符合数据状态
    2.不会发生内存泄漏
    3.不会因Activity停止而导致崩溃
    4.不再需要手动处理生命周期
    5.数据始终保持最新状态
    6.适当的适配更改
    7.共享资源        
        
# DataBinding
    让布局文件承担了部分原本属于页面的工作，使页面与布局耦合度进一步降低。
### xml中快捷键生成layout data
    alt + enter
### examples1 实例
    展示databinding基础使用
### examples2 实例
    二级页面参数传递实例            