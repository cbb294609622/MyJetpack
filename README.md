# MyJetpack
    研究一下JetPack
# LifeCycle
    # LifeCycle的好处
        1.帮组开发者建立可感知生命周期的组件
        2.组件在其内部管理自己的生命周期，从而降低模块耦合度
        3.降低内存泄漏发声的可能性
        4.Activity Fragment Service Application均有LifeCycle的支持
# ViewModel
    # 问题的关键
        1.瞬态数据丢失
        2.异步调用的内存泄漏
        3.类膨胀提高维护难度和测试难度
    # ViewModel的作用
        1.它是介于View和Model之间的桥梁
        2.使视图和数据能够分离，也能保持通信
        关系链:用户 <---> View <---> ViewModel <---> Model
        不管生命周期怎么变化，viewModel上的数据是不会搜影响的，因为它单独存在。      
    # ViewModel的小提示
        1.不要向ViewModel中传入Context，会导致内存泄漏
        2.如果要使用Context，请使用AndroidViewModel中的Application         