import Vue from 'vue'
import VueRouter from 'vue-router'
import store from "../store";


Vue.use(VueRouter)

const routes = [
  {
      path: '/',
      name: 'Manage',
      component: () => import('../views/Manage.vue'),
      redirect:"/home",
      children:[
          {path: 'home',name: '首页', component: () => import('../views/Home.vue')},
          {path: 'user',name: '用户管理', component: () => import('../views/User.vue')},
          {path: 'newstype',name: '新闻类别', component: () => import('../views/Newstype.vue')},
          {path: 'news',name: '新闻管理', component: () => import('../views/News.vue')}
      ]
  },
  {
    path: '/about',
    name: 'About',
    component: () => import( '../views/About.vue')
  },
    {
        path: '/login',
        name: 'Login',
        component: () => import( '../views/Login.vue')
    },
    {
        path: '/register',
        name: 'Register',
        component: () => import( '../views/Register.vue')
    },
]

const router = new VueRouter({
    mode: 'history',
  routes
})
// 路由守卫
router.beforeEach((to, from, next) => {
    localStorage.setItem("currentPathName", to.name)  // 设置当前的路由名称，为了在Header组件中去使用
    store.commit("setPath")  // 触发store的数据更新
    next()  // 放行路由
})
export default router
