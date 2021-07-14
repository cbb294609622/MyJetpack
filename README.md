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
### examples3 实例
    BindingAdapter 图片加载
### examples4 实例
    双向绑定  继承BaseObservable   
### examples5 实例
    双向绑定  ObservableField
### examples6 实例
    RecyclerView 绑定实例
### examples7 实例 
    ViewModel+DataBinding+LiveData

# Room
    Android采用SQLite作为数据库存储，开源社区常见的ORM库有ORMLite等，
    Room和其他库一样，也是在SQLite上提供了一层封装。    
![Image text](https://github.com/cbb294609622/MyJetpack/blob/master/img/room.png)      
### Room的重要概念
    1.Entity:实体类，对应的是数据库的一张表结构， 使用注解@Entity标记。 
    2.Dao:包含访问一系列访问数据库的方法，使用注解@Dao标记。
    3.Database:数据库持有者，作为与应用持久化相关数据的底层连接的主要接入点。
        使用注解@Database标记，另外需满足以下条件:定义的类必须是一一个继承于RoomDatabase的抽象类，
        在注解中需要定义与数据库相关联的实体类列表。包含 -个没有参数的抽象方法并且返回一个Dao对象。
### Entity Dao Database 三者之间的关系
![Image text](https://github.com/cbb294609622/MyJetpack/blob/master/img/room1.png) 
### 进一步优化
    问题：每当数据库数据发生变化时，都需要开启一个工作线程去重新获取数据库中的数据？
    解决：当数据发生变化时，通过LiveData通知View层，实现数据自动更新。     
### Room + ViewModel + LiveData 关系图
    MyRoom2 数据自动变更
![Image text](https://github.com/cbb294609622/MyJetpack/blob/master/img/room2.png) 
### Room DataBase升级
    需要使用Migration配置。
    如果遇到需要从1升级到N(跳级)升级形式，需要逐步升级。    
       