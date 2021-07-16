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
    
    假设我们将数据库版本升级到4，却没有为此写相应的Migration，
    则会出现一个lllegalStateException异常，
    加入fallbackToDestructiveMigration()，
    该方法在出现升级异常时，重建数据表,同时数据也会丢失。
### Room添加版本升级schemas文件
    Room每次升级都会导出一个schemas文件，是一个json格式的文件。
    其中包含了数据库的基本信息，有了此文件，开发者可以很方便的排查问题。 
### 销毁和重建策略(MyDataBase 中 MIGRATION_3_4)
    在SQLite中修改表结构比较麻烦，例如，我们想将Student表 中sex字段类型从INTEGER改为TEXT，
    最好的方式是采用销毁与重建策略，大致分为以下步骤:
        ●创建一张符合表结构要求的临时表temp_ student
        ●将数据从旧表student复 制到临时表temp_ student
        ●删除旧表student
        ●将临时表temp_ student重命名为student
![Image text](https://github.com/cbb294609622/MyJetpack/blob/master/img/room3.png)
### 预填充数据库
    有时候我们希望应用自带一些数据供我们使用，我们可以将数据库文件放入assets目录一起打包发布。
    在用户首次打开APP时，使用createFromAsset()和createFromFile()创建Room数据库。    
    
# Navigation
    Activity嵌套多个Fragment的UI架构模式已经非常普遍，但是对Fragment的管理一直是一件比较麻烦的事情。
    我们需要通过FragmentManager和FragmentTransaction来管理Fragment之间的切换。
    页面的切换通常还包括对应用程序App bar的管理、Fragment间的切换动画，以及Fragment间的参数传递。
    纯代码的方式使用起来不是特别友好，并且Fragment和App bar在管理和使用的过程中显得混乱。
    为此，Jetpack提供了Navigation组件，旨在方便我们管理页面和App Bar。
### Navigation的优势
    ●可视化的页面导航图，类似于Apple Xcode中的StoryBoard，便于我们理清页面关系。
    ●通过destination和action完成页面间的导航。
    ●方便添加页面切换动画。
    ●页面间类型安全的参数传递。
    ●通过NavigationUl，对菜单、底部导航、抽屉菜单导航进行统一的管理。
    ●支持深层链接DeepLink。
### Navigation的主要元素
    ●Navigation Graph，一种新的XML资源文件，包含应用程序所有的页面，以及页面间的关系。
    ●NavHostFragment，一个特殊的Fragment，可以将它看作是其他Fragment的容器，
        Navigation Graph中的Fragment正是通过NavHostFragment进行展示的。
    ●NavController，用于在代码中完成Navigation Graph中具体的页面切换工作。
### 他们三责之间的关系 (Navigation Graph/NavHostFragment/NavController)
    当你想切换Fragment时，使用NavController对象，告诉它你想要去Navigation Graph中的哪个Fragment,
    NavController会将你想去的Fragment展示NavHostFragment中。
### 参数传递方式一
    使用Bundle形式
### 参数传递方式二
    使用safeargs方式，需要引入插件  
    project gradle中： 
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0-alpha06"     
    module gradle中：
        plugins{ id 'androidx.navigation.safeargs'}

# Navigation UI
    Fragment的切换，除了Fragment页面本身的切换，通常还伴有AppBar的变化。
    为了方便统一管理，Navigation组件引入了NavigationUI类。  
    
    支持AppBar:ActionBar 、ToolBar 、 CollapsingToolbarLlayout
    menu:抽屉菜单(Drawlayout+navigation View) 、 底部菜单(BottonNavigationView)  

# DeepLink(深层链接)
    PendingIntent方式
        当App收到某个通知推送，我们希望用户在点击该通知时，能够直接跳转到展示该通知内容的页面，可以通过PendingIntent来完成。
    URL方式
        当用户通过手机浏览器浏览网站上某个页面时，可以在网页上放置一个类似于“在应用内打开"的按钮，如果用户的手机安装有我们的App，
        那么通过DeepLink就能打开相应的页面;如果没有安装，那么网站可以导航到应用程序的下载页面，引导用户安装应用程序。
        adb shell am start -a android.intent.action.VIEW -d "http://www.dongnaoedu.com/fromWeb"
         